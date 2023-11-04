package com.kfm.mybatis02.exception;

public class ServiceException extends Exception{


    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
