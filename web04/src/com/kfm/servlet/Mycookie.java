package com.kfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Mycookie")
public class Mycookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","text/plain;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        Cookie cookie = new Cookie("kfm","wwww");
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie1 : cookies){
            System.out.println(cookie1.getValue());
        }
    }
}
