package com.kfm.mybatis02.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码控制器类
 */
@Controller
public class CaptchaController {

    /**
     * 生成验证码图片
     *
     * @param request  请求对象
     * @param response 响应对象
     * @throws IOException IO异常
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GifCaptcha gifCaptcha = new GifCaptcha(100, 30, 3);
        CaptchaUtil.out(gifCaptcha, request, response);
    }
}

