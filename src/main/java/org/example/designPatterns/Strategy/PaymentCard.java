package org.example.designPatterns.Strategy;


public class PaymentCard {

    String cardNumber;

    int cvvNumber;

    String cardHolderNumber;

    public PaymentCard(String cardNumber, int cvvNumber, String cardHolderNumber) {
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
        this.cardHolderNumber = cardHolderNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public String getCardHolderNumber() {
        return cardHolderNumber;
    }

    public void setCardHolderNumber(String cardHolderNumber) {
        this.cardHolderNumber = cardHolderNumber;
    }
}
