package DAO;

import java.util.ArrayList;
import java.util.List;

import model.Patient;
import webservices.AppoinmentWebService;
import webservices.PatientWebService;

public class Test {

	public static void main(String[] args) {
		
		PatientDAO pp = new PatientDAO();
		List<Patient> hh = new ArrayList<Patient>();
//		System.out.println(pp.getPatientByCpr("23456-112"));
//		System.out.println(pp.getPatientByCpr("25446-142"));
//		System.out.println(hh.get(1));
		PatientWebService ser = new PatientWebService();
		System.out.println(ser.getAllPatientByCprNo());
		
		//System.out.println(pp.getPatientByCpr("23456-162"));
		AppoinmentWebService ggg = new AppoinmentWebService();
		//ggg.AddAppointment();
		System.out.println();
	}

}
