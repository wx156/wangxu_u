package com.kfm.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class CaptchaController {
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request , HttpServletResponse response){

    }
}
