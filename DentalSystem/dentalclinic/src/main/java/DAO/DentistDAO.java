package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dentist;

public class DentistDAO implements IDentistDAO {
	
	private DatabaseConnection dbconn;

	public DentistDAO() {

		dbconn = new DatabaseConnection();

	}

	public Dentist getDentist(int id) {
		Dentist tempDentist = null;
		String sql = "select * from \"DentalClinic\".dentist where dentistid=" + id + ";";
		
		ResultSet rs = dbconn.retriveData(sql);
		try {
			while (rs.next()) {
				int dentistId = rs.getInt("dentistid");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("lastName");
				int branchId = rs.getInt("branchid");
				String Speciality= rs.getString("specialist");
				
			
				tempDentist = (new Dentist(dentistId,firstName, lastName,branchId , Speciality));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return tempDentist;
	}

	public List<Dentist> getAllDentist()  {
		List<Dentist> dentistList = new ArrayList<Dentist>();
		String sql = "SELECT * FROM \"DentalClinic\".dentist;";

		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while (rs.next()) {
				int dentistId = rs.getInt("dentistid");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("lastName");
				int branchId = rs.getInt("branchid");
				String speciality= rs.getString("specialist");
				
				dentistList.add( new Dentist(dentistId, firstName, lastName, branchId, speciality));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dentistList;
	}
	public List <Dentist> getAllDentistByBranchId(int branchId) {
		
	  List<Dentist> dentistListByBranchId = new ArrayList<Dentist>();
		String sql = "SELECT * FROM \"DentalClinic\".dentist WHERE branchid =" + branchId +";";
		ResultSet rs = dbconn.retriveData(sql);
		
		try  {
			while(rs.next()) {
				int dentistId = rs.getInt("dentistid");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("lastName");
				String Speciality= rs.getString("specialist");
				
				dentistListByBranchId.add(new Dentist(dentistId, firstName, lastName,branchId , Speciality));
				
			}
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return dentistListByBranchId;
	}
	
	public void AddDentist(Dentist newDentist) {

		String sql = "INSERT INTO \"DentalClinic\".dentist VALUES(Default,'" + newDentist.getFirstName()
				+ "','" + newDentist.getLastName() + "',"+ newDentist.getBranchId()+ ",'" + newDentist.getSpecialty() + "');";
		dbconn.WriteData(sql);

	}

	@Override
	public void RemoveDentist(int dentistId) {
		String sql = "Delete from \"DentalClinic\".dentist where dentistid ="+ dentistId + ";";
		
		dbconn.WriteData(sql);
		
	}

	@Override
	public void EditDentist(Dentist dentist) {
		String sql = "UPDATE \"DentalClinic\".dentist "
				+ " SET firstname ='"+dentist.getFirstName()+"', lastname ='"+dentist.getLastName()+"', branchid='" +dentist.getBranchId() +"', specialist ='"+dentist.getSpecialty()+"'"
						+ "Where dentistid ="+dentist.getEmpNo()+";";
				
		dbconn.WriteData(sql);
		
		// TODO Auto-generated method stub
		
	}
}