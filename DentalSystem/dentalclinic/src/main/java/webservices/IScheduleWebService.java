package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Schedule;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface IScheduleWebService {

	@WebMethod
	public void AddSchedule(Schedule Schedule);
	@WebMethod
	public Schedule getScheduleByID(int DateAndTimeID);
	
	@WebMethod
	public List<Schedule> getAllSchedule();
	@WebMethod
	public void updateSchedule(Schedule Schedule);
}
