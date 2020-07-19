package com.evan.config;

import com.evan.bean.Color;
import com.evan.bean.factorybean.ColorFactoryBean;
import com.evan.bean.Person;
import com.evan.bean.Red;
import com.evan.condition.LinuxCondition;
import com.evan.condition.MyImportBeanDefinitionRegistrar;
import com.evan.condition.MyImportSelector;
import com.evan.condition.WindowCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;


@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    //默认是单实例的

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     *
     * @return\
     * @Scope:调整作用域 prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动的时候创建对象；
     * 懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION     sesssion
     */
    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }

    /**
     * @Conditional() 按照一定的条件进行判断，满足条件给容器中注册bean
     * <p>
     * 如果系统是windows，给容器中注册("bilibili")
     * 如果系统是linux , 给容器注册("afun")
     */

    @Conditional(WindowCondition.class)
    @Bean("bilibili")
    public Person person01() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }

    @Conditional(LinuxCondition.class)
    @Bean("afun")
    public Person person02() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }

    /**
     * 给容器中注册组件
     *  1.包扫描（需要被注册到容器中的bean 加上 @controller @service 等注解） 这种方式的局限在于当我们引用第三方的bean时，人家可能没有加相应的注解
     *  2.@Bean[ 导入第三方]
     *  3.@Import[导入第三方]
     *      1. @Import({Color.class, Red.class}) @Import(Color.class) id 为全类名
     *      2. 实现接口 ImportSelector
     *      3. 实现接口 ImportBeanDefinitionRegistrar 手工注册bean到容器中
     *  4.使用 spring 提供的 FactoryBean
     *      1. 默认获取到的是工厂bean调用getObject创建的对象
     *      2. 要获取工厂Bean 本身，我们需要给id前面加一个&
     *
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }


}