package control;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import model.Parking;
import model.Vehicle;

public class ParkingController extends Observable implements Observer {

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
			setChanged();
			notifyObservers();
			
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public void setSelectedItem(String vehiclePlate) {
		selectedVehiclePlate = vehiclePlate;
	}

	public double finishSelectedParking(String plate) {
		double value = Parking.getInstance().finishParking(plate);
		setChanged();
		notifyObservers();
		
		return value;
	}

}
