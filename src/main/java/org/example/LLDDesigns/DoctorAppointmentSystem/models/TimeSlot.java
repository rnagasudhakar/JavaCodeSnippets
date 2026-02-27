package org.example.LLDDesigns.DoctorAppointmentSystem.models;

import org.example.LLDDesigns.DoctorAppointmentSystem.enums.SlotStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {
    private String slotId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private SlotStatus slotStatus;

    public TimeSlot(String slotId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.slotId = slotId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotStatus = SlotStatus.EMPTY;
    }

    public void bookTimeSlot(){
        if(slotStatus == SlotStatus.BOOKED){
            throw new RuntimeException("Slot is already booked");
        }
        this.slotStatus = SlotStatus.BOOKED;
    }

    public void cancelTimeSlot(){
        this.slotStatus = SlotStatus.EMPTY;
    }

    public boolean isTimeSlotOverlaps(TimeSlot t1, TimeSlot t2){
        if(t1.getDate().equals(t2.getDate())){
            return t1.getStartTime().isAfter(t2.getEndTime()) && t1.getEndTime().isAfter(t2.getStartTime());
        }
        return false;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

}
