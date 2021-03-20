package com.Jianzhou.dao;

import com.Jianzhou.entity.QuestionFrm;
import com.Jianzhou.utils.Jdbc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.*;

/**
 * @ClassName QuestionDao
 * @Description TODO
 * @Author
 * @Date 2021/3/16
 **/
public class QuestionDao {
    private Jdbc jdbc = new Jdbc();

    /**
     * 获取之前创建好的连接
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
     * 试题的添加
     * @param request
     * @return
     */
    public int addQuestion(HttpServletRequest request){
        int i = 0;
        if ( request.getParameter("A") == null ||
                request.getParameter("C") == null ||
                request.getParameter("D") == null ||
                request.getParameter("B") == null||
                request.getParameter("title") == null ||
                request.getParameter("rightOption") == null){
            System.out.println("其中有一个为空");
            return i;
        }
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,rightAnswer) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("title"));
            preparedStatement.setString(2,request.getParameter("A"));
            preparedStatement.setString(3,  request.getParameter("B"));
            preparedStatement.setString(4, request.getParameter("C"));
            preparedStatement.setString(5,request.getParameter("D"));
            preparedStatement.setString(6,request.getParameter("rightOption"));
            i = preparedStatement.executeUpdate();
            System.out.println("sql语句执行完毕! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return i;
    }

    /**
     * 试题发现
     * @param request
     * @return
     */
    public List findQuestion(HttpServletRequest request){
        ArrayList<Object> list = new ArrayList<>();
        String sql = "select * from question";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                QuestionFrm questionFrm = new QuestionFrm();
                questionFrm.setId(resultSet.getInt(1));
                questionFrm.setTitle(resultSet.getString(2));
                questionFrm.setOptionA(resultSet.getString(3));
                questionFrm.setOptionB(resultSet.getString(4));
                questionFrm.setOptionC(resultSet.getString(5));
                questionFrm.setOptionD(resultSet.getString(6));
                questionFrm.setRightAnswer(resultSet.getString(7));
                list.add(questionFrm);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(resultSet);
        }
        return list;
    }

    /**
     * 试题删除
     * @param request
     * @return
     */
    public int deleteQuestion(HttpServletRequest request){
        int i = 0;
        String id = request.getParameter("id");
        if (id == null){
            return i;
        }
        String sql = "delete from question where id = ?";
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1, id);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close();
        }
        return i;
    }

    /**
     * find需要修改的试题
     * @param request
     * @return
     */
    public QuestionFrm  findQuestionTwo(HttpServletRequest request){
            String sql = "select * from question where id = ?";
            ResultSet resultSet = null;
            QuestionFrm questionFrm = new QuestionFrm();
            try {
                PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
                preparedStatement.setString(1,request.getParameter("id"));
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    questionFrm.setId(resultSet.getInt(1));
                    questionFrm.setTitle(resultSet.getString(2));
                    questionFrm.setOptionA(resultSet.getString(3));
                    questionFrm.setOptionB(resultSet.getString(4));
                    questionFrm.setOptionC(resultSet.getString(5));
                    questionFrm.setOptionD(resultSet.getString(6));
                    questionFrm.setRightAnswer(resultSet.getString(7));

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                jdbc.close(resultSet);
            }
           return questionFrm;
        }

    /**
     * 修改试题
     * @param request
     * @return
     */
    public int alertQuestion(HttpServletRequest request){
        int i = 0;
        String sql = "update question set title = ?,optionA = ?,optionB = ?,optionC = ?,optionD = ?,rightAnswer = ? where id = ?";
        PreparedStatement preparedStatement = null;
        if ( request.getParameter("A") == null ||
                request.getParameter("C") == null ||
                request.getParameter("D") == null ||
                request.getParameter("B") == null||
                request.getParameter("title") == null ||
                request.getParameter("rightOption") == null){
            return i;
        }
        try {
            preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("title"));
            preparedStatement.setString(2,request.getParameter("A"));
            preparedStatement.setString(3,  request.getParameter("B"));
            preparedStatement.setString(4, request.getParameter("C"));
            preparedStatement.setString(5,request.getParameter("D"));
            preparedStatement.setString(6,request.getParameter("rightOption"));
            preparedStatement.setString(7,request.getParameter("id"));
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbc.close();
        }
        return i;
    }

    /**
     * 试题的查找
     * @param request
     * @return
     */
    public List search(HttpServletRequest request){
        ArrayList<Object> list = new ArrayList<>();
        String title = request.getParameter("title");
        String sql = "select * from question where title like ?\"%\" ";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,title);
            resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               QuestionFrm questionFrm = new QuestionFrm(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
               list.add(questionFrm);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(resultSet);
        }
        return list;
    }

    /**
     * 随机生成试题
     * @param request
     * @param num
     * @return
     */
    public List startTest(HttpServletRequest request,int num){
        ArrayList<Object> list = new ArrayList<>();
        String sql = "select * from question order by rand() limit  ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setInt(1,num);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                QuestionFrm questionFrm = new QuestionFrm(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
               list.add(questionFrm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(resultSet);
        }
        return list;
    }

}
