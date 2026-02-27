package org.example.LLDDesigns.DoctorAppointmentSystem.services;

import org.example.LLDDesigns.DoctorAppointmentSystem.dao.AppointmentDao;
import org.example.LLDDesigns.DoctorAppointmentSystem.dao.UserDao;
import org.example.LLDDesigns.DoctorAppointmentSystem.enums.SlotStatus;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Appointment;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Customer;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Doctor;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.TimeSlot;

public class AppointmentService {

    private final AppointmentDao appointmentDao;
    private UserService userService;
    public static  AppointmentService getAppointmentServiceInstance(){
        return new AppointmentService();
    }

    private AppointmentService(){
        this.appointmentDao = new AppointmentDao();
        this.userService = new UserService();
    }


    public void createAppointment(String appointmentId,String customerId, String doctorId, TimeSlot timeSlot){
        if(appointmentDao.getAppointmentById(appointmentId)!=null){
            throw new IllegalArgumentException("appointment is present");
        }
        Customer customer = userService.getCustomer(customerId);
        Doctor doctor = userService.getDoctor(doctorId);
        System.out.println("Doctor is" + doctor.getName());
        if(doctor.getTimeSlotBy(timeSlot.getSlotId()).getSlotStatus().equals(SlotStatus.EMPTY)){
            Appointment appointment = new Appointment(appointmentId,doctor,customer,timeSlot);
            appointmentDao.addAppointment(appointmentId,appointment);
            doctor.getTimeSlotBy(timeSlot.getSlotId()).bookTimeSlot();
            System.out.println("Time slot has been booked");
        }
        else{
            System.out.println("Time slot is already booked");
            return;
        }
        System.out.println("Doctor has been booked");
    }

    public void cancelAppointment(String appointmentId){
        Appointment appointment = appointmentDao.getAppointmentById(appointmentId);
        if(appointmentId==null){
            throw new RuntimeException("appointment Id is not valid");
        }
        Doctor doctor = appointment.getDoctor();
        TimeSlot timeSlot = appointment.getTimeSlot();
        doctor.getTimeSlotBy(timeSlot.getSlotId()).cancelTimeSlot();
        appointmentDao.removeAppointement(appointmentId);
    }

    public void postPoneAppointment(String appointmentId, TimeSlot futureTimeSlot){
        Appointment appointment = appointmentDao.getAppointmentById(appointmentId);
        if(appointmentId==null){
            throw new RuntimeException("appointment Id is not valid");
        }
        Doctor doctor = appointment.getDoctor();
        if(doctor.getTimeSlotBy(futureTimeSlot.getSlotId()).getSlotStatus().equals(SlotStatus.BOOKED)){
            System.out.println("Time slot is not present");
            return;
        }
        TimeSlot timeSlot = appointment.getTimeSlot();
        doctor.getTimeSlotBy(timeSlot.getSlotId()).cancelTimeSlot();
        doctor.getTimeSlotBy(futureTimeSlot.getSlotId()).bookTimeSlot();
        appointment.setTimeSlot(futureTimeSlot);
    }

}
