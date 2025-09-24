package org.example.LLDDesigns.TicTacToe;

public class Cell {
    private  int rowId;
    private int columnId;
    private boolean isEmpty;
    private Piece piece;

    public Cell(int rowId, int columnId) {
        this.rowId = rowId;
        this.columnId = columnId;
        this.isEmpty= true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        this.isEmpty = false;
    }






}
