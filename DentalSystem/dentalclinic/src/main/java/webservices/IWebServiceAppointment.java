package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Appointment;
import model.Patient;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceAppointment {
	
	@WebMethod
	public void AddAppointment(Appointment appointment);
	
	@WebMethod
	public void deleteAppointment(int appointmentId);
	
	@WebMethod
	public void EditAppointment(Appointment appointment);
	
	@WebMethod
	public List<Appointment> getAllAppointment();
	
	@WebMethod
	public Appointment getAppointmentById(int appointmentId);
	
	@WebMethod
	public List<Appointment> getAppointmentByDentistId(int dentist);
	
	@WebMethod
	public List<Appointment> getAppointmentByCprNo(String CprNo);
}
