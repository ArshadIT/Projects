package DAO;

import java.util.List;

import model.Appointment;

public interface IAppointmentDAO {


	public void AddAppointment(Appointment appointment);
	
	
	public void deleteAppointment(int appointmentId);
	
	
	public void EditAppointment(Appointment appointment);
	
	
	public List<Appointment> getAllAppointment();
	
	
	public Appointment getAppointmentById(int appointmentId);
	
	
	public List<Appointment> getAppointmentByDentistId(int dentist);
	
	
	public List<Appointment> getAppointmentByCprNo(String CprNo);


	//void AddAppointment(int dentistId, String date, String time, int branchId, String cprNo);
}
