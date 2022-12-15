package com.example.revolutionary_hangman;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private Man man = new Man();

    private String name;
    private String word;
    public int points;
    public int xPosition;
    public int yPosition;
    public int width;
    public int height;

    private ArrayList<Character> wordAsArrayList;

    private Group drawing;

    public Player(int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;

        wordAsArrayList = new ArrayList<>();
        drawing = new Group();
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
        man.setWidth(width);
        man.setHeight(height);
        man.setxPosition(xPosition);
        man.setyPosition(yPosition);
        man.createDrawing();
        drawing = man.getDrawing();

    }


    public List<Shape> getDrawing(){
        return drawing;
    }
}