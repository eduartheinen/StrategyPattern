package model;

import control.PropertiesHandler;

public class Car extends Vehicle {
	public Car(String p) {
		super(p);
		this.setPricebyHour(Integer.parseInt(PropertiesHandler
				.getProperty("price.car.hour")));
		this.setPricebyDay(Integer.parseInt(PropertiesHandler
				.getProperty("price.car.day")));
		this.setPricebyMonth(Integer.parseInt(PropertiesHandler
				.getProperty("price.car.month")));
	}
}
