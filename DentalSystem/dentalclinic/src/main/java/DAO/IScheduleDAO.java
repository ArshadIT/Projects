package DAO;

import java.util.List;

import model.Schedule;

public interface IScheduleDAO {
		
		public void AddSchedule(Schedule Schedule);
		
		public Schedule getScheduleByID(int DateAndTimeID);
		
		public void updateSchedule(Schedule Schedule);
		
		public List<Schedule> getAllSchedule();

}
