package org.example.LLDDesigns.ElevatorSystem.Utilities;

public class DoorButton {
    public DoorState doorState;

    public DoorButton(DoorState doorState) {
        this.doorState = doorState;
    }

    public void openDoor(){
        if(this.doorState == DoorState.CLOSE) {
            this.doorState = DoorState.OPEN;
        }
    }

    public void closeDoor(){
        if(this.doorState == DoorState.OPEN) {
            this.doorState = DoorState.CLOSE;
        }
    }

}
