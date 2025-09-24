package org.example.LLDDesigns.ATMMachine;

public class AutomatedTellerMachine {

    int automatedTellerMachineId;
    String location;
    AtmInventory atmInventory;
    AtmState atmState;
    Card card;

    public AutomatedTellerMachine(int automatedTellerMachineId, String location, AtmInventory atmInventory) {
        this.automatedTellerMachineId = automatedTellerMachineId;
        this.location = location;
        this.atmInventory = atmInventory;
        this.atmState = new IdleState();
        this.card = card;
    }

    void setNextState(AtmState atmState){
        this.atmState = atmState;
    }

}
