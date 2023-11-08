package com.kfm.mybatis02.controller;


import com.kfm.mybatis02.util.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class LogoutController {
    /**
     * 退出登录
     * @param request HTTP请求
     * @return 重定向到登录页面的视图
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        // 注销登录
        HttpSession session = request.getSession();
        session.removeAttribute(Constant.LOGIN_USER);
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }
}

