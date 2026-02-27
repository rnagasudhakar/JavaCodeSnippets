package org.example.LLDDesigns.DoctorAppointmentSystem.dao;

import org.example.LLDDesigns.DoctorAppointmentSystem.models.Appointment;

import java.util.HashMap;

public class AppointmentDao {
    private final HashMap<String, Appointment> appointmentHashMap;

    public AppointmentDao() {
        this.appointmentHashMap = new HashMap<>();
    }

    public void addAppointment(String appointmentId, Appointment appointment){
        this.appointmentHashMap.computeIfAbsent(appointmentId,K->appointment);
    }


    public Appointment getAppointmentById(String appointmentId){
        if(appointmentHashMap.containsKey(appointmentId)){
            return appointmentHashMap.get(appointmentId);
        }
        return null;
    }

    public void removeAppointement(String appointmentId){
       appointmentHashMap.remove(appointmentId);
    }
}
