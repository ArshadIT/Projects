package server.mediator;

import java.sql.SQLException;

import shared.model.Guest;
import shared.model.GuestList;

public interface IGuestHandler {
	
	public GuestList getAllGuests() throws SQLException;
	public void addNewGuest(Guest guest) throws SQLException;

}
