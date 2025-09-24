package org.example.LLDDesigns.ParkingLot.ParkingSpot;

import org.example.LLDDesigns.ParkingLot.VehicleType;

import java.util.UUID;

public class LargeParkingSpot extends ParkingSpot{

    public LargeParkingSpot(UUID id) {
        super(id);
    }

    @Override
    public void setVehicleType() {
        this.vehicleType = VehicleType.LARGE_VEHICLE;
    }
}
