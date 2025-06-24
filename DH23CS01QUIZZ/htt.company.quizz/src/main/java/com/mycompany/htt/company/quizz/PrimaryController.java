package com.mycompany.htt.company.quizz;

import htt.company.utils.mySence;
import htt.company.utils.singletonAlert;
import htt.company.utils.theme.theme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public abstract  class PrimaryController implements Initializable {
  @FXML private ComboBox<theme>cbTheme;
        
   public void Questionadd(ActionEvent event) throws IOException{
    
//       Scene scene = new Scene(new FXMLLoader(App.class.getResource("QUESTION1.fxml")).load());
//       Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("QUIZZ APP");
//        stage.show();
       mySence.getInstance().showStage("QUESTION1.fxml");
   }
   
   
   public void Pratice( ActionEvent event ){
       singletonAlert.getInstance().show("Coming soonn");
   }
         public void DangNhap( ActionEvent event ){
       singletonAlert.getInstance().show("Coming soonn");
   }
             
            public void Dangky( ActionEvent event ){
       singletonAlert.getInstance().show("Coming soonn");
   }
             public void Thi( ActionEvent event ){
       singletonAlert.getInstance().show("Coming soonn");
   }

      @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.cbTheme.setItems(FXCollections.observableArrayList(theme.values())); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void handleTheme(ActionEvent e){
        this.cbTheme.getSelectionModel().getSelectedItem().updateThem();
        
    }
    public abstract  void updateThem();
}
