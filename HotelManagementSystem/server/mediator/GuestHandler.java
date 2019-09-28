package server.mediator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import shared.model.Guest;
import shared.model.GuestList;

public class GuestHandler implements IGuestHandler {

	private Connection c = null;
	private Statement stmt = null;
	private PreparedStatement stm;

	public GuestHandler() {

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
	public GuestList getAllGuests() throws SQLException {
		GuestList temp = new GuestList();

		try {
			stmt = c.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = stmt.executeQuery("select * from  \"Hotel\".guest ;");

		while (rs.next()) {

			String passportNo = rs.getString("passportno");

			temp.addGuest(new Guest(passportNo));

		}
		rs.close();

		System.out.println("Database query ok ");

		return temp;

	}

	@Override
	public void addNewGuest(Guest guest) throws SQLException

	{

		try {

			stm = c.prepareStatement(
					"INSERT INTO \"Hotel\".guest(fName, lName,address, phone, passportNo, nationality, email ) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?);");

			stm.setString(1, guest.getfName());
			stm.setString(2, guest.getlName());
			stm.setString(3, guest.getAddress());
			stm.setString(4, guest.getPhone());
			stm.setString(5, guest.getPasportNr());
			stm.setString(6, guest.getNationality());
			stm.setString(7, guest.getEmail());
			stm.executeUpdate();

			stmt.close();
			c.commit();
			// c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Database query ok ");

	}
public static void main(String[] args) throws SQLException {
	GuestHandler gh = new GuestHandler();
	Guest guest2 = new Guest("nationality", "fName", "lName", "address", "phone", "Wirginia", "email");
	

	System.out.println(gh.getAllGuests());
	gh.addNewGuest(guest2);
}
}
