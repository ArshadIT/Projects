

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ClassesList implements Serializable{

	private ArrayList<Classes> classesList;

	public ClassesList() {

		classesList = new ArrayList<Classes>();

	}

	public void addClasses(Classes classes) {
		classesList.add(classes);
	}

	public void removeClasses(Classes classes) {
		classesList.remove(classes);
	}

	public ArrayList<Classes> getListOfClasses() {
		return classesList;
	}

	public ClassesList searchByName(String name) {
		ClassesList list = new ClassesList();
		for (int i = 0; i < classesList.size(); i++) {
			if (classesList.get(i).getName().equals(name)) {
				list.addClasses(classesList.get(i));
			}
		}
		return list;

	}

	public Classes getClassesByName(String name) {
		for (int i = 0; i < classesList.size(); i++) {
			if (classesList.get(i).getName().equalsIgnoreCase(name)) {
				return classesList.get(i);
			}
		}
		return null;
	}

	public Classes editClasses(String oldName, String newName) {
		Classes newClass = getClassesByName(oldName);
		newClass.setName(newName);
		return newClass;

	}

	public String getInstructorName(int index) {
		return classesList.get(index).getInstructorName();
	}
	public Classes searchClassByName(String name) {

		Classes newClass1 = getClassesByName(name);
		return newClass1;
	}

	public int getTotalClases() {
		return classesList.size();
	}

	public String toString() {
		String all = "";
		for (int i = 0; i < classesList.size(); i++) {
			all += classesList.get(i);
			all += "\n";

		}
		return all;
	}


	public Classes get(int index){
		if(index <classesList.size()){
			return classesList.get(index);
		} else {
			return null;
		}
	}

	public int size(){
		return classesList.size();
	}
}
