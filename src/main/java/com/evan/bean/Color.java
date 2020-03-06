package com.evan.bean;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/16 10:22
 * @Mail : xuyt@zendaimoney.com
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color [car=" + car + "]";
    }


}