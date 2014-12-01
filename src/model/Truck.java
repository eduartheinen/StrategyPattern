package model;

import control.PropertiesHandler;

public class Truck extends Vehicle {
	public Truck(String p) {
		super(p);
		this.setPricebyHour(Integer.parseInt(PropertiesHandler
				.getProperty("price.truck.hour")));
		this.setPricebyDay(Integer.parseInt(PropertiesHandler
				.getProperty("price.truck.day")));
		this.setPricebyMonth(Integer.parseInt(PropertiesHandler
				.getProperty("price.truck.month")));
	}
}
