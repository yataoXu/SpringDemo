package com.evan.config.lifeCycle;

import com.evan.bean.Car01;
import com.evan.bean.Cat;
import com.evan.bean.Dog;
import com.evan.dao.MyBeanPostProcessor;
import com.evan.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({Cat.class, Dog.class, MyBeanPostProcessor.class, UserDao.class})
//@Import({UserDao.class})
public class MainConfig01 {
    @Bean(initMethod = "init", destroyMethod = "distroy")
    public Car01 car() {
        return new Car01();
    }
}
