package server.mediator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;

public class BookingHandler implements IBookingHandler {

	private Connection c = null;
	private Statement stmt = null;
	private PreparedStatement stm;

	public BookingHandler() {

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

		}

	}

	@Override
	public ArrayList<CheckToday> getAllCheckInTodayList() throws SQLException {

		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<CheckToday> temp = new ArrayList<>();
		ResultSet rs = stmt.executeQuery("SELECT * FROM \"Hotel\".CheckIn_today;");
		while (rs.next()) {

			int bookingId = rs.getInt("Booking ID");
			int roomNo = rs.getInt("Room");
			String guestName = rs.getString("Guest Name");
			int daysStaying = rs.getInt("Days Staying");
			Date leaving = rs.getDate("Leaving");
			float payment = rs.getFloat("Payment");

			temp.add(new CheckToday(bookingId, roomNo, guestName, daysStaying, leaving, payment));

		}
		rs.close();
		// c.close();
		System.out.println("Database query ok ");

		return temp;

	}

	@Override
	public ArrayList<CheckToday> getAllCheckOutTodayList() throws SQLException {

		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<CheckToday> temp = new ArrayList<>();
		ResultSet rs = stmt.executeQuery("SELECT * FROM \"Hotel\".checkOut_today;");
		while (rs.next()) {

			int bookingId = rs.getInt("Booking ID");
			int roomNo = rs.getInt("Room");
			String guestName = rs.getString("Guest Name");
			float payment = rs.getFloat("Payment");

			temp.add(new CheckToday(bookingId, roomNo, guestName, payment));

		}
		rs.close();
		// c.close();
		System.out.println("Database query ok ");

		return temp;

	}

	@Override
	public BookingList getAllBookings() throws SQLException {

		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookingList temp1 = new BookingList();

		ResultSet rs = stmt.executeQuery("select * from  \"Hotel\".booking where startdate>=now() ;");

		while (rs.next()) {

			int bookingId = rs.getInt("bookingId");
			String guestPasportNo = rs.getString("guest");
			Date startDate = rs.getDate("startDate");
			Date endDate = rs.getDate("endDate");
			int roomNo = rs.getInt("roomNo");

			Booking booking = new Booking(bookingId, guestPasportNo, startDate, endDate, roomNo);

			temp1.addBooking(booking);

		}
		rs.close();
		// c.close();
		System.out.println("Database query ok ");

		return temp1;

	}

	@Override
	public void addNewBooking(Booking booking1) {
		try {

			java.sql.Date sqlStartDate = new java.sql.Date(booking1.getStartDate().getTime());// java Date convert to
																								// sql Date

			java.sql.Date sqlEndDate = new java.sql.Date(booking1.getEndDate().getTime()); // java Date convert to sql
																							// Date

			// ResultSet generatedKeys = stm.getGeneratedKeys();

			if (c == null)
				System.out.println("777777777777");
			stm = c.prepareStatement(
					"INSERT INTO \"Hotel\".booking( guest, startdate,enddate, roomno ) " + "VALUES (?, ?, ?, ?);");

			// booking1.setId(generatedKeys.getInt(1));
			System.out.println("1");

			stm.setString(1, booking1.getPassport());
			stm.setDate(2, sqlStartDate);
			System.out.println("2");
			stm.setDate(3, sqlEndDate);
			System.out.println("3");
			stm.setInt(4, booking1.getRoom());
			System.out.println("4");
			if (stm == null)
				System.out.println("!!!!!!!!!!S");
			int r = stm.executeUpdate();
			System.out.println(r);
			stm.close();
			c.commit();
			// c.close();
		} catch (Exception e) {

			System.err.println("kjbjhg" + e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Database query ok ");

	}

}
