package com.Jianzhou.utils;

import javax.servlet.ServletContext;
import java.sql.*;

/**
 * @ClassName Jdbc
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class Jdbc {
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
    public Connection createConnection(int t){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mangerSystem",
                    "root","123321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
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

//   连接池就不需要   connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet resultSet){
        if (preparedStatement != null && connection != null) {
            try {
                resultSet.close();
                close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
