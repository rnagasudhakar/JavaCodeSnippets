package org.example.LLDDesigns.ParkingLot.ParkingSpot;

import org.example.LLDDesigns.ParkingLot.VehicleType;

import java.util.UUID;

public class CarParkingSpot extends ParkingSpot{

    public CarParkingSpot(UUID id) {
        super(id);
    }

    @Override
    public void setVehicleType() {
        this.vehicleType = VehicleType.CAR;
    }
}
