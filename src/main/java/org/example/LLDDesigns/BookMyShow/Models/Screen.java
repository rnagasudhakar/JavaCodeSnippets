package org.example.LLDDesigns.BookMyShow.Models;

import org.example.LLDDesigns.BookMyShow.Services.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen {
    private  final int maxNumberOfSeatsInRow = 10;
    int screenId;
    List<Seat> seats = new ArrayList<>();

    public Screen(int screenId) {
        this.screenId = screenId;
        initializeScreen();
    }


    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    private void initializeScreen(){
        // RECLINER
        for(Character i='A';i<='B';i++) {
            for (int j = 1; j <= maxNumberOfSeatsInRow; j++) {
                seats.add(new Seat(IdGenerator.getNextSeatId(), j, i, SeatType.RECLINER));
            }
        }

        // PREMIUM
        for(Character i='C';i<='F';i++) {
            for (int j = 1; j <= maxNumberOfSeatsInRow; j++) {
                seats.add(new Seat(IdGenerator.getNextSeatId(), j, i, SeatType.PREMIUM));
            }
        }

        // ECONOMY
        for(Character i='G';i<='N';i++) {
            for (int j = 1; j <= maxNumberOfSeatsInRow; j++) {
                seats.add(new Seat(IdGenerator.getNextSeatId(), j, i, SeatType.ECONOMY));
            }
        }

    }

    // CRUD adding and delete Seats

}
