package controller;

import java.util.List;

import model.Dentist;

public interface IDentistController {

	public void AddDentist(Dentist newDentist);
	public Dentist getDentistByDentistId(int Id);
	public List <Dentist> getAllDentistByBranchId(int branchId);
	public List <Dentist> getAllDentist();
	public void RemoveDentistById(int id); 
}