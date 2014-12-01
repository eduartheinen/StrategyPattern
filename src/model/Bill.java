package model;

import control.TimeManager;

public class Bill {
	private long beginTime;
	private long endTime;
	private long duration;
	private Vehicle vehicle;

	public Bill(Vehicle v) {
		beginTime = System.currentTimeMillis();
		vehicle = v;
	}

	public float checkout() {
		endTime = System.currentTimeMillis();
		duration = endTime - beginTime;
		ChargeMethod b = TimeManager.setBillingMethod(duration);
		return b.calc(duration, vehicle);
	}
}
