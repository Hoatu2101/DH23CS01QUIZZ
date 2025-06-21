/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.htt.company.quizz;

import Pojo.Catagory;
import Service.CatagoryService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Administrator
 */
public class Question implements Initializable {

    @FXML private ComboBox<Catagory> cbCates;
    private final static CatagoryService cateSer = new CatagoryService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateSer.getCates()));
        } catch (SQLException EX) {
        }  }

}
