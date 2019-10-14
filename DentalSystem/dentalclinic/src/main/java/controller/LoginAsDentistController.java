package controller;

import DAO.ILoginAsDentistDAO;
import DAO.LoginAsDentistDAO;

import model.Dentist;
import model.LoginAsDentist;

public class LoginAsDentistController implements ILoginAsDentistDAO{

	
	private ILoginAsDentistController loginAsDentistController;
	
	@Override
	public LoginAsDentist getPasswordByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		ILoginAsDentistDAO dentistLogin = new LoginAsDentistDAO();
		
		return dentistLogin.getPasswordByDentistId(dentistId);
	}

	@Override
	public Dentist getDentistByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		if(getPasswordByDentistId(dentistId) != null)
		{
			ILoginAsDentistDAO dentist = new LoginAsDentistDAO();
			return dentist.getDentistByDentistId(dentistId);
		}else
		{
			return null;
		}
	}

}
