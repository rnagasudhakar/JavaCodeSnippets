package org.example.LLDDesigns.ATMMachine;

public class BankAccount {
    int bankAccountId;
    double bankBalance;

    public BankAccount(int bankAccountId, double bankBalance) {
        this.bankAccountId = bankAccountId;
        this.bankBalance = bankBalance;
    }

    public double getBankBalanceEnquiry(){
        return this.bankBalance;
    }

    public void deductMoney(double amount){
        if(this.bankBalance < amount){
            System.out.println("bankBalance is very low");
            return ;
        }
        this.bankBalance -=amount;
        System.out.println("Deducting money from bank Account");
    }

}
