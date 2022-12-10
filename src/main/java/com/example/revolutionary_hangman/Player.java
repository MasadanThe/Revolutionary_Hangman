package com.example.revolutionary_hangman;

import java.util.ArrayList;

public class Player {

  //instance of man begins whit private
  private Man man= new Man();


        private String name;
        public int points;
        private String word;
        public int xPosition;
        public int yPosition;
        public int width;
        public int height;


        ArrayList<Character> wordAsArrayList = new ArrayList<>();
        public Player(int xPosition, int yPosition, int width, int height){
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.width = width;
            this.height = height;
        }


        public String getName() {
           return name;
        }
         public int getPoints() {
           return points;
        }
        public void setPoints(int points) {
            this.points = points;
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



    public void createDrawing(int xPosition, int yPosition, int width, int height) {

    }
}

