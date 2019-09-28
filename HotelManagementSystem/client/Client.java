package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import client.controller.IBookingController;
import client.controller.IGuestController;
import client.controller.IRoomController;

import shared.ServerInterface;
import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;
import shared.model.Guest;
import shared.model.GuestList;
import shared.model.RoomList;

public class Client implements Remote{

	private ServerInterface si;

	public Client() throws MalformedURLException, RemoteException, NotBoundException {

		UnicastRemoteObject.exportObject(this, 0);

		si = (ServerInterface) Naming.lookup("rmi://localhost:1099/hotel");

	}

	public ArrayList<CheckToday> getAllCheckInTodayList() throws RemoteException, SQLException {

		CheckToday ch = new CheckToday();
		ch.setList(si.getAllCheckInTodayList());
		return ch.getList();

	}


	public ArrayList<CheckToday> getAllCheckOutTodayList() throws RemoteException, SQLException {

		CheckToday ch = new CheckToday();
		ch.setList(si.getAllCheckOutTodayList());
		return ch.getList();

	}


	public RoomList getAvailableRooms(Date startDate, Date endDate) throws RemoteException, SQLException {

		RoomList list = si.getAvailableRooms(startDate, endDate);

		return list;

	}


	public GuestList getAllGuest() throws RemoteException, SQLException {
		GuestList list = si.getAllGuest();
		return list;
	}

	public void addNewGuest(Guest guest) throws RemoteException, SQLException {

		si.addNewGuest(guest);
	

	}


	public void addNewBooking(Booking booking) throws RemoteException, SQLException {
		si.addNewBooking(booking);
	

	}


	public BookingList getAllBookings() throws RemoteException, SQLException {
		BookingList list = si.getAllBookingsList();
		return list;
	}

}
