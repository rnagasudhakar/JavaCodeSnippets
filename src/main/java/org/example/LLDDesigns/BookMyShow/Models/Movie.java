package org.example.LLDDesigns.BookMyShow.Models;

import java.util.Date;

public class Movie {
    int movieId;
    String movieTitle;
    String hero; // It can be separate class of Cast
    int durationInMinutes;

    public Movie(int movieId, String movieTitle, String hero, int durationInMinutes) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.hero = hero;
        this.durationInMinutes = durationInMinutes;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
