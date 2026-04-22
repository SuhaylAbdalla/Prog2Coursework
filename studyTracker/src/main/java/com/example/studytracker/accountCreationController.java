package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class accountCreationController {

    @FXML
    //login button gets pressed - opens main menu window
    private void continuePressed(ActionEvent event) throws IOException {

        /*
        TODO proper account creation that adds info to DB
         */


            //getting new file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("healthQuiz.fxml"));
            Parent root = fxmlLoader.load();

            //getting current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //displaying new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

