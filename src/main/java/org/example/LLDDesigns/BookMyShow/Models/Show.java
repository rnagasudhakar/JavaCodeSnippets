package org.example.LLDDesigns.BookMyShow.Models;
import org.example.LLDDesigns.BookMyShow.Controllers.PricingStrategy;

import java.util.*;
import java.time.*;


public class Show {

    int showId;
    Movie movie;
    Screen screen;
    List<ShowSeat> showSeatList;
    LocalDateTime startingTime;
    PricingStrategy pricingStrategy;


    public Show(int showId, Movie movie,  Screen screen,  LocalDateTime startingTime, PricingStrategy pricingStrategy) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startingTime = startingTime;
        this.pricingStrategy = pricingStrategy;
        this.showSeatList = new ArrayList<>();
        for(int i=0;i<this.screen.getSeats().size();i++){
            Seat seat = this.screen.getSeats().get(i);
            this.showSeatList.add(new ShowSeat(seat.getSeatId(),seat.getRow(),seat.getCol(),seat.getSeatType(),pricingStrategy.calculatePrice(seat,this.startingTime)));
        }
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
