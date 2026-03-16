package org.example.LLDDesigns.TravelApplication.services;

import org.example.LLDDesigns.TravelApplication.models.BookingTrip;
import org.example.LLDDesigns.TravelApplication.models.Driver;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class TravelApplication {
    private HashMap<String, BookingTrip> trips = new HashMap<>();
    private DriverService driverService = new DriverService();


    public void addTrip(String bookingTripId,
                        LocalTime startTime,
                        LocalTime endTime){
        trips.computeIfAbsent(bookingTripId,(K)-> new BookingTrip(bookingTripId,
                 startTime,
                 endTime,
                null));
    }

    private double totalCost(){
        double totalCost = 0.0;
        for(BookingTrip trip: trips.values()){
            Driver driver = getNearestAvaibleDriver(trip.getStartTime());
            trip.setDriver(driver);
            if(driver == null) continue;
            totalCost += trip.getTotalCost();
        }
        return totalCost;
    }


    public Driver getNearestAvaibleDriver(LocalTime currTime){
        List<Driver> driverList = driverService.getDriverList();
        long diff = 86500;
        Driver currDriver = null;
        for(Driver driver : driverList){
            if(driver.getAvailableTime() == null) continue;
            long seconds = Duration.between(currTime,driver.getAvailableTime()).toSeconds();
            if(diff >seconds){
                diff = seconds;
                currDriver = driver;
            }
        }
        if(currDriver !=null){
            currDriver.setAvailableTime(null);
        }
        return currDriver;
    }

}
