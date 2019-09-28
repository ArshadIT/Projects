package client.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import client.Client;
import client.view.MainView;
import shared.model.RoomList;

public class RoomController implements IRoomController {

	private Client client;
	private MainView mainView;


	public RoomController(Client client, MainView mainView) {
		super();
		this.mainView = mainView;
		this.client = client;

		mainView.setRController(this);

	}



	@Override
	public RoomList getAvailableRooms(Date startDate, Date endDate) throws RemoteException, SQLException {

		return client.getAvailableRooms(startDate, endDate);

	}





}
