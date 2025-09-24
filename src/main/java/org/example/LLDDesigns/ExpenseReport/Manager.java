package org.example.LLDDesigns.ExpenseReport;

public class Manager extends Approver{

    private final int amountThreshold = 1000;


    Manager(Approver nextApprover){
        this.setNext(nextApprover);
    }

    @Override
    void handleExpense(int amount) {
        if(amount <= amountThreshold){
            System.out.println("Amount has been approved by manger");
            return ;
        }
        this.nextApprover.handleExpense(amount);
    }
}
