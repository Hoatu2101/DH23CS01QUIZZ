/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.question;

import com.dht.pojo.Category;
import com.dht.pojo.Choice;
import com.dht.pojo.Question;
import com.dht.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices implements  BaseQuestionServices{

    @Override
    public String getSQL(List<Object> params) {
        return "SELECT * FROM question WHERE 1 =1";// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public List<Question> getQuestion() throws SQLException {
//        Connection conn = JdbcConnector.getInstance().connect();
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery("SELECT * FROM question");
//
//        List<Question> questions = new ArrayList<>();
//        while (rs.next()) {
//
//            Question q = new Question.Builder(rs.getInt("id"), rs.getString("content")).build();
//            questions.add(q);
//        }
//        return questions;
//
//    }

//    public List<Question> getQuestion(String kw) throws SQLException {
//        Connection conn = JdbcConnector.getInstance().connect();
//        PreparedStatement stm = conn.prepareCall("SELECT * FROM question WHERE content like concat('%', ?, '%')");
//        stm.setString(1, kw);
//        ResultSet rs = stm.executeQuery();
//        List<Question> questions = new ArrayList<>();
//        while (rs.next()) {
//            Question q = new Question.Builder(rs.getInt("id"), rs.getString("content")).build();
//            questions.add(q);
//        }
//        return questions;
//    }

     public List<Question> getQuestion(int num) throws SQLException {
        Connection conn = JdbcConnector.getInstance().connect();
        PreparedStatement stm = conn.prepareCall("SELECT * FROM question ORDER BY rand() LIMIT ?");
        stm.setInt(1,num);
        ResultSet rs = stm.executeQuery();
        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
             int id =rs.getInt("id");
            String content=rs.getString("content");
            Question q = new Question.Builder(id,content).addALLChoice(this.getChoicesByQuestionId(id)).build();
            questions.add(q);
        }
        return questions;
    }
     public List<Choice>getChoicesByQuestionId(int questionID) throws SQLException{
       Connection conn = JdbcConnector.getInstance().connect();
        PreparedStatement stm = conn.prepareCall("SELECT * FROM choice WHERE question_id =?");
        stm.setInt(1,questionID);
        ResultSet rs = stm.executeQuery();
        List<Choice> choice  = new ArrayList<>();
        while (rs.next()) {
            int id =rs.getInt("id");
            String content=rs.getString("content");
            boolean correct = rs.getBoolean("is_correct");
          Choice c = new Choice(questionID, content, correct);
            choice.add(c);
        }
        return choice;
     
     }

   
}
