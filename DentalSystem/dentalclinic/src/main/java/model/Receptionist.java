package model;

import java.io.Serializable;

public class Receptionist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String firstName;
	private String lastName;
	private int receptionistId;
	
	public Receptionist() {
		
	}
	
	public Receptionist(String firstName,String lastName,int receptionistId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.receptionistId = receptionistId;
	}
	

	public int getReceptionistId() {
		// TODO Auto-generated method stub
		return receptionistId;
	}


	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	
	public String toString() {
		return "Receptionist [firstName=" + firstName + ", lastName=" + lastName + ", Receptionist id=" + receptionistId +"]";
	}
}
