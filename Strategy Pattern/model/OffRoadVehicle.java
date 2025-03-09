package com.company.behavioural.strategy.model;

public class OffRoadVehicle extends Vehicle{

	public OffRoadVehicle() {
		super(new SprotsDriveStrategy());
	}

}
