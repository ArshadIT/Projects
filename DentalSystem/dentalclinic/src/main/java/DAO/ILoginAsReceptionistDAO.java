package DAO;

import model.LoginAsReceptionist;
import model.Receptionist;

public interface ILoginAsReceptionistDAO {

	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId);
	
	public Receptionist getReceptionistByReceptionistId(int receptionistId);
}
