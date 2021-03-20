package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class startTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        HttpSession session = request.getSession();
        int i = Integer.parseInt(request.getParameter("num"));
        if (i == 0){
           session.setAttribute("list",null);
        }else {
            List list = questionDao.startTest(request, i);
            session.setAttribute("list",list);
            request.getRequestDispatcher("test.jsp").forward(request,response);
        }
    }

}
