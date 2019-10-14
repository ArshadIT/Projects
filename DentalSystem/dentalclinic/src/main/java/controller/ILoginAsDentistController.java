package controller;

import model.Dentist;
import model.LoginAsDentist;

public interface ILoginAsDentistController {

	public LoginAsDentist getPasswordByDentistId(int dentistId);
	
	public Dentist getDentistByDentistId(int dentistId);
}
