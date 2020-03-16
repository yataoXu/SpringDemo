package com.listener.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class HelloEventListener2 {

    @EventListener
    public void helloEvent(HelloEvent event) {
        log.info(" ====================> listen {} say hello from listenHello method!!!", event.getName());
    }
}
