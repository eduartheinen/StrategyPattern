package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.xml.transform.OutputKeys;

import model.Car;
import model.Observer;
import model.Subject;
import control.ParkingController;

public class MenuView extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4170601937523669733L;
	private static final String startParkingString = "Iniciar";
	private static final String finishParkingString = "Encerrar";
	private StartParkingListener startParkingListener = new StartParkingListener();
	private FinishParkingListener finishParkingListener = new FinishParkingListener();
	private JTextField vehiclePlateField;
	private JComboBox vehicleTypeComboBox;
	private String selectedPlate;
	private Subject subject;

	public MenuView(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);

		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		this.add(finishParkingButton());
		this.add(Box.createHorizontalStrut(5));

		this.add(new JSeparator(SwingConstants.VERTICAL));
		this.add(Box.createHorizontalStrut(5));

		this.add(vehiclePlateField());
		this.add(Box.createHorizontalStrut(5));

		this.add(vehicleTypeComboBox());
		this.add(Box.createHorizontalStrut(5));

		this.add(startParkingButton());
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	private JComboBox vehicleTypeComboBox() {		
		Vector model = new Vector();
		model.addElement(new ComboBoxItem("Carro", Car.class));

		vehicleTypeComboBox = new JComboBox(model);
		vehicleTypeComboBox.setRenderer(new ItemRenderer());


		return vehicleTypeComboBox;
	}

	private JTextField vehiclePlateField() {
		vehiclePlateField = new JTextField(10);
		vehiclePlateField.addActionListener(startParkingListener);
		vehiclePlateField.getDocument().addDocumentListener(
				startParkingListener);

		return vehiclePlateField;
	}

	private JButton finishParkingButton() {
		JButton finishParkingButton = new JButton(finishParkingString);
		finishParkingButton.setActionCommand(finishParkingString);
		finishParkingButton.addActionListener(finishParkingListener);

		return finishParkingButton;
	}

	private JButton startParkingButton() {
		JButton startParkingButton = new JButton(startParkingString);
		startParkingButton.setActionCommand(startParkingString);
		startParkingButton.addActionListener(startParkingListener);

		return startParkingButton;
	}

	// This listener is shared by the text field and the hire button.
	class StartParkingListener implements ActionListener, DocumentListener {
		public void actionPerformed(ActionEvent e) {
			String vehiclePlate = vehiclePlateField.getText();
			Class vehicleType = ((ComboBoxItem) vehicleTypeComboBox.getSelectedItem()).getVehicle();

			ParkingController.getInstance().addVehicle(vehiclePlate, vehicleType);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
	}

	class FinishParkingListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = ParkingController.getInstance()
					.finishSelectedParking(selectedPlate);
			
			JOptionPane.showMessageDialog(null, "Encerrar estacionamento: " + value);
		}
	}

	class ComboBoxItem {
		public String description;
		public Class vehicle;

		public ComboBoxItem(String description, Class vehicle) {
			this.description = description;
			this.vehicle = vehicle;
		}

		public String getDescription() {
			return description;
		}

		public Class getVehicle() {
			return vehicle;
		}
	}

	class ItemRenderer extends BasicComboBoxRenderer {
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			super.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);

			if (value != null) {
				ComboBoxItem item = (ComboBoxItem) value;
				setText(item.getDescription());
			}

			if (index == -1) {
				ComboBoxItem item = (ComboBoxItem) value;
				setText("" + item.getDescription());
			}

			return this;
		}
	}

	@Override
	public void update(String arg) {
		selectedPlate = arg;
	}
}