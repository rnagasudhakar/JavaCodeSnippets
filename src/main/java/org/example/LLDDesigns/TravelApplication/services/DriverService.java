package org.example.LLDDesigns.TravelApplication.services;

import org.example.LLDDesigns.TravelApplication.models.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DriverService {
    private final HashMap<String, Driver> driverHashMap;

    public DriverService() {
        this.driverHashMap = new HashMap<>();
    }

    public void addDriver(Driver driver){
        driverHashMap.computeIfAbsent(driver.getDriverId(),(k)->driver);
    }

    public Driver getDriverById(String driverId){
        return driverHashMap.get(driverId);
    }

    public List<Driver> getDriverList(){
        return (List<Driver>) driverHashMap.values();
    }

}
