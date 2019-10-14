package model;

import java.io.Serializable;

public class LoginAsDentist implements Serializable{

	private int dentistId;
	private String password;
	
	public LoginAsDentist() {
		
	}
	
	public LoginAsDentist(int dentistId,String password)
	{
		super();
		this.dentistId = dentistId;
		this.password = password;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public int getDentistId() {
		// TODO Auto-generated method stub
		return dentistId;
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	
	public void setDentistId(int dentistId) {
		this.dentistId = dentistId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Log in as a dentist: [Dentist id: " + dentistId + ", password: " + password + "]";
	}
}
