package controller;

import model.LoginAsPatient;
import model.Patient;

public interface ILoginAsPatientController {
	
	public LoginAsPatient getPasswordByCprNo(String cprNo) ;
	
	public Patient getPatientByCprNo(String CprNumber);
}
