package shared.model;

import java.io.Serializable;
import java.util.ArrayList;


public class GuestList implements Serializable {
	
	private  ArrayList<Guest>guests;

	public GuestList() {
		guests = new ArrayList<Guest>();
	}
	
	public void addGuest(Guest guest) {
		guests.add(guest);
	}
	
	public void removeGuest(Guest guest) {
		guests.remove(guest);
	}
	
	public ArrayList<Guest> getAllGuestFromList(){
		return guests;
	}
	public boolean contains(Guest guest) {
		if (!guests.contains(guest.getPasportNr()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = " ";
		for (int i = 0; i < guests.size(); i++) {
			str += guests.get(i).getPasportNr().toString() + "\n";
		}
		return str;

	}

	public String[] toArray(String[] strings) {
		String[] array = guests.toArray(new String[guests.size()]);
		return array;
	}

	public int size() {
		
		return guests.size();
	}

	 public Guest getGuest(int index)
	   {
	      if (index<guests.size())
	      {
	      return guests.get(index);
	      }
	      else return null;
	   }

	public boolean isEmpty() {
		if(guests.size()==0)
			return true;
		else return false;
	}

}
