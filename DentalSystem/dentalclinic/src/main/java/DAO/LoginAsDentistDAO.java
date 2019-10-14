package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Dentist;
import model.LoginAsDentist;


public class LoginAsDentistDAO implements ILoginAsDentistDAO {

	private DatabaseConnection dbsConn;

	public LoginAsDentistDAO() {
		// TODO Auto-generated constructor stub
		dbsConn = new DatabaseConnection();
	}
	
	@Override
	public LoginAsDentist getPasswordByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		
		int j = 0;
		LoginAsDentist logAD = null;
		
		String sql = "select * from \"DentalClinic\".LoginAsDentist where dentistId= '" + dentistId +"' ;";
		
		ResultSet rs = dbsConn.retriveData(sql);
		try {
			while(rs.next())
			{
				int _dentistId = rs.getInt("dentistId");
				String password = rs.getString("password");
				j++;
				
				//
				logAD = new LoginAsDentist(_dentistId, password);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(j);
		
		
		return logAD;
	}

	@Override
	public Dentist getDentistByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		if(getPasswordByDentistId(dentistId) != null) {    //check if the password is correct
			int i =0;
			Dentist temDentist = null;

		String sql = "select * from \"DentalClinic\".Dentist where dentistId= '" + dentistId + "' ;";
		
		ResultSet rs = dbsConn.retriveData(sql);
		try {
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String specialty = rs.getString("specialist");
				int branchId = rs.getInt("branchId"); 
					int _dentistId = rs.getInt("dentistId");
					i++;
				//String Email = rs.getString("Email");
				// String Address= rs.getString("Address");
					temDentist= new Dentist(_dentistId, firstName, lastName, branchId,specialty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		return temDentist;
		}else
		{
		 return null;
		}
	}
	
	
}
