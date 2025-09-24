package org.example.LLDDesigns.ElevatorSystem.Utilities;

public class HallButton extends Button{
    public Direction direction;

    public HallButton(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
