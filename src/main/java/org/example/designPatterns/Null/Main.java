package org.example.designPatterns.Null;

public class Main {
    // question is assume how will you avoid null pointer exception
    public static void main(String[] args) {
         Vehicle vehicle = VehicleFactory.getVehicle("Bike");
         getVehicleDetails(vehicle);
    }

    private static void getVehicleDetails(Vehicle vehicle){
        System.out.println(vehicle.getFuelCapacity() + vehicle.vehiclePrice());
    }
}
