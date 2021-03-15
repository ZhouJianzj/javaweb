package com.Jianzhou.controller;

import com.Jianzhou.dao.UserDao;
import com.Jianzhou.entity.UserFm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取请求头中的数据
        request.setCharacterEncoding("utf-8");
        //创建检测登录的dao层对象
        UserDao userDao = new UserDao();
        int check = userDao.check(request);
        int i = userDao.checkUserName(request);
        if (check == 1){
            //请求转发到导航页面,会话层对象是为防止被过滤器过滤掉
            HttpSession session = request.getSession();
            //存储用户的信心
            session.setAttribute("userName",request.getParameter("userName"));
            session.setAttribute("password",request.getParameter("password"));
            response.sendRedirect("DaoHang.html");
            return;
        }else if (i == 1){
            //账户密码错误,账户存在,下面的写法不读

           response.sendRedirect("Login.jsp?key=1");
        }else if (i == 0){
            //表示用户不存在需要注册
            response.sendRedirect("Login.jsp?key=0");

        }

    }

}
