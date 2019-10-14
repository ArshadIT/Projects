package dentalclinic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.sql.SQLException;

import org.hamcrest.CoreMatchers;
import org.junit.internal.runners.statements.Fail;
import org.junit.jupiter.api.Test;

import controller.AppointmentController;
import model.Appointment;

class TestAppointmentController {

	@Test
	void testAddAppointment() throws SQLException
	{
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		apcon.AddAppointment(testApoint);
		assertThat(apcon.getAllAppointment().toString(), CoreMatchers.containsString(testApoint.toString()));
	}
	
	@Test
	void testEditAppointment() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		assertNotEquals(testApoint.toString(), apcon.getAppointmentById(testApoint.getAppointmentID()).toString());
		apcon.EditAppointment(testApoint);
		assertEquals(testApoint.toString(), apcon.getAppointmentById(testApoint.getAppointmentID()).toString());
		
	}

	@Test
	void testDeleteAppointment() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		assertEquals(testApoint.toString(), apcon.getAppointmentById(testApoint.getAppointmentID()).toString());
		apcon.deleteAppointment(testApoint.getAppointmentID());
		assertEquals(null, apcon.getAppointmentById(testApoint.getAppointmentID()));
		
	}
		


	@Test
	void testGetAllAppointments() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		assertThat(apcon.getAllAppointment().toString(), CoreMatchers.containsString(testApoint.toString()));
		
	}

	@Test
	void testGetAppointmentById() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		assertEquals(testApoint.toString(), apcon.getAppointmentById(1).toString());
	}
	


	@Test
	void testGetAppointmentByDentistId() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(11,3, "2019-06-08", "12:00", "030284xxxx", 3);
		assertThat(apcon.getAppointmentByDentistId(3).toString(), CoreMatchers.containsString(testApoint.toString()));
		
	}
	
	@Test
	void testGetAppointmentByCprNo() {
		AppointmentController apcon=new AppointmentController();
		Appointment testApoint=new Appointment(1, 1, "", "", "", 1);
		assertThat(apcon.getAppointmentByCprNo("030284xxxx").toString(), CoreMatchers.containsString(testApoint.toString()));
	}
	

}