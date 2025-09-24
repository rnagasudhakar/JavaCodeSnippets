package org.example.LLDDesigns.VendingMachine.Models;

import java.util.List;

public interface VendingMachineState {

    void vendingMachineIdle();

    void userSelectingProducts(List<Product> products);


    void userMakingPayment();

    void userCancelingPayment();

    void userCollectingProducts();

}
