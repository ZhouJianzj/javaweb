package com.zhoujian.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLoginIn extends HttpServlet {
    /**
     * 实现令牌机制
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过会话层的数据中的cookie来进行核对的
        HttpSession session = request.getSession(false);
        if (session ==null){
            PrintWriter writer = response.getWriter();
            writer.print("别想恶意登录");
        }else {
            request.getRequestDispatcher("/myWeb/two.jpg").forward(request,response);
        }
    }
}
