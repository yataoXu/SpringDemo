package com.evan;

import com.currentlyInCreationException.StudentA;
import com.evan.bean.CreateBeanProcess;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTEST_CreateBean {

    @Test
    public void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getBean("a", StudentA.class));
//        CreateBeanProcess obj = (CreateBeanProcess) context.getBean("createBeanProcess");
//        String message = obj.getMessage();
//        System.out.println(message);
    }
}

