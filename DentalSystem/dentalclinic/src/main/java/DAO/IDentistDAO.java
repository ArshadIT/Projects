package DAO;

import java.util.List;

import model.Dentist;

public interface IDentistDAO {
	public Dentist getDentist(int id);
	public List<Dentist>getAllDentistByBranchId(int branchId);
	public List<Dentist> getAllDentist();
	public void AddDentist(Dentist newDentist) ;
	public void RemoveDentist(int dentistId);
	public void EditDentist(Dentist dentist);
}

