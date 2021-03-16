package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        int i = questionDao.addQuestion(request);
        request.setAttribute("add",i);
        request.getRequestDispatcher("question.jsp").forward(request,response);
    }
}
