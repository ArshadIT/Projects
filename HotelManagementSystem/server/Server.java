package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import server.mediator.BookingHandler;
import server.mediator.GuestHandler;
import server.mediator.IBookingHandler;
import server.mediator.IGuestHandler;
import server.mediator.IRoomHandler;
import server.mediator.RoomHandler;

import shared.ServerInterface;
import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;
import shared.model.Guest;
import shared.model.GuestList;
import shared.model.RoomList;

public class Server implements ServerInterface {


	private IBookingHandler bookingH;
	private IRoomHandler roomH;
	private IGuestHandler guestH;

	public Server(IBookingHandler bookingH, IRoomHandler roomH, IGuestHandler guestH) throws RemoteException {

		UnicastRemoteObject.exportObject(this, 0);

		this.bookingH = bookingH;
		this.roomH = roomH;
		this.guestH = guestH;
	}

	@Override
	public ArrayList<CheckToday> getAllCheckInTodayList() throws RemoteException, SQLException {

		return bookingH.getAllCheckInTodayList();

	}

	@Override
	public ArrayList<CheckToday> getAllCheckOutTodayList() throws RemoteException, SQLException {

		return bookingH.getAllCheckOutTodayList();
	}

	@Override
	public RoomList getAvailableRooms(Date startdate, Date endDate) throws SQLException, RemoteException {

		if (startdate != null && endDate != null) {

			RoomList list = roomH.getAvailableRooms(startdate, endDate);
			return list;

		} else
			System.out.println("Select Date");
		return null;

	}

	@Override
	public GuestList getAllGuest() throws RemoteException, SQLException {
		
		return guestH.getAllGuests();

	}

	@Override
	public void addNewGuest(Guest guest) throws RemoteException, SQLException {
		Guest guest1 = guest;
		guestH.addNewGuest(guest1);

	}

	@Override
	public void addNewBooking(Booking booking) throws SQLException, RemoteException {
		Booking booking1 = booking;
		bookingH.addNewBooking(booking1);

	

	}

	@Override
	public BookingList getAllBookingsList() throws SQLException, RemoteException {

		return bookingH.getAllBookings();
	}

}
