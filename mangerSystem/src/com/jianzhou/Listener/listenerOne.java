package com.jianzhou.Listener;

import com.jianzhou.utils.initJdbc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName listenerOne
 * @Description TODO
 * @Author
 * @Date 2021/3/12
 **/
public class listenerOne implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //创建多个connect通道
        Map map = new HashMap();
        for (int i = 0; i < 20; i++){
            initJdbc initJdbc = new initJdbc();
            initJdbc.createConnection();
            //装对象的，true表示是空闲的
//  这里的键值对是initJdbc对象不是Connection对象，所以导致下面的全错
            map.put(initJdbc,true);
        }
        //把这个hashmap传到全局作用对象中去
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("keymap",map);
        System.out.println("通道创建完毕！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==========================");
    //销毁连接
        ServletContext servletContext = sce.getServletContext();
        //得到map集合
        Map keyMap = (Map) servletContext.getAttribute("keyMap");
        //是由迭代器
        Iterator iterator = keyMap.keySet().iterator();
        while (iterator.hasNext()){
            //得到连接
            Connection connection =(Connection) iterator.next();
            if (connection != null) {
                try {
                    //关闭
                    connection.close();
                    System.out.println("通道已关闭！！！");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("资源销毁完毕！！");
    }

}
