package com.jianZhou.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class addGouWuCheServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取加入购物车的信息
        String value = request.getParameter("name");
//        获取会话层
        HttpSession session = request.getSession();
//        下面进行增加操作的
        Integer attribute = (Integer) session.getAttribute(value);
        if (attribute == null){
            session.setAttribute(value,1);
        }else {
            session.setAttribute(value,attribute+1);
        }

//        向浏览器发送请求的
        response.sendRedirect("/gouWuChe/gouWu.html");


    }
}
