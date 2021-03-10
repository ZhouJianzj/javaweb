package com.jianzhou;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doServletContextOne")
public class doServletContextOne extends HttpServlet {
//  获取doServletContext传递到全局对象中的key1值

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
//        获取全局对象中的key1的值
        Object value = servletContext.getAttribute("key1");
        System.out.println(value);
    }
}
