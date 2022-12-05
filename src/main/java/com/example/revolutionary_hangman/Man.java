package com.example.revolutionary_hangman;

import javafx.scene.shape.Rectangle;
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

    public void createDrawing(){
        // Create a base
        Rectangle base = new Rectangle();
        base.setHeight(height * 0.1);
        base.setWidth(width * 0.6);
        base.setX( xPosition + width * 0.2);
        base.setY(yPosition + height * 0.9);
        drawing.add(base);

        // Create the pole
        Rectangle pole = new Rectangle();
        pole.setHeight(height * 0.7);
        pole.setWidth(width * 0.1);
        pole.setX(base.getX() + base.getWidth() * 0.5);
        pole.setY(base.getY() + pole.getHeight());
        drawing.add(pole);

        // Create the roof
        Rectangle roof = new Rectangle();
        roof.setWidth(base.getWidth() * 0.5);
        roof.setHeight(height * 0.1);
        roof.setX(pole.getX());
        roof.setY(pole.getY());
        drawing.add(roof);


    }

}
