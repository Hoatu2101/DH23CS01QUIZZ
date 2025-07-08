/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.services.question;

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
public interface BaseQuestionServices {
    String getSQL(List<Object> params);
    default public List<Question> list() throws SQLException {
         Connection conn = JdbcConnector.getInstance().connect();
         
          List<Object> params = new ArrayList<>();
        PreparedStatement  stm = conn.prepareCall(this.getSQL(params));
        for (int i =0 ;i<params.size();i++)
            stm.setObject(i+1, params.get(i));
            
        ResultSet rs = stm.executeQuery();

        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
            Question q = new Question.Builder(rs.getInt("id"),rs.getString("content")).build();
            questions.add(q);
        }
        
        return questions;
    }
    
}
