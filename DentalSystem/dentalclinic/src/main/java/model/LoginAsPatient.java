package model;

import java.io.Serializable;

public class LoginAsPatient implements Serializable{

	private String cprNo;
	private String password;
	
	public LoginAsPatient() {
		
	}
	
	public LoginAsPatient(String cprNo, String password) {
		super();
		this.cprNo = cprNo;
		this.password = password;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String getCprNo() {
		// TODO Auto-generated method stub
		return cprNo;
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setCprNo(String cprNo) {
		this.cprNo = cprNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Log in as a patient: [cprNo: " + cprNo + ", password: " + password + "]";
	}
	

}
