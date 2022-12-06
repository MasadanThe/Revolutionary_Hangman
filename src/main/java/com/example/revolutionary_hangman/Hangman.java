package com.example.revolutionary_hangman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Hangman extends Application {
    String pressedKey;
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
        playerScene = sceneSetKeyPress(playerScene);

        // Stage
        stage.setTitle("Hello!");
        stage.setScene(playerScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Scene sceneSetKeyPress(Scene scene) {
        //Records the key press
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            pressedKey = key.getText();
        });

        return scene;
    }
}