package org.example.LLDDesigns.DoctorAppointmentSystem.services;

import org.example.LLDDesigns.DoctorAppointmentSystem.dao.UserDao;
import org.example.LLDDesigns.DoctorAppointmentSystem.enums.SlotStatus;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Appointment;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Customer;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Doctor;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.TimeSlot;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void addDoctor(Doctor doctor){
        userDao.addDoctor(doctor.getUserId(),doctor);
        System.out.println("Doctor has been added " + doctor.getName());
    }

    public Doctor getDoctor(String doctorId){
        return userDao.getDoctorById(doctorId);
    }

    public Customer getCustomer(String customerId){
        return  userDao.getCustomerById(customerId);
    }

    public void addCustomer(Customer customer){
        userDao.addCustomer(customer.getUserId(),customer);
        System.out.println("Customer has been added " + customer.getName());
    }

    public void addTimeSlot(String doctorId, TimeSlot timeSlot){
        Doctor doctor = userDao.getDoctorById(doctorId);
        if(doctor==null){
            throw new RuntimeException("Doctor is not present");
        }
        doctor.addTimeSlot(timeSlot);
    }

    public void bookTimeSlotForDoctor(String doctorId, String timeSlotId){
        Doctor doctor = userDao.getDoctorById(doctorId);
        if(doctor==null){
            throw new RuntimeException("Doctor is not present");
        }
        TimeSlot timeSlot = doctor.getTimeSlotBy(timeSlotId);
        if(timeSlot == null){
            throw new RuntimeException("TimeSlot is not present");
        }
        timeSlot.bookTimeSlot();
    }


    public void cancelTimeSlotForDoctor(String doctorId, String timeSlotId){
        Doctor doctor = userDao.getDoctorById(doctorId);
        if(doctor==null){
            throw new RuntimeException("Doctor is not present");
        }
        TimeSlot timeSlot = doctor.getTimeSlotBy(timeSlotId);
        if(timeSlot == null){
            throw new RuntimeException("TimeSlot is not present");
        }
        timeSlot.cancelTimeSlot();
    }






}
