package com.example.revolutionary_hangman;

public class Player {


  private Man man= new Man();

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




    public void createDrawing(int xPosition, int yPosition, int width, int height) {

    }
}

