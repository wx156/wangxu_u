package com.kfm.mybatis02.controller;

import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.impl.UserServiceImpl;
import com.kfm.mybatis02.util.Constant;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import javax.websocket.Session;

@RestController
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping({"/", "/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserModel userModel, String captcha, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        // 校验验证码
        if (!CaptchaUtil.ver(captcha, request)) {
            // 验证码错误
            // 清除验证码
            CaptchaUtil.clear(request);
            // 重定向到登录页面
            redirectAttributes.addFlashAttribute("message", "验证码错误");
            return modelAndView;
        }

        // 清除验证码
        CaptchaUtil.clear(request);
        try {
            UserModel login = userService.login(userModel);
            if (login == null) {
                redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
                return modelAndView;
            }
            request.getSession().setAttribute(Constant.LOGIN_USER, login);
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        } catch (ServiceException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
