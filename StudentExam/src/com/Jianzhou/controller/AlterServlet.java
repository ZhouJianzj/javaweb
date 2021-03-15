package com.Jianzhou.controller;

import com.Jianzhou.dao.UserDao;
import com.Jianzhou.entity.UserFm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里不需要判空是因为当没有userName为空的就执行不了修改操作
        UserDao userDao = new UserDao();
        int i = userDao.updataUser(request);
        request.setAttribute("num",i);
        request.getRequestDispatcher("FindAndAlter.jsp").forward(request,response);

    }
}
