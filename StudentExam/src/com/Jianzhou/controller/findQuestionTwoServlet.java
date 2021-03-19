package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;
import com.Jianzhou.entity.QuestionFrm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class findQuestionTwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao questionDao = new QuestionDao();
        QuestionFrm questionTwo = questionDao.findQuestionTwo(request);
        HttpSession session = request.getSession();
        session.setAttribute("obj", questionTwo);
        session.setAttribute("alter",-1);
        request.getRequestDispatcher("alterQuestion.jsp").forward(request,response);
    }
}
