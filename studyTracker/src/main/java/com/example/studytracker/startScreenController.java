package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class startScreenController {

    @FXML
    //login button gets pressed - opens main menu window
    private void loginPressed(ActionEvent event) throws IOException {

        /*
        TODO proper login system that checks username and password
         */

        //getting new file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        //getting current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //displaying new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
