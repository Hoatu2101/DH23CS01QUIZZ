/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizapp;

import com.dht.pojo.Category;
import com.dht.pojo.Choice;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.question.BaseQuestionServices;
import com.dht.services.question.CatagoryQuesSerDecorator;
import com.dht.services.question.KeyWordQuestionSerDecorator;
import com.dht.services.question.QuestionServices;
import com.dht.utils.JdbcConnector;
import com.dht.utils.MyAlert;
import com.dht.utils.configs;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private TextArea txtContent;
    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private ComboBox<Category> cbSoftCates;
     @FXML
    private ComboBox<Level> cbSoftLevrl;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private VBox vboxChoices;
    @FXML
    private TableView<Question> questioncb;
    @FXML
    private ToggleGroup toggleChoice;
    @FXML
    private TextField txtSearch;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(configs.cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(configs.levelServices.getLevels()));
            this.cbSoftCates.setItems(FXCollections.observableList(configs.cateServices.getCates()));
            this.cbSoftLevrl.setItems(FXCollections.observableList(configs.levelServices.getLevels()));
            this.loadCol();
            this.loadQuestion(configs.questionServices.list());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.txtSearch.textProperty().addListener((e) -> {
            try {
                BaseQuestionServices s = new KeyWordQuestionSerDecorator(configs.questionServices,this.txtSearch.getText());
                this.questioncb.setItems(FXCollections.observableList(s.list()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
        this.cbSoftCates.getSelectionModel().selectedItemProperty().addListener(e->{
         try {
                BaseQuestionServices s = new CatagoryQuesSerDecorator(configs.questionServices,this.cbSoftCates.getSelectionModel().getSelectedItem());
                this.questioncb.setItems(FXCollections.observableList(s.list()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
        
    }

    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");

        RadioButton r = new RadioButton();
        r.setToggleGroup(toggleChoice);

        TextField txt = new TextField();
        txt.getStyleClass().add("Input");
        h.getChildren().addAll(r, txt);

        this.vboxChoices.getChildren().add(h);
    }

    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());

            for (var c : this.vboxChoices.getChildren()) {
                HBox h = (HBox) c;

                Choice choice = new Choice(((TextField) h.getChildren().get(1)).getText(),
                        ((RadioButton) h.getChildren().get(0)).isSelected());
                b.addChoice(choice);
            }

            configs.updateQuestion.addQuestion(b.build());
            this.questioncb.getItems().add(0, b.build());
            MyAlert.getInstance().showMsg("Thêm câu hỏi thành công!");
        } catch (SQLException ex) {
            MyAlert.getInstance().showMsg("Thêm câu hỏi thất bại!");
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg("Dữ liệu không hợp lệ!");
        }
    }

    public void loadCol() {
        TableColumn cotID = new TableColumn("Id");   //tạo cột với tên là id
        cotID.setCellValueFactory(new PropertyValueFactory("id"));
        cotID.setPrefWidth(100);
        TableColumn cotContext = new TableColumn("Nội dung câu hỏi"); //tạp cột với tên là nội dung câu hỏi
        cotContext.setCellValueFactory(new PropertyValueFactory("content"));
        cotContext.setPrefWidth(250);
         TableColumn colActions = new TableColumn();
         colActions.setCellFactory((e)->{
             TableCell cell = new TableCell();
             Button btn = new Button("Xóa");
             btn.setOnAction((event)->{
             Optional<ButtonType> t=   MyAlert.getInstance().showMsg("Bạn có chắc chắn muốn xóa ?", Alert.AlertType.CONFIRMATION);
             if(t.isPresent() && t.get().equals(ButtonType.OK)){
                 Question q = (Question)cell.getTableRow().getItem();
                 try {
                     configs.updateQuestion.deleteQuestion(q.getId());
                     this.questioncb.getItems().remove(q);
                     MyAlert.getInstance().showMsg("Xóa thành công");
                 } catch (SQLException ex) {
                     MyAlert.getInstance().showMsg("Xóa thất bại", Alert.AlertType.WARNING);
                 }
             }
         });
             cell.setGraphic(btn);
             
            return cell;
             
                 
                 });   // tao noi dung cho moi o
         this.questioncb.getColumns().addAll(cotID,cotContext,colActions);
    }

    private void loadQuestion(List<Question> questions) {

        this.questioncb.setItems(FXCollections.observableArrayList(questions));
    }
}
