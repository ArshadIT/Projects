

import java.io.Serializable;
import java.util.ArrayList;

public class InstructorList implements Serializable {

	private ArrayList<Instructor> instructorList;

	public InstructorList() {

		instructorList = new ArrayList<Instructor>();
	}

	public void addInstructor(Instructor instructor) {
		instructorList.add(instructor);
	}

	public void removeInstructor(Instructor instructor) {
		instructorList.remove(instructor);
	}

	public ArrayList<Instructor> getListOfInstructor() {
		return instructorList;
	}

	public String[] getAllInstructorName() {
		String[] temo = new String[instructorList.size()];
		for(int i=0; i< instructorList.size();i++) {
			temo[i] = instructorList.get(i).getName();
		}
		return temo;
	}
	public Instructor getInstructorByName(String name) {
		for (int i = 0; i < instructorList.size(); i++) {
			if (instructorList.get(i).getName().equals(name)) {
				return instructorList.get(i);
			}
		}
		return null;
	}

	public Instructor searchInstructorByName(String name) {
		Instructor instructor1 = getInstructorByName(name);
		return instructor1;
	}

	public Instructor editInstructor(String oldName, String newName) {
		Instructor instructor2 = getInstructorByName(oldName);
		instructor2.setName(newName);
		return instructor2;
	}
	
	public int getTotalInstructor() {
		return instructorList.size();
	}
	public String toString() {
		String s = "";
		for(int i=0; i < instructorList.size();i++) {
			s += instructorList.get(i);
			s += "\n";
		}
		return s;
	}

	public Instructor get(int index){
		if(index <instructorList.size()){
			return instructorList.get(index);
		} else {
			return null;
		}
	}

	public int size(){
		return instructorList.size();
	}
}
