package shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomTypeList implements Serializable {
	
	private ArrayList<RoomType> roomTypeList;

	public RoomTypeList() {
		roomTypeList = new ArrayList<>();
	}

	public int size() {
		return roomTypeList.size();
	}

	public String toString() {
		return roomTypeList.toString();
	}

	public void add(RoomType e) {
		roomTypeList.add(e);
	}

	public void remove(RoomType o) {
		roomTypeList.remove(o);
	}
	
	
	

}
