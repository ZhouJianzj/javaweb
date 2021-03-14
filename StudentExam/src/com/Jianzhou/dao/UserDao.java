package com.Jianzhou.dao;

import com.Jianzhou.entity.UserFm;
import com.Jianzhou.utils.Jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class UserDao {
    private Jdbc jdbc = new Jdbc();
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
}
