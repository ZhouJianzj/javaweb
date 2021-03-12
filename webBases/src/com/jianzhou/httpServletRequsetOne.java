package com.jianzhou;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "httpServletRequsetOne")
public class httpServletRequsetOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第四种数据共享方法
        request.setAttribute("name",1);
        request.getRequestDispatcher("/myWeb/RequestTwo").forward(request,response);
    }
}
