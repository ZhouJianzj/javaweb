package com.Jianzhou.dao;

import com.Jianzhou.entity.UserFm;
import com.Jianzhou.utils.Jdbc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.TabableView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class UserDao {
    private Jdbc jdbc = new Jdbc();


    /**
     * 得到之前创建的连接
     * @param request
     * @return
     */
    public Connection getCon(HttpServletRequest request){
        Connection con = null;
        //获取全局变量中的map
        ServletContext servletContext = request.getServletContext();
        Map mapAll = (Map) servletContext.getAttribute("mapAll");
        Iterator iterator = mapAll.keySet().iterator();
        while (iterator.hasNext()){
            Connection next = (Connection)iterator.next();
            Boolean falg =(Boolean) mapAll.get(next);
            if (falg == true){
                con = next;
                falg = false;
                break;
            }
        }
        return con;
    }
    /**
     * 检测登录的
     * @param user
     * @return 1 表示有存在用户
     */
    public int check(UserFm user){
        int i = 0;
        String sql  = "select count(*) from users where userName = ? && psd = ?";

        jdbc.createConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = jdbc.CreatePreparement(sql);
        try {
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPsd());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(1);
                i = Integer.parseInt(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return i;
    }
    //连接池中获取连接
    public int check( HttpServletRequest request){
        int i = 0;
        String sql  = "select count(*) from users where userName = ? && psd = ?";
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("userName"));
            preparedStatement.setString(2,request.getParameter("password"));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(1);
                i = Integer.parseInt(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return i;
    }

    /**
     * 检测是否需要注册 ,1用户存在 ，0代表需要需要注册，都不是表示是有重复的用户
     * @param user
     * @return
     */
    public int checkUserName(UserFm user){
        int i = 0;
        String sql  = "select count(*) from users where userName = ?";
        jdbc.createConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = jdbc.CreatePreparement(sql);
        try {
            preparedStatement.setString(1,user.getUserName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(1);
                i = Integer.parseInt(string);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return i;
    }
    //连接池中获取连接
    public int checkUserName(HttpServletRequest request){
        int i = 0;
        String sql  = "select count(*) from users where userName = ?";

        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("userName"));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String string = resultSet.getString(1);
                i = Integer.parseInt(string);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return i;
    }

    /**
     * 用户的注册
     * @param userFm
     * @return
     */
    public int userSignIn(UserFm userFm){
        int i = 0;
        String sql = "insert into users(userName,psd,email,gender)values(?,?,?,?)";
        jdbc.createConnection();
        PreparedStatement preparedStatement = jdbc.CreatePreparement(sql);
        try {
            preparedStatement.setString(1, userFm.getUserName());
            preparedStatement.setString(2, userFm.getPsd());
            preparedStatement.setString(3, userFm.getEmail());
            preparedStatement.setString(4, userFm.getGender());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i ;

    }
    //使用创建好的连接
    public int userSignIn(HttpServletRequest request){
        int i = 0;
        String sql = "insert into users(userName,psd,email,gender)values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1, request.getParameter("userName"));
            preparedStatement.setString(2,request.getParameter("psd"));
            preparedStatement.setString(3, request.getParameter("email"));
            preparedStatement.setString(4, request.getParameter("gender"));
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i ;

    }

    /**
     * 获取用户的信息
     * @param name
     * @param password
     * @return
     */
    public UserFm find(String name,String password){
        String sql  = "select * from users where userName = ? && psd = ?";

        jdbc.createConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = jdbc.CreatePreparement(sql);
        UserFm userFm = new UserFm();
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userName = resultSet.getString(2);
                String psd = resultSet.getString(3);
                String email = resultSet.getString(4);
                String gender = resultSet.getString(5);
                userFm.setUserName(userName);
                userFm.setPsd(psd);
                userFm.setEmail(email);
                userFm.setGender(gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return userFm;
    }
    //连接池中获取连接
    public UserFm find(HttpServletRequest request){
        String sql  = "select * from users where userName = ? && psd = ?";
        ResultSet resultSet = null;
        UserFm userFm = new UserFm();
        HttpSession session = request.getSession();
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1, (String)session.getAttribute("userName"));
            preparedStatement.setString(2, (String)session.getAttribute("password"));
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userName = resultSet.getString(2);
                String psd = resultSet.getString(3);
                String email = resultSet.getString(4);
                String gender = resultSet.getString(5);
                userFm.setUserName(userName);
                userFm.setPsd(psd);
                userFm.setEmail(email);
                userFm.setGender(gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close(resultSet);
        }
        return userFm;
    }

    /**
     *用户数据修改的操作
     * @param userFm
     * @return
     */
    public  int updataUser(UserFm userFm){
        int i = 0;
        String sql = "update users set psd = ?,email = ?,gender = ? where userName = ?";
        jdbc.createConnection();
        PreparedStatement preparedStatement = jdbc.CreatePreparement(sql);
        try {
            preparedStatement.setString(1,userFm.getPsd());
            preparedStatement.setString(2,userFm.getEmail());
            preparedStatement.setString(3,userFm.getGender());
            preparedStatement.setString(4,userFm.getUserName());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return i;
    }
    //连接池中获取连接
    public  int updataUser(HttpServletRequest request){
        int i = 0;
        String sql = "update users set psd = ?,email = ?,gender = ? where userName = ?";
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("password"));
            preparedStatement.setString(2,request.getParameter("email"));
            preparedStatement.setString(3,request.getParameter("gender"));
            preparedStatement.setString(4,request.getParameter("userName"));
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return i;
    }
}


