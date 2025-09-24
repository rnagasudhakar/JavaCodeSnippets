package org.example.LLDDesigns.ExpenseReport;

public class Director extends Approver {

    private final int amountThreshold = 10000;


    Director(Approver nextApprover){
        this.setNext(nextApprover);
    }

    @Override
    void handleExpense(int amount) {
        if(amount <= amountThreshold){
            System.out.println("Amount has been approved by director");
            return ;
        }
        this.nextApprover.handleExpense(amount);
    }
}
