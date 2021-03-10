package com.jianzhou;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataChuanDiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        下面是请求转发实现多个servlet之间的交互
        //得到请求申请表
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myWeb/dataChuanDiOne");
        //申请表提前说明
        requestDispatcher.forward(request,response);
        System.out.println("servletOne 执行");
    }
}
