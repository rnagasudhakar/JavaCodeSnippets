package org.example.LLDDesigns.ElevatorSystem.Utilities;

import java.util.*;

public class ElevatorCar {
    int elevatorId;
    ElevatorPanel elevatorPanel;
    Display display;
    ElevatorCarState currentState;
    Queue<Integer> upRequests;
    Queue<Integer> downRequests;
    int currentFloor;

    public ElevatorCar(int elevatorId) {
        this.elevatorId = elevatorId;
        this.elevatorPanel = new ElevatorPanel();
        this.display = new Display(Direction.UP,0);
        this.currentState = ElevatorCarState.IDLE;
        upRequests = new PriorityQueue<>();
        downRequests = new PriorityQueue<>(Comparator.reverseOrder());
        currentFloor = 0;
    }


    public synchronized  void move(){
        if(this.currentState == ElevatorCarState.IN_MAINTENANCE){
            System.out.println("Elevator is in maintaience mode");
            return;
        }
        if(currentState == ElevatorCarState.IDLE){
            currentState = ElevatorCarState.MOVING_UP;
            while (!upRequests.isEmpty()){
                int destinationFloor = upRequests.peek();
                currentFloor = destinationFloor;
                System.out.println("Please get down, current Floor is" + destinationFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                upRequests.poll();
            }

            System.out.println("Elevator is Going Down");
            currentState = ElevatorCarState.MOVING_DOWN;

            while (!downRequests.isEmpty()){
                int destinationFloor = downRequests.peek();
                currentFloor = destinationFloor;
                System.out.println("Please get down, current Floor is" + destinationFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                downRequests.poll();
            }

            currentState = ElevatorCarState.IDLE;

        }
    }


    public void pressFloorButton(int floor){
        if(currentState == ElevatorCarState.MOVING_UP){
            if(currentFloor< floor){
                upRequests.add(floor);
            }
            else{
                downRequests.add(floor);
            }
        }
        else{
            if(currentFloor>floor){
                upRequests.add(floor);
            }
            else {
                downRequests.add(floor);
            }
        }
    }



    public int getElevatorId() {
        return elevatorId;
    }

    public ElevatorCarState getCurrentState() {
        return currentState;
    }

    public Queue<Integer> getUpRequests() {
        return upRequests;
    }

    public Queue<Integer> getDownRequests() {
        return downRequests;
    }

    public ElevatorPanel getElevatorPanel() {
        return elevatorPanel;
    }

    public Display getDisplay() {
        return display;
    }


}
