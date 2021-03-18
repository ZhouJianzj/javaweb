package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class deleteQuestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("删除开始执行!");
        QuestionDao questionDao = new QuestionDao();
        int i = questionDao.deleteQuestion(request);
        HttpSession session = request.getSession();
        //0空或者删除失败,1删除成功
        session.setAttribute("delete",i);
        request.getRequestDispatcher("/publicFind").forward(request,response);

    }
}
