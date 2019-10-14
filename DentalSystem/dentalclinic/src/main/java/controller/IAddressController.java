package controller;

import java.util.List;

import javax.jws.WebMethod;

import model.Address;

public interface IAddressController {
	public void AddAdress(Address address);

	public void deleteAddress(int addressId);

	public void EditAddress(Address address);

	public Address getAddress(int addressId);
	
	public List<Address> getAllAddress();

}
