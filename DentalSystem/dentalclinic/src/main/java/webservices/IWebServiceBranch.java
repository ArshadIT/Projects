package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Branch;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IWebServiceBranch {

	@WebMethod
	public void AddBranch(Branch branch);
	
	@WebMethod
	public void deleteBranch(int branchId);
	
	@WebMethod
	public void EditBranch(Branch branch);
	
	@WebMethod
	public List<Branch> getAllBranch();
	
	@WebMethod
	public Branch getBranchById(int branchId);
}
