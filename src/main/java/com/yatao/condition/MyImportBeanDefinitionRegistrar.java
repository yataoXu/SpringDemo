package com.yatao.condition;

import com.yatao.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 把需要添加到容器中的bean; 通过 beanDefinitionRegistry.registerBeanDefinition() 手工注册到容器中
     *
     * @param annotationMetadata     当前类的注解信息及其他信息
     * @param beanDefinitionRegistry beanDefinition 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.yatao.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.yatao.bean.Blue");
        if (red && blue) {
            // 指定被注册bean 的id名
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
