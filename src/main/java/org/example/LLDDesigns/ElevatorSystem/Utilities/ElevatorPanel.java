package org.example.LLDDesigns.ElevatorSystem.Utilities;

import java.util.*;

public class ElevatorPanel {
    List<FloorButton> floorButtonList;
    DoorButton openDoorButton;
    DoorButton closeDoorButton;

    ElevatorPanel(){
        this.floorButtonList = new ArrayList<>();
        for(int i=0;i<=4;i++){
            this.floorButtonList.add(new FloorButton(i));
        }
        openDoorButton = new DoorButton(DoorState.OPEN);
        closeDoorButton = new DoorButton(DoorState.CLOSE);
    }

    public void addFloorButton(int destinationFloor){
        if(floorButtonList.stream().anyMatch(floorButton -> floorButton.getDestinationFloorNumber() == destinationFloor)){
            System.out.println("Floor number is already present");
            return;
        }
        floorButtonList.add(new FloorButton(destinationFloor));
    }

    public void deleteFloorButton(int destinationFloor){
        if(floorButtonList.stream().anyMatch(floorButton -> floorButton.getDestinationFloorNumber() == destinationFloor)){
           floorButtonList.remove(new FloorButton(destinationFloor));
           return ;
        }
        System.out.println("Floor is not  present");
    }


}
