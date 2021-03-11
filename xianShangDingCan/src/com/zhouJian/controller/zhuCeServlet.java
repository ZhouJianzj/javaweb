package com.zhouJian.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "zhuCeServlet")
public class zhuCeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        处理注册的
        //获取注册会员信息
        String userName = request.getParameter("userName");
        String money = request.getParameter("money");
        //创建cookie对象跟随用户走的
        Cookie name = new Cookie("userName", userName);
        Cookie cMoney = new Cookie("money", money);
        //把cookie形式的数据共享对象添加到响应头中
        response.addCookie(name);
        response.addCookie(cMoney);
        //请求转发多个servlet之间的交互，服务器模仿浏览器发送请求定位先要的资源
        request.getRequestDispatcher("/dingCanJieMian.html").forward(request,response);


    }
}
