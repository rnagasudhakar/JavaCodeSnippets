package org.example.LLDDesigns.ExpenseReport;

public class Application {


    public static void main(String[] args) {

        Approver vicePresident = new VicePresident();

        Approver director = new Director(vicePresident);

        Approver manager = new Manager(director);

        manager.handleExpense(12345432);
    }






}
