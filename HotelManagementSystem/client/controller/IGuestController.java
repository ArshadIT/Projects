package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JComboBox;

import shared.model.Guest;
import shared.model.GuestList;

public interface IGuestController {

	public GuestList getAllGuest() throws SQLException, RemoteException;

	

	void displayGuestsToComboBox(JComboBox<String> comboBox) throws RemoteException, SQLException;

	void addNewGuest(String nationality, String fname, String lname, String address, String phone, String passportnr,
			String email) throws RemoteException, SQLException;;

}
