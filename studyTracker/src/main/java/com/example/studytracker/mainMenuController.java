package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainMenuController {


    @FXML
    //user wants to start a study session - opens study session window
    private void studySessionPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studySession.fxml"));
        Parent root = fxmlLoader.load();

        //getting current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //displaying new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
