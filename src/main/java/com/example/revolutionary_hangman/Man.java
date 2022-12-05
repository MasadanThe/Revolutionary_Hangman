package com.example.revolutionary_hangman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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

    public List<Shape> getDrawing() {
        return drawing;
    }

    public void createDrawing(){
        // Create a base
        Rectangle base = new Rectangle();
        base.setHeight(height * 0.1);
        base.setWidth(width * 0.6);
        base.setX( xPosition + width * 0.2);
        base.setY(yPosition + height * 0.9);
        base.setFill(Color.BLACK);
        drawing.add(base);

        // Create the pole
        Rectangle pole = new Rectangle();
        pole.setHeight(height * 0.7);
        pole.setWidth(width * 0.1);
        pole.setX(base.getX() + base.getWidth() * 0.5);
        pole.setY(base.getY() + pole.getHeight());
        pole.setFill(Color.BLACK);
        drawing.add(pole);

        // Create the roof
        Rectangle roof = new Rectangle();
        roof.setWidth(base.getWidth() * 0.5);
        roof.setHeight(height * 0.1);
        roof.setX(pole.getX());
        roof.setY(pole.getY());
        roof.setFill(Color.BLACK);
        drawing.add(roof);

        // Create stability pole
        Line stabilityPole = new Line();
        stabilityPole.setStartX(pole.getX());
        stabilityPole.setStartY(pole.getY() + pole.getHeight() * 0.2);
        stabilityPole.setEndX(roof.getX() + roof.getWidth() * 0.2);
        stabilityPole.setEndY(roof.getY());
        stabilityPole.setFill(Color.BLACK);
        drawing.add(stabilityPole);

        // Create noose
        Rectangle noose = new Rectangle();
        noose.setX(roof.getX() + roof.getWidth());
        noose.setY(roof.getY());
        noose.setWidth(width * 0.1);
        noose.setHeight(height * 0.3);
        noose.setFill(Color.BLACK);
        drawing.add(noose);

        // Create head
        Circle head = new Circle();
        head.setRadius(width * 0.3);
        head.setCenterX(noose.getX());
        head.setCenterY(noose.getY() + head.getRadius());
        head.setFill(Color.BLACK);
        drawing.add(head);

        // Create body
        Rectangle body = new Rectangle();
        body.setX(head.getCenterX());
        body.setY(head.getCenterY() + head.getRadius());
        body.setHeight(height * 0.5);
        body.setWidth(width * 0.1);
        body.setFill(Color.BLACK);
        drawing.add(body);

        // Create left arm
        Line leftArm = new Line();
        leftArm.setStartX(body.getX());
        leftArm.setStartY(body.getY() + body.getHeight()*0.2);
        leftArm.setEndX(body.getX() - body.getHeight() * 0.3);
        leftArm.setEndY(body.getY() + body.getHeight() * 0.3);
        leftArm.setFill(Color.BLACK);
        drawing.add(leftArm);

        // Create right arm
        Line rightArm = new Line();
        rightArm.setStartX(body.getX());
        rightArm.setStartY(body.getY() + body.getHeight()*0.2);
        rightArm.setEndX(body.getX() + body.getHeight() * 0.3);
        rightArm.setEndY(body.getY() + body.getHeight() * 0.3);
        rightArm.setFill(Color.BLACK);
        drawing.add(rightArm);

        // Create left leg
        Line leftLeg = new Line();
        leftLeg.setStartX(body.getX());
        leftLeg.setStartY(body.getY() + body.getHeight());
        leftLeg.setEndX(leftLeg.getStartX() - body.getHeight() * 0.3);
        leftLeg.setEndY(leftLeg.getStartY() + body.getHeight() * 0.3);
        leftLeg.setFill(Color.BLACK);
        drawing.add(leftLeg);

        // Create right leg
        Line rightLeg = new Line();
        rightLeg.setStartX(body.getX());
        rightLeg.setStartY(body.getY() + body.getHeight());
        rightLeg.setEndX(rightLeg.getStartX() + body.getHeight() * 0.3);
        rightLeg.setEndY(rightLeg.getStartY() + body.getHeight() * 0.3);
        rightLeg.setFill(Color.BLACK);
        drawing.add(rightLeg);
    }

}
