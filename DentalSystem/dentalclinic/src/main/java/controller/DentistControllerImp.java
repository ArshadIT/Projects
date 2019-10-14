package controller;

import java.util.List;

import DAO.DentistDAO;
import DAO.IDentistDAO;
import model.Dentist;

public class DentistControllerImp implements IDentistController   {
private IDentistDAO dentist;
	public DentistControllerImp() {
		dentist = new DentistDAO();
	}

	@Override
	public void AddDentist(Dentist newDentist) {
		dentist.AddDentist(newDentist);
	}

	@Override
	public Dentist getDentistByDentistId(int Id) {

		return dentist.getDentist(Id);
	}

	@Override
	public List<Dentist> getAllDentistByBranchId(int branchId) {
		return  dentist.getAllDentistByBranchId(branchId);
	}

	@Override
	public List<Dentist> getAllDentist() {
		return dentist.getAllDentist();
	}

	@Override
	public void RemoveDentistById(int id) {
		dentist.RemoveDentist(id);
	}

}