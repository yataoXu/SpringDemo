package com.evan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String nickName;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）


}