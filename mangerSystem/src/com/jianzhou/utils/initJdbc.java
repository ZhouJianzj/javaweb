package com.jianzhou.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName initJdbc
 * @Description TODO
 * @Author
 * @Date 2021/3/6
 **/
public class initJdbc {
    /**
     * 全局变量
     */
    private Connection connection;
    private PreparedStatement preparedStatement;
    /**
     * 注册驱动
     */
   static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建连接
     */
    public void createConnection(){
        try {
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mangerSystem",
                   "root","123321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createConnection(ServletContext request){
//        Map keyMap = (Map) request.getAttribute("keyMap");
//        //测试
//        System.out.println(keyMap);
//        Iterator iterator = keyMap.keySet().iterator();
//        while (iterator.hasNext()){
//            initJdbc initJdbc =(initJdbc) iterator.next();
//
//            //map中获取value的方法get（keyName）
//            boolean falg = (Boolean) keyMap.get(initJdbc.connection);
//            //判断是否被占用
//            if (falg == true){
//                //传递连接到当前的
//                this.connection = connection;
//                //表示被占用了
//                falg = true;
//                break;
//            }
//        }
    }
    /**
     *创建运输工具
     *
     */
    public PreparedStatement CreatePreparement(String sql){
        try {
             preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return this.preparedStatement;
        }

    }
    /**
     * 停止运输关闭连接,有的有结果集就需要关闭
     *
     */
    public void close(){
        if (preparedStatement != null && connection != null) {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet resultSet){
        if (preparedStatement != null && connection != null) {
            try {
                preparedStatement.close();
                connection.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        initJdbc initJdbc = new initJdbc();
        initJdbc.createConnection();
       PreparedStatement preparedStatement = initJdbc.CreatePreparement("select userName from users where id = 1");
        ResultSet resultSet = null;
        try {
           resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(1);
                System.out.println(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
//                关闭resultSet and preparedStatement and connection
                initJdbc.close(resultSet);
            }
        }
    }
}
