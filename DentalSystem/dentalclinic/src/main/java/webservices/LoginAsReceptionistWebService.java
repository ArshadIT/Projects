package webservices;


import javax.jws.WebService;

import DAO.ILoginAsReceptionistDAO;
import controller.LoginAsReceptionistController;
import model.LoginAsReceptionist;
import model.Receptionist;

@WebService(endpointInterface="webservices.IWebServiceLoginAsReceptionist")
public class LoginAsReceptionistWebService implements IWebServiceLoginAsReceptionist{

	private ILoginAsReceptionistDAO receptionistDb;
	
	@Override
	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		LoginAsReceptionistController receptionistController = new LoginAsReceptionistController();
		return receptionistController.getPasswordByReceptionistId(receptionistId);
	}

	@Override
	public Receptionist getReceptionistByReceptionistId(int receptionistId) {
		// TODO Auto-generated method stub
		
		return receptionistDb.getReceptionistByReceptionistId(receptionistId);
	}

}
