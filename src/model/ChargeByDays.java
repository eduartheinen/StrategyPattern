package model;


public class ChargeByDays implements ChargeMethod {

	@Override
	public float calc(long duration, Vehicle v) {
		return v.getPricebyDay() * (duration / 86400);
	}
}
