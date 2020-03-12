package com.evan.config;

import com.evan.bean.Person;
import com.evan.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 配置类 == 配置文件
@Configuration  // 告诉spring这是一个注册类

//包扫描、只要标注了@Controller、@Service、@Repository，@Component
//<context:component-scan base-package="com.evan" use-default-filters="false"></context:component-scan>
//@ComponentScan


// excludeFilters =  Filter[] 排除那些组件
//@ComponentScan(value = "com.evan",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})

// 配置只包含的过滤规则的时候需要屏蔽掉默认的过滤规则
// includeFilters =  Filter[] 只包含 Filter 中的 组件，注意点就是要屏蔽掉spring默认的过滤规则
//@ComponentScan(value = "com.evan.bean")
//        ,includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})},
////        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
////        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})},
//        useDefaultFilters = false)

// jdk8 可以配置多个ComponentScan
// FilterType.ANNOTATION 按照注解
// FilterType.ASSIGNABLE_TYPE 按照给定的类型
// FilterType.REGEX 按照制定正则
public class MainConfig {
    // 给spring注入一个bean 类型为返回值类型 ID为方法名
    @Bean
    public Person person(){
        System.out.println("person 方法执行");
        return new Person("lisi",20);
    }

    @Bean
    public String name(Person person) {
        System.out.println("name(Person person) 方法执行");
        System.out.println(person.hashCode());
        System.out.println("再次调用person()方法: " + person.hashCode());
        return "123";
    }


}