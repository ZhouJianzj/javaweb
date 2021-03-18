package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class publicFindQuestionServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao questionDao = new QuestionDao();
        List question = questionDao.findQuestion(request);
        request.setAttribute("list",question);
        request.getRequestDispatcher("findAndDeleteAndAlter.jsp").forward(request,response);
    }
}
