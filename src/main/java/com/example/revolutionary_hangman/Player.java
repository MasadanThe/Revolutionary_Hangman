package com.example.revolutionary_hangman;

public class Player {

    public static class Man {


    private String name;
    private String word;
    public int xPosition;
    public int yPosition;
    public int width;
    public int height;

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

        public Man(String name, String word, int xPosition, int yPosition, int width, int height) {
            this.name = name;
            this.word = word;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.width = width;
            this.height = height;

        }

    }
    public int createDrawing(int xPosition, int yPosition, int width, int height) {

    }
}
