package com.listener.learn;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * spring的事件监听有三个部分组成，事件（ApplicationEvent)、监听器(ApplicationListener)和事件发布操作。
 */
@Getter
public class HelloEvent extends ApplicationEvent {

    private String name;


    public HelloEvent(Object source, String name) {
        super(source);
        this.name = name;

    }
}
