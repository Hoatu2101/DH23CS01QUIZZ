/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.company.utils;

import com.mycompany.htt.company.quizz.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class mySence {

    private static mySence instance;
    private final Stage stage;
    private static Scene scene;

    private mySence() {
        stage = new Stage();
        stage.setTitle("Quiz app");
    }

    public static  mySence getInstance() {
        if (instance == null) {
            instance = new mySence();
        }
        return instance;
    }

    public void showStage(String fxml) throws IOException {
        if (scene == null) {
            scene = new Scene((new FXMLLoader(App.class.getResource("QUESTION1.fxml")).load()));
        } else {
            scene.setRoot((new FXMLLoader(App.class.getResource("QUESTION1.fxml")).load()));
        }
        this.stage.setScene(scene);
        this.stage.show();
    }

}
