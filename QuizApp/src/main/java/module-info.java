module com.ntt.quizapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ntt.quizapp to javafx.fxml;
    exports com.ntt.quizapp;
}
