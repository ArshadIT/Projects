package controller;

import java.util.List;

import model.Appointment;

public interface IAppointmentController {
	public void AddAppointment(Appointment appointment);
	
	
	public void deleteAppointment(int appointmentId);
	
	
	public void EditAppointment(Appointment appointment);
	
	
	public List<Appointment> getAllAppointment();
	
	
	public Appointment getAppointmentById(int appointmentId);
	
	
	public List<Appointment> getAppointmentByDentistId(int dentist);
	
	
	public List<Appointment> getAppointmentByCprNo(String CprNo);

}
