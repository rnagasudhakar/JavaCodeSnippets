package org.example.designPatterns.Strategy;

public class CashOnDelivery implements  PaymentStrategy{

    private final int cash;
    public CashOnDelivery(int cash){
        this.cash = cash;
    }

    @Override
    public void pay() throws Exception {
        if(this.cash ==0){
            throw new Exception("Cash cannot be Empty");
        }
        System.out.print("Cash is paid successfully");
    }


}
