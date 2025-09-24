package org.example.LLDDesigns.ElevatorSystem.Utilities;

public class Display {
    Direction direction;
    int currentFloor;

    public Display(Direction direction, int currentFloor) {
        this.direction = direction;
        this.currentFloor = currentFloor;
    }


    public void showDisplay(){
        System.out.println("current direction is "+  this.direction + " and current floor is " + this.currentFloor);
    }

}
