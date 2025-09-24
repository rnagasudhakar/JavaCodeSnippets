package org.example.LLDDesigns.VendingMachine.Models;

import java.util.List;

public class IdleState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
    }


    @Override
    public void vendingMachineIdle() {
        System.out.println("Welcome to vending machine, please select products");
    }

    @Override
    public void userSelectingProducts(List<Product> products) {
        this.vendingMachine.setVendingMachineState(new UserSelectingProductState());
    }




    @Override
    public void userMakingPayment() {
        System.out.println("Select the products");
    }

    @Override
    public void userCancelingPayment() {
        System.out.println("Invalid transaction");

    }

    @Override
    public void userCollectingProducts() {
        System.out.println("Payment should happen");
    }
}
