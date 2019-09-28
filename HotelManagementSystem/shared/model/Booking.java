package shared.model;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

	
	public int id;
	public String guestPasport;
	public int roomNo;
	public Date startDate;
	public Date endDate;
	
	

	public Booking() {
	
	}

	public Booking(int id, String guestPasport, Date startDate, Date endDate, int roomNo) {

		this.id = id;
		this.guestPasport = guestPasport;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomNo = roomNo;

	}
	
	

	public Booking(String guestPasport, int roomNo, Date startDate, Date endDate) {
		super();
	
		this.guestPasport = guestPasport;
		this.roomNo = roomNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassport() {
		return guestPasport;
	}

	public void setGuest(String guestPasport) {
		this.guestPasport = guestPasport;
	}

	public int getRoom() {
		return roomNo;
	}

	public void setRoom(int room) {
		this.roomNo = room;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Booking [id= " + id + ", guestPasportNo= " + guestPasport + ", room= " + roomNo + ", startDate= " + startDate + ", endDate= "
				+ endDate + "]";
	}

}
