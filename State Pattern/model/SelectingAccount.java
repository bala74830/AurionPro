package com.company.behavioural.model;

public class SelectingAccount implements AtmState{

	@Override
	public void handleRequest(AtmMachine atmMachine) {
		System.out.println("Account type selected. Enter the amount you want to withdraw");
		
		atmMachine.setTransaction(new WithdrawMoney());
		
	}

}
