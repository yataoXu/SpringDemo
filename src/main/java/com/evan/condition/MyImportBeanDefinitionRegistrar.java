package com.evan.condition;

import com.evan.bean.Blue;
import com.evan.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 把需要添加到容器中的bean; 通过 beanDefinitionRegistry.registerBeanDefinition() 手工注册到容器中
     *
     * @param annotationMetadata     当前类的注解信息及其他信息
     * @param beanDefinitionRegistry beanDefinition 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.evan.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.evan.bean.Blue");
        if (red && blue) {
            // 指定被注册bean 的id名
            System.out.println("通过registerBeanDefinition()将RainBow 注入容器中");
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow", rootBeanDefinition);

            BeanDefinitionBuilder blue1  = BeanDefinitionBuilder.rootBeanDefinition(Blue.class);
            blue1.addPropertyValue("name","蓝色");
            beanDefinitionRegistry.registerBeanDefinition("蓝色", blue1.getBeanDefinition());

        }
    }
}
