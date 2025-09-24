package org.example.LLDDesigns.BookMyShow.Models;
import java.util.*;

public class Theater {

    int theaterId;
    String theaterTitle;
    String city; // this can be separate class of Address
    List<Screen> screens;

    public Theater(int theaterId, String theaterTitle, String city, List<Screen> screens) {
        this.theaterId = theaterId;
        this.theaterTitle = theaterTitle;
        this.city = city;
        this.screens = screens;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterTitle() {
        return theaterTitle;
    }

    public void setTheaterTitle(String theaterTitle) {
        this.theaterTitle = theaterTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    // CRUD adding and delete Screen

}
