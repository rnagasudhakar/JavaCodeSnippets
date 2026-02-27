package org.example.LLDDesigns.DoctorAppointmentSystem;

import org.example.LLDDesigns.DoctorAppointmentSystem.enums.SpecializationType;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Customer;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Doctor;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.TimeSlot;
import org.example.LLDDesigns.DoctorAppointmentSystem.services.AppointmentService;
import org.example.LLDDesigns.DoctorAppointmentSystem.services.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AppointmentService appointmentService = AppointmentService.getAppointmentServiceInstance();
        Doctor doctor1 = new Doctor("D1","Sudhakar", Arrays.asList(SpecializationType.CARDIO,SpecializationType.NEURO),1000.0,3.0);
        Doctor doctor2 = new Doctor("D2","Rohith", Arrays.asList(SpecializationType.GASTRO,SpecializationType.NEURO),1200.0,4.0);
        userService.addDoctor(doctor1);
        userService.addDoctor(doctor2);

        Customer customer1 = new Customer("C1","Revathi");
        Customer customer2 = new Customer("C2","Sudha");
        userService.addCustomer(customer1);
        userService.addCustomer(customer2);

        TimeSlot t1 = new TimeSlot("T1", LocalDate.now(), LocalTime.of(9,30),LocalTime.of(12,30));
        TimeSlot t2 = new TimeSlot("T1", LocalDate.now(), LocalTime.of(13,30),LocalTime.of(18,30));

        doctor1.addTimeSlot(t1);
        doctor2.addTimeSlot(t2);

        appointmentService.createAppointment("A1","C1","D1",t1);


    }
}
