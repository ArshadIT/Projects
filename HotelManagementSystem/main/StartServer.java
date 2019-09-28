package main;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.Server;
import server.mediator.BookingHandler;
import server.mediator.GuestHandler;
import server.mediator.RoomHandler;
import shared.ServerInterface;

public class StartServer {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		ServerInterface si = new Server(new BookingHandler(), 
				new RoomHandler(), new GuestHandler());
        LocateRegistry.createRegistry(1099);
        Naming.bind("hotel", si);
        System.out.println("Server started");
      
		
	}

}
