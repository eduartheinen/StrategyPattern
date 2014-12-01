package model;

public class ChargeByMonth implements ChargeMethod {

	@Override
	public float calc(long duration, Vehicle v) {
		return v.getPricebyMonth() * (duration / 2592000); //2592000s = 1mês
	}

}
