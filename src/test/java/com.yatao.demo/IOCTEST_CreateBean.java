package com.yatao.demo;

import com.yatao.bean.CreateBeanProcess;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTEST_CreateBean {

    @Test
    public void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CreateBeanProcess obj = (CreateBeanProcess) context.getBean("createBeanProcess");
        String message = obj.getMessage();
        System.out.println(message);
    }
}

