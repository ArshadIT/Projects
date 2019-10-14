package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Dentist;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceDentist {

	@WebMethod
	public void AddDentist(Dentist newDentist);
	
	@WebMethod
	public Dentist getDentisttByDentistId(int dentistId);
	@WebMethod
	public List<Dentist> getAllDentist();
	@WebMethod
	public void EditDentist(Dentist dentist);
	
	@WebMethod
	public List<Dentist> getAllDentistByBranchId(int branchId);

}