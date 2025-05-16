package com.example.fortunetellerfinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FortuneTellerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FortuneTellerApp.class.getResource("fortune-app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 490, 475);
        stage.setTitle("Fortune Teller");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}