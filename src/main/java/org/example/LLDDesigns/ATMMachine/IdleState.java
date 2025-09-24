package org.example.LLDDesigns.ATMMachine;

public class IdleState extends AtmState{

    @Override
    void IdleState(AutomatedTellerMachine automatedTellerMachine) {
        System.out.println("Welcome to ATM, Please enter your card");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        automatedTellerMachine.setNextState(new HasCardState());
    }

    @Override
    void hasCardState(AutomatedTellerMachine automatedTellerMachine, Card card, String pin) {

    }

}
