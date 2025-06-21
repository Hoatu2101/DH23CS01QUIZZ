/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.company.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class singletonConn {

    private static singletonConn instance;
    private final Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //DRIVER BAT BUOC PHAI CO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(singletonConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private singletonConn() throws SQLException { //localhost may chu cuc bo jdbc:mysql://cu phap  mac dinh
    //"jdbc:mysql://localhost/TenSERVER"
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/quizz", "root", "root");
    }

    public static singletonConn getInstance() throws SQLException {
        if (instance == null) {
            instance = new singletonConn();
        }
        return instance;

    }
    public  Connection connect (){
        return this.conn;
    }

    public void close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }

}
