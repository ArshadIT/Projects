package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Patient>patientlist;

	public PatientList() {
		
		patientlist = new ArrayList<Patient>();
		
	}
	
	public void addPatient(Patient patient) {
		patientlist.add(patient);
	}
	public void removePatient(Patient patient) {
		patientlist.remove(patient);
	}
}
