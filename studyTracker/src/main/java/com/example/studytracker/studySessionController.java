package com.example.studytracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

        //if true then user is starting study session - if not they are ending one
        if (studySessionButton.getText().equals("Start Session")){
            studySessionButton.setText("Stop Session");
            studySessionButton.setStyle("-fx-background-color: #FF0000");

            //getting location and module data
            String location = locationBox.getText();
            String module = moduleBox.getText();

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
            studySessionButton.setText("Start Session");
            studySessionButton.setStyle("-fx-background-color: #3BB143");
            readingBox.setSelected(false);
            revisionBox.setSelected(false);
            courseworkBox.setSelected(false);
            lectureSlidesBox.setSelected(false);
            locationBox.setText("");
            moduleBox.setText("");

            //TODO link with stop session method

        }
    }
}
