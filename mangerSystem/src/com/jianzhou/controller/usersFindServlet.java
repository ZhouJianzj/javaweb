package com.jianzhou.controller;

import com.jianzhou.dao.UserDao;
import com.jianzhou.entity.UserFrm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "usersFindServlet")
public class usersFindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<UserFrm> list = userDao.userFind();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<br><br><br><br><table border = \"1px\" align = \"center\"><tr><th>编号</th><th>用户名</th><th>密码</th><th>邮箱</th><th>性别</th></tr>");
        for (UserFrm userFrm : list){
            writer.println("<tr>");
            writer.println("<td>" + userFrm.getId() + "</td>");
            writer.println("<td>" + userFrm.getUserName() + "</td>");
            writer.println("<td>" + userFrm.getPwd() + "</td>");
            writer.println("<td>" + userFrm.getEmail() + "</td>");
            writer.println("<td>" + userFrm.getGender() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
