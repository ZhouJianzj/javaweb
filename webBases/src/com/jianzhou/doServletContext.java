package com.jianzhou;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doServletContext extends HttpServlet {
//传递key1到全局变量中去，全局对象中的数据是以map的形式存储
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        //设置要上传到全局对象中的变量
        servletContext.setAttribute("key1","one");
        System.out.println("key1上传完毕！");

    }
}
