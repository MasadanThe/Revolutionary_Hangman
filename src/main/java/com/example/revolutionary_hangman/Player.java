package com.example.revolutionary_hangman;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private Man man = new Man();

    private String name;
    private String word;

    private ArrayList<Character> guessedWrong;
    public int points;
    public int xPosition;
    public int yPosition;
    public int width;
    public int height;
    public int wrongLetterCounter = 0;
    private ArrayList<Character> wordAsArrayList;
    String rightWord;

    private Group drawing;

    public Player(int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;


        rightWord = "";
        wordAsArrayList = new ArrayList<>();
        drawing = new Group();
        guessedWrong = new ArrayList<>();
    }
   /* I player skapa ArrayList<char> "wordAsArrayList" som sparar ordet som bokstäver
    så man kan skriva ut varje i taget.*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWord(String word) {

        this.word = word;
        wordAsArrayList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++)
        {
            wordAsArrayList.add('-');
        }
    }

    public String getWord() {
        return word;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void updateText(){
        List list = drawing.getChildren();
        Boolean foundFirstText = false;
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i) instanceof Text)
            {
                if (!foundFirstText)
                {
                    ((Text) list.get(i)).setText();
                }
            }
        }
    }

    public Boolean checkForCharacter(char character) {
        Boolean foundChar = false;
        // Checks if the Character in word
        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == character) {
                foundChar = true;
            }
        }

        return foundChar;
    }


    public void createDrawing() {
        // Creates the properties of Man and creates the picture
        man.setWidth(width);
        man.setHeight(height);
        man.setxPosition(xPosition);
        man.setyPosition(yPosition);
        man.createDrawing();

        // Adds the man drawing
        drawing.getChildren().addAll(man.getDrawing());

        // Adds the text
        drawing.getChildren().addAll(createText());

    }

    private List<Text> createText(){
        List<Text> textList = new ArrayList<>();


        for (char character: wordAsArrayList) {
            rightWord += character;

        }
        // Right word text
        Text rightWordText = new Text();
        rightWordText.setText(rightWord);
        rightWordText.setX(width * 0.1 + xPosition);
        rightWordText.setY(height * 0.78 + yPosition);
        rightWordText.setFill(Color.BLACK);
        rightWordText.setStyle("-fx-font: 15 arial;");
        textList.add(rightWordText);

        // Wrong guessed letter text
        Text wrongLetterText = new Text();
        wrongLetterText.setText(guessedWrong.toString());
        wrongLetterText.setX(width * 0.1 + xPosition);
        wrongLetterText.setY(height * 0.8 + yPosition);
        wrongLetterText.setFill(Color.BLACK);
        wrongLetterText.setStyle("-fx-font: 15 arial;");
        textList.add(wrongLetterText);

        return textList;
    }

    public void wrongWord () {
        man.getDrawing().get(wrongLetterCounter).setVisible(true);
    }
    public Group getDrawing(){
        return drawing;
    }
}