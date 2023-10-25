package com.kfm.web.servlet;

import com.kfm.web.entity.User;
import com.wf.captcha.utils.CaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String captcha = req.getParameter("captcha");
        // 校验验证码
        if (!CaptchaUtil.ver(captcha, req)) {
            // 验证码错误
            // 清除验证码
            CaptchaUtil.clear(req);
            resp.sendRedirect("register.html");
            return;
        }
        // 清除验证码
        CaptchaUtil.clear(req);


        if ((!password.isEmpty() && !passwordConfirm.isEmpty()) && !password.equals(passwordConfirm)){
            resp.sendRedirect("register.html");
            return;
        }
        



        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<span>注册成功，三秒后前往登录页面，或点击</span><a href='index.html'>登录</a>立即跳转");
        resp.setHeader("refresh", "3;url=index.html");
    }
}
