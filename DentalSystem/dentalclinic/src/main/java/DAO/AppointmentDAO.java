package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import model.Dentist;

public class AppointmentDAO implements IAppointmentDAO {
	private DatabaseConnection dbconn;

	public AppointmentDAO() {
		dbconn = new DatabaseConnection();
	}

	
	@Override
	public void AddAppointment(Appointment appointment) {
		String sql = "INSERT INTO \"DentalClinic\".appointment VALUES(DEFAULT,'" + appointment.getDate() + "','" + appointment.getTime() + "',"
				+ appointment.getDentistId() + "," + appointment.getBranchID() + ",'" + appointment.getCprNo() + "');";

		dbconn.WriteData(sql);
	}

	@Override
	public void deleteAppointment(int appointmentId) {
		String sql = "Delete from \"DentalClinic\".appointment where appointmentId =" + appointmentId + ";";

		dbconn.WriteData(sql);

	}
	
	

	@Override
	public void EditAppointment(Appointment appointment) {
		String sql = "UPDATE \"DentalClinic\".appointment SET  date="+ appointment.getDate()+ ", time ="+ appointment.getTime() + ", dentistid ="+ appointment.getDentistId() +"  where appointmentId = "+appointment.getAppointmentID()+ ";";

		dbconn.WriteData(sql);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> AppointmentList = new ArrayList<Appointment>();
		String sql = "SELECT * FROM \"DentalClinic\".appointment;";

		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while (rs.next()) {
				int appointmentID = rs.getInt("appointmentid");
				int dentistId = rs.getInt("dentistid");
				String date =rs.getString("date");
				String time =rs.getString("time");
				//int DateAndTimeID = rs.getInt("date");
				String cprNo= rs.getString("cprno");
				int branchId = rs.getInt("branchid");
				
				
				AppointmentList.add( new Appointment(appointmentID,  dentistId,date, time, cprNo, branchId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AppointmentList;
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		Appointment tempAppointment = null;
		String sql = "select * from \"DentalClinic\".appointment where appointmentid=" + appointmentId + ";";
		
		ResultSet rs = dbconn.retriveData(sql);
		try {
			while (rs.next()) {
				int appointmentID = rs.getInt("appointmentid");
				int dentistId = rs.getInt("dentistid");
				String date =rs.getString("date");
				String time =rs.getString("time");
				//int DateAndTimeID = rs.getInt("timedateid");
				String cprNo= rs.getString("cprno");
				int branchId = rs.getInt("branchid");
				
			
				tempAppointment = (new Appointment(appointmentID, dentistId, date, time, cprNo, branchId));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return tempAppointment;
	}

	@Override
	public List<Appointment> getAppointmentByDentistId(int dentist) {
		List<Appointment> AppointmentList = new ArrayList<Appointment>();
		String sql = "SELECT * FROM \"DentalClinic\".appointment where dentistid="+ dentist+";";

		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while (rs.next()) {
				int appointmentID = rs.getInt("appointmentid");
				int dentistId = rs.getInt("dentistid");
				String date =rs.getString("date");
				String time =rs.getString("time");
				String cprNo= rs.getString("cprno");
				int branchId = rs.getInt("branchid");
				
				
				AppointmentList.add( new Appointment(appointmentID, dentistId, date, time, cprNo, branchId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AppointmentList;
	}

	@Override
	public List<Appointment> getAppointmentByCprNo(String CprNo) {
		List<Appointment> AppointmentList = new ArrayList<Appointment>();
		String sql = "SELECT * FROM \"DentalClinic\".appointment where cprno='"+CprNo+"';";

		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while (rs.next()) {
				int appointmentID = rs.getInt("appointmentid");
				int dentistId = rs.getInt("dentistid");
				String date =rs.getString("date");
				String time =rs.getString("time");
				String cprNo= rs.getString("cprno");
				int branchId = rs.getInt("branchid");
				
				
				AppointmentList.add( new Appointment(appointmentID, dentistId, date, time, cprNo, branchId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AppointmentList;
	}


	
	}
