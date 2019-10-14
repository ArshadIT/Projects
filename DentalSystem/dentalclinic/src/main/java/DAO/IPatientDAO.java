package DAO;

import java.util.List;

import model.Patient;

public interface IPatientDAO {
	
	public void AddPatient(Patient patient);
	
	public Patient getPatientByCpr(String cprNo);
	
	public void updatePatient(Patient patient);
	
	public void deletePatient(String cprNo);
	
	public List<Patient> getAllPatientByCprNo();

}
