package com.jianzhou.dao;

import com.jianzhou.utils.initJdbc;

import javax.naming.Name;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 对用户这个对象的操作（跟新数据库的）
 * @ClassName User
 * @Description TODO
 * @Author ZhouJian
 * @Date 2021/3/7
 **/
public class UserDao {
    private com.jianzhou.utils.initJdbc initJdbc = new initJdbc();
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
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        int i = userDao.userAdd("zhoujian", "123", "2998678997@qq.com", "男");
        System.out.println(i);

    }
}
