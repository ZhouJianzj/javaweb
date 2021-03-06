package com.jianzhou.utils;

import java.sql.*;

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
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mangerSystem?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
                   "root","123321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *创建运输工具
     *
     */
    public PreparedStatement CreatePreparement(String sql){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        PreparedStatement preparedStatement = initJdbc.CreatePreparement("select userName from mangerSystem where id = 1");
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(2);
                System.out.println(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
