package shared.model;

import java.io.Serializable;

public class RoomType implements Serializable {

	private String roomType;
	private float price;

	public RoomType(String roomType, float price) {
		super();
		this.roomType = roomType;
		this.price = price;
	}

	public RoomType() {
		// TODO Auto-generated constructor stub
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RoomType [roomType=" + roomType + ", price=" + price + "]";
	}
	

}
