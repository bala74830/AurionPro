package com.company.behavioural.model;

public class EnteringPin implements AtmState{

	@Override
	public void handleRequest(AtmMachine atmMachine) {
		System.out.println("pin entered. Now select your account type.");
		
		atmMachine.setTransaction(new SelectingAccount());
	}

}
