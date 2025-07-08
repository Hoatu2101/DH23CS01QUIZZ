/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizapp;

import com.dht.pojo.Question;
import com.dht.services.question.QuestionServices;
import com.dht.utils.configs;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PraticeController implements Initializable {

    @FXML
    private VBox vboxChoice;
    @FXML
    private Text txtContent;
    @FXML
    private TextField txtNum;
    @FXML
    private Text result;
    
    private List<Question> Questions;
    private int currentQuestion = 0;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

   public void HandleStart(ActionEvent event) {
//        try {
//            // TODO
//            this.Questions = configs.questionServices.getQuestion(Integer.parseInt(this.txtNum.getText()));
//            this.loadQuestion();
//        } catch (SQLException ex) {
//            Logger.getLogger(PraticeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
   }

    public void HandleNext(ActionEvent event) {
        if (this.currentQuestion < this.Questions.size() - 1) {
            this.currentQuestion++;
            this.loadQuestion();
        }
    }

    public void HandleCheck(ActionEvent event) {
        Question q = this.Questions.get(currentQuestion);
        for (int i = 0; i < q.getChoices().size(); i++) {
            if (q.getChoices().get(i).isCorrect()) {
                RadioButton btn = (RadioButton) this.vboxChoice.getChildren().get(i);
                 this.result.getStyleClass().clear();
                if (btn.isSelected()) {
                    this.result.setText("Chúc mừng ! bạn làm đúng");
                    this.result.getStyleClass().add("Correct");
                } else {
                    this.result.setText("Sai rồi mày ");
                    this.result.getStyleClass().add("Wrong");
                }
            }
        }
    }

    private void loadQuestion() {
        Question q = this.Questions.get(this.currentQuestion);
        this.txtContent.setText(q.getContent());
        this.vboxChoice.getChildren().clear();
        ToggleGroup t = new ToggleGroup();

        for (var c : q.getChoices()) {
            RadioButton btn = new RadioButton(c.getContent());
            btn.setToggleGroup(t);
            this.vboxChoice.getChildren().add(btn);
        }
    }
}
