package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;
import com.Jianzhou.entity.QuestionFrm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class questionSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        List search = questionDao.search(request);
        HttpSession session = request.getSession();
        session.setAttribute("list",search);
        request.getRequestDispatcher("findAndDeleteAndAlter.jsp").forward(request,response);
        System.out.println("查询执行中》》》》》》》》》");
    }
}
