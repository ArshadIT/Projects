package webservices;

import java.util.List;

import javax.jws.WebService;

import controller.AppointmentController;
import controller.IAppointmentController;
import model.Appointment;

@WebService(endpointInterface = "webservices.IWebServiceAppointment")
public class AppoinmentWebService implements IWebServiceAppointment {
	private IAppointmentController appointmentController;

	public AppoinmentWebService() {
		appointmentController = new AppointmentController();
		
	}

	@Override
	public void AddAppointment(Appointment appointment) {
		appointmentController.AddAppointment(appointment);

	}

	@Override
	public void deleteAppointment(int appointmentId) {
		appointmentController.deleteAppointment(appointmentId);

	}

	@Override
	public void EditAppointment(Appointment appointment) {
		appointmentController.EditAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentController.getAllAppointment();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return appointmentController.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentByDentistId(int dentist) {
		// TODO Auto-generated method stub
		return appointmentController.getAppointmentByDentistId(dentist);
	}

	@Override
	public List<Appointment> getAppointmentByCprNo(String CprNo) {
		// TODO Auto-generated method stub
		return appointmentController.getAppointmentByCprNo(CprNo);
	}

}
