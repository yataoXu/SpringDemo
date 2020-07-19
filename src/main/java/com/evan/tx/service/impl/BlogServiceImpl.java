package com.evan.tx.service.impl;

import com.evan.tx.Blog;
import com.evan.tx.service.BlogService;
import com.evan.tx.service.BlogService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @ClassName BlogServiceImpl
 * @Author Evan
 * @date 2020.07.15 13:06
 */

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BlogService2 blogService2;

    @Override
    public void save(Blog blog, int deleteId) {

        String sql = "insert into blog values(?,?,?)";
        jdbcTemplate.update(sql,
                new Object[]{blog.getId(), blog.getName(), blog.getUr()},
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR});

        blogService2.delete(deleteId);


    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void update(Blog blog) {

        String sql = "update blog set name = ? where id=?";
        jdbcTemplate.update(sql, new Object[]{blog.getName(), blog.getId()},
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
    }


}
