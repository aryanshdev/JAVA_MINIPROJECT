package com.cpllabs.APK_Builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("APK Builder");
        stage.setResizable(false);
        stage.setScene(scene); //set loaded scene as current-actice
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}