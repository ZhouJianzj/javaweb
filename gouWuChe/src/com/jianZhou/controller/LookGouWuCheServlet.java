package com.jianZhou.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class LookGouWuCheServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
//        获取到所有的key
        Enumeration<String> attributeNames = session.getAttributeNames();
        writer.write("<br><br><br><br>");
        writer.write("<center>");
        writer.write("<table border = \"1\">");
        while (attributeNames.hasMoreElements()){
            //遍历key
            String s = attributeNames.nextElement();
            //获取key的值
            int num = (int)session.getAttribute(s);

            writer.write("<tr>");
            writer.write("<td>");
            writer.write(s);
            writer.write("<td>");
            writer.write("<td>");
            writer.write(num +"");
            System.out.println(num);
            writer.write("</td>");
            writer.write("</tr>");

        }
        writer.write("</table>");
        writer.write("</center>");
    }
}
