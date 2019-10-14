package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Branch;

public class BranchDAO implements IBranchDAO {

	private DatabaseConnection dbconn;

	public BranchDAO() {
		dbconn = new DatabaseConnection();
	}

	@Override
	public void AddBranch(Branch branch) {
		String sql = "INSERT INTO \"DentalClinic\".branch VALUES(Default,'" + branch.getBranchName() + "','"
				+ branch.getPhoneNumber() + "','" + branch.getBranchEmail()+ "');";
		dbconn.WriteData(sql);
	}

	@Override
	public void deleteBranch(int branchId) {
	String sql = "DELETE FROM 	\"DentalClinic\".branch  WHERE branchId ="+branchId+";";
	dbconn.WriteData(sql);
	}

	@Override
	public void EditBranch(Branch branch) {
		String sql = "UPDATE \"DentalClinic\".branch SET branchname ='" +branch.getBranchName()+ "', phonenumber='"+branch.getPhoneNumber()+"', branchemail='"+branch.getBranchEmail()+"' WHERE branchid ="+ branch.getBranchId()+ ";";
		dbconn.WriteData(sql);
	
	}

	@Override
	public List<Branch> getAllBranch() {
		List<Branch> tempBranchList = new ArrayList<Branch>();
		
		String sql = "SELECT * FROM	\"DentalClinic\".branch ";
		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while(rs.next()) {
				int branchid = rs.getInt("branchid");
				String branchName = rs.getString("branchname");
				String phonenumber = rs.getString("branchname");
				String branchemail = rs.getString("branchemail");
				tempBranchList.add( new  Branch(branchid, branchName, phonenumber, branchemail));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempBranchList;
	}

	@Override
	public Branch getBranchById(int branchId) {
		Branch tempBranch = null;
		String sql = 	"SELECT * FROM \"DentalClinic\".branch WHERE branchid=" +branchId+";";
		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while(rs.next()) {
				int branchid = rs.getInt("branchid");
				String branchName = rs.getString("branchname");
				String phonenumber = rs.getString("branchname");
				String branchemail = rs.getString("branchemail");
			
				  tempBranch =new  Branch(branchid, branchName, phonenumber, branchemail);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempBranch;
	}

}
