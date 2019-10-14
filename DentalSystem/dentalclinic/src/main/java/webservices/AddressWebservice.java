package webservices;

import java.util.List;

import javax.jws.WebService;

import controller.AppointmentController;
import controller.IAddressController;
import model.Address;
@WebService(endpointInterface = "webservices.IWebServiceAddress")
public class AddressWebservice implements IWebServiceAddress {

	private IAddressController addressController;
	@Override
	public void AddAdress(Address address) {
	addressController.AddAdress(address);
	}

	@Override
	public void deleteAddress(Address addressId) {
		addressController.AddAdress(addressId);
	}

	@Override
	public void EditAddress(Address address) {
		addressController.EditAddress(address);
	}

	

	@Override
	public List<Address> getAllAddressById() {
		
		return addressController.getAllAddress();
	}

	@Override
	public Address getAddress(int addressId) {
		
		return addressController.getAddress(addressId);
	}

}
