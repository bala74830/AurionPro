package com.company.behavioural.strategy.model;

public class GoodVehicle extends Vehicle{

	public GoodVehicle() {
		super(new NormalDrive());
	}

}
