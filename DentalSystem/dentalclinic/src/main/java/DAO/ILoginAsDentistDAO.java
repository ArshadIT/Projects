package DAO;

import model.Dentist;
import model.LoginAsDentist;

public interface ILoginAsDentistDAO {

	public LoginAsDentist getPasswordByDentistId(int dentistId);
	
	public Dentist getDentistByDentistId(int dentistId);
}
