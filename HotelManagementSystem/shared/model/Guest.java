package shared.model;

import java.io.Serializable;

public class Guest implements Serializable {
	

	private String fName;
	private String lName;
	private String address;
	private String nationality;
	private String passportNr;
	private String email;
	private String phone;

	public Guest(String nationality, String fName, String lName, String address, String phone, String passportNr, String email) {

		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.passportNr = passportNr;
		this.email = email;
		this.nationality = nationality;
		this.phone = phone;
	}
	

	public Guest(String passportNr) {
		super();
		this.passportNr = passportNr;
	}


	


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPasportNr() {
		return passportNr;
	}

	public void setPasportNr(String pasportNr) {
		this.passportNr = pasportNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Guest [fName=" + fName + ", lName=" + lName + ", address=" + address + ", nationality=" + nationality
				+ ", passportNr=" + passportNr + ", email=" + email + "]";
	}

}
