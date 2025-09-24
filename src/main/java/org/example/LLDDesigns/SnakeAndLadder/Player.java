package org.example.LLDDesigns.SnakeAndLadder;

public class Player {
    Color color;
    String name;
    int currentPosition;
    int playerIndex;

    public Player(Color color, String name, int playerIndex) {
        this.color = color;
        this.name = name;
        this.currentPosition = 0;
        this.playerIndex = playerIndex;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
