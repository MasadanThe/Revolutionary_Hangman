package com.example.revolutionary_hangman;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman extends Application {
    private String pressedKey;

    static int amountPlayers;
    static int gameMode;
    static int disabledRounds;
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    private // 0 = settingsScene, 1 = chooseWordScene, 2 = playScene
    int state = 0;


    private ArrayList<Player> playersList = new ArrayList<>();
    private Group playersDrawing = new Group();

    private Stage stage = new Stage();
    int playerIndex = 0;

    // Settings Group
    private Group settingsGroup = createSettingsGroup();

    // Choose word group
    private Group chooseWordGroup = createChooseWordGroup();

    //Scene for settings
    private Scene settingScene = new Scene(settingsGroup, WIDTH, HEIGHT);

    //Scene for creating word
    private Scene chooseWordScene = new Scene(chooseWordGroup, WIDTH, HEIGHT);

    // Scene for playing
    private Scene playScene = new Scene(playersDrawing, WIDTH, HEIGHT);


    private char forbiddenVowel;

    @Override
    public void start(Stage startStage) throws IOException {

        stage = startStage;

        // Test man
        Man testMan = new Man(0, 0, 400, 800);
        testMan.createDrawing();

        // Test Group
        Group testGroup = new Group();
        testGroup.getChildren().addAll(testMan.getDrawing());


        createSettingsGroup();
        createChooseWordGroup();
        createplaySceneGroup();


        chooseWordScene.setFill(Color.WHITE);
        chooseWordScene = sceneSetKeyPress(chooseWordScene);

        playScene.setFill(Color.WHITE);
        playScene = sceneSetKeyPress(playScene);

        chooseWordScene.setFill(Color.WHITE);
        chooseWordScene = sceneSetKeyPress(chooseWordScene);


        run();

        // Stage
        stage.setTitle("Hangman!");
        stage.setScene(settingScene);
        stage.show();
    }

    public void run() {
        // Timeline is the runs every 0.2 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), ev -> {

            // settingsScene
            if (state == 0) {
            }
            // chooseWordScene
            else if (state == 1) {
            }
            // playScene
            else if (state == 2) {
            }

        }));
        // Runs the timeline forever
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
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

    public ArrayList<Integer> randomiseWhoToGuess(int players) {
        Random random = new Random();
        // Store the order
        ArrayList<Integer> order = new ArrayList<>();
        Boolean isDone = false;
        while (!isDone) {
            int randomNumber = random.nextInt(1, players);
            boolean foundNumber = false;
            // Checks if the random number already exist
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) == randomNumber) {
                    foundNumber = true;
                }
            }

            // If the number doesn't exist, add it to the order list
            if (!foundNumber) {
                order.add(randomNumber);
            }
            // If the list is full
            if (order.size() == players) {
                isDone = true;
            }
        }

        return order;

    }

    public char randomizeForbiddenVowel() {
        Random random = new Random();
        char[] forbiddenVowels = {'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö'};
        // Randomize which index of the character that will be forbidden.
        int forbiddenVowelIndex = random.nextInt(forbiddenVowels.length - 1);

        return forbiddenVowels[forbiddenVowelIndex];
    }

    public ArrayList<Player> createPlayers(int width, int height, int players) {
        ArrayList<Player> playersList = new ArrayList<>();
        int newXPosition = 0;
        int playerWidth = width / players;

        // Creates the number of players and add their new x position
        for (int i = 0; i < players; i++) {
            Player player = new Player(newXPosition, 0, playerWidth, height);
            player.createDrawing();
            playersDrawing.getChildren().addAll(player.getDrawing());
            playersList.add(player);
            newXPosition += playerWidth;
        }

        return playersList;
    }

    public Group createSettingsGroup() {
        Group settingsGroup = new Group();

        Button buttonAmountPlayers2 = new Button("Amount Players  2");
        Button buttonAmountPlayers3 = new Button("Amount Players  3");
        Button buttonAmountPlayers4 = new Button("Amount Players  4");
        buttonAmountPlayers2.setLayoutX(550);
        buttonAmountPlayers2.setLayoutY(90);
        buttonAmountPlayers3.setLayoutX(670);
        buttonAmountPlayers3.setLayoutY(90);
        buttonAmountPlayers4.setLayoutX(790);
        buttonAmountPlayers4.setLayoutY(90);
        buttonAmountPlayers2.setOnAction(e -> playersList = createPlayers(WIDTH, HEIGHT, 2));
        buttonAmountPlayers3.setOnAction(e -> playersList = createPlayers(WIDTH, HEIGHT, 3));
        buttonAmountPlayers4.setOnAction(e -> playersList = createPlayers(WIDTH, HEIGHT, 4));

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
        settingsGroup.getChildren().add(buttonKey0);
        settingsGroup.getChildren().add(buttonKey1);
        settingsGroup.getChildren().add(buttonKey2);
        settingsGroup.getChildren().add(buttonSetDisabledRounds1);
        settingsGroup.getChildren().add(buttonSetDisabledRounds2);
        settingsGroup.getChildren().add(buttonSetDisabledRounds3);
        settingsGroup.getChildren().add(buttonAmountPlayers2);
        settingsGroup.getChildren().add(buttonAmountPlayers3);
        settingsGroup.getChildren().add(buttonAmountPlayers4);

        Button choseWordButton = new Button("Chose Word");
        choseWordButton.setLayoutX(550);
        choseWordButton.setLayoutY(190);
        choseWordButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(chooseWordScene);
            }
        });
        settingsGroup.getChildren().add(choseWordButton);

        Button startButton = new Button("Start");
        startButton.setLayoutX(550);
        startButton.setLayoutY(240);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(playScene);
            }
        });
        settingsGroup.getChildren().add(startButton);

        return settingsGroup;
    }


    public Group createChooseWordGroup() {

        Group chooseWordGroup = new Group();
        playersList = createPlayers(WIDTH, HEIGHT, 4); // temp
        TextField chooseWord = new TextField();
        chooseWord.setLayoutX(550);
        chooseWord.setLayoutY(90);

        chooseWordGroup.getChildren().add(chooseWord);

        Button enterWordButton = new Button("Enter your word");
        enterWordButton.setLayoutX(550);
        enterWordButton.setLayoutY(130);
        enterWordButton.setOnAction(actionEvent -> {
            String word = chooseWord.getText();
            Player player = playersList.get(playerIndex);
            player.setWord(word);
            playerIndex++;                                  // next player be able to enter word
        });
        chooseWordGroup.getChildren().add(enterWordButton);

        return chooseWordGroup;
    }

    public Group createplaySceneGroup() {

        Group playSceneGroup = new Group();

        Button nextRoundButton = new Button("Next Round");
        nextRoundButton.setLayoutX(300);
        nextRoundButton.setLayoutY(650);
        nextRoundButton.setTextFill(Color.FIREBRICK);
        nextRoundButton.setOnAction(event -> stage.setScene(settingScene));


        playersDrawing.getChildren().add(nextRoundButton);


        return playSceneGroup;
    }

}
