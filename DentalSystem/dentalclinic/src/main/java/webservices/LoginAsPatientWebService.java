package webservices;

import javax.jws.WebService;

import DAO.ILoginAsPatientDAO;
import controller.LoginAsPatientController;

import model.LoginAsPatient;
import model.Patient;
@WebService(endpointInterface="webservices.IWebServiceLoginAsPatient")
public class LoginAsPatientWebService implements IWebServiceLoginAsPatient{

	private ILoginAsPatientDAO patientLoginDb;
	
	
	@Override
	public LoginAsPatient getPasswordByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		LoginAsPatientController patientController = new LoginAsPatientController();
		return patientController.getPasswordByCprNo(cprNo);
	}

	@Override
	public Patient getPatientByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		return patientLoginDb.getPatientByCprNo(cprNo);
	}

}
