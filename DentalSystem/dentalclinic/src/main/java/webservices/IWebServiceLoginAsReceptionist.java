package webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.LoginAsReceptionist;
import model.Receptionist;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceLoginAsReceptionist {
	@WebMethod
	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId);
	
	
	@WebMethod
	public Receptionist getReceptionistByReceptionistId (int receptionistId);
}
