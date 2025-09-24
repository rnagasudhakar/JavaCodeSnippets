package org.example.LLDDesigns.TicTacToe;

public class Board {
    public int numOfRows;
    public int numOfColumns;
    private Cell[][] board;

    Board(int numOfRows, int numOfColumns){
        this.board = new Cell[numOfRows][numOfColumns];
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfColumns;j++){
                this.board[i][j] = new Cell(i,j);
            }
        }
    }

    public void play(int rowId, int columnId, Piece piece){
        if(this.board[rowId][columnId].isEmpty()) {
            this.board[rowId][columnId].setPiece(piece);
        }
    }

    public void currentGameStatus(){
        // implement
    }


}
