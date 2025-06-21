/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nt.quizzapp;

import com.nt.pojo.Category;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //B1: Nap driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //b2: mo ket noi
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizzdb", "root", "root");
            
            //b3: Xu ly truy van
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery("SELECT * FROM category");
            
            List<Category> cates = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                cates.add(new Category(id, name));
            }
            
            //b4: dong ket noi
            conn.close();
            this.cbCates.setItems(FXCollections.observableList(cates));
        } catch (ClassNotFoundException|SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
}
