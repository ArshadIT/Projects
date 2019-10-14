package controller;

import DAO.ILoginAsReceptionistDAO;
import DAO.LoginAsReceptionistDAO;
import model.LoginAsReceptionist;
import model.Receptionist;

public class LoginAsReceptionistController implements ILoginAsReceptionistDAO {

	private ILoginAsReceptionistController loginAsReceptionistController;
	
	
	@Override
	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		ILoginAsReceptionistDAO receptionistLogin = new LoginAsReceptionistDAO();
		
		return receptionistLogin.getPasswordByReceptionistId(receptionistId);
	}

	@Override
	public Receptionist getReceptionistByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		if(getPasswordByReceptionistId(receptionistId)!=null)
		{
			ILoginAsReceptionistDAO receptionist = new LoginAsReceptionistDAO();
			return receptionist.getReceptionistByReceptionistId(receptionistId);
		}else
		{
			return null;
		}
	}

}
