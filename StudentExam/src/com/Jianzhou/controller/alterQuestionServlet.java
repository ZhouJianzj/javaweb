package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class alterQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        int i = questionDao.alertQuestion(request);
        HttpSession session = request.getSession();
        session.setAttribute("alter",i);
        request.getRequestDispatcher("alterQuestion.jsp").forward(request,response);
        System.out.println("修改试题服务执行！");
    }
}
