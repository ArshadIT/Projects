package webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.LoginAsPatient;
import model.Patient;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceLoginAsPatient {

	@WebMethod
	public LoginAsPatient getPasswordByCprNo(String cprNo);
	
	
	@WebMethod
	public Patient getPatientByCprNo(String cprNo);
}
