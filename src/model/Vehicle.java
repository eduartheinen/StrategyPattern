package model;

public abstract class Vehicle {
	private String plate;
	private float pricebyHour;
	private float pricebyDay;
	private float pricebyMonth;

	public Vehicle(String p) {
		plate = p;
	}

	public String getPlate() {
		return plate;
	}
	
	public float getPricebyHour(){
		return pricebyHour;
	}

	public float getPricebyDay() {
		return pricebyDay;
	}

	public float getPricebyMonth() {
		return pricebyMonth;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setPricebyHour(float pricebyHour) {
		this.pricebyHour = pricebyHour;
	}

	public void setPricebyDay(float pricebyDay) {
		this.pricebyDay = pricebyDay;
	}

	public void setPricebyMonth(float pricebyMonth) {
		this.pricebyMonth = pricebyMonth;
	}
}
