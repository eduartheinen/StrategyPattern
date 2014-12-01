package main;

import model.Car;
import model.Parking;
import view.MainView;

public class Main {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainView.createAndShowGUI();
            }
        });

		Parking p = Parking.getInstance();
		p.add(new Car("abc123"));
		p.add(new Car("abc124"));
	}
}
