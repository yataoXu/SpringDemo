package com.dynamicdatasource;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import	java.lang.annotation.Target;


import java.lang.annotation.Documented;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicRoutingDataSource {
    String value() default "dataSource";//本文默认dataSource

}
