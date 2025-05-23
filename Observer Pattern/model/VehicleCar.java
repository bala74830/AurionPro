package behavioural.observer.traffic.model;

public class VehicleCar implements ObserverVehicle {

	private String light;
	
	@Override
	public void update(String lightColour) {
		this.light = lightColour;
		System.out.println("Car : Traffic light updated to : " + light);
	}

}
