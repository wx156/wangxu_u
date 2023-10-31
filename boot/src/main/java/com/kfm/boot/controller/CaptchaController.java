package com.kfm.boot.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class CaptchaController {
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request , HttpServletResponse response) throws IOException {
        GifCaptcha gifCaptcha = new GifCaptcha(100, 30,3);
        CaptchaUtil.out(gifCaptcha,request,response);
    }
}
