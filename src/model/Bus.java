package model;

import control.PropertiesHandler;

public class Bus extends Vehicle {
	public Bus(String p) {
		super(p);
		this.setPricebyHour(Integer.parseInt(PropertiesHandler
				.getProperty("price.bus.hour")));
		this.setPricebyDay(Integer.parseInt(PropertiesHandler
				.getProperty("price.bus.day")));
		this.setPricebyMonth(Integer.parseInt(PropertiesHandler
				.getProperty("price.bus.month")));
	}
}
