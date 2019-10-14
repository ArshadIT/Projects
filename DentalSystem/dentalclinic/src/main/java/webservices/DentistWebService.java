package webservices;

import java.util.List;

import javax.jws.WebService;

import DAO.IDentistDAO;
import controller.DentistControllerImp;
import model.Dentist;

@WebService(endpointInterface="webservices.IWebServiceDentist")
public class DentistWebService implements IWebServiceDentist {

	private IDentistDAO dentistController;
	
	@Override
	public void AddDentist(Dentist newDentist) {
		dentistController.AddDentist(newDentist);
	}

	@Override
	public Dentist getDentisttByDentistId(int dentistId) {
		DentistControllerImp dentistcontroller = new DentistControllerImp();
		
		return dentistcontroller.getDentistByDentistId(dentistId);
		
	}

	@Override
	public List<Dentist> getAllDentist() {
		DentistControllerImp dentistcontroller = new DentistControllerImp();
		return dentistcontroller.getAllDentist();
	}

	@Override
	public void EditDentist(Dentist dentist) {
		
		dentistController.EditDentist(dentist);
	}

	@Override
	public List<Dentist> getAllDentistByBranchId(int branchId) {
		DentistControllerImp dentistcontroller = new DentistControllerImp();
		return dentistcontroller.getAllDentistByBranchId(branchId);
	}

}

