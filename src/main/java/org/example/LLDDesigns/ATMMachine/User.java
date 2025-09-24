package org.example.LLDDesigns.ATMMachine;

public class User {
    int userId;
    BankAccount bankAccount;
    Card card;

    public User(int userId, BankAccount bankAccount, Card card) {
        this.userId = userId;
        this.bankAccount = bankAccount;
        this.card = card;
    }




}
