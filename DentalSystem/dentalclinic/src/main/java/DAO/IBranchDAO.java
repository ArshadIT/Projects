package DAO;

import java.util.List;

import model.Branch;

public interface IBranchDAO {
	public void AddBranch(Branch branch);
	

	public void deleteBranch(int branchId);
	
	public void EditBranch(Branch branch);
	
	
	public List<Branch> getAllBranch();
	

	public Branch getBranchById(int branchId);
}
