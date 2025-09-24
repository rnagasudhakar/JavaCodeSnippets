package org.example.LLDDesigns.ExpenseReport;

public abstract class Approver {

    Approver nextApprover;

    abstract void handleExpense(int amount);

    void setNext(Approver nextApprover){
        this.nextApprover = nextApprover;
    }

}
