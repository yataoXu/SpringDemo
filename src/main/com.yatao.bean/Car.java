package com.yatao.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car constructor ....");
    }

    public void init() {
        System.out.println("car init ......");
    }

    public void distroy() {
        System.out.println("car distroy ....");
    }
}
