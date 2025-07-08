/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.question;

import com.dht.pojo.Level;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelQuestionDecorator extends  QuestionServicesDecorator{
    private Level level;

    public LevelQuestionDecorator( BaseQuestionServices decorator) {
        super(decorator);
        this.level = level;
    }

    @Override
    public String getSQL(List<Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
