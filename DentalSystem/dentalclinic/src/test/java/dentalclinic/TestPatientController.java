package dentalclinic;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import controller.PatientControllerImp;
import model.Patient;

class TestPatientController {

	@Test
	void testAddPatient() throws SQLException
	{
		PatientControllerImp apcon=new PatientControllerImp();
		Patient testPat=new Patient("Dennis", "May", "030284xxxx", "dennismay@gmail.com", 1);
		apcon.AddPatient(testPat);
		assertThat(apcon.getAllPatientByCprNo().toString(), CoreMatchers.containsString(testPat.toString()));
	}
	
	@Test
	void testEditPatient() {
		PatientControllerImp apcon=new PatientControllerImp();
		Patient testPat=new Patient("Dennis", "May", "030284xxxx", "dennismay@gmail.com", 1);
		assertNotEquals(testPat.toString(), apcon.getPatientByCpr(testPat.getCprNo()).toString());
		apcon.updatePatient(testPat);
		assertEquals(testPat.toString(), apcon.getPatientByCpr(testPat.getCprNo()).toString());
		
	}

	@Test
	void testDeletePatient() {
		PatientControllerImp apcon=new PatientControllerImp();
		Patient testPat=new Patient("Dennis", "May", "030284xxxx", "dennismay@gmail.com",1);
		assertEquals(testPat.toString(), apcon.getPatientByCpr(testPat.getCprNo()).toString());
		apcon.deletePatient(testPat.getCprNo());
		assertEquals(null, apcon.getPatientByCpr(testPat.getCprNo()));
		
	}

	@Test
	void testGetAllPatients() {
		PatientControllerImp apcon=new PatientControllerImp();
		Patient testPat=new Patient("Dennis", "May", "030284xxxx", "dennismay@gmail.com",1);
		assertThat(apcon.getAllPatientByCprNo().toString(), CoreMatchers.containsString(testPat.toString()));
		
	}

	@Test
	void testGetPatientbyCprNo() {
		PatientControllerImp apcon=new PatientControllerImp();
		Patient testPat=new Patient("Dennis", "May", "030284xxxx", "dennismay@gmail.com",1);
		assertEquals(testPat.toString(), apcon.getPatientByCpr("030284xxxx").toString());
	}

}
