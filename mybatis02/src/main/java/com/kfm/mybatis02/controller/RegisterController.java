package com.kfm.mybatis02.controller;

import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.impl.UserServiceImpl;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(UserModel userModel,String captcha,String password, String repassword, HttpServletRequest request) throws ServiceException {
        if (ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(repassword) ||!password.equals(repassword)) {
            // 密码不一致
            return new ModelAndView("register");
        }
        // 校验验证码
        if (!CaptchaUtil.ver(captcha, request)) {
            // 验证码错误
            // 清除验证码
            CaptchaUtil.clear(request);
            // 重定向到登录页面
            return new ModelAndView("register");
        }
        // 清除验证码
        CaptchaUtil.clear(request);

        if (userService.register(userModel) == null){
            return new ModelAndView("register");
        };
        return new ModelAndView("login");
    }
}
