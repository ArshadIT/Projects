package webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Dentist;
import model.LoginAsDentist;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceLoginAsDentist {
	@WebMethod
	public LoginAsDentist getPasswordByDentistId(int dentistId);
	
	
	@WebMethod
	public Dentist getDentistByDentistId(int dentistId);
}
