package com.jianzhou.dao;

import com.jianzhou.entity.UserFrm;
import com.jianzhou.utils.initJdbc;

import javax.naming.Name;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对用户这个对象的操作（跟新数据库的）
 * @ClassName User
 * @Description TODO
 * @Author ZhouJian
 * @Date 2021/3/7
 **/
public class UserDao {
    private com.jianzhou.utils.initJdbc initJdbc = new initJdbc();

    /**
     * 用户注册
     * @param userName
     * @param pwd
     * @param email
     * @param gender
     * @return
     */
    public int userAdd(String userName,String pwd, String email,String gender){
        String sql = "insert into users(userName,psd,email,gender)values(?,?,?,?)";
        initJdbc.createConnection();
        PreparedStatement preparedStatement = initJdbc.CreatePreparement(sql);
        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pwd);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, gender);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            initJdbc.close();
            //表示没有进行数据的插入，用户没有注册
        }
        return 0;
    }

    /**
     * 用户的查询
     * @return
     */
    public List userFind(){
        List list = new ArrayList();
        String sql = "select * from users";
        initJdbc.createConnection();
        PreparedStatement preparedStatement = initJdbc.CreatePreparement(sql);
        ResultSet resultSet = null;
        try {
             resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String psd = resultSet.getString(3);
                String email = resultSet.getString(4);
                String gender = resultSet.getString(5);
                list.add(new UserFrm(id,userName,psd,email,gender));
//                System.out.println("成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            initJdbc.close(resultSet);
        }
        return list;
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public int login(String userName, String password ){
        int a = 0;
        String sql = "select count(*) from users where userName = ? and psd = ?";
        initJdbc.createConnection();
        PreparedStatement preparedStatement = initJdbc.CreatePreparement(sql);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                a = resultSet.getInt(1);
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (resultSet != null) {
                initJdbc.close(resultSet);
            }
        }

        return a;
    }
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        int i = userDao.userAdd("zhoujian", "123", "2998678997@qq.com", "男");
//        System.out.println(i);
//        List list = userDao.userFind();
        System.out.println(userDao.login("zhoujian", "123"));

    }
}
