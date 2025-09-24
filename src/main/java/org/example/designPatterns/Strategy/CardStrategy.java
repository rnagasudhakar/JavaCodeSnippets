package org.example.designPatterns.Strategy;

public class CardStrategy implements PaymentStrategy{

    private final PaymentCard paymentCard;

    public CardStrategy(PaymentCard paymentCard){
        this.paymentCard = paymentCard;
    }


    @Override
    public void pay() throws  Exception {
        if(this.paymentCard.cardNumber == null){
            throw new Exception("Card Number  cannot be Empty");
        }
        System.out.print("Card is paid successfully");
    }

}
