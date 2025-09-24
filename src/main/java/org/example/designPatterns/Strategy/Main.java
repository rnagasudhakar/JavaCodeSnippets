package org.example.designPatterns.Strategy;

public class Main {

    public static  void main(String[] args){
        PaymentCard paymentCard = new PaymentCard("1234",123,"sudha");
        Payment payment = new Payment();
        payment.setPaymentStrategy(new CardStrategy(paymentCard));
        payment.pay();

    }
}
