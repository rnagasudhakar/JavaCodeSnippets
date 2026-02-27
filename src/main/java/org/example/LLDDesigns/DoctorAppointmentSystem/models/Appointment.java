package org.example.LLDDesigns.DoctorAppointmentSystem.models;

import org.example.LLDDesigns.CarRentalSystem.Payment;

public class Appointment {
    private String appointmentId;
    private Doctor doctor;
    private Customer customer;
    private TimeSlot timeSlot;
    private Payment payment;

    public Appointment(String appointmentId, Doctor doctor, Customer customer, TimeSlot timeSlot) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.customer = customer;
        this.timeSlot = timeSlot;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
