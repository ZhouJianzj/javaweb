package com.Jianzhou.listener;

import com.Jianzhou.utils.Jdbc;

import javax.lang.model.element.VariableElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName AllListener
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class AllListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Jdbc jdbc = new Jdbc();
        ServletContext mapAll = sce.getServletContext();
        //创建一个map集合去装载这些通道
        HashMap<Object, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 1;i <=20; i++){
            Connection connection = jdbc.createConnection(20);
            //true表示的是没有被占用
            map.put(connection,true);
            count++;
            System.out.println("通道创建成功！" +count);
        }
        mapAll.setAttribute("mapAll",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Map mapAll =(HashMap) servletContext.getAttribute("mapAll");
        //得到所有key形成一个集合，集合里面的元素就是连接Connection
        Iterator iterator = mapAll.keySet().iterator();
        int count = 0;
        while (iterator.hasNext()){
            Connection next = (Connection) iterator.next();
            try {
                next.close();
                count++;
                System.out.println("关闭连接了" + count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
