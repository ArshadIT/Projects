package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;
import model.Schedule;
import model.Schedule;

public class ScheduleDAO implements IScheduleDAO{
	private DatabaseConnection dbconn;
	
	public ScheduleDAO()
	{
		dbconn = new DatabaseConnection();
	}

	@Override
	public void AddSchedule(Schedule Schedule) {
		String sql = "INSERT INTO \"DentalClinic\".Schedule VALUES(DEFAULT,'" + Schedule.getDate() + "','" + Schedule.getTime() + "');";

		dbconn.WriteData(sql);
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		String sql = "UPDATE \"DentalClinic\".Schedule SET date='"+schedule.getDate()+"', time='"+schedule.getTime()+"' where TimeDateID =" + schedule.getDateAndTimeId()+ ";";

		dbconn.WriteData(sql);

	}

	
	public List<Schedule> getAllSchedule() {
		List<Schedule> ScheduleList = new ArrayList<Schedule>();
		String sql = "SELECT * FROM \"DentalClinic\".Schedule;";

		ResultSet rs = dbconn.retriveData(sql);
		
		try {
			while (rs.next()) {
				int DateAndTimeID = rs.getInt("TimeDateID");
				java.util.Date Date = rs.getDate("Date");
				java.util.Date Time = rs.getTime("Time");
				
				
				ScheduleList.add( new Schedule(DateAndTimeID, Date, Time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ScheduleList;
	}
	
	@Override
	public Schedule getScheduleByID(int DateAndTimeId) {
		Schedule tempSchedule = null;
		String sql = "select * from \"DentalClinic\".Schedule where timedateID=" + DateAndTimeId + ";";
		
		ResultSet rs = dbconn.retriveData(sql);
		try {
			while (rs.next()) {
				int DateAndTimeID = rs.getInt("DateAndTimeID");
				java.sql.Date Date = rs.getDate("Date");
				java.sql.Time Time = rs.getTime("Time");
				
			
				tempSchedule = (new Schedule(DateAndTimeID, Date, Time));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return tempSchedule;
	}

	
}
