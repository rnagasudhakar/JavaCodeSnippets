package org.example.LLDDesigns.TravelApplication.models;

import java.time.LocalTime;
import java.util.TreeSet;

public class Driver {
    private final String driverId;
    private final String name;
    private final Double hourlyRate;
    private LocalTime availableTime;

    public Driver(String driverId, String name, Double hourlyRate) {
        this.driverId = driverId;
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public void setAvailableTime(LocalTime time){
        availableTime = time;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public LocalTime getAvailableTime() {
        return availableTime;
    }
}
