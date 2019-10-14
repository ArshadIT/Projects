package controller;

import DAO.AppointmentDAO;
import model.Appointment;
import webservices.AppoinmentWebService;
import webservices.BranchWebService;

public class TestClass {

	public static void main(String[] args) {
		
		
		PatientControllerImp  pacimp = new PatientControllerImp();
		BranchWebService hh = new BranchWebService();
		AppointmentDAO kkk = new AppointmentDAO();
			kkk.getAllAppointment();
			//Appointment appointment = new Appointment(0, 3, "2019-06-08", "12:00", "030284xxxx", 3);
			
	//kkk.AddAppointment(appointment);
	
	AppoinmentWebService app = new AppoinmentWebService();
	//app.AddAppointment(appointment);
	
	System.out.println("Appointment id" + app.getAppointmentById(30));
		
				
	}

}
