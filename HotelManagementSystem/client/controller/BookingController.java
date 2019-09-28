package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.view.AddNewReservation;
import client.view.MainView;
import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;

public class BookingController implements IBookingController {

	private Client client;
	private MainView mainView;
	private AddNewReservation newReservation;

	public BookingController(Client client, MainView mainView) {
		super();
		this.mainView = mainView;
		this.client = client;

		mainView.setBController(this);

	}

	@Override
	public ArrayList<CheckToday> getAllCheckInTodayList() throws RemoteException, SQLException {

		return client.getAllCheckInTodayList();

	}

	@Override
	public ArrayList<CheckToday> getAllCheckOutTodayList() throws RemoteException, SQLException {

		return client.getAllCheckOutTodayList();

	}

	@Override
	public void addNewBooking(String passportnr, int room, Date startDate, Date endDate) 
												throws RemoteException, SQLException {
		
		Booking booking = new  Booking(passportnr, room, startDate, endDate);
		client.addNewBooking(booking);

	}

	@Override
	public BookingList getAllBookings() throws RemoteException, SQLException {
		return client.getAllBookings();

	}

	@Override
	public boolean CheckIfStartDateBeforeEndDate(Date startDate, Date endDate) {
		if (startDate.before(endDate))
			return true;
		else
			return false;

	}

	@Override
	public void set(AddNewReservation addNewReservation) {
		this.newReservation = newReservation;

	}

}
