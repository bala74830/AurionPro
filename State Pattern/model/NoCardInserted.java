package com.company.behavioural.model;

public class NoCardInserted implements AtmState{

	@Override
	public void handleRequest(AtmMachine atmMachine) {
		System.out.println("No card is insert. Please Insert your Atm Card");
		
		atmMachine.setTransaction(new CardInserted());
		
	}

}
