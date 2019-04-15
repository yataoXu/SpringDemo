package com.yatao.config;

import com.yatao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 配置类 == 配置文件
@Configuration  // 告诉spring这是一个注册类
@ComponentScan(value = "com.yatao",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
public class MainConfig {



    //包扫描、只要标注了@Controller、@Service、@Repository，@Component
    //<context:component-scan base-package="com.atguigu" use-default-filters="false"></context:component-scan>


    // 给spring注入一个bean 类型为返回值类型 ID为方法名
    @Bean
    public Person person(){
        return new Person("lisi",20);
    }


}