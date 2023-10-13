package com.kfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/parameter")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ParameterServlet 接收到请求");

        // 设置请求编码
        request.setCharacterEncoding("utf-8");

        // 获取请求参数
        String username = request.getParameter("username");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("username : " + username);

        // 获取请求参数 keys
//        Enumeration<String> parameterNames = request.getParameterNames();
//
//        // 遍历
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            // 获取请求参数的值
//            String value = request.getParameter(name);
//            System.out.println(name + " : " + value);
//        }

        // 获取请求参数的 Map 集合
//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        // 遍历
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//        Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
//
//        while (iterator.hasNext()){
//            Map.Entry<String, String[]> next = iterator.next();
//            String name = next.getKey();
//            String[] value = next.getValue();
//            System.out.println(name + " : " + Arrays.toString(value));
//        }


        /*
            servletContext.getContextPath() 获取当前项目的路径
            request.getContextPath() 获取当前项目的路径
            request.getServletPath() 获取当前请求的资源路径
         */
        System.out.println(request.getContextPath()); // web02_war_exploded
        System.out.println(request.getServletPath()); // /parameter


        // 获取请求参数的 URI, get 请求方式才有值，post 请求方式为 null
        String queryString = request.getQueryString();
        System.out.println(queryString); // username=123&hobby=eat&hobby=drink

    }
}
