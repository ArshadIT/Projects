package webservices;

import java.util.List;

import javax.jws.WebService;

import controller.IScheduleController;
import controller.ScheduleControllerimp;
import model.Schedule;

@WebService(endpointInterface = "webservices.IScheduleWebService")
public class ScheduleWebService implements IScheduleWebService {
	private IScheduleController schcon;

	public ScheduleWebService() {
		schcon = new ScheduleControllerimp();

	}
	
	@Override
	public void AddSchedule(Schedule Schedule) {
		schcon.AddSchedule(Schedule);
		
	}
	
	@Override
	public void updateSchedule(Schedule Schedule) {
		schcon.updateSchedule(Schedule);

	}

	@Override
	public Schedule getScheduleByID(int DateAndTimeID) {
		// TODO Auto-generated method stub
		return schcon.getScheduleByID(DateAndTimeID);
	}
	@Override
	public List<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return schcon.getAllSchedule();
	}

}
