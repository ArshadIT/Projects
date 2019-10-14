package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Patient;

public interface IPatientController {

	public ArrayList<Patient> getAllPatient() throws SQLException;
	
	public Patient getPatientByCprNo(String CprNumber);
	
	public void addPatient(Patient patient);
	
	public void removePatient(String cprNo);
	
	public Patient editPatient(Patient patient);
	
}
