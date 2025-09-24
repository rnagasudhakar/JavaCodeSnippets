package org.example.LLDDesigns.ParkingLot.CustomExceptions;

public class FloorsFullException extends RuntimeException{

    public FloorsFullException(String message){
        super(message);
    }

}
