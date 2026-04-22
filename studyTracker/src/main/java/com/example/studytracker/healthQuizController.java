package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class healthQuizController {

    @FXML
    private TextField sleepHours;

    @FXML
    private CheckBox poorBox;

    @FXML
    private CheckBox fairBox;

    @FXML
    private CheckBox goodBox;

    @FXML
    private CheckBox greatBox;


    //save pressed and user moves to main menu
    @FXML
    private void savePressed(ActionEvent event) throws IOException {

        String sleepQuality;
        int sleepTime;

        if (poorBox.isSelected()){
            sleepQuality = "Poor";
        }

        else if (fairBox.isSelected()){
            sleepQuality = "Fair";
        }

        else if (goodBox.isSelected()){
            sleepQuality = "Good";
        }

        else if (greatBox.isSelected()){
            sleepQuality = "Great";
        }

        sleepTime = Integer.valueOf(sleepHours.getText());


        //TODO submit sleep data to DB

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
