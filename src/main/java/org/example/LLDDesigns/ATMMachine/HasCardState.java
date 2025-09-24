package org.example.LLDDesigns.ATMMachine;

public  class HasCardState extends  AtmState{

    @Override
    void IdleState(AutomatedTellerMachine automatedTellerMachine) {
        System.out.println("Card is already present");
    }

    @Override
    void hasCardState(AutomatedTellerMachine automatedTellerMachine, Card card, String pin) {
        System.out.println("Authenticating the card");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(card.getCardPin().equals(pin)){
            System.out.println("Validation Completed");
            automatedTellerMachine.setNextState(new SelectOperation());
            System.out.println("Please Select a Operation");
            return;
        }
        System.out.println("Please enter pin correctly");
    }


}
