package com.company.behavioural.model;

public class AtmMachine {
	
	private AtmState atmState;
	
	public AtmMachine()
	{
		atmState = new NoCardInserted();
	}
	
	public void setTransaction(AtmState state)
	{
		this.atmState = state;
	}

	public void changeState()
	{
		atmState.handleRequest(this);
	}
}
