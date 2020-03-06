package com.evan.config;

import com.evan.annotation.EnableMyImportSelector;
import com.evan.bean.Blue;
import com.evan.bean.Color;
import com.evan.bean.Yellow;
import com.evan.condition.MyImportBeanDefinitionRegistrar;
import com.evan.condition.MyImportSelector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({Yellow.class, Blue.class, Color.class})
//@Import({Yellow.class, Blue.class, MyImportSelector.class})
//@Import({Yellow.class, Blue.class, MyImportBeanDefinitionRegistrar.class})
//@EnableMyImportSelector(name = "test")
public class MainConfig05 {
}
