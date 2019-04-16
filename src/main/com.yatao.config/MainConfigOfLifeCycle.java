package com.yatao.config;

import com.yatao.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * bean的声明周期
 *          bean的创建     初始化    销毁的过程
 *
 * 容器管理Bean的生命周期
 *  我们可以自定义初始化和销毁方法
 *
 * 方式1 指定初始化和销毁方法
 *              指定init-method和destroy-method方法
 *
 */
@Configuration
public class MainConfigOfLifeCycle {

    @Bean
    public Car car(){
        return new Car();
    }
}
