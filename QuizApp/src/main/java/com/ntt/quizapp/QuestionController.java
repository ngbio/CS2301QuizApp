/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntt.quizapp;

import com.ntt.pojo.Category;
import com.ntt.pojo.Choice;
import com.ntt.pojo.Level;
import com.ntt.pojo.Question;
import com.ntt.services.CategoryServices;
import com.ntt.services.LevelServices;
import com.ntt.services.QuestionServices;
import com.ntt.utils.Configs;
import com.ntt.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
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
public class QuestionController implements Initializable {

    @FXML
    private TextArea txtContent;
    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private VBox vboxChoice;
    @FXML 
    private ToggleGroup toggleChoice;
    @FXML
    private TableView<Question> tbQuestions;
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

            this.cbCates.setItems(FXCollections.observableList(Configs.cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(Configs.levelServices.getLevels()));
            
            this.loadColums();
            this.tbQuestions.setItems(FXCollections.observableArrayList(Configs.questionServices.getQuestions()));

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        this.txtSearch.textProperty().addListener(e ->{
            try {
                this.tbQuestions.getItems().clear();
                this.tbQuestions.setItems(FXCollections.observableList(Configs.questionServices.getQuestions(this.txtSearch.getText())));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }

    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");

        RadioButton rdo = new RadioButton();
        rdo.setToggleGroup(toggleChoice);
        TextField txt = new TextField();

        h.getChildren().addAll(rdo, txt);

        this.vboxChoice.getChildren().add(h);
    }

    public void adddQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());
            
            for(var c: this.vboxChoice.getChildren()){
                HBox h = (HBox) c;
                
                Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(),
                                        ((RadioButton)h.getChildren().get(0)).isSelected());
                
                b.addChoice(choice);
            }
            
            Configs.questionServices.addQuestion(b.build());
            MyAlert.getInstance().showMsg("Them cau hoi thanh cong!");
        }catch(SQLException ex) {
            MyAlert.getInstance().showMsg("Them khong thanh cong, ly do: " + ex.getMessage());
        } catch (Exception ex) {        
            MyAlert.getInstance().showMsg("Du lieu khong hop le!");
        }
    }
    
    private void loadColums(){
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);
        
        TableColumn colContent = new TableColumn("Noi dung cau hoi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(100);
        
        this.tbQuestions.getColumns().addAll(colId, colContent);
    }
}
