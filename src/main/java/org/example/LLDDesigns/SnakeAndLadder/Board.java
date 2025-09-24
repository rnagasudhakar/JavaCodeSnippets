package org.example.LLDDesigns.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    int noOfRows;
    int noOfColumns;
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladders;
    int[][] board;

    public Board(int noOfRows, int noOfColumns) {
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.board = new int[noOfRows][noOfColumns];
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        initializeBoard();
        initializeSnakesAndLadders();
    }

    private void initializeBoard(){
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfColumns;j++){
                board[i][j] = (i*10)+j;
            }
        }
    }

    private void initializeSnakesAndLadders(){
        this.snakes.put(34,5);
        this.snakes.put(43,24);
        this.snakes.put(74,27);

        this.ladders.put(23,56);
        this.ladders.put(4,46);
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

}
