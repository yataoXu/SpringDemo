package com.evan.config;

import com.evan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig03 {


    @Lazy
    @Bean("person")
    public Person person01(){
        System.out.println("给容器中添加Person....");
        return new Person("evan",24,"zhangsan");
    }
}
