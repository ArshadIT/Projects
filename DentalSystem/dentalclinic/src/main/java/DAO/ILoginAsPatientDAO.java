package DAO;

import model.LoginAsPatient;
import model.Patient;

public interface ILoginAsPatientDAO {
	public LoginAsPatient getPasswordByCprNo(String cprNo);
	public Patient getPatientByCprNo(String cprNo);

}
