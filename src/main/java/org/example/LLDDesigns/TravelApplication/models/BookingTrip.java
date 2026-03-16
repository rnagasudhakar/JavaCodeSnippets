package org.example.LLDDesigns.TravelApplication.models;

import org.example.LLDDesigns.TravelApplication.enums.TripStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookingTrip {
    private String bookingTripId;
    private LocalTime startTime;
    private LocalTime endTime;
    private Driver driver;
    private Double totalCost;
    private TripStatus tripStatus;

    public BookingTrip(String bookingTripId, LocalTime startTime, LocalTime endTime, Driver driver) {
        this.bookingTripId = bookingTripId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.driver = driver;
        this.totalCost = 0.0;
        this.tripStatus = TripStatus.SCHEDULED;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getBookingTripId() {
        return bookingTripId;
    }

    public void setBookingTripId(String bookingTripId) {
        this.bookingTripId = bookingTripId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    public Double getTotalCost() {
        long hourCount = Duration.between(startTime,endTime).toHours();
        return hourCount * driver.getHourlyRate();
    }



    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
}
