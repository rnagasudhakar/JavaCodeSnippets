package org.example.LLDDesigns.ParkingLot;

import org.example.LLDDesigns.ParkingLot.CustomExceptions.FloorsFullException;
import org.example.LLDDesigns.ParkingLot.ParkingSpot.CarParkingSpot;
import org.example.LLDDesigns.ParkingLot.ParkingSpot.LargeParkingSpot;
import org.example.LLDDesigns.ParkingLot.ParkingSpot.ParkingSpot;
import org.example.LLDDesigns.ParkingLot.ParkingSpot.SmallParkingSpot;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class Floor {

    private ArrayList<ParkingSpot> parkingSpots;
    int floorId;
    private static final int parkingSpotsCount = 100;
    private final int carParkingSpots;
    private final int bikeParkingSpots;
    private final int largeVehicleParkingSpots;

    private Floor(int floorId, FloorBuilder floorBuilder) {
        this.parkingSpots = new ArrayList<>();
        this.floorId = floorId;
        this.carParkingSpots = floorBuilder.carParkingSpots;
        this.bikeParkingSpots = floorBuilder.bikeParkingSpots;
        this.largeVehicleParkingSpots = floorBuilder.largeVehicleParkingSpots;
        initializeFloor();
    }

    public void initializeFloor(){
        for(int i=0;i<carParkingSpots;i++){
            this.addParkingSpot(VehicleType.CAR);
        }
        for(int i=0;i<bikeParkingSpots;i++){
            this.addParkingSpot(VehicleType.BIKE);
        }
        for(int i=0;i<largeVehicleParkingSpots;i++){
            this.addParkingSpot(VehicleType.LARGE_VEHICLE);
        }
    }

   public static class FloorBuilder {
        private int carParkingSpots;
        private int bikeParkingSpots;
        private int largeVehicleParkingSpots;
        private int floorId;

        public  FloorBuilder(int floorId){
            this.floorId = floorId;
        }

       public FloorBuilder setCarParkingSpots(int carParkingSpots) {
           this.carParkingSpots = carParkingSpots;
           return this;
       }

       public FloorBuilder setBikeParkingSpots(int bikeParkingSpots) {
           this.bikeParkingSpots = bikeParkingSpots;
           return this;

       }

       public FloorBuilder setLargeVehicleParkingSpots(int largeVehicleParkingSpots) {
           this.largeVehicleParkingSpots = largeVehicleParkingSpots;
           return this;
       }

       public Floor buildFloor(){
           return new Floor(this.floorId,this);
       }

   }

    public void addParkingSpot(VehicleType vehicleType) {
        if (this.parkingSpots.size() == parkingSpotsCount) {
            throw new FloorsFullException("Floor is full");
        }
        ParkingSpot parkingSpot = switch (vehicleType) {
            case BIKE -> new SmallParkingSpot(UUID.randomUUID());
            case LARGE_VEHICLE -> new LargeParkingSpot(UUID.randomUUID());
            default -> new CarParkingSpot(UUID.randomUUID());
        };
        parkingSpots.add(parkingSpot);
    }

    public void deleteParkingSpot(UUID uuid) {
        if (parkingSpots.stream().filter(parkingSpot -> parkingSpot.getId().equals(uuid)).findFirst().isEmpty()) {
            throw new RuntimeException("UUID is not present");
        }
        parkingSpots = parkingSpots.stream().filter(parkingSpot -> !parkingSpot.getId().equals(uuid)).collect(Collectors.toCollection(ArrayList::new));
    }


}
