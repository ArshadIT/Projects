package shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable {

	private ArrayList<Room> rooms;

	public RoomList() {
		rooms = new ArrayList<>();
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public void removeRoom(Room room) {
		rooms.remove(room);
	}

	public ArrayList<Room> getAllRoomFromList() {
		return rooms;
	}
	public int size() {
		return rooms.size();
	}
	
	
	
	@Override
	public String toString() {
		String str = " ";
		for (int i = 0; i < rooms.size(); i++) {
			str += rooms.get(i).toString() + "\n";
		}
		return str;

	}

	public Room get(int index)
	   {
	      
	      
	      return rooms.get(index);
	     
	   }

}
