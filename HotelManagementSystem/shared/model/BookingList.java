package shared.model;

import java.io.Serializable;
import java.util.ArrayList;




public class BookingList implements Serializable {
	
	private ArrayList<Booking>bookings;
	
	public BookingList() {
		
		bookings = new ArrayList<>();
	}
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	
	public void removeBooking(Booking booking) {
		bookings.remove(booking);
	}
	
	public ArrayList<Booking> getAllBookingFromList(){
		return bookings;
	}
	public int size() {
		return bookings.size();
	}
	

	@Override
	public String toString() {
		String str = " ";
		for (int i = 0; i < bookings.size(); i++) {
			str += bookings.get(i).toString() + "\n";
		}
		return str;

	}



}
