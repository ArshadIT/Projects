import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Classes implements Serializable {

	private String name;
	private String date;
	private String maxParticipants;
	private String duration;
	private String startTime;
	private String endTime;
	private ArrayList<Member> memberList;
	private Instructor instructor1;

	public Classes(String name, String date, Instructor instructor, String maxParticipants, String duration, String startTime, String endTime) {

		this.name = name;
		this.date = date;
		this.maxParticipants = maxParticipants;
		this.duration = duration;
		this.startTime = startTime;
		this.endTime = endTime;
		memberList = new ArrayList<>();
		this.instructor1 = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String  getMaxParticipant() {
		return maxParticipants;
	}

	public void setMaxParticipant(String maxParticipant) {
		this.maxParticipants = maxParticipant;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void addMemberToClasses(Member member) {
		memberList.add(member);
	}

	public void addIstructorToClasses(Instructor instructor) {
		this.instructor1 = instructor;
	}

	public String getInstructorName(){
	    return instructor1.getName();
    }

	public void removeMemberFromClass(Member member) {
		memberList.remove(member);
	}

	public void removeInstructorFromClass(Instructor instructor) {
		this.instructor1 = null;
	}

	public String toString() {

		return "Name: " + name + "  MaxParticipant: " + maxParticipants + " Duration: " + duration + " Start Time: "
				+ startTime + " End Time : " + endTime;
	}

	public boolean equals(Classes obj) {
		if (!(obj instanceof Classes)) {
			return false;
		}

		Classes other = (Classes) obj;

		return name.equals(other.name) && maxParticipants == other.maxParticipants && duration.equals(other.duration) && startTime.equals(other.startTime) && endTime.equals(other.endTime);
	}

}
