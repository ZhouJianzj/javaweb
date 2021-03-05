package com.jianzhou;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class fourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    学习里面的httpServletRequest接口
        response.sendRedirect("http://localhost:8080/webBases_war_exploded/four.html?userName=zhoujian&password=12312");
        //得到请求的url
        StringBuffer requestURL = request.getRequestURL();
        //得到请求的uri
        String requestURI = request.getRequestURI();
        //得到请求的method
        String method = request.getMethod();
        PrintWriter writer = response.getWriter();
        writer.println("URL:" + requestURL);
        writer.println("URI:" + requestURI);
        writer.println("Method:" + method);
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
        //获取参数的名字
            String name = parameterNames.nextElement();
        //获取参数的值
            String value = request.getParameter(name);
            System.out.println(name + value);
        }

    }
}
