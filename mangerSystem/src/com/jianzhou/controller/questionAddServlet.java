package com.jianzhou.controller;

import com.jianzhou.dao.QuestionDao;
import com.jianzhou.entity.QuestionFrm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class questionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Integer id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter(" optionB");
        String optionC = request.getParameter(" optionC");
        String optionD = request.getParameter("optionD");
        String rightAnswer = request.getParameter("rightAnswer");
        //创建一个对象来存储这些请求中得到的数据
        QuestionFrm questionFrm = new QuestionFrm(id,title,optionA,optionB,
                optionC,optionD,rightAnswer);
        //调用dao层的方法实现数据库的试题的添加
        QuestionDao questionDao = new QuestionDao();
        int add = questionDao.add(questionFrm);
        //jsp 和servlet之间的合作,涉及到数据共享个请求转发机制
        if (add == 1){
            request.setAttribute("add",1);
        }else{
            request.setAttribute("add",0);
        }
        request.getRequestDispatcher("/mangerSystem_war_exploded/questionAddJsp.jsp").forward(request,response);
    }
}
