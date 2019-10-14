package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginAsPatient;
import model.Patient;

public class LoginAsPatientDAO implements ILoginAsPatientDAO{

	private DatabaseConnection dbsConn;
	
	public LoginAsPatientDAO()
	{
		dbsConn = new DatabaseConnection();
	}
	
	@Override
	public LoginAsPatient getPasswordByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		int j = 0;
		LoginAsPatient logAP = null;
		
		String sql = "select * from \"DentalClinic\".LoginAsPatient where cprNo= '" + cprNo +"' ;";
		
		ResultSet rs = dbsConn.retriveData(sql);
		try {
			while(rs.next())
			{
				String cprNumber = rs.getString("cprNo");
				String password = rs.getString("password");
				j++;
				
				//
				logAP = new LoginAsPatient(cprNumber, password);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(j);
		
		
		return logAP;
	}
	
	@Override
	public Patient getPatientByCprNo(String cprNo) {
		// TODO Auto-generated method stub
		
		if(getPasswordByCprNo(cprNo) != null) {    //check if the password is correct
		int i =0;
		Patient temPatient = null;

	String sql = "select * from \"DentalClinic\".patient where cprNo= '" + cprNo + "' ;";
	
	ResultSet rs = dbsConn.retriveData(sql);
	try {
		while (rs.next()) {
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
				String cprNo1 = rs.getString("cprNo");
				String email = rs.getString("email");
				int addressId = rs.getInt("addressid");
				i++;
			//String Email = rs.getString("Email");
			// String Address= rs.getString("Address");
			temPatient= new Patient(firstName, lastName, cprNo1, email, addressId);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println(i);
	return temPatient;
	}else
	{
	 return null;
	}


	}


	

	
}
