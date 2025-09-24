package org.example.LLDDesigns.ATMMachine;

public class SelectOperation extends  AtmState{
    @Override
    void IdleState(AutomatedTellerMachine automatedTellerMachine) {

    }

    @Override
    void hasCardState(AutomatedTellerMachine automatedTellerMachine, Card card, String pin) {

    }

    void selectOperation(AutomatedTellerMachine automatedTellerMachine, OperationType operationType){
        if(automatedTellerMachine.card == null){
            System.out.println("Please enter your card");
            automatedTellerMachine.setNextState(new IdleState());
            return ;
        }
        User user = UsersRepository.getInstance().getUserByCard(automatedTellerMachine.card);

//        switch (operationType){
//            case OperationType.BALANCE_ENQUIRY:
//                System.out.println("Checking Balance Enquiry");
//                System.out.println("Your balance is" + user.bankAccount.getBankBalanceEnquiry());
//                break;
//            case OperationType.WITHDRAW_BALANCE:
//                // keeping amount for now
//                double amount = 300;
//                if(automatedTellerMachine.atmInventory.)
//        }
    }

}
