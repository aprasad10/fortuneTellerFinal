module com.example.fortunetellerfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fortunetellerfinal to javafx.fxml;
    exports com.example.fortunetellerfinal;
}