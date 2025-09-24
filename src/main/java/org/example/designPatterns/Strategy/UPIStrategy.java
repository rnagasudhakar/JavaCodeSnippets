package org.example.designPatterns.Strategy;

public class UPIStrategy implements PaymentStrategy {

    private final String phoneNumber;

    public UPIStrategy(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay() throws Exception {
        if(phoneNumber.length() != 10){
            throw new Exception("phone Number cannot be less than 10");
        }
        System.out.print("Cash is paid successfully through UPI");
    }

}
