package behavioural.observer.traffic.model;

import java.util.ArrayList;
import java.util.List;

public class TrafficSignal implements Subject1{

	private List<ObserverVehicle> vehicles;
	private String light;
	
	public TrafficSignal()
	{
		vehicles = new ArrayList<>();
	}
	
	@Override
	public void addVehicle(ObserverVehicle vehicle) {
		vehicles.add(vehicle);
	}

	@Override
	public void removeVehicle(ObserverVehicle vehicle) {
		vehicles.remove(vehicle);
	}

	@Override
	public void notifyObserver() {
		for(ObserverVehicle ov : vehicles)
		{
			ov.update(light);
		}
	}
	
	public void changeLight(String s) {
		this.light = s;
		System.out.println("\nTraffic Signal light changes to : "+ light);
		notifyObserver();
		
	}

}
