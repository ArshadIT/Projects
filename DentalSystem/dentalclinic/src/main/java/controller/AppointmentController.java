package controller;

import java.util.List;

import DAO.AppointmentDAO;
import DAO.IAppointmentDAO;
import model.Appointment;

public class AppointmentController implements IAppointmentController {
	private IAppointmentDAO apdao = new AppointmentDAO();

	public AppointmentController() {

	}

	@Override
	public void AddAppointment(Appointment appointment) {
	System.out.println("Add appointment method");	
	apdao.AddAppointment(appointment);

	}

	@Override
	public void deleteAppointment(int appointmentId) {
		apdao.deleteAppointment(appointmentId);

	}

	@Override
	public void EditAppointment(Appointment appointment) {
		apdao.EditAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return  apdao.getAllAppointment();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return apdao.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentByDentistId(int dentist) {
		// TODO Auto-generated method stub
		return apdao.getAppointmentByDentistId(dentist);
	}

	@Override
	public List<Appointment> getAppointmentByCprNo(String CprNo) {
		// TODO Auto-generated method stub
		return apdao.getAppointmentByCprNo(CprNo);
	}

}
