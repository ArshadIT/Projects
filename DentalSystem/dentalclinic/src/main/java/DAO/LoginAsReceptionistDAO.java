package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginAsReceptionist;
import model.Receptionist;

public class LoginAsReceptionistDAO implements ILoginAsReceptionistDAO{

	private DatabaseConnection dbsConn;
	
	public LoginAsReceptionistDAO() {
		dbsConn = new DatabaseConnection();
	}

	@Override
	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		int j = 0;
		LoginAsReceptionist logAR = null;
		
		String sql = "select * from \"DentalClinic\".LoginAsReceptionist where receptionistId= '" + receptionistId +"' ;";
		
		ResultSet rs = dbsConn.retriveData(sql);
		try {
			while(rs.next())
			{
				int _receptionistId = rs.getInt("receptionistId");
				String password = rs.getString("password");
				j++;
				
				//
				logAR = new LoginAsReceptionist(_receptionistId, password);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(j);
		
		
		return logAR;
	}

	@Override
	public Receptionist getReceptionistByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		if(getPasswordByReceptionistId(receptionistId) != null) {    //check if the password is correct
			int i =0;
			Receptionist temReceptionist = null;

		String sql = "select * from \"DentalClinic\".Dentist where receptionistId= '" + receptionistId + "' ;";
		
		ResultSet rs = dbsConn.retriveData(sql);
		try {
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				
					int _receptionistId = rs.getInt("receptionistId");
					i++;
				//String Email = rs.getString("Email");
				// String Address= rs.getString("Address");
					temReceptionist= new Receptionist( firstName, lastName,_receptionistId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		return temReceptionist;
		}else
		{
		 return null;
		}
	}
	
	
}
