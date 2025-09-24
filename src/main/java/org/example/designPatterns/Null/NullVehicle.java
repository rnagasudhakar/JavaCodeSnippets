package org.example.designPatterns.Null;

public class NullVehicle implements Vehicle{
    @Override
    public int getFuelCapacity() {
        return 0;
    }

    @Override
    public int vehiclePrice() {
        return 0;
    }
}
