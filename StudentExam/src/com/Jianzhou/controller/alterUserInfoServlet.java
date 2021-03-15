package com.Jianzhou.controller;

import com.Jianzhou.dao.UserDao;
import com.Jianzhou.entity.UserFm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class alterUserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查找用户信息
        UserDao userDao = new UserDao();
        UserFm userFm = userDao.find(request);
        //数据共享 httpServletRequest，请求转发
        request.setAttribute("UserFm",userFm);
        //为下面修改是否成功做好准备
        request.setAttribute("num",-1);
        request.getRequestDispatcher("FindAndAlter.jsp").forward(request,response);
    }
}
