package control;

import model.ChargeByDays;
import model.ChargeByHours;
import model.ChargeMethod;

public class TimeManager {

	public static ChargeMethod setBillingMethod(long duration) {
		if(duration < 43200000){ //se menor que 12h
			return new ChargeByHours();
		}
		return new ChargeByDays();
	}
}
