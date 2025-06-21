module com.mycompany.htt.company.quizz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    opens com.mycompany.htt.company.quizz to javafx.fxml;
    exports com.mycompany.htt.company.quizz;
}
