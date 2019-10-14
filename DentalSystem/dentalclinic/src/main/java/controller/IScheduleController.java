package controller;

import java.util.List;

import model.Schedule;

public interface IScheduleController {

	public void AddSchedule(Schedule Schedule);

	public Schedule getScheduleByID(int DateAndTimeID);

	public void updateSchedule(Schedule Schedule);

	public List<Schedule> getAllSchedule();

}
