package org.example.LLDDesigns.ATMMachine;

import java.util.Map;

public class AtmInventory {
    Map<AmountType, Integer> atmInventory;

    public AtmInventory(Map<AmountType, Integer> atmInventory) {
        this.atmInventory = atmInventory;
    }

    public void addMoney(AmountType amountType, Integer amountCount){
        if(this.atmInventory.containsKey(amountType)){
            this.atmInventory.put(amountType, this.atmInventory.get(amountType) + amountCount);
            return ;
        }
        this.atmInventory.putIfAbsent(amountType,amountCount);
    }


    public void totalCash(){
        double totalAmount = 0;
//        for()
    }

}
