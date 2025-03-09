package behavioural.observer.traffic.test;

import behavioural.observer.traffic.model.TrafficSignal;
import behavioural.observer.traffic.model.VehicleBike;
import behavioural.observer.traffic.model.VehicleBus;
import behavioural.observer.traffic.model.VehicleCar;

public class TrafficSignalTest {

	public static void main(String[] args) {
		VehicleCar car = new VehicleCar();
		VehicleBike bike = new VehicleBike();
		VehicleBus bus = new VehicleBus();
		
		TrafficSignal signal = new TrafficSignal();
		
		signal.addVehicle(car);
		signal.addVehicle(bike);
		signal.addVehicle(bus);
		
		signal.changeLight("Red");
		signal.changeLight("Green");
	}

}