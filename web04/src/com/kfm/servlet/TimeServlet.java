package com.kfm.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/plain;charset=utf-8");
        //获取cookie
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();
        boolean isFirst = true;
        //遍历cookie
        for (Cookie cookie : cookies) {
            if ("lastTime".equals(cookie.getName())) {
                String value = cookie.getValue();
                writer.println("上一次访问时间为" + value);
                isFirst = false;
            }
        }
        if (isFirst) {
            writer.println("这是您第一次访问此网站");
        }
        //获取当前时间
        String string = LocalTime.now().toString();
        Cookie cookie = new Cookie("lastTime", string);
        //设置生命周期
        cookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie);
    }
}
