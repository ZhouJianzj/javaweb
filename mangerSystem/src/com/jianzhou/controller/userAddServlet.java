package com.jianzhou.controller;

import com.jianzhou.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class userAddServlet extends HttpServlet {
    /**
     * 是signIn页面点击提交的时候执行的文件，实现用户的注册
     * 服务器自动的调用doGet方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到请求协议包头中传递过来的数据
        String userName,pwd,email,gender;
         userName = request.getParameter("userName");
         pwd = request.getParameter("pwd");
         email = request.getParameter("email");
         gender = request.getParameter("gender");
        UserDao userDao = new UserDao();
        int i = userDao.userAdd(userName, pwd, email, gender);
        PrintWriter writer = response.getWriter();
        writer.println(i);
    }
}
