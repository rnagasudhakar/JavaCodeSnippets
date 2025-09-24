package org.example.LLDDesigns.ATMMachine;

public abstract  class AtmState {

    abstract void IdleState(AutomatedTellerMachine automatedTellerMachine);

    abstract void hasCardState(AutomatedTellerMachine automatedTellerMachine, Card card, String pin);

    void selectOperation(AutomatedTellerMachine automatedTellerMachine, OperationType operationType){
        if(automatedTellerMachine.card != null){
            System.out.println("Please enter your card");
            return ;
        }
        System.out.println("Please enter your pin");
    }

    void cancelState(AutomatedTellerMachine automatedTellerMachine){
        System.out.println("Cancelling all transaction");
        automatedTellerMachine.card = null;
        automatedTellerMachine.setNextState(new IdleState());
    }

}
