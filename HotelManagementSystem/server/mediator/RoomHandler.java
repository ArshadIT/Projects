package server.mediator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import shared.model.Room;
import shared.model.RoomList;

public class RoomHandler implements IRoomHandler {

	Connection c = null;
	Statement stmt = null;

	public RoomHandler() {

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
	public RoomList getAllRooms() throws SQLException {
		RoomList temp = new RoomList();

		try {
			stmt = c.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = stmt.executeQuery("select * from  \"Hotel\".room ;");

		while (rs.next()) {

			int roomNo = rs.getInt("roomNo");
			String roomtype = rs.getString("roomtype");
			boolean isclean = rs.getBoolean("isclean");

			temp.addRoom(new Room(roomNo, roomtype, isclean));

		}
		rs.close();

		System.out.println("Database query ok ");

		return temp;

	}

	@Override
	public RoomList getAvailableRooms(Date startDate, Date endDate) throws SQLException {
		System.out.println(startDate);
		System.out.println(endDate);
		RoomList temp = new RoomList();

		try {
			stmt = c.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = stmt.executeQuery("select * from \"Hotel\".room " + " where roomNo not in "
				+ "(select roomno from \"Hotel\".booking where ' " + startDate + "' between startdate and enddate "
				+ "or ' " + endDate + "' between startdate and enddate " + " or startDate between ' " + startDate
				+ " ' and ' " + endDate + "'" + " or enddate between '" + startDate + "' and ' " + endDate + "' );");

		while (rs.next()) {

			int roomNo = rs.getInt("roomNo");
			String roomtype = rs.getString("roomtype");
			boolean isclean = rs.getBoolean("isclean");

			temp.addRoom(new Room(roomNo, roomtype, isclean));

		}
		rs.close();
		// c.close();
		System.out.println("Database query ok ");

		return temp;

	}

}
