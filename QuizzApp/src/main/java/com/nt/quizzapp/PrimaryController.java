package com.nt.quizzapp;

import com.nt.utils.MyAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
        
public class PrimaryController {
    public void handleQuestion(ActionEvent event) throws IOException{
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("question.fxml")).load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Quizz App");
        stage.show();
    }
    public void handlePractice(ActionEvent event){
        MyAlert.getInstance().showMessenger("Coming soon...");
    }
}
