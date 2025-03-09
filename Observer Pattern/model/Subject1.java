package behavioural.observer.traffic.model;

public interface Subject1 {
	
	void addVehicle(ObserverVehicle vehicle);
	
	void removeVehicle(ObserverVehicle vehicle);
	
	void notifyObserver();
}
