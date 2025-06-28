/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nt.quizzapp;


import com.nt.pojo.Category;
import com.nt.pojo.Level;
import com.nt.pojo.Question;
import com.nt.services.CategotyServices;
import com.nt.services.LevelServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private VBox vBoxChoices;
    @FXML private TextArea txtContent;
    
    
    private static final CategotyServices cateServices = new CategotyServices();
    private static final LevelServices levelServices = new LevelServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(levelServices.getLevels()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }    
    
    public void addChoice(ActionEvent event){
        HBox h = new HBox();
        h.getStyleClass().add("Main");
        
        RadioButton r= new RadioButton();
        TextField txt = new TextField();
        
//        txt.getStyleClass().add("input");
        h.getChildren().addAll(r, txt);
        this.vBoxChoices.getChildren().add(h);
    }
    
    public void addQuestion(){
        Question.Builder b = new Question.Builder(this.txtContent.getText(),
                this.cbCates.getSelectionModel().getSelectedItem(),
                this.cbLevels.getSelectionModel().getSelectedItem());
        
    }
}
