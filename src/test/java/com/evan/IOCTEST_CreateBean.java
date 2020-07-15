package com.evan;

import com.currentlyInCreationException.CirculardependencyConfig;
import com.currentlyInCreationException.StudentA;
import com.evan.bean.CreateBeanProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CirculardependencyConfig.class })
public class IOCTEST_CreateBean {

//    @Test
//    public void test01() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        System.out.println(context.getBean("a", StudentA.class));
////        CreateBeanProcess obj = (CreateBeanProcess) context.getBean("createBeanProcess");
////        String message = obj.getMessage();
////        System.out.println(message);
//    }



    @Autowired
    ApplicationContext context;

    @Test
    public void test02() {
        StudentA studentA = context.getBean(StudentA.class);
        System.err.println(studentA);
    }
}

