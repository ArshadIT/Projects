package main;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import client.Client;
import client.controller.BookingController;
import client.controller.GuestController;
import client.controller.RoomController;
import client.view.MainView;

public class StartClient {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		
		Client client = new Client();
		MainView mainView = new MainView();
		

		
		RoomController rc =new RoomController(client, mainView);
		GuestController gc =new GuestController(client, mainView);
		BookingController bc = new BookingController(client, mainView);
		
		
		
		
		
	}

}
