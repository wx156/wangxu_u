package com.kfm.mybatis02.controller.exception;

import com.kfm.mybatis02.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public String myServiceException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return "发生异常了: " + runtimeException.getMessage();
    }
    @ExceptionHandler(value = ServiceException.class)
    public ModelAndView myServiceException(ServiceException serviceException, HttpServletRequest request, HttpServletResponse response) {
        serviceException.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @ExceptionHandler(value = Exception.class)
    public ModelAndView myException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        exception.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.addObject("cause", exception.getCause());
        modelAndView.addObject("status", response.getStatus());
        modelAndView.addObject("path", request.getRequestURI());
        return modelAndView;
    }
}
