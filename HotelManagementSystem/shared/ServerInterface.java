package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;
import shared.model.Guest;
import shared.model.GuestList;
import shared.model.RoomList;

public interface ServerInterface extends Remote{
	
	
	
	public ArrayList<CheckToday> getAllCheckInTodayList() throws RemoteException, SQLException;
	
	public ArrayList<CheckToday> getAllCheckOutTodayList() throws RemoteException, SQLException;
	
	public GuestList getAllGuest() throws RemoteException, SQLException;
	
	public void addNewGuest(Guest guest)throws RemoteException, SQLException;
	
	public RoomList getAvailableRooms(Date startDate, Date endDate) throws SQLException, RemoteException;
	
	public void addNewBooking(Booking booking) throws SQLException, RemoteException;

	public BookingList getAllBookingsList()throws SQLException, RemoteException;
	
	
	
	

}
