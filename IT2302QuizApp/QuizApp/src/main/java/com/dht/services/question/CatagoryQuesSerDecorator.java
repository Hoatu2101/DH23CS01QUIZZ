/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.question;

import com.dht.pojo.Category;
import java.util.List;

/**
 *
 * @author admin
 */
public class CatagoryQuesSerDecorator extends  QuestionServicesDecorator{
 private  Category category;
    public CatagoryQuesSerDecorator(BaseQuestionServices decorator,Category c) {
        super(decorator);
         this.category=c;
    }
public CatagoryQuesSerDecorator(BaseQuestionServices decorator,int  cateID) {
        super(decorator);
         this.category=new Category(cateID);
    }
    @Override
    public String getSQL(List<Object> params) {
      String sql= this.decorator.getSQL(params)+" AND category_id=?";
      params.add(this.category.getId());
     return sql;
      
    }
    
    
}
