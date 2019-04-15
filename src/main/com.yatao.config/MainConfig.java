package com.yatao.config;

import com.yatao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类 == 配置文件
@Configuration
public class MainConfig {

    @Bean
    public Person person(){
        return new Person("lisi",20);
    }


}