package controller;

import java.util.List;

import javax.jws.WebService;

import DAO.AddressDAO;
import DAO.IAddressDAO;
import model.Address;
@WebService(endpointInterface = "webservices.IWebServiceAddress")
public class AddressController implements IAddressController {

	private IAddressDAO addres;
	@Override
	public void AddAdress(Address address) {
		IAddressDAO adress = new AddressDAO();
		adress.AddAddress(address);

	}

	@Override
	public void deleteAddress(int addressId) {
		addres.deleteAddress(addressId);

	}

	@Override
	public void EditAddress(Address address) {
		addres.Update(address);

	}

	@Override
	public Address getAddress(int addressId) {
		
		return addres.getAddressById(addressId);
	}

	@Override
	public List<Address> getAllAddress() {
		
		return addres.getAllAddressById();
	}

}
