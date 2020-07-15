package com.evan.tx.service;


import com.evan.tx.Blog;

// 主要负责Blog的添加和修改
public interface BlogService {
    void save(Blog blog,int deleteId);
    void update(Blog blog);
}