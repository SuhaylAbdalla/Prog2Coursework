module com.example.studytracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.xml.crypto;

    opens com.example.studytracker to javafx.fxml;
    exports com.example.studytracker;
}