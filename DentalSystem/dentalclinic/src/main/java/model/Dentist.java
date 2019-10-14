package model;

import java.io.Serializable;

public class Dentist implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int empNo;
	private String firstName;
	private String lastName;
	private int branchId;
	private String specialty;
	public Dentist( int empNo, String firstName, String lastName,int branchId, String specialty) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branchId = branchId;
		this.specialty = specialty;
	}
	public Dentist(  String firstName, String lastName,int branchId, String specialty) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.branchId = branchId;
		this.specialty = specialty;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dentist [firstName=" + firstName + ", lastName=" + lastName + ", empNo=" + empNo + ", specialty="
				+ specialty +"]";
	}
	
}
