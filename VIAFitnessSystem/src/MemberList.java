

import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable {

	private ArrayList<Member> memberList;
	
	public MemberList() {
		
		memberList = new ArrayList<Member>();
	}
	public void addMember(Member member) {
		memberList.add(member);
	}
	public void removeMember(Member member) {
		memberList.remove(member);
	}
	public ArrayList<Member> getListOfMember() {
		return memberList;
	}


	public Member getMemberByName(String name) {
		for(int i =0; i < memberList.size();i++) {
			if(memberList.get(i).getName().equals(name)) {
				return memberList.get(i);
			}
		}
		return null;
	}
	
		
	public Member editMember(String oldName, String newName) {
		Member member2 = getMemberByName(oldName);
		member2.setName(newName);
		return member2;
			
	}
	
	public int getTotalMember() {
		return memberList.size();
	}
	
	public String toString() {
		String s = " ";
		for(int i=0; i < memberList.size();i++) {
			s += memberList.get(i);
			s += "\n";
		}
		return s;
	}

	public Member get(int index){
		if(index <memberList.size()){
		    return memberList.get(index);
        } else {
		    return null;
        }
	}

	public void removeMember(int index){

			for(int i = 0; i<memberList.size(); i++){
				memberList.remove(i);
			}

	}


	public int size(){
	    return memberList.size();
    }
}
