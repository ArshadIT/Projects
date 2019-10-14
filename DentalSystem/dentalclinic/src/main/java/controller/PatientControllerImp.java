package controller;
import java.util.List;

import DAO.IPatientDAO;
import DAO.PatientDAO;
import model.Patient;

public class PatientControllerImp  implements IPatientDAO{

	private IPatientController patientController;
		public void AddPatient(Patient patient) {
		IPatientDAO patients = new PatientDAO();
		patients.AddPatient(patient);
	
	}

		
		public List<Patient> getAllPatientByCprNo() {
			IPatientDAO patientlist = new PatientDAO();
			
			return patientlist.getAllPatientByCprNo();
		}

	
	public void updatePatient(Patient patient) {
		patientController.editPatient(patient);
		
	}

	
	public void deletePatient(String cprNo) {
				patientController.removePatient(cprNo);
	}


	
	@Override
	public Patient getPatientByCpr(String cprNo) {
		IPatientDAO patient = new PatientDAO();
		return patient.getPatientByCpr(cprNo);
	
	}



	
	
	}
