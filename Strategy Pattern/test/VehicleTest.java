package com.company.behavioural.strategy.test;

import com.company.behavioural.strategy.model.GoodVehicle;
import com.company.behavioural.strategy.model.OffRoadVehicle;
import com.company.behavioural.strategy.model.Sportsvehicle;

public class VehicleTest {

	public static void main(String[] args) {
		GoodVehicle good = new GoodVehicle();
		Sportsvehicle sport = new Sportsvehicle();
		OffRoadVehicle offRoad = new OffRoadVehicle();
		
		good.drive();
		sport.drive();
		offRoad.drive();
	}

}
