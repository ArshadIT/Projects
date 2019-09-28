package shared.model;

import java.io.Serializable;

public class Room implements Serializable {

	private int roomNr;
	private String roomType;
	private boolean isClean;

	public Room(int roomNr, String roomType, boolean isClean) {
		super();
		this.roomNr = roomNr;
		this.roomType = roomType;
		this.isClean = isClean;
	}

	public int getRoomNr() {
		return roomNr;
	}

	public void setRoomNr(int roomNr) {
		this.roomNr = roomNr;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isClean() {
		return isClean;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}

	@Override
	public String toString() {
		return "Room [roomNr=" + roomNr + ", roomType=" + roomType + ", isClean=" + isClean + "]";
	}
	
	

}
