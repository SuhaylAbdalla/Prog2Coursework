package com.example.studytracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;

public class trendsWindowController {

    @FXML
    private PieChart studyPie;
    @FXML
    private BarChart<String, Integer> productivityChart;
    @FXML
    private ToggleButton locationToggle;
    @FXML
    private ToggleButton dayToggle;
    @FXML
    private Label pieLabel;
    @FXML
    private Label barLabel;


    //TODO: get data from databases to populate the charts - current stuff is just placeholding
    //defining the differnt data lists to fill the pie chart with - just test data for now
    private ObservableList<PieChart.Data> locationPieData = FXCollections.observableArrayList(
            new PieChart.Data("Library", 40),
            new PieChart.Data("Home", 50),
            new PieChart.Data("Cafe", 10)
    );

    private ObservableList<PieChart.Data> dayPieData = FXCollections.observableArrayList(
            new PieChart.Data("Monday", 10),
            new PieChart.Data("Tuesday", 15),
            new PieChart.Data("Wednesday", 10),
            new PieChart.Data("Thursday", 30),
            new PieChart.Data("Friday", 5),
            new PieChart.Data("Saturday", 10),
            new PieChart.Data("Sunday", 20)
    );

    //data series for the bar chart
    private XYChart.Series<String, Integer> dailyProdChartSeries = new XYChart.Series<>();
    private XYChart.Series<String, Integer> locationProdCharSeries = new XYChart.Series<>();


    //method to initialize the charts -- starts off with location data as default
    public void initialize(){

        locationToggle.setSelected(true);

        //daily productivity data -- test data for now
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Monday", 6));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Tuesday", 8));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Wednesday", 3));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Thursday", 3));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Friday", 6));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Saturday", 9));
        dailyProdChartSeries.getData().add(new XYChart.Data<>("Sunday", 6));
        dailyProdChartSeries.setName("Average self reported user productivity per day");

        //location productivity data -- test data for now
        locationProdCharSeries.getData().add(new XYChart.Data<>("Library", 6));
        locationProdCharSeries.getData().add(new XYChart.Data<>("Home", 8));
        locationProdCharSeries.getData().add(new XYChart.Data<>("Cafe", 3));
        locationProdCharSeries.setName("Average self reported user productivity per location");


        //populating the graphs with the data - starting with the location
        studyPie.getData().addAll(locationPieData);
        productivityChart.getData().add(locationProdCharSeries);

        productivityChart.setAnimated(false);
        studyPie.setAnimated(false);

    }

    //user wants to return to the menu from the trends page
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


    //user selects to view the location data
    @FXML
    private void locationTogglePressed(ActionEvent event) throws IOException {
        pieLabel.setText("STUDY LOCATIONS");
        barLabel.setText("PRODUCTIVITY PER LOCATION");
        //updating toggles
        dayToggle.setSelected(false);
        locationToggle.setStyle("-fx-background-color: #2E315E");
        dayToggle.setStyle("-fx-background-color: #121640");

        //updating charts
        studyPie.setData(locationPieData);
        productivityChart.setData(FXCollections.observableArrayList(locationProdCharSeries));


    }

    //user selects to view the day data
    @FXML
    private void dayTogglePressed(ActionEvent event) throws IOException {
        pieLabel.setText("STUDY PER DAY");
        barLabel.setText("PRODUCTIVITY BY DAY");

        //updating toggles
        locationToggle.setSelected(false);
        dayToggle.setStyle("-fx-background-color: #2E315E");
        locationToggle.setStyle("-fx-background-color: #121640");

        //updating charts
        studyPie.setData(dayPieData);
        productivityChart.setData(FXCollections.observableArrayList(dailyProdChartSeries));

    }


}
