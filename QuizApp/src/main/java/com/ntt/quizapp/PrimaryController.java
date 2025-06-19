package com.ntt.quizapp;

import com.ntt.utils.MyAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {
    public void handleQuestion(ActionEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("questions.fxml")).load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("QuizApp");
        stage.show();    
    }
    
    public void handleSignUp(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    public void handleSignIn(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
}
