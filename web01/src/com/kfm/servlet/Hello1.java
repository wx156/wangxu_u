package com.kfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello1")
public class Hello1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp1) throws ServletException, IOException {
        super.doPost(request, resp1);
        System.out.println("ParameterServlet 接收到请求");

        // 设置请求编码
        request.setCharacterEncoding("utf-8");

        // 获取请求参数
        String username = request.getParameter("username");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("username : " + username);
    }
}
