
	import javax.swing.*;
	import javax.swing.event.DocumentEvent;
	import javax.swing.event.MouseInputAdapter;
	import javax.swing.table.*;
	import java.awt.*;
	import java.awt.event.*;

	public class InstructorGUI extends JFrame {

	    private Adapter adapter;
	    private LoadButtonListener lbuttonListener;
	    private GetRowData ro;
	    private SaveRowData sro;
	    private SaveTableData stb;
	    private AddNewInstructor instr;
	    private RemoveInstructor del;
	   

	    private JTable instructorTable;
	    private String[] columnNames;
	    private DefaultTableModel dtm;
	    
	    private JScrollPane instructorScrollPane;
	    private JPanel btnPanel, textFieldsPanel;
	    private JButton loadButton, saveButton, saveToFile, addNewInstructor, deleteInstructor, search;

	    private JTextField name, address,skills, telNr, email,srchf;
	    private JLabel lab;
	    
	    public InstructorGUI(Adapter adapter) {
	    	super("Instructor");
	    	this.adapter = adapter;
	    	lbuttonListener = new LoadButtonListener();
	    	ro = new GetRowData();
	        sro = new SaveRowData();
	        stb = new SaveTableData();
	       instr = new AddNewInstructor();
	        del = new RemoveInstructor();
	        
	        btnPanel = new JPanel();
	        textFieldsPanel = new JPanel();

	        columnNames = new String[5];
	        columnNames[0] = "Name";
	        columnNames[1] = "Address";
	        columnNames[2] = "Skills";
	        columnNames[3] = "tel Numnber";
	        columnNames[4] = "Email";
	        
	        dtm = new DefaultTableModel(columnNames, 0);
	        //rowSorter = new TableRowSorter<TableModel>(dtm);
	        setLayout(new BorderLayout());

	        instructorTable = new JTable(dtm);
	        instructorTable.getTableHeader().setReorderingAllowed(false);
	        instructorTable.getTableHeader().setResizingAllowed(false);
	        instructorTable.setPreferredScrollableViewportSize(new Dimension(500, instructorTable.getRowHeight()));
	        
	        instructorScrollPane = new JScrollPane(instructorTable);
	        instructorScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        add(instructorScrollPane, BorderLayout.CENTER);
            lab = new JLabel("Name");
	       name = new JTextField("           ");
	        address = new JTextField("            ");
	        telNr = new JTextField("             ");
	        skills = new JTextField("             ");
	        email = new JTextField("              ");
	        //srchf = new JTextField("                   ");
	        
	        saveButton = new JButton("Save Edits");
	        saveButton.addActionListener(sro);
	        
	        loadButton = new JButton("Load All Instructor");
	        loadButton.addActionListener(lbuttonListener);

	        saveToFile = new JButton("Save To File");
	        saveToFile.addActionListener(stb);

	        addNewInstructor = new JButton("Add New Instructor");
	       addNewInstructor.addActionListener(instr);

	        deleteInstructor = new JButton("Delete Instructor");
	        deleteInstructor.addActionListener(del);
	        
	        add(btnPanel, BorderLayout.SOUTH);

	        btnPanel.add(textFieldsPanel, BorderLayout.WEST);
	        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));

	        textFieldsPanel.add(name);
	        textFieldsPanel.add(address);
	        textFieldsPanel.add(skills);
	        textFieldsPanel.add(telNr);
	        textFieldsPanel.add(email);
	        

	        btnPanel.add(loadButton, BorderLayout.EAST);
	        btnPanel.add(saveButton, BorderLayout.EAST);
	        btnPanel.add(saveToFile, BorderLayout.EAST);
	        btnPanel.add(addNewInstructor, BorderLayout.EAST);
	        btnPanel.add(deleteInstructor, BorderLayout.EAST);
	        //btnPanel.add(search, BorderLayout.NORTH);
	        //btnPanel.add(srchf, BorderLayout.NORTH);

	        instructorScrollPane.setVisible(true);


	        setSize(1000, 800);
	        setVisible(true);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);


	        instructorTable.addMouseListener(ro);
	        
	    }

	    public void updateInstructorTable() {

	        InstructorList inst = adapter.getAllInstructors();
	        Object[][] data = new Object[inst.size()][5];

	        for (int i = 0; i < inst.size(); i++) {
	            data[i][0] = inst.get(i).getName();
	            data[i][1] = inst.get(i).getAddress();
	            data[i][2] = inst.get(i).getSkills();
	            data[i][3] = inst.get(i).getTelNumber();
	            data[i][4] = inst.get(i).getEmail();
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
	        instructorTable.setModel(dtm);


	    }
	    
	    private class LoadButtonListener implements ActionListener {

	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == loadButton) {

	                updateInstructorTable();
	            }
	        }
	    }


	    private class GetRowData extends MouseAdapter {

	        @Override
	        public void mouseClicked(MouseEvent e) {

	            if (e.getSource() == instructorTable) {

	                int i = instructorTable.getSelectedRow();

	                name.setText(instructorTable.getValueAt(i, 0).toString());
	                address.setText(instructorTable.getValueAt(i, 1).toString());
	                skills.setText(instructorTable.getValueAt(i, 2).toString());
	                telNr.setText(instructorTable.getValueAt(i, 3).toString());
	                email.setText(instructorTable.getValueAt(i, 4).toString());




	            }
	        }
	    }
	    
	    
	    private class SaveRowData implements ActionListener{

	        public void actionPerformed(ActionEvent e) {

	            try {
	                if (e.getSource() == saveButton) {

	                    int i = instructorTable.getSelectedRow();

	                    instructorTable.setValueAt(name.getText(), i, 0);
	                    instructorTable.setValueAt(address.getText(), i, 1);
	                    instructorTable.setValueAt(skills.getText(), i, 2);
	                    instructorTable.setValueAt(telNr.getText(), i, 3);
	                    instructorTable.setValueAt(email.getText(), i, 4);

	                }
	            } catch (ArrayIndexOutOfBoundsException i){
	                    JOptionPane.showMessageDialog(null, "Please Select a Instructor", "Error", JOptionPane.ERROR_MESSAGE);

	                }
	            }

	    }

	    
	    private class SaveTableData implements ActionListener {

	        public void actionPerformed(ActionEvent e) {

	            if (e.getSource() == saveToFile) {


	                InstructorList temp = new InstructorList();

	                for (int i = 0; i < instructorTable.getRowCount(); i++) {

	                    Object o1 = instructorTable.getValueAt(i, 0);
	                    Object o2 = instructorTable.getValueAt(i, 1);
	                    Object o3 = instructorTable.getValueAt(i, 2);
	                    Object o4 = instructorTable.getValueAt(i, 3);
	                    Object o5 = instructorTable.getValueAt(i, 4);

	                    temp.addInstructor(new Instructor(o1.toString(), o2.toString(), o3.toString(), o4.toString(), o5.toString()));
	                    

	                }

	                adapter.saveInstructors(temp);

	            }


	        }


	    }

	    public class AddNewInstructor implements ActionListener {

	        public void actionPerformed(ActionEvent e) {

	            if (e.getSource() == addNewInstructor) {


	                String name = JOptionPane.showInputDialog(null, "Instructor Name:", "Add New Instructor", JOptionPane.QUESTION_MESSAGE);
	                String address = JOptionPane.showInputDialog(null, "Address:", "Add New Address", JOptionPane.QUESTION_MESSAGE);
	                String skills = JOptionPane.showInputDialog(null, "Skills:", "Add New Skills ", JOptionPane.QUESTION_MESSAGE);
	                String telNr = JOptionPane.showInputDialog(null, "Telephone Number:", "Add New Telephone", JOptionPane.QUESTION_MESSAGE);
	                String email = JOptionPane.showInputDialog(null, "Email:", "Add New Email", JOptionPane.QUESTION_MESSAGE);

	                Instructor temp = new Instructor(name, address, skills, telNr,email);


	                InstructorList tempList = adapter.getAllInstructors();
	                tempList.addInstructor(temp);
	                adapter.saveInstructors(tempList);
	                updateInstructorTable();


	            }

	        }
	    }

	    public class RemoveInstructor implements ActionListener {

	        public void actionPerformed(ActionEvent e){

	           if(e.getSource() == deleteInstructor){

	               String name = JOptionPane.showInputDialog(null, "Member's Name:", "Remove Instructor", JOptionPane.WARNING_MESSAGE);

	               InstructorList tempList = adapter.getAllInstructors();

	               Instructor temp = tempList.getInstructorByName(name);

	               tempList.removeInstructor(temp);

	               adapter.saveInstructors(tempList);
	               updateInstructorTable();

	           }


	        }

	    }


	    public static void main(String[] args) {
	        Adapter a = new Adapter("instructor.bin");
	        InstructorGUI test= new InstructorGUI(a);
	    }

	    
	    
	    
	    
	}



	
	
	
	
	
