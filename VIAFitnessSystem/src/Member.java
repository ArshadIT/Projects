import java.io.Serializable;

public class Member implements Serializable {

	private String name;
	private String address;
	private String telNumber;
	private String email;
	private String membership;

	public Member(String name, String address, String telNumber, String email, String membership) {
		this.name = name;
		this.address = address;
		this.telNumber = telNumber;
		this.email = email;
		this.membership = membership;
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

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String toString() {
		return " name : " + name + " address :" + address + " telNumber :" + telNumber + " Email : " + email
				+ "Membership:" + membership;
	}
	
	public boolean equals(Member obj) {
		
		if(!(obj instanceof Member)) {
			return false;
		}
		Member other = (Member)obj;
		
		return name.equals(other.name) && address.equals(other.address) && telNumber.equals(other.telNumber) && email.equals(other.email) && membership.equals(other.membership);
	}

}
