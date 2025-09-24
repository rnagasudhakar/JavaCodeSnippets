package org.example.LLDDesigns.BookMyShow.Models;

public class Seat {
    int seatId;
    int row;
    Character col;


    SeatType seatType;

    public Seat(int seatId, int row, Character col, SeatType seatType) {
        this.seatId = seatId;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Character getCol() {
        return col;
    }

    public void setCol(Character col) {
        this.col = col;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
