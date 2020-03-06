#### Spring 核心思想
Spring认为所有的组件都应该放在Spring 容器中(Spring context),所有的组件之间的关系应该相互依赖注入完成。




### AnnotationConfigApplicationContext
AnnotationConfigApplicationContext是Spring用来加载注解配置的ApplicationContext





一个demo

```java
package com.evan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
    
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
package com.evan.config;

import com.yatao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置类 == 配置文件
@Configuration  // 告诉spring这是一个注册类
public class MainConfig {

    // 给spring注入一个bean 类型为返回值类型 ID为方法名
    @Bean("person")
    public Person person01(){
        return new Person();
    }
}
```

```java
package com.evan.demo;

import com.evan.config.MainConfig;
import com.yatao.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    
    @Test
    public void test01() {

        printBeans(applicationContext);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);
        }

        System.out.println("====================");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }


    @Test
    public void test02() {
        System.out.println("ioc 容器创建完成。。。。。。");
        Person bean = applicationContext.getBean(Person.class);
        Person bean1 = applicationContext.getBean(Person.class);
        System.out.println(bean); //Person(name=张三, age=18, nickName=${person.nickName})
        System.out.println(bean1); // Person(name=张三, age=18, nickName=${person.nickName})
        System.out.println(bean == bean1); // true
    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }
    
}

```


![image](https://mmbiz.qpic.cn/mmbiz_png/vb4xFWPs1FhRibt0X6ic1Ps4PINGYJFQibk5dmSrYvVYBdhnE5iaclY1hEOaZN9b9vXxfibLFg1mr2L241iaiatK5tL6g/0?wx_fmt=png)


##### 构造器
```java
	public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
		this();
		register(annotatedClasses);
		refresh();
	}

```
###### 	this();

```java
	/**
	 * Create a new AnnotationConfigApplicationContext that needs to be populated
	 * through {@link #register} calls and then manually {@linkplain #refresh refreshed}.
	 */
	public AnnotationConfigApplicationContext() {
		this.reader = new AnnotatedBeanDefinitionReader(this);
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}
```

无参构造函数中主要是初始化AnnotatedBeanDefinitionReader和ClassPathBeanDefinitionScanner两个类。这里主要关注AnnotatedBeanDefinitionReader，跟踪这个类的初始化发现它会注册一堆BeanFactoryPostProcessor处理器，*只需关注ConfigurationClassPostProcessor**。

```java
public static Set<BeanDefinitionHolder> registerAnnotationConfigProcessors(
            BeanDefinitionRegistry registry, Object source) {
   ...
    if (!registry.containsBeanDefinition(CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME)) {
            RootBeanDefinition def = new RootBeanDefinition(ConfigurationClassPostProcessor.class);
            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME));
    }
    ...
}
```

###### register(annotatedClasses)
这个方法主要是把所有的配置类注册成bean。
###### refresh()
ClassPathXmlApplicationContext加载也调用了它，但是ClassPathXmlApplicationContext在调用obtainFreshBeanFactory()的时候就把所有的bean加载完成，但是AnnotationConfigApplicationContext并没有继承自AbstractRefreshableApplicationContext，所以在obtainFreshBeanFactory()这步还是没有加载bean。真正加载bean的操作是在invokeBeanFactoryPostProcessors(beanFactory),这个方法调用所有实现BeanFactoryPostProcessor接口的bean。那么BeanFactoryPostProcessor又是干嘛的呢？



##### BeanFactoryPostProcessor处理器
和BeanPostProcessor原理一致，Spring提供了对BeanFactory进行操作的处理器BeanFactoryProcessor，**简单来说就是获取容器BeanFactory**，这样就可以在真正初始化bean之前对bean做一些处理操作。BeanFactoryProcessor定义如下:
```java
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
```
##### BeanDefinitionRegistryPostProcessor
BeanDefinitionRegistryPostProcessor是BeanFactoryPostProcessor的子类，也只要一个方法
```java
public interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor {
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;
}
```

调用逻辑
AbstractApplicationContext#refresh()中调用了invokeBeanFactoryPostProcessors(beanFactory);这个方法逻辑如下：

1. 遍历所有实现了BeanDefinitionRegistryPostProcessor接口的bean
2. 调用实现了PriorityOrdered接口的BeanDefinitionRegistryPostProcessors的postProcessBeanDefinitionRegistry
3. 调用实现了Ordered接口的BeanDefinitionRegistryPostProcessors的postProcessBeanDefinitionRegistry
4. 调用普通的BeanDefinitionRegistryPostProcessors(没有实现Ordered接口和PriorityOrdered接口)的postProcessBeanDefinitionRegistry
5. 遍历所有实现BeanFactoryPostProcessor接口的bean，剩下的操作和BeanDefinitionRegistryPostProcessors的处理逻辑是一样的。