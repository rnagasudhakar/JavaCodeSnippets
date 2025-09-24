package org.example.LLDDesigns.VendingMachine.Models;

import java.util.List;

public class UserSelectingProductState implements VendingMachineState{



    @Override
    public void vendingMachineIdle() {
        System.out.println("User is in selecting state");
    }

    @Override
    public void userSelectingProducts(List<Product> products) {
        products.forEach((product)->{
            if(!product.isProductAvailable()){
                System.out.println("This product" + product.getProductTitle() +" is not available");
            }
            else{
                product.upDateProductStockCount(1,Operation.DELETE);
            }
        });

        System.out.println("Selecting is completed choose to do payment");
    }


    @Override
    public void userMakingPayment() {

    }

    @Override
    public void userCancelingPayment() {

    }

    @Override
    public void userCollectingProducts() {

    }
}
