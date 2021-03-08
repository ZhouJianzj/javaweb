package com.jianzhou.controller;

import com.jianzhou.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class userLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName ,password;
        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        UserDao userDao = new UserDao();
        int login = userDao.login(userName, password);
        if (login == 1){
            response.sendRedirect("http://localhost:8080/mangerSystem_war_exploded/daoHang.html");
        }else{
            response.sendRedirect("http://localhost:8080/mangerSystem_war_exploded/login.error.html");
        }
    }


}
