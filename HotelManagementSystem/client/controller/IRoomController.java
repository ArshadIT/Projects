package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import client.Client;
import shared.model.RoomList;

public interface IRoomController {

	public RoomList getAvailableRooms(Date startDate, Date endDate) throws RemoteException, SQLException;

}
