package com.example.revolutionary_hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Man testMan = new Man(0,0, 400, 800);
        testMan.createDrawing();
        Group testGroup = new Group();
        testGroup.getChildren().addAll(testMan.getDrawing());
        Scene scene = new Scene(testGroup, 1500, 800);
        scene.setFill(Color.WHITE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}