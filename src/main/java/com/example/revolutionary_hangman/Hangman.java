package com.example.revolutionary_hangman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Hangman extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Test man
        Man testMan = new Man(0,0, 400, 800);
        testMan.createDrawing();

        // Test Group
        Group testGroup = new Group();
        testGroup.getChildren().addAll(testMan.getDrawing());

        // Scene settings
        Scene playerScene = new Scene(testGroup, 1500, 800);
        playerScene.setFill(Color.WHITE);

        // Stage
        stage.setTitle("Hello!");
        stage.setScene(playerScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}