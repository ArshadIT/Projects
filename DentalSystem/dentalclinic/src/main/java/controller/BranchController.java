package controller;

import java.util.List;

import DAO.BranchDAO;
import DAO.IBranchDAO;
import model.Branch;

public class BranchController implements IBranchController {
	private IBranchDAO branchdao;
	
	 public BranchController() {
		 branchdao = new BranchDAO();
	 
	 }
	@Override
	public void AddBranch(Branch branch) {
		branchdao.AddBranch(branch);
	}

	@Override
	public void deleteBranch(int branchId) {
	
		branchdao.deleteBranch(branchId);
	}
	

	@Override
	public void EditBranch(Branch branch) {
		branchdao.EditBranch(branch);

	}

	@Override
	public List<Branch> getAllBranch() {
		return branchdao.getAllBranch();
	}
	@Override
	public Branch getBranchById(int branchId) {
		return branchdao.getBranchById(branchId);
	}

}
