package com.example.revolutionary_hangman;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Man {
    private int width;
    private int height;

    private int xPosition;
    private int yPosition;

    private List<Shape> drawing;

    public Man (int xPosition, int yPosition, int width, int height){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;

        drawing = new ArrayList<>();
    }
}
