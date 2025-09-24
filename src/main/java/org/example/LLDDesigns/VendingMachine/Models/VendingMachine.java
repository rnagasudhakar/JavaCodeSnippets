package org.example.LLDDesigns.VendingMachine.Models;

import java.util.*;

public class VendingMachine {

    private static volatile VendingMachine vendingMachine;
    List<ProductShelf> vendingMachineInventory;
    VendingMachineState vendingMachineState;



    private VendingMachine(){
        this.vendingMachineInventory = new ArrayList<>();
        this.initializeInventory();
        this.vendingMachineState = new IdleState(this);
    }


    private void initializeInventory() {

        Product cola = new Product(1, "Cola", 100, 10);
        Product pepsi = new Product(2, "Pepsi", 90, 8);
        Product water = new Product(3, "Water", 50, 15);
        Product energyDrink = new Product(4, "Energy Drink", 120, 5);


        ProductShelf shelf1 = new ProductShelf(1, cola);
        ProductShelf shelf2 = new ProductShelf(2, pepsi);
        ProductShelf shelf3 = new ProductShelf(3, water);
        ProductShelf shelf4 = new ProductShelf(4, energyDrink);


        vendingMachineInventory.add(shelf1);
        vendingMachineInventory.add(shelf2);
        vendingMachineInventory.add(shelf3);
        vendingMachineInventory.add(shelf4);
    }

    private static VendingMachine vendingMachineInstance(){
        if(vendingMachine == null){
            synchronized (vendingMachine){
                if(vendingMachine == null){
                    vendingMachine = new VendingMachine();
                }
            }
        }
        return vendingMachine;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }




}
