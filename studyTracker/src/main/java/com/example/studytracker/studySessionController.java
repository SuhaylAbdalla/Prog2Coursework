package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class studySessionController {

    //injecting the interactive FX elements to allow for reading/changing them
    @FXML
    private Button studySessionButton;
    @FXML
    private CheckBox revisionBox;
    @FXML
    private CheckBox courseworkBox;
    @FXML
    private CheckBox lectureSlidesBox;
    @FXML
    private CheckBox readingBox;
    @FXML
    private TextField locationBox;
    @FXML
    private TextField moduleBox;


    //user wants to return to the menu from the study session page
    @FXML
    private void returnToMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        //getting current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //displaying new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    //User has either started or finished study session - different function depending on which
    private void sessionButtonPressed(ActionEvent event) throws IOException{

        //getting location and module data
        String location = locationBox.getText();
        String module = moduleBox.getText();


        //if true then user is starting study session - if not they are ending one
        if (studySessionButton.getText().equals("Start Session")){
            studySessionButton.setText("Stop Session");
            studySessionButton.setStyle("-fx-background-color: #FF0000");


            /*
            series of conditionals to find out which box is ticked
            TODO link with startSession with the corresponding details
             */
            if(revisionBox.isSelected()){

            }
            else if(courseworkBox.isSelected()){

            }
            else if(lectureSlidesBox.isSelected()){

            }
            else if(readingBox.isSelected()){

            }
        }

        //stoping session - change button back and reset all check boxes
        else{

            //jumping to review page - user can then self rate to get more info about the session
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studySessionReview.fxml"));
            Parent root = fxmlLoader.load();

            //updating the labels on the review page
            studySessionReviewController controller = fxmlLoader.getController();
            controller.setLabel(location + " . " + module );

            //TODO pass through all needed info about the study session needed to end it

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }
    }
}
