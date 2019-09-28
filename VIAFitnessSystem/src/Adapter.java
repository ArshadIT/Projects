import java.io.FileNotFoundException;
import java.io.IOException;

public class Adapter {

    private String fileName;
    private FileIO mfio;
    private MemberList mList;
    private ClassesList cList;
    private InstructorList iList;
    private MemberList nMList;
    private InstructorList nIList;
    private ClassesList nCList;

    public Adapter(String fileName) {
        this.fileName=fileName;
        mfio = new FileIO();
        mList= new MemberList();
        cList = new ClassesList();
        iList = new InstructorList();
        nMList = new MemberList();
        nCList = new ClassesList();
        nIList = new InstructorList();
    }

    public MemberList getAllMembers(){

        try{
            mList = (MemberList)mfio.readObjectFromFile(fileName);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return mList;

    }

    public InstructorList getAllInstructors(){


        try{
            iList = (InstructorList) mfio.readObjectFromFile(fileName);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return iList;
    }

    public ClassesList getAllClasses(){


        try{
            cList = (ClassesList) mfio.readObjectFromFile(fileName);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return cList;
    }

    public MemberList getMembersBy( String byName){


        try{
            MemberList result = (MemberList)mfio.readObjectFromFile(fileName);
            for(int i = 0; i < result.size(); i++) {
                if(result.get(i).getName().equals(byName)){
                    nMList.addMember(result.get(i));
                }
            }

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return nMList;
    }

    public InstructorList getInstructorsBy( String byName){


        try{
            InstructorList result = (InstructorList) mfio.readObjectFromFile(fileName);
            for(int i = 0; i < result.size(); i++) {
                if(result.get(i).getName().equals(byName)){
                    nIList.addInstructor(result.get(i));
                }
            }

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return nIList;
    }

    public ClassesList getClassesBy( String byName){


        try{
            ClassesList result = (ClassesList) mfio.readObjectFromFile(fileName);
            for(int i = 0; i < result.size(); i++) {
                if(result.get(i).getName().equals(byName)){
                    nCList.addClasses(result.get(i));
                }
            }

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch(IOException e) {
            System.out.println("IO reading file.");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return nCList;
    }

    public void saveMembers(MemberList mList){
        try{
            mfio.writeToFile(fileName, mList);
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        } catch(IOException e) {
            System.out.println("IO Error writing to file.");
        }
    }

    public void saveInstructors(InstructorList iList){
        try{
            mfio.writeToFile(fileName, iList);
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        } catch(IOException e) {
            System.out.println("IO Error writing to file.");
        }
    }

    public void saveClasses(ClassesList cList){
        try{
            mfio.writeToFile(fileName, cList);
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        } catch(IOException e) {
            System.out.println("IO Error writing to file.");
        }
    }



}

