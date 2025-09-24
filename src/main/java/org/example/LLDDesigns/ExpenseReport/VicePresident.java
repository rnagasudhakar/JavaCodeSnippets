package org.example.LLDDesigns.ExpenseReport;

public class VicePresident extends Approver {

    private final int amountThreshold = 100000;




    @Override
    void handleExpense(int amount) {
        if(amount <= amountThreshold) {
            System.out.println("Amount has been approved by Vice President");
            return;
        }
        System.out.println("Budget is not present");
    }
}
