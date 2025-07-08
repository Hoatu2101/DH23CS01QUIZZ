/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.question.QuestionServices;
import com.dht.services.UpdateQuestion;
import com.dht.services.question.BaseQuestionServices;

/**
 *
 * @author Administrator
 */
public class configs {

    public static final LevelServices levelServices = new LevelServices();
    public static final CategoryServices cateServices = new CategoryServices();
    public static  BaseQuestionServices  questionServices = new QuestionServices();
    public static UpdateQuestion updateQuestion= new UpdateQuestion();
    
}
