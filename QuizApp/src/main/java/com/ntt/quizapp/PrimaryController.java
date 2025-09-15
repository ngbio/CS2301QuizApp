package com.ntt.quizapp;

import com.ntt.themes.DarkThemeFactory;
import com.ntt.themes.Theme;
import com.ntt.themes.ThemeManager;
import com.ntt.utils.MyAlert;
import com.ntt.utils.MyStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {
    @FXML ComboBox<Theme> cbThemes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    public void handleQuestionManager(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("question.fxml");
    }
    
    public void handleChangeThemes(ActionEvent action) {
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
    
    public void handlePratice(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("practice.fxml");
    }

    public void handleTest(ActionEvent event) {
        MyAlert.getInstance().showMsg("Coming soon...");
    }

    public void handleSignUp(ActionEvent event) {
        MyAlert.getInstance().showMsg("Coming hehe...");
    }

    public void handleSignIn(ActionEvent event) {
        MyAlert.getInstance().showMsg("Coming soon...");
    }

}
