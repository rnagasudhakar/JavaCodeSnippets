package org.example.LLDDesigns.ElevatorSystem.Utilities;

public class Floor {
    int floorId;
    HallPanel hallPanel;

    public Floor(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorId() {
        return floorId;
    }

    public HallPanel getHallPanel() {
        return hallPanel;
    }
}
