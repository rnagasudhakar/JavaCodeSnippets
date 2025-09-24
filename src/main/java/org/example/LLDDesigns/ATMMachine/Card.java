package org.example.LLDDesigns.ATMMachine;

public class Card {
    private final int cardId;
    private final String cardNumber;
    private final String cardPin;

    public Card(int cardId, String cardNumber, String cardPin) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }

    public int getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

}
