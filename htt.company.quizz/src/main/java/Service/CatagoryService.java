/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Pojo.Catagory;
import htt.company.utils.singletonConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CatagoryService {
    public List<Catagory> getCates() throws SQLException{
        Connection conn = singletonConn.getInstance().connect();
        Statement stm = conn.createStatement();// tao doi tuong tu conn
        ResultSet rs = stm.executeQuery("SELECT * FROM quizz"); //truy van du lieu
        List<Catagory>cates= new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
             System.out.println("ID: " + id + " - Name: " + name); // thêm dòng này

            Catagory c = new Catagory(id, name);
            cates.add(c);
        }
        return cates;
    }
    
}
