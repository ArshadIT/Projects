package model;

import java.io.Serializable;

public class LoginAsReceptionist implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int receptionistId;
	private String password;
	
	public LoginAsReceptionist() {
		
	}
	
	public LoginAsReceptionist(int receptionistId,String password)
	{
		this.receptionistId = receptionistId;
		this.password = password;
	}
	
	
	
	public int getReceptionistId() {
		// TODO Auto-generated method stub
		return receptionistId;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Log in as a Receptionist: [Receptionist id: " + receptionistId + ", password: " + password + "]";
	}
}
