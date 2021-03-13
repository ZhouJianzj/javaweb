package com.jianzhou.dao;

import com.jianzhou.entity.QuestionFrm;
import com.jianzhou.utils.initJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName QuestionDao
 * @Description TODO
 * @Author
 * @Date 2021/3/13
 **/
public class QuestionDao {
     private com.jianzhou.utils.initJdbc initJdbc = new initJdbc();

    /**
     * 题目的添加
     * @param questionFrm
     * @return
     */
    public int add(QuestionFrm questionFrm){
        int i = 0;
        String sql = "insert into question(id,title,optionA,optionB,optionC,optionD,rightAnswer)value(?,?,?,?,?,?,?)";
        initJdbc.createConnection();
        PreparedStatement preparedStatement = initJdbc.CreatePreparement(sql);
        try {
            preparedStatement.setInt(1,questionFrm.getId());
            preparedStatement.setString(2,questionFrm.getTitle());
            preparedStatement.setString(3,questionFrm.getOptionA());
            preparedStatement.setString(4,questionFrm.getOptionB());
            preparedStatement.setString(5,questionFrm.getOptionC());
            preparedStatement.setString(6,questionFrm.getOptionD());
            preparedStatement.setString(7,questionFrm.getRightAnswer());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            initJdbc.close();
        }
        return i;
    }
}
