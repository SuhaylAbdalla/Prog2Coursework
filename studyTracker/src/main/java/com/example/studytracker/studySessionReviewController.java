package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class studySessionReviewController {

    @FXML
    private Slider productivitySlider;

    //method to take in data from previous window to allow it to be displayed
    @FXML
    private Label sessionInfoLabel;
    public void setLabel(String info){
        sessionInfoLabel.setText(info);
    }

    //save pressed and user moves back to main menu
    @FXML
    private void savePressed(ActionEvent event) throws IOException {


        //collecting data from the review info
        int productivityRating = (int) productivitySlider.getValue();

        //TODO submit all data to sessionEnd

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
