package com.company.behavioural.model;

public class WithdrawMoney implements AtmState{

	@Override
	public void handleRequest(AtmMachine atmMachine) {
		System.out.println("Amount wihdraw successfully. please remove you card");
		
		atmMachine.setTransaction(new NoCardInserted());
	}

}
