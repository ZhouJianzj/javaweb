package com.zhouJian.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dianChanServlet")
public class dianChanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//处理点餐的
        //需要的变量
        String key = null;
        String value = null;
        String userName = null;
        String userNameValue = null;
        String money = null;
        String moneyValue = null;
        //得到cookie数组
        Cookie[] cookies = request.getCookies();
        for (Cookie c :cookies){
             key = c.getName();
             value = c.getValue();
             //按条件赋值
             if ("userName".equals(key)){
                 userName = key;
                 userNameValue = value;
             }else if ("money".equals(key)){
                 money = key;
                 moneyValue = value;
             }
        }
        //获取发来的点餐信息,得到的是食物的名字 30 25 20 15 10
        int shuiJiao_money = 30;
        int hunDun_money  = 25;
        int gaiFan_money = 20;
        int mianTiao_money = 15;
        int chaoFan_money = 10;
        String food = request.getParameter("food");
        //转换为intMoney
        int intMoney = Integer.parseInt(moneyValue);
        //设置响应
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if ("shuiJiao".equals(food)){
            if (intMoney >= shuiJiao_money){
//     这里面更新cookie里面的数据 重现new一个会自动的覆盖掉之前的
                //下面别的点餐系统一次的一样的代码
                Cookie money1 = new Cookie("money", String.valueOf((intMoney - shuiJiao_money)));
                response.addCookie(money1);
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + (intMoney-shuiJiao_money) +
                        " 正在为你加速制作中。。。。</font><a href = \"/xianShangDingCan/dingCanJieMian.html\">继续点餐</a></center>");
            }else {
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + intMoney + " 不支持你吃那么贵的了</font></center>");
            }
            return;
        }else if ("hunDun".equals(food)){
            if (intMoney >= hunDun_money){
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + (intMoney-hunDun_money) + " 正在为你加速制作中。。。。</font></center>");
            }else {
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + intMoney + " 不支持你吃那么贵的了</font></center>");
            }
            return;
        }else if ("gaiFan".equals(food)){
            if (intMoney >= gaiFan_money){
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + (intMoney-gaiFan_money) + " 正在为你加速制作中。。。。</font></center>");
            }else {
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + intMoney + " 不支持你吃那么贵的了</font></center>");
            }
            return;
        }else if("mianTiao".equals(food)){
            if (intMoney >= mianTiao_money){
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + (intMoney-mianTiao_money) + " 正在为你加速制作中。。。。</font></center>");
            }else {
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + intMoney + " 不支持你吃那么贵的了</font></center>");
            }
            return;
        }else if("chaoFan".equals(food)){
            if (intMoney >= chaoFan_money){
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + (intMoney-chaoFan_money) + " 正在为你加速制作中。。。。</font></center>");
            }else {
                writer.print("<br><br><br><br><center><font size = \"30\">当前余额为：" + intMoney + " 不支持你吃那么贵的了</font></center>");
            }
            return;
        }
    }
}
