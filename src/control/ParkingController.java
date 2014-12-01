package control;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import model.Parking;
import model.Subject;
import model.Vehicle;

public class ParkingController implements Subject {

	private ArrayList<model.Observer> observers = new ArrayList<model.Observer>();
	private static ParkingController instance = new ParkingController();
	private String selectedVehiclePlate;

	public static ParkingController getInstance() {
		return instance;
	}

	private ParkingController() {
	}

	public Set<String> getCars() {
		return Parking.getInstance().getPlatesList();
	}

	public void addVehicle(String vehiclePlate, Class vehicleType) {
		try {
			Vehicle vehicle = (Vehicle) vehicleType.getDeclaredConstructor(
					String.class).newInstance(vehiclePlate);

			Parking.getInstance().add(vehicle);
			notifyObservers(vehicle.getPlate());

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void setSelectedItem(String vehiclePlate) {
//		selectedVehiclePlate = vehiclePlate;
//	}

	public double finishSelectedParking(String plate) {
		double value = Parking.getInstance().finishParking(plate);
		notifyObservers(plate);

		return value;
	}

	@Override
	public void registerObserver(model.Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(model.Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);

	}

	@Override
	public void notifyObservers(String arg) {
		for (int i = 0; i < observers.size(); i++) {
			model.Observer obsrv = observers.get(i);
			obsrv.update(arg);
		}

	}

}
