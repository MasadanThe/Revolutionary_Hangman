package com.example.revolutionary_hangman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman extends Application {
    private String pressedKey;

    static int amountPlayers;
    static int gameMode;
    static int disabledRounds;


    private char forbiddenVowel;
    @Override
    public void start(Stage stage) throws IOException {


        final int WIDTH = 1500;
        final int HEIGHT = 800;

        int players = 0;
        int round = 0;
        // 0 = Choose who to pick, 1 = random who to pick, 2 = mix of them both.
        int settings = 0;

        ArrayList<Player> playersList = new ArrayList<>();



        // Test man
        Man testMan = new Man(0,0, 400, 800);
        testMan.createDrawing();

        // Test Group
        Group testGroup = new Group();
        testGroup.getChildren().addAll(testMan.getDrawing());


        // Scene settings
        Button buttonAmountPlayers2 = new Button("Amount Players  2");
        Button buttonAmountPlayers3 = new Button("Amount Players  3");
        Button buttonAmountPlayers4 = new Button("Amount Players  4");
        buttonAmountPlayers2.setLayoutX(550);
        buttonAmountPlayers2.setLayoutY(90);
        buttonAmountPlayers3.setLayoutX(670);
        buttonAmountPlayers3.setLayoutY(90);
        buttonAmountPlayers4.setLayoutX(790);
        buttonAmountPlayers4.setLayoutY(90);
        buttonAmountPlayers2.setOnAction(e -> amountPlayers = 2);
        buttonAmountPlayers3.setOnAction(e -> amountPlayers = 3);
        buttonAmountPlayers4.setOnAction(e -> amountPlayers = 4);

        Button buttonKey0 = new Button("Selection Mode");
        Button buttonKey1 = new Button("Random Mode");
        Button buttonKey2 = new Button("Queue Mode");
        buttonKey0.setLayoutX(550);
        buttonKey0.setLayoutY(120);
        buttonKey1.setLayoutX(650);
        buttonKey1.setLayoutY(120);
        buttonKey2.setLayoutX(750);
        buttonKey2.setLayoutY(120);
        buttonKey0.setOnAction(e -> gameMode = 0);
        buttonKey1.setOnAction(e -> gameMode = 1);
        buttonKey2.setOnAction(e -> gameMode = 2);

        Button buttonSetDisabledRounds1 = new Button("Dis round 1");
        Button buttonSetDisabledRounds2 = new Button("Dis round 2");
        Button buttonSetDisabledRounds3 = new Button("Dis round 3");
        buttonSetDisabledRounds1.setLayoutX(550);
        buttonSetDisabledRounds1.setLayoutY(150);
        buttonSetDisabledRounds2.setLayoutX(650);
        buttonSetDisabledRounds2.setLayoutY(150);
        buttonSetDisabledRounds3.setLayoutX(750);
        buttonSetDisabledRounds3.setLayoutY(150);
        buttonSetDisabledRounds1.setOnAction(e -> disabledRounds = 0);
        buttonSetDisabledRounds2.setOnAction(e -> disabledRounds = 1);
        buttonSetDisabledRounds3.setOnAction(e -> disabledRounds = 2);
        testGroup.getChildren().add(buttonKey0);
        testGroup.getChildren().add(buttonKey1);
        testGroup.getChildren().add(buttonKey2);
        testGroup.getChildren().add(buttonSetDisabledRounds1);
        testGroup.getChildren().add(buttonSetDisabledRounds2);
        testGroup.getChildren().add(buttonSetDisabledRounds3);
        testGroup.getChildren().add(buttonAmountPlayers2);
        testGroup.getChildren().add(buttonAmountPlayers3);
        testGroup.getChildren().add(buttonAmountPlayers4);

        Scene playerScene = new Scene(testGroup, WIDTH, HEIGHT);
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
        //Records the key press and stores it in pressedKey
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            pressedKey = key.getText();
        });

        return scene;
    }

    public ArrayList<Integer> randomiseWhoToGuess(int players){
        Random random = new Random();
        // Store the order
        ArrayList<Integer> order = new ArrayList<>();
        Boolean isDone = false;
        while (!isDone)
        {
            int randomNumber = random.nextInt(1, players);
            boolean foundNumber = false;
            // Checks if the random number already exist
            for (int i = 0; i < order.size(); i++)
            {
                if (order.get(i) == randomNumber)
                {
                    foundNumber = true;
                }
            }

            // If the number doesn't exist, add it to the order list
            if (!foundNumber)
            {
                order.add(randomNumber);
            }
            // If the list is full
            if(order.size() == players){
                isDone = true;
            }
        }

        return order;

    }

    public char randomizeForbiddenVowel(){
        Random random = new Random();
        char[] forbiddenVowels = {'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö'};
        // Randomize which index of the character that will be forbidden.
        int forbiddenVowelIndex = random.nextInt(forbiddenVowels.length - 1);

        return forbiddenVowels[forbiddenVowelIndex];
    }

    public ArrayList<Player> createPlayers(int width, int height, int players){
        ArrayList<Player> playersList = new ArrayList<>();
        int newXPosition = 0;
        int playerWidth = width / players;

        // Creates the number of players and add their new x position
        for(int i = 0; i < players; i++)
        {
            Player player = new Player(newXPosition, 0, playerWidth, height);
            playersList.add(player);
            newXPosition += playerWidth;
        }

        return playersList;
    }
}