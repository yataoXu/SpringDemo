package com.evan.config;

import com.evan.condition.LinuxCondition;
import com.evan.condition.WindowCondition;
import com.evan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Conditional() 按照一定的条件进行判断，满足条件给容器中注册bean
 * <p>
 * 如果系统是windows，给容器中注册("bilibili")
 * 如果系统是linux , 给容器注册("afun")
 */
@Conditional(WindowCondition.class)
@Configuration
public class MainConfig04 {

    @Bean("bilibili")
    public Person person01() {
        System.out.println("给容器中添加Person....");
        return new Person("bilibili", 25);
    }

    @Bean("afun")
    public Person person02() {
        System.out.println("给容器中添加Person....");
        return new Person("afun", 25);
    }
}
