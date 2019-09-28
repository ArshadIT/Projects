package shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CheckToday implements Serializable {

	public int bookingId;
	public int roomNo;
	public String guestName;
	public int daysStaying;
	public Date leaving;
	public float payment;
	public ArrayList<CheckToday> list;

	public CheckToday() {
		
	}

	public CheckToday(int bookingId, int roomNo, String guestName, int daysStaying, Date leaving, float payment) {
		super();
		this.bookingId = bookingId;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.daysStaying = daysStaying;
		this.leaving = leaving;
		this.payment = payment;
		list = new ArrayList<CheckToday>();
	}

	public CheckToday(int bookingId, int roomNo, String guestName, float payment) {
		this.bookingId = bookingId;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.payment = payment;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getDaysStaying() {
		return daysStaying;
	}

	public void setDaysStaying(int daysStaying) {
		this.daysStaying = daysStaying;
	}

	public Date getLeaving() {
		return leaving;
	}

	public void setLeaving(Date leaving) {
		this.leaving = leaving;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}
	


	public ArrayList<CheckToday> getList() {
		return list;
	}

	public void setList(ArrayList<CheckToday> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Id=" + bookingId + ", room=" + roomNo + ", name=" + guestName
				+ ", daysStaying=" + daysStaying + ", leaving=" + leaving + ", payment=" + payment + "\n";
	}

	
	

}
