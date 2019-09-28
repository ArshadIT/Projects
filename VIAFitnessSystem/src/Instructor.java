import java.awt.*;
import java.io.Serializable;

public class Instructor implements Serializable {

	private String name;
	private String address;
	private String skills;
	private String telNumber;
	private String email;

	public Instructor(String name, String address, String skills, String telNumber, String email) {
		this.name = name;
		this.address = address;
		this.skills = skills;
		this.telNumber = telNumber;
		this.email = email;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String coursePre) {
		this.skills = skills;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public String toString() {

		return "Name: " + name + "  Address:" + address + " Skills :" + skills + "  telNumber: " + telNumber
				+ "  Email:" + email;
	}

	public boolean equals(Instructor obj) {
		if (!(obj instanceof Instructor)) {
			return false;
		}
		Instructor other = (Instructor) obj;
		return name.equals(other.name) && address.equals(other.address) && skills.equals(other.skills) && telNumber.equals(other.telNumber) && email.equals(other.email);
	}
}
