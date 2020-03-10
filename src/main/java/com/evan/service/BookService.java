package com.evan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class BookService {

    @Value("classpath:person.properties")
    private Resource resource;

    @Value("classpath:person.properties")
    private Properties properties;



    public Properties getProperties(){
        return this.properties;
    }

    public Resource getResource(){
        return this.resource;
    }


}