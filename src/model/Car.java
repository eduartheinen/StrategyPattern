package model;

import control.PropertiesHandler;


public class Car extends Vehicle {
	public Car(String p) {
		super(p);
		this.setPricebyHour(Integer.parseInt(PropertiesHandler
				.getProperty("price.car.hour")));
	}
}
