module com.ntt.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql; 
    requires lombok; 

    opens com.ntt.quizapp to javafx.fxml;
    exports com.ntt.quizapp;
    exports com.ntt.pojo;   
}
