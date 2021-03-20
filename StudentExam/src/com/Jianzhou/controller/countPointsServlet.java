package com.Jianzhou.controller;

import com.Jianzhou.dao.QuestionDao;
import com.Jianzhou.entity.QuestionFrm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class countPointsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        int count = 0;
        Enumeration<String> parameterNames = request.getParameterNames();
        HttpSession session = request.getSession();
        //得到之前的list
        List list = (List)session.getAttribute("list");
        Iterator iterator = list.iterator();
        while (parameterNames.hasMoreElements()){
            //得到的是key
            String s = parameterNames.nextElement();
            int i = Integer.parseInt(s);
            System.out.print("题号：" + i);
            String option = request.getParameter(s);
            System.out.println("===》考生所选：" +  option);
            while (iterator.hasNext()){
                QuestionFrm next = (QuestionFrm) iterator.next();
                int id = next.getId();
                String rightAnswer = next.getRightAnswer();
                if (id == i && option.equals(rightAnswer)){
                    count++;
                    break;
                }
            }
        }
        session.setAttribute("rightNum",count);
        request.getRequestDispatcher("points.jsp").forward(request,response);


    }
}
