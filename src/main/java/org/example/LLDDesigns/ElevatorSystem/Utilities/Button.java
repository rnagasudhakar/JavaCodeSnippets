package org.example.LLDDesigns.ElevatorSystem.Utilities;

public abstract class Button {
    boolean isPressed;

    public void pressButton(){
        if(!this.isPressed) {
            this.isPressed = true;
        }
    }

    public void resetButton(){
        if(this.isPressed){
            this.isPressed=false;
        }
    }

}
