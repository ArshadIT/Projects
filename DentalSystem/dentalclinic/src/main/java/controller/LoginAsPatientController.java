package controller;

import DAO.ILoginAsPatientDAO;
import DAO.LoginAsPatientDAO;
import model.LoginAsPatient;
import model.Patient;

public class LoginAsPatientController implements ILoginAsPatientDAO {

	private ILoginAsPatientController loginAsPatientController;
	
	
	@Override
	public LoginAsPatient getPasswordByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		ILoginAsPatientDAO patientLogin = new LoginAsPatientDAO();
		
		return patientLogin.getPasswordByCprNo(cprNo);
	}

	@Override
	public Patient getPatientByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		
		if(getPasswordByCprNo(cprNo) != null)
		{
			ILoginAsPatientDAO patient = new LoginAsPatientDAO();
			return patient.getPatientByCprNo(cprNo);
		}else
		{
			return null;
		}
	}

}
