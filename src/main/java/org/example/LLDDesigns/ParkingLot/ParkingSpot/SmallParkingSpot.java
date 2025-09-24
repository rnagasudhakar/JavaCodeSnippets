package org.example.LLDDesigns.ParkingLot.ParkingSpot;

import org.example.LLDDesigns.ParkingLot.VehicleType;

import java.util.UUID;

public class SmallParkingSpot extends ParkingSpot{

    public SmallParkingSpot(UUID id) {
        super(id);
    }

    @Override
    public void setVehicleType() {
        this.vehicleType = VehicleType.BIKE;
    }

}
