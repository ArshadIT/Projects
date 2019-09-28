package server.mediator;

import java.sql.SQLException;
import java.util.Date;

import shared.model.Booking;
import shared.model.RoomList;

public interface IRoomHandler {

	RoomList getAllRooms() throws SQLException;

	public RoomList getAvailableRooms(Date startDate, Date endDate) throws SQLException;

}
