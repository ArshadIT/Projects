package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import client.Client;
import client.view.AddNewReservation;
import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;

public interface IBookingController {

	public ArrayList<CheckToday> getAllCheckInTodayList() throws RemoteException, SQLException;

	public ArrayList<CheckToday> getAllCheckOutTodayList() throws RemoteException, SQLException;

	public boolean CheckIfStartDateBeforeEndDate(Date startDate, Date endDate);

	public BookingList getAllBookings() throws RemoteException, SQLException;

	public void set(AddNewReservation addNewReservation);

	public void addNewBooking(String passportnr, int room, Date startDate, Date endDate) throws RemoteException, SQLException;

}
