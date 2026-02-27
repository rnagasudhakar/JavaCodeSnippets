package org.example.LLDDesigns.DoctorAppointmentSystem.dao;

import org.example.LLDDesigns.DoctorAppointmentSystem.models.Customer;
import org.example.LLDDesigns.DoctorAppointmentSystem.models.Doctor;

import java.util.HashMap;

public class UserDao {

    private final HashMap<String, Customer> customerHashMap;
    private final HashMap<String, Doctor> doctorHashMap;


    public UserDao() {
        this.customerHashMap = new HashMap<>();
        this.doctorHashMap = new HashMap<>();
    }

    public void addDoctor(String doctorId, Doctor doctor){
        this.doctorHashMap.computeIfAbsent(doctorId,K->doctor);
        System.out.println(this.doctorHashMap.get(doctorId).getUserId());
    }

    public void addCustomer(String customerId, Customer customer){
        this.customerHashMap.computeIfAbsent(customerId,K->customer);
    }

    public Doctor getDoctorById(String doctorId){
        if(doctorHashMap.containsKey(doctorId)){
            return doctorHashMap.get(doctorId);
        }
        return null;
    }

    public Customer getCustomerById(String customerId){
        if(customerHashMap.containsKey(customerId)){
            return customerHashMap.get(customerId);
        }
        return null;
    }



}
