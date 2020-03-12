package com.evan.config;

import com.evan.bean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


//    @Bean
//    public Person person() throws Exception {
//        factoryBean().getObject();
//        return new Person();
//    }

//    @Bean
//    public String name() throws Exception {
//        factoryBean().getObject();
//        return "CallBack 源代码走读";
//    }

    @Bean
    public FactoryBean factoryBean() {
        return new FactoryBean<Person>() {
            @Override
            public Person getObject() throws Exception {
                System.out.println("111");
                return new Person();
            }

            @Override
            public Class<?> getObjectType() {
                return Person.class;
            }
        };
    }

}
