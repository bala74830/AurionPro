package com.company.behavioural.model;

public class CardInserted implements AtmState{

	@Override
	public void handleRequest(AtmMachine atmMachine) {
		System.out.println("Card inserted. Please enter your atm pin ");
		
		atmMachine.setTransaction(new EnteringPin());
	}

}
