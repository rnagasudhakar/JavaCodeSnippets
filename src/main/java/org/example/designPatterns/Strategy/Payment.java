package org.example.designPatterns.Strategy;

public class Payment {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(){
        try{
            paymentStrategy.pay();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
