package com.company.behavioural.strategy.model;

public class Sportsvehicle extends Vehicle{

	public Sportsvehicle() {
		super(new SprotsDriveStrategy());
	}

}
