package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    // "index.fxml" - index
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TMC");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}