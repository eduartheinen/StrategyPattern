package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Subject;
import control.ParkingController;

public class ListView extends JPanel implements Subject, Observer,
		ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2724666589846648871L;
	private ArrayList<model.Observer> observers;
	private static JList list;
	private static DefaultListModel listModel;

	public ListView() {
		super(new BorderLayout());
		observers = new ArrayList<model.Observer>();
		this.add(initList());

		// observer
		ParkingController.getInstance().addObserver(this);
	}

	private JScrollPane initList() {
		listModel = new DefaultListModel();
		loadListData();

		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);
		list.addListSelectionListener(this);

		return new JScrollPane(list);
	}

	private void loadListData() {
		listModel.clear();
		for (String plate : ParkingController.getInstance().getCars()) {
			listModel.addElement(plate);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		loadListData();
	}

	@Override
	public void registerObserver(model.Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(model.Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);

	}

	@Override
	public void notifyObservers(String arg) {
		for (int i = 0; i < observers.size(); i++) {
			model.Observer obsrv = observers.get(i);
			obsrv.update(arg);
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (list.getSelectedValue() != null)
			notifyObservers(list.getSelectedValue().toString());
	}
}
