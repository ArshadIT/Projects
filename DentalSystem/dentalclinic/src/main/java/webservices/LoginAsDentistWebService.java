package webservices;



import javax.jws.WebService;

import DAO.ILoginAsDentistDAO;
import controller.LoginAsDentistController;
import model.Dentist;
import model.LoginAsDentist;

@WebService(endpointInterface="webservices.IWebServiceLoginAsDentist")
public class LoginAsDentistWebService implements IWebServiceLoginAsDentist{

	private ILoginAsDentistDAO dentistDb;
	
	@Override
	public LoginAsDentist getPasswordByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		LoginAsDentistController dentistController = new LoginAsDentistController();
		return dentistController.getPasswordByDentistId(dentistId);
	}

	@Override
	public Dentist getDentistByDentistId(int dentistId) {
		// TODO Auto-generated method stub
		
		return dentistDb.getDentistByDentistId(dentistId);
	}

}
