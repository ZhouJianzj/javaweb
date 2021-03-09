package com.jianzhou.controller;

import com.jianzhou.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class userDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        int result = userDao.delete(id);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (result == 1){
            writer.println("<br><br><br><br><center style=\"font-size: 30px;color: red;\">删除成功！！<center/>");
        }else{
            writer.println("删除失败！");
        }
    }
}
