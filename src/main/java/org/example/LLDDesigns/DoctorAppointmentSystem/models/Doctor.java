package org.example.LLDDesigns.DoctorAppointmentSystem.models;

import org.example.LLDDesigns.DoctorAppointmentSystem.enums.SpecializationType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor extends User {
    private List<SpecializationType> specializationTypeList;
    private Map<String,TimeSlot> timeSlotMap;
    private Double opdCost;
    private Double rating;

    public Doctor(String userId, String name, List<SpecializationType> specializationTypeList,  Double opdCost, Double rating) {
        super(userId, name);
        this.specializationTypeList = specializationTypeList;
        this.timeSlotMap = new HashMap<>();
        this.opdCost = opdCost;
        this.rating = rating;
    }


    public void addTimeSlot(TimeSlot timeSlot){
        for(TimeSlot slots: timeSlotMap.values()){
            if(slots.isTimeSlotOverlaps(timeSlot,slots)){
                throw new IllegalArgumentException("Time slot is overlapping");
            }
        }
        timeSlotMap.put(timeSlot.getSlotId(),timeSlot);
    }

    public TimeSlot getTimeSlotBy(String timeSlotId){
        return timeSlotMap.get(timeSlotId);
    }



    public List<SpecializationType> getSpecializationTypeList() {
        return specializationTypeList;
    }

    public void setSpecializationTypeList(List<SpecializationType> specializationTypeList) {
        this.specializationTypeList = specializationTypeList;
    }


    public Double getOpdCost() {
        return opdCost;
    }

    public void setOpdCost(Double opdCost) {
        this.opdCost = opdCost;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
