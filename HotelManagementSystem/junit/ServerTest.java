package junit;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import server.mediator.BookingHandler;
import server.mediator.GuestHandler;
import server.mediator.RoomHandler;
import shared.model.Booking;
import shared.model.BookingList;
import shared.model.CheckToday;
import shared.model.Guest;
import shared.model.GuestList;
import shared.model.Room;
import shared.model.RoomList;

public class ServerTest {
private RoomList rooms;
private GuestList guests;
private BookingList bookingsList;
private Room room1;
private Room room2;
private Guest guest1;
private Guest guest2;
private Guest guest3;
private Booking booking1;
private Booking booking2;
private RoomHandler rHandler;
private GuestHandler gHandler;
private BookingHandler bHandler;
Date startDate;
Date endDate;
private CheckToday chkToday;
private CheckToday chkToday1;
private CheckToday chkToday2;
private CheckToday chkToday3;
private ArrayList<CheckToday> lists;

private Booking booking3 = null;

@Before
public void setUp() {
	
	room1 = new Room(209, "King Size", true);
	room2 = new Room(210, "single room", true);
	 rooms = new RoomList();
	 rHandler = new RoomHandler();
	 startDate = new Date(12/12/2018);
	 endDate = new Date(1/12/2018);
	 guest1= new Guest("Danish", "Arshad", "Moh", "Park Alle, Aarhus", "23445566", "Dk345678", "ar@via.dk");
	 guest2= new Guest("Danish", "Tanja", "Tatjana", "Englandvey, kolding", "24445566", "Dk5675678", "ta@via.dk");
	 gHandler = new GuestHandler();
	 booking1 = new Booking("DK8365836458", 209, startDate, endDate);
	 booking2 = new Booking("DK8365836458", 210, startDate, endDate);
			 

		bHandler = new BookingHandler();
	
}
@Test
public void getAllRoomTest() throws SQLException {
	
	rooms.addRoom(room1);
	rooms.addRoom(room2);
	RoomList rl = rHandler.getAllRooms();
	
	boolean foundRoom1 = false;
	boolean foundRoom2 = false;
	for(Room r : rl.getAllRoomFromList()) {
		if(r.getRoomNr() == room1.getRoomNr()) {
			
				foundRoom1 = true;
			
		}
		
		if(r.getRoomNr()== room2.getRoomNr()) {
			
				foundRoom2 = true;
			}
		
		
		
	}
	
	assertTrue(foundRoom1);
	assertTrue(foundRoom2);
}

@Test

	public void addNewBookingTest() throws SQLException {
		
	bHandler.addNewBooking(booking1);
	bHandler.addNewBooking(booking2);

	BookingList  r2 =bHandler.getAllBookings();
		
	boolean foundBooking1 = false;
	boolean foundBooking2 = false;
	for(Booking r : r2.getAllBookingFromList()) {
		if(r.guestPasport.equals(booking1.guestPasport)) {
			
				foundBooking1= true;
			}
		
		
		if(r.guestPasport.equals(booking2.guestPasport)) {
			
			foundBooking2= true;
			}
		
	}
	assertTrue(foundBooking1);
	assertTrue(foundBooking2);
		
}
@Test
public void addNewGuestTest() throws SQLException {
	gHandler.addNewGuest(guest1);
	gHandler.addNewGuest(guest2);
	guest3= new Guest("Danish", "wirginia", "Szoltysek", "jenvej, Horsens", "56445566", "Dk78978678", "wir@via.dk");
	gHandler.addNewGuest(guest3);
	GuestList r3 =gHandler.getAllGuests();
	boolean foundGuest1 = false;
	boolean foundGuest2 = false;
	boolean foundGuest3 = false;
	for(Guest r: r3.getAllGuestFromList()) {
		if(r.getPasportNr().equals(guest1.getPasportNr())) {
			foundGuest1 = true;
		}
		if(r.getPasportNr().equals(guest2.getPasportNr())) {
			foundGuest2 = true;
		}
		if(r.getPasportNr().equals(guest3.getPasportNr())) {
			foundGuest3 = true;
		}
	}
	
	assertTrue(foundGuest1);
	assertTrue(foundGuest2);
	assertTrue(foundGuest3);
	
}

}
