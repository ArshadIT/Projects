package controller;

import java.util.List;

import DAO.IScheduleDAO;
import DAO.ScheduleDAO;
import model.Schedule;

public class ScheduleControllerimp  implements IScheduleController{
	private IScheduleDAO schDao;
	
	public ScheduleControllerimp() {
		schDao = new ScheduleDAO();
		
		
	}

	@Override
	public void AddSchedule(Schedule Schedule) {
		
		schDao.AddSchedule(Schedule);
	
	}

	@Override
	public Schedule getScheduleByID(int DateAndTimeID) {
		// TODO Auto-generated method stub
		return schDao.getScheduleByID(DateAndTimeID);
	}

	@Override
	public void updateSchedule(Schedule Schedule) {
		schDao.updateSchedule(Schedule);
		
	}

	

	@Override
	public List<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return schDao.getAllSchedule();
	}
}
