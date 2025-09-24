package org.example.LLDDesigns.ElevatorSystem.Utilities;

public class HallPanel {
    HallButton downButton;
    HallButton upButton;

    HallPanel(){
        downButton = new HallButton(Direction.DOWN);
        upButton = new HallButton(Direction.UP);
    }

    public HallButton getDownButton() {
        return downButton;
    }

    public HallButton getUpButton() {
        return upButton;
    }
}
