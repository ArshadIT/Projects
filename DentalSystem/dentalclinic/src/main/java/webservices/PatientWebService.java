package webservices;



import java.util.List;

import javax.jws.WebService;

import DAO.IPatientDAO;
import controller.PatientControllerImp;
import model.Patient;

@WebService(endpointInterface="webservices.IWebServicePatient")

public class PatientWebService implements IWebServicePatient {

	private IPatientDAO patientService;
	
	public void AddPatient(Patient patient) {
		Patient patient1 = new Patient();
		patient1.setFirstName(patient.getFirstname());
		patient1.setLastName(patient.getLastName());
		patient1.setCprNo(patient.getCprNo());
	}

	@Override
	public Patient getPatientByCprNo(String cprNo) {
		PatientControllerImp patientController = new PatientControllerImp();
		return patientController.getPatientByCpr(cprNo);
	}

	public List<Patient> getAllPatientByCprNo() {
		PatientControllerImp patientController = new PatientControllerImp();
		return patientController.getAllPatientByCprNo();
	}

	@Override
	public void deletePatient(String cprNo) {
		patientService.deletePatient(cprNo);
		
	}

	@Override
	public void updatePatient(Patient patient) {
		patientService.updatePatient(patient);
		
	}

	
}
