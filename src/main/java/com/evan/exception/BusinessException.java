package com.evan.exception;

/**
 * @Description
 * @ClassName BusinessException
 * @Author Evan
 * @date 2020.07.19 15:21
 */
public class BusinessException extends RuntimeException{

    private String code;
    private Object[] args;

}
