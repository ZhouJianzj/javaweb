package com.jianzhou;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


@WebServlet(name = "threeServlet")
public class threeServlet extends HttpServlet {
/*
    HttpServletResponse 响应接口
    1、输出为 字符串、字符、ascii码 使用println
 */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       想要看见下面的效果需要注释掉最后一段代码，
//       输出字符串、字符、ascii 码
        String string = "java and mysql and javaWeb  ";
        //为后面的汉字输出和html语句做好准备
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //输出的是一样的java and mysql and javaweb
        writer.write(string);
        // 输出的是2 的ascii码 ，所以要输出为50 就学要使用到的是print
        writer.write(50);

//      输出汉字参杂着html
        String stringOne = "<br/>字符字符串参杂<br/>着html";
        //设置contenttype和字符集，并且使用println
        writer.println(stringOne);
        writer.println(50);


//      改变地址栏，注释掉下面的代码
        String url = "http://www.baidu.com";
        //通过这个方法设置浏览器中的location地址栏的参数
        response.sendRedirect(url);

    }
}
