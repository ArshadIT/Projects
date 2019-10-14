package controller;

import model.LoginAsReceptionist;
import model.Receptionist;

public interface ILoginAsReceptionistController
{

	public LoginAsReceptionist getPasswordByReceptionistId(int receptionistId);
	
	public Receptionist getReceptionistByReceptionistId(int receptionistId);
}
