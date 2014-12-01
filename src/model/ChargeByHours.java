package model;

public class ChargeByHours implements ChargeMethod {

	@Override
	public float calc(long duration, Vehicle v) {
		return v.getPricebyHour() * (duration / 3600); // 3600s = 1h
	}

}
