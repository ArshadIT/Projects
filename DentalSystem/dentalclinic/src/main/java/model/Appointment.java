package model;



public class Appointment  {

	private int appointmentID;
	private int dentistId;
	private String date;
	private String time;
	private String CprNo;
	private int branchID;
	
	public Appointment(int appointmentID, int dentistId, String date, String time, String cprNo, int branchID) {

		this.appointmentID = appointmentID;
		this.dentistId = dentistId;
		this.date = date;
		this.time =time;
		CprNo = cprNo;
		this.branchID = branchID;
	}
	//used for add methods.
	public Appointment(int dentistId, String date, String time, String cprNo, int branchID) {
		this.dentistId = dentistId;
		this.date =date;
		this.time=time;
		CprNo = cprNo;
		this.branchID = branchID;
	}

	public Appointment(int appointmentID, int dentistId, String date, String time) {

		this.appointmentID = appointmentID;
		this.dentistId = dentistId;
		this.date =date;
		this.time =time;

	}
	
	public Appointment() {

	}
	

	
	public int getAppointmentID() {
		return appointmentID;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointmentID + ", dentistId=" + dentistId + ", date=" + date + ", time="
				+ time + ", CprNo=" + CprNo + ", branchID=" + branchID + "]";
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getDentistId() {
		return dentistId;
	}
	public void setDentistId(int dentistId) {
		this.dentistId = dentistId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getCprNo() {
		return CprNo;
	}
	public void setCprNo(String cprNo) {
		CprNo = cprNo;
	}
	
}
