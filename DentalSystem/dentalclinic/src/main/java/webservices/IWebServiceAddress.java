package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Address;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceAddress {

	@WebMethod
	public void AddAdress(Address address);
	
	@WebMethod
	public void deleteAddress(Address addressId);
	
	@WebMethod
	public void EditAddress(Address address);
	
	@WebMethod
	public Address getAddress(int addressId);
	
	@WebMethod
	public List<Address> getAllAddressById();
	
}
