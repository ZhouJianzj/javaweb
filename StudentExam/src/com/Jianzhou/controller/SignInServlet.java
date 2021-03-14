package com.Jianzhou.controller;

import com.Jianzhou.dao.UserDao;
import com.Jianzhou.entity.UserFm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建对象
        String name = request.getParameter("userName");
        String psd = request.getParameter("psd");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        UserFm userFm = new UserFm(name,psd,email,gender);
        UserDao userDao = new UserDao();
        if (name == null || psd == null || gender ==null || email == null){
          response.sendRedirect("signIn.html");
            System.out.println("没有填写注册数据");
            return;}
        //检测是否存在相同的用户名
        int countUserName = userDao.checkUserName(userFm);
        System.out.println(countUserName);
        System.out.println(userFm.getUserName() +userFm.getPsd());
        if (countUserName >= 1){
            //用户名已存在,1表示用户名存在了，11 表示存储成功，0表示没有存储成功
            request.getRequestDispatcher("signIn.jsp?do=1").forward(request,response);
        }else {
            //插入用户的注册数据
            int i = userDao.userSignIn(userFm);
            if (i == 1){
                request.getRequestDispatcher("signIn.jsp?do=11").forward(request,response);
            }else{
                request.getRequestDispatcher("signIn.jsp?do=0").forward(request,response);
            }
        }

    }
}
