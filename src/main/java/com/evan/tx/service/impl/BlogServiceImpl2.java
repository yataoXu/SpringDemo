package com.evan.tx.service.impl;

import com.evan.tx.service.BlogService2;
import com.evan.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @ClassName BlogServiceImpl2
 * @Author Evan
 * @date 2020.07.15 13:07
 */

@Transactional(propagation = Propagation.MANDATORY)
@Component
public class BlogServiceImpl2 implements BlogService2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Override
    public void delete(int id) {

        String sql = "delete from blog where id=?";
        jdbcTemplate.update(sql, id);

        userService.insertUser();
    }
}
