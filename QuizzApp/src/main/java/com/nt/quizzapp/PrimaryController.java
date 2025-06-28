package com.nt.quizzapp;

import com.nt.utils.MyAlert;
import com.nt.utils.MyStage;
import com.nt.utils.theme.Theme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
        
public class PrimaryController implements Initializable{
    @FXML private ComboBox<Theme> cbThemes;
    
    public void changeTheme(){
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
    public void handleQuestion(ActionEvent event) throws IOException{
//        Scene scene = new Scene(new FXMLLoader(App.class.getResource("question.fxml")).load());
//        
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("Quizz App");
//        stage.show();
        MyStage.getInstance().showStage("question.fxml");
    }
    public void handlePractice(ActionEvent event){
        MyAlert.getInstance().showMessenger("Coming soon...");
    }

    
}
