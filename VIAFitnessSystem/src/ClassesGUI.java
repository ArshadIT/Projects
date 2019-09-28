import javax.swing.*;
	import javax.swing.event.DocumentEvent;
	import javax.swing.event.MouseInputAdapter;
	import javax.swing.table.*;

	import java.awt.*;
	import java.awt.event.*;

	public class ClassesGUI extends JFrame {

	    private Adapter adapter , adapter1 ;
	    
	    private LoadButtonListener lbuttonListener;
	    private GetRowData ro;
	    private SaveRowData sro;
	    private SaveTableData stb;
	    private AddNewClasses clas;
	    private RemoveClasses del;
	    private AddMemberToClass addMC;
	   

	    private JTable classesTable;
	    private String[] columnNames;
	    private DefaultTableModel dtm;
	    
	    private JScrollPane classesScrollPane;
	    private JPanel btnPanel, textFieldsPanel;
	    private JButton loadButton, saveButton, saveToFile, addNewClass, deleteClass, search, addMember;
 
	    private JTextField name, date, maxPaticipants, instructor ,duration, startTime, endTime,srchf;

	    public ClassesGUI(Adapter adapter, Adapter adapter1) {
	    	super("Classes");
	    	this.adapter = adapter;
	    	this.adapter1 =adapter1;
	    	
	    	lbuttonListener = new LoadButtonListener();
	    	ro = new GetRowData();
	        sro = new SaveRowData();
	        stb = new SaveTableData();
	       clas = new AddNewClasses();
	        del = new RemoveClasses();
	        addMC = new AddMemberToClass();
	        btnPanel = new JPanel();
	        textFieldsPanel = new JPanel();

	        columnNames = new String[7];
	        columnNames[0] = "Name";
	        columnNames[1] = "Date";
	        columnNames[2] = "Instructor";
	        columnNames[3] = "Max Partipants";
	        columnNames[4] = "Duration";
	        columnNames[5] = "StartTime";
	        columnNames[6] = "EndTime";
	        dtm = new DefaultTableModel(columnNames, 0);
	   
	        setLayout(new BorderLayout());

	        classesTable = new JTable(dtm);
	        classesTable.getTableHeader().setReorderingAllowed(false);
	        classesTable.getTableHeader().setResizingAllowed(false);
	        classesTable.setPreferredScrollableViewportSize(new Dimension(500, classesTable.getRowHeight()));
	        
	        classesScrollPane = new JScrollPane(classesTable);
	        classesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        add(classesScrollPane, BorderLayout.CENTER);
	    
	        name = new JTextField("           ");
	        date = new JTextField("            ");
	        instructor = new JTextField("             ");
	        maxPaticipants = new JTextField("             ");
	        duration = new JTextField("              ");
	        startTime = new JTextField("              ");
	        endTime= new JTextField("              ");
	        //srchf = new JTextField("                   ");
	    
	        saveButton = new JButton("Save Edits");
	        saveButton.addActionListener(sro);
	        
	        loadButton = new JButton("Load All Classes");
	        loadButton.addActionListener(lbuttonListener);

	        saveToFile = new JButton("Save To File");
	        saveToFile.addActionListener(stb);

	        addNewClass = new JButton("Add New Class");
	        addNewClass.addActionListener(clas);

	        deleteClass = new JButton("Delete Class");
	        deleteClass.addActionListener(del);
	        
	        addMember = new JButton("Add Member To Class");
	        addMember.addActionListener(addMC);
	        
	        
	        
	        
	        
	        add(btnPanel, BorderLayout.SOUTH);

	        btnPanel.add(textFieldsPanel, BorderLayout.WEST);
	        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));
	        textFieldsPanel.add(name);
	        textFieldsPanel.add(date);
	        textFieldsPanel.add(instructor);
	        textFieldsPanel.add(maxPaticipants);
	        textFieldsPanel.add(duration);
	        textFieldsPanel.add(startTime);
	        textFieldsPanel.add(endTime);
	        

	        btnPanel.add(loadButton, BorderLayout.EAST);
	        btnPanel.add(saveButton, BorderLayout.EAST);
	        btnPanel.add(saveToFile, BorderLayout.EAST);
	        btnPanel.add(addNewClass, BorderLayout.EAST);
	        btnPanel.add(deleteClass, BorderLayout.EAST);
	        btnPanel.add(addMember, BorderLayout.EAST);
	        
	        classesScrollPane.setVisible(true);


	        setSize(1000, 800);
	        setVisible(true);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);


	        classesTable.addMouseListener(ro);
	        
	    }

	    public void updateClassesTable() {

	        ClassesList clas = adapter1.getAllClasses();
	        Object[][] data = new Object[clas.size()][7];

	        for (int i = 0; i < clas.size(); i++) {
	            data[i][0] = clas.get(i).getName();
	            data[i][1] = clas.get(i).getDate();
	            data[i][2] = clas.get(i).getInstructorName();
	            data[i][3] = clas.get(i).getMaxParticipant();
	            data[i][4] = clas.get(i).getDuration();
	            data[i][5] = clas.get(i).getStartTime();
	            data[i][6] = clas.get(i).getEndTime();
	        }

	        dtm = new DefaultTableModel(data, columnNames);  /*{
	            public Class getColumnsClass(int columns){
	                Class returnValue;
	                if((columns >= 0)&&(columns < getColumnCount())){
	                    returnValue = getValueAt(0, columns).getClass();
	                }else {
	                    returnValue=Object.class;
	                }
	                return returnValue;
	            }

	        };*/
	        classesTable.setModel(dtm);


	    }
	    private class LoadButtonListener implements ActionListener {

	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == loadButton) {

	                updateClassesTable();
	            }
	        }
	    }
	    
	    private class GetRowData extends MouseAdapter {

	        @Override
	        public void mouseClicked(MouseEvent e) {

	            if (e.getSource() == classesTable) {

	                int i = classesTable.getSelectedRow();

	                name.setText(classesTable.getValueAt(i, 0).toString());
	                date.setText(classesTable.getValueAt(i, 1).toString());
	                instructor.setText(classesTable.getValueAt(i, 2).toString());
	                maxPaticipants.setText(classesTable.getValueAt(i, 3).toString());
	                duration.setText(classesTable.getValueAt(i, 4).toString());
	                startTime.setText(classesTable.getValueAt(i, 5).toString());
	                endTime.setText(classesTable.getValueAt(i, 6).toString());


	            }
	        }
	    }
	    private class SaveRowData implements ActionListener{

	        public void actionPerformed(ActionEvent e) {

	            try {
	                if (e.getSource() == saveButton) {

	                    int i = classesTable.getSelectedRow();

	                    name.setText(classesTable.getValueAt(i, 0).toString());
		                date.setText(classesTable.getValueAt(i, 1).toString());
		                instructor.setText(classesTable.getValueAt(i, 2).toString());
		                maxPaticipants.setText(classesTable.getValueAt(i, 3).toString());
		                duration.setText(classesTable.getValueAt(i, 4).toString());
		                startTime.setText(classesTable.getValueAt(i, 5).toString());
		                endTime.setText(classesTable.getValueAt(i, 6).toString());

	                }
	            } catch (ArrayIndexOutOfBoundsException i){
	                    JOptionPane.showMessageDialog(null, "Please Select a Class", "Error", JOptionPane.ERROR_MESSAGE);

	                }
	            }

	    }
	    
	    private class SaveTableData implements ActionListener {

	        public void actionPerformed(ActionEvent e) {

	            if (e.getSource() == saveToFile) {


	                ClassesList temp = new ClassesList();

	                for (int i = 0; i < classesTable.getRowCount(); i++) {

	                    Object o1 = classesTable.getValueAt(i, 0);
	                    Object o2 = classesTable.getValueAt(i, 1);
	                    Object o3 = classesTable.getValueAt(i, 2);
	                    Object o4 = classesTable.getValueAt(i, 3);
	                    Object o5 = classesTable.getValueAt(i, 4);
	                    Object o6 = classesTable.getValueAt(i, 5);
	                    Object o7 = classesTable.getValueAt(i, 6);

	                  //  temp.addClasses( new Classes(o1.toString(),o2.toString(),o3.toString(),o4.toString(), o5.toString(),o6.toString(),o7.toString()));
	                    

	                }

	                adapter.saveClasses(temp);

	            }


	        }


	    }
	    
	    public class AddNewClasses implements ActionListener {

	        public void actionPerformed(ActionEvent e) {

	            if (e.getSource() == addNewClass) {

	            	InstructorList temp1 = adapter.getAllInstructors();
	            	Object[] selectionValue = temp1.getListOfInstructor().toArray();
	            	String initialSelection = null;
	            	
	                String name = JOptionPane.showInputDialog(null, "Class Name:", "Add New Class", JOptionPane.QUESTION_MESSAGE);
	                String date = JOptionPane.showInputDialog(null, "Date:", "Add New date", JOptionPane.QUESTION_MESSAGE);
	                
	                Object instructor = JOptionPane.showInputDialog(null, "Select an instructor", "Add New instructor", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelection);
	                String maxParticipants = JOptionPane.showInputDialog(null, "maxParticipants:", "Add New participant", JOptionPane.QUESTION_MESSAGE);
	                String duration = JOptionPane.showInputDialog(null, "Duration:", "Add New Duration", JOptionPane.QUESTION_MESSAGE);
	                String startTime = JOptionPane.showInputDialog(null, "Start Time:", "Add New StartTime", JOptionPane.QUESTION_MESSAGE);
	                String endTime= JOptionPane.showInputDialog(null, "End Time:", "Add New EndTime", JOptionPane.QUESTION_MESSAGE);
	                
	                
	                
	                Classes temp = new Classes(name, date,(Instructor)instructor, maxParticipants, duration,startTime, endTime);


	                ClassesList tempList = adapter1.getAllClasses();
	                tempList.addClasses(temp);
	                adapter1.saveClasses(tempList);
	                updateClassesTable();


	            }

	        }
	    }

	    public class RemoveClasses implements ActionListener {

	        public void actionPerformed(ActionEvent e){

	           if(e.getSource() == deleteClass){

	               String name = JOptionPane.showInputDialog(null, "Class Name:", "Remove Classess", JOptionPane.WARNING_MESSAGE);

	               ClassesList tempList = adapter.getAllClasses();

	               Classes temp = tempList.getClassesByName(name);

	               tempList.removeClasses(temp);

	               adapter.saveClasses(tempList);
	               updateClassesTable();

	           }


	        }

	    }

	    
	    
	    
	    public class AddMemberToClass implements ActionListener {

	        public void actionPerformed(ActionEvent e){

	           if(e.getSource() == addMember){
	        	   
	        	   
	        	   
	               String name = JOptionPane.showInputDialog(null, "Member Name:", "Add Member to Class", JOptionPane.WARNING_MESSAGE);

	               MemberList tempList1 = adapter.getAllMembers();
	               
	               MemberList tempList2 = new MemberList();

	               Member tempM = tempList1.getMemberByName(name);

	               tempList2.addMember(tempM);
	               
	               ClassesList tempClasses =  adapter.getAllClasses();

	               
	               int i = classesTable.getSelectedRow();

	               String name1 = classesTable.getValueAt(i, 0).toString();
	                String date = classesTable.getValueAt(i, 1).toString();
	               Object instructor=classesTable.getValueAt(i, 2);
	               String maxParticipants=classesTable.getValueAt(i, 3).toString();
	               String  duration =classesTable.getValueAt(i, 4).toString();
	               String startTime =classesTable.getValueAt(i, 5).toString();
	               String endTime =classesTable.getValueAt(i, 6).toString();
	               
	               
	              
	               Classes tempClass = new Classes(name1, date, (Instructor)instructor, maxParticipants, duration, startTime, endTime);
	               
	               tempClass.addMemberToClasses(tempM);
	               
	               
	               if(tempClass.equals(tempClasses.get(i))) {
	            	   
	            	   tempClass = tempClasses.get(i);
	            	   
	            	   tempClasses.addClasses(tempClass);
	               }
	               
	               adapter.saveClasses(tempClasses);
	               

	           }

	    }
	    }
	        
	    public static void main(String[] args) {
	        Adapter a = new Adapter("instructor.bin");
	        Adapter a1 = new Adapter("classes1.bin");
	        
	        ClassesGUI test= new ClassesGUI(a,a1);
	    }

	    

	        
	        
	        
	}