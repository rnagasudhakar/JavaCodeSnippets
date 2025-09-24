package org.example.LLDDesigns.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private static volatile ParkingLot parkingLotInstance;
    private int floorCount;
    private Map<Integer, Floor> parkingLotContainer ;


    private ParkingLot(int floorCount){
        this.floorCount = floorCount;
        this.parkingLotContainer = new HashMap<>();
        for(int i=1;i<=floorCount;i++){
            Floor floor = new Floor.FloorBuilder(i).setBikeParkingSpots(20).setCarParkingSpots(10).setLargeVehicleParkingSpots(5).buildFloor();
            this.parkingLotContainer.put(i, floor);
        }
    }

    public static ParkingLot getParkingLotInstance (int floorCount){
        if(ParkingLot.parkingLotInstance == null){
            synchronized (ParkingLot.class){
                if(parkingLotInstance == null){
                    parkingLotInstance = new ParkingLot(floorCount);
                }
            }
        }
        return ParkingLot.parkingLotInstance;
    }

    public void parkingFloor(){
        Floor floor = new Floor.FloorBuilder(floorCount).setCarParkingSpots(20).buildFloor();
        this.parkingLotContainer.put(floorCount,floor);
        this.floorCount++;
    }

    public void deleteParkingFloor(int floorId){
        if(parkingLotContainer.isEmpty()){
            throw new RuntimeException("parking lot is empty");
        }
        if(!parkingLotContainer.containsKey(floorId)){
            throw  new RuntimeException("Floor Id is not present to delete");
        }
        this.parkingLotContainer.remove(floorId);
    }



}
