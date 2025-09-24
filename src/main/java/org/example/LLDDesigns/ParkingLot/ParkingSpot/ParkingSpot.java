package org.example.LLDDesigns.ParkingLot.ParkingSpot;

import org.example.LLDDesigns.ParkingLot.VehicleType;

import java.util.UUID;

public abstract class ParkingSpot {

    private final UUID id;
    private boolean isEmpty;
    public   VehicleType vehicleType;


    public ParkingSpot(UUID id) {
        this.id = id;
        this.isEmpty = true;
    }

    public abstract void setVehicleType();

    public void parkVehicle(){
        this.isEmpty = false;
    }

    public void freeVehicle(){
        this.isEmpty = true;
    }

    public UUID getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


}
