package server.mediator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;
import shared.model.Room;
import shared.model.RoomList;

public interface IBookingHandler {
	
	public ArrayList<CheckToday> getAllCheckInTodayList() throws SQLException;
	public ArrayList<CheckToday> getAllCheckOutTodayList() throws SQLException;
	public BookingList getAllBookings() throws SQLException;
	
	void addNewBooking(Booking booking1) throws SQLException;


}
