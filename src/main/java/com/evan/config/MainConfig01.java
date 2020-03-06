package com.evan.config;

import com.yatao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置类 == 配置文件
@Configuration  // 告诉spring这是一个注册类
public class MainConfig01 {

    // 给spring注入一个bean 类型为返回值类型 ID为方法名
    @Bean("person")
    public Person person01(){
        return new Person();
    }
}
