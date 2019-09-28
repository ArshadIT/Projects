package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JComboBox;

import client.Client;
import client.view.AddNewReservation;
import client.view.MainView;
import shared.model.Guest;
import shared.model.GuestList;

public class GuestController implements IGuestController {

	private Client client;
	private MainView mainView;
	private AddNewReservation newReservation;

	public GuestController(Client client, MainView mainView) {
		super();
		this.mainView = mainView;
		this.client = client;

		mainView.setGuestController(this);

	}

	@Override
	public GuestList getAllGuest() throws SQLException, RemoteException {

		return client.getAllGuest();
	}

	@Override
	public void addNewGuest(String nationality, String fname, String lname, String address, String phone, String passportnr, String email) throws RemoteException, SQLException {

		Guest guest = new Guest(nationality, fname, lname, address, phone, passportnr, email);
	

		
			client.addNewGuest(guest);
		
		

	}

	@Override
	public void displayGuestsToComboBox(JComboBox<String> comboBox) throws RemoteException, SQLException {

		GuestList list = getAllGuest();
		comboBox.insertItemAt("", 0);
		for (int i = 0; i < list.size(); i++) {
			
			comboBox.addItem(list.getGuest(i).getPasportNr().toString());
		}
	}


}
