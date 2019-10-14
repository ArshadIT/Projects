package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Address;

public class AddressDAO implements IAddressDAO{

	private DatabaseConnection dbconn;
	
	
	public AddressDAO() {
		
	dbconn = new DatabaseConnection();
	}
	
	@Override
	public void AddAddress(Address address) {
		String sql = "INSERT INTO\"DentalClinic\".address VALUES(default " + ",'" + address.getStreetName()+ "','" +address.getStreetNo()
		+ "','" + address.getPostalCode() + "','" + address.getCity()+ "');";
		dbconn.WriteData(sql);
	}

	@Override
	public Address getAddressById(int addressId) {
		Address tempAddress = null;
		String sql = "select * from \"DentalClinic\".address where addressid=" + addressId +";";
		ResultSet rs = dbconn.retriveData(sql);
		try {
			while(rs.next()) {
				int addressId1 = rs.getInt("addressId");
				String streetName = rs.getString("streetname");
				String streetNo = rs.getString("streetnumber");
				String postalCode = rs. getString("postalcode");
				String City = rs.getString("city");
				tempAddress = new Address(addressId1, streetName,streetNo,postalCode,City);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tempAddress;
	}

	@Override
	public void Update(Address address) {
		String sql = "UPDATE \"DentalClinic\".address"
				+ "SET streetname = '"+address.getStreetName() +"', streetnumber='" + address.getStreetNo()
				+"',postalcode='" +address.getPostalCode() +"',city ='" +address.getCity() + ";";
		dbconn.WriteData(sql);
	}

	@Override
	public void deleteAddress(int addressId) {
		
		String sql = "Delete from \"DentalClinic\".address where addressid =" + addressId + ";";
	}

	@Override
	public List<Address> getAllAddressById() {
		List <Address> addresslist = new ArrayList<Address>();
		
		String sql = "Select * from \"DentalClinic\".address;";
		
		ResultSet rs = dbconn.retriveData(sql);
		try {
			while(rs.next()) {
				int addressId = rs.getInt("addressId");
				String streetName = rs.getString("streetname");
				String streetNo = rs.getString("streetnumber");
				String postalCode = rs. getString("postalcode");
				String City = rs.getString("city");
				addresslist.add(new Address(addressId, streetName,streetNo,postalCode, City));
			}
		}catch(Exception e) {
			
		}
		
		return addresslist;
	}

}
