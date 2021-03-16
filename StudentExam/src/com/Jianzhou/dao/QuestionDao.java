package com.Jianzhou.dao;

import com.Jianzhou.utils.Jdbc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

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

    public int addQuestion(HttpServletRequest request){

        int i = 0;

        if ( request.getParameter("a") == null ||
                request.getParameter("b") == null ||
                request.getParameter("c") == null ||
                request.getParameter("d") == null||
                request.getParameter("title") == null ||
                request.getParameter("rightOption") == null){
            return i;
        }
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,rightAnswer) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getCon(request).prepareStatement(sql);
            preparedStatement.setString(1,request.getParameter("title"));
            preparedStatement.setString(2,request.getParameter("a"));
            preparedStatement.setString(3,  request.getParameter("b"));
            preparedStatement.setString(4, request.getParameter("c"));
            preparedStatement.setString(5,request.getParameter("d"));
            preparedStatement.setString(6,request.getParameter("rightOption"));
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return i;
    }
}
