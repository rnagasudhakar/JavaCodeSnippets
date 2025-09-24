package org.example.designPatterns.Null;

public class VehicleFactory {

    public static  Vehicle getVehicle(String vehicleName){
        if (vehicleName.equals("Bike")) {
            return new Bike();
        }
        return new NullVehicle(); // here instead of returning null always returns default object
    }

}
