package DAO;

import java.util.List;

import model.Address;

public interface IAddressDAO {

	public void AddAddress(Address address);
	
	public Address getAddressById(int addressId);
	
	public void Update(Address address);
	
	public void deleteAddress(int addressId);
	
	public List<Address> getAllAddressById();
}
