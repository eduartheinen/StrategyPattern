package model;

import java.util.HashMap;
import java.util.Set;

public class Parking {
	private HashMap<String, Bill> parkedCars = new HashMap<String, Bill>();
	private static Parking instance = new Parking();

	private Parking() {
	}

	public void add(Vehicle v) {
		parkedCars.put(v.getPlate(), new Bill(v));
	}

	public float finishParking(String plate) {
		Bill b = parkedCars.get(plate);
		parkedCars.remove(plate);
		return b.checkout();
	}

	public Set<String> getPlatesList() {
		return parkedCars.keySet();
	}

	public static Parking getInstance() {
		return instance;
	}
}
