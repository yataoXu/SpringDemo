package com.yatao.demo;

import com.yatao.tx.TxConfig;
import com.yatao.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class IOCTest_Tx {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.insertUser();
        applicationContext.close();
    }

}
