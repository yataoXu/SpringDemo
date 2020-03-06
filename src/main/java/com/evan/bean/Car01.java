package com.evan.bean;

import org.springframework.stereotype.Component;

@Component
public class Car01 {

    public Car01() {
        System.out.println("car constructor ....");
    }

    public void init() {
        System.out.println("car init ......");
    }

    public void distroy() {
        System.out.println("car distroy ....");
    }
}
