package com.evan;

import com.evan.tx.Blog;
import com.evan.tx.TxConfig;
import com.evan.tx.service.UserService;
import com.evan.tx.service.BlogService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest_Tx {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.insertUser();
        applicationContext.close();
    }

    @Test
    public void Test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
        BlogService service = ac.getBean(BlogService.class);

        Blog b = new Blog();
        b.setName("lisi");
        b.setUr("url");
        service.save(b,18);
    }
}

