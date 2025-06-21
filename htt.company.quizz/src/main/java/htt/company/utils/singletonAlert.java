/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.company.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author Administrator
 */
public class singletonAlert {
    private static singletonAlert instance;
    private final Alert alert;
    
    private singletonAlert(){
     alert= new Alert(Alert.AlertType.INFORMATION);
     alert.setHeaderText("Thong bao");
    }

    public static singletonAlert getInstance() {
        if(instance==null)
        instance= new singletonAlert();
       
        return instance;
    }
    public void show(String msg){
    this.alert.setContentText(msg);
    this.alert.showAndWait();
    }
}
