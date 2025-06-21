package com.mycompany.htt.company.quizz;

import htt.company.utils.singletonAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {

   public void Questionadd(ActionEvent event) throws IOException{
    
       Scene scene = new Scene(new FXMLLoader(App.class.getResource("QUESTION1.fxml")).load());
       Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("QUIZZ APP");
        stage.show();
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
}
