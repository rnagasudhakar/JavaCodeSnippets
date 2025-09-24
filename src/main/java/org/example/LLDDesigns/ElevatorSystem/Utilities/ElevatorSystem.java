package org.example.LLDDesigns.ElevatorSystem.Utilities;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ElevatorSystem {

    private volatile ElevatorSystem elevatorSystem;
    List<ElevatorCar> elevatorCarList;
    List<Floor> floors;
    Queue<Integer> upRequests;
    Queue<Integer> downRequests;


    private ElevatorSystem(){
        this.elevatorCarList = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.upRequests = new PriorityQueue<>();
        this.downRequests = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i = 0; i < 4; i++) {
            this.elevatorCarList.add(new ElevatorCar(i));
        }


        for (int i = 0; i < 4; i++) {
            this.floors.add(new Floor(i));
        }
    }

    public ElevatorSystem getElevatorSystemInstance(){
        if(elevatorSystem!=null){
            synchronized(this){
                if(elevatorSystem!=null){
                    elevatorSystem = new ElevatorSystem();
                }
            }
        }
        return elevatorSystem;
    }


    ElevatorCar getNearestElevatorCar(int floor) {
        // logic can be improved but first learn elevator algorithms
        ElevatorCar elevatorCar = elevatorCarList.get(0);
        int diff = 10;
        for (ElevatorCar elevatorCar1 : elevatorCarList) {
            if (elevatorCar1.currentState == ElevatorCarState.MOVING_UP) {
                int elevatorFloor = elevatorCar1.currentFloor;
                if (elevatorFloor < floor) {
                    if (diff > floor - elevatorFloor) {
                        diff = floor - elevatorFloor;
                        elevatorCar = elevatorCar1;
                    }
                    else{

                    }
                }
            } else {

            }
        }
        return elevatorCar;
    }



    public void assignElevator(){
        while(upRequests.size() >0 ){

        }
    }

}
