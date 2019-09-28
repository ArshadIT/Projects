import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class InstructorGui1 extends JPanel {
   

/**
    * 
    */
   private static final long serialVersionUID = 1L;

   private Adapter adapter;
   private  Object[] columns = {"Name", "Address", "Skills", "Telephone", "Email"};
   private JFrame frame;
   private JTable table;
   private DefaultTableModel model;


public static void main(String[] args) {
   EventQueue.invokeLater(new Runnable() {
      public void run() {
         try {
            InstructorGui1 mem = new InstructorGui1();
            mem.setVisible(true);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   });
}
   public InstructorGui1() {
      setName("Instructor");
        // create JFrame and JTable
        frame = new JFrame();
        table = new JTable();
        adapter = new Adapter("Instructors.bin");
        // create a table model and set a Column Identifiers to this model 

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,14);
        table.setFont(font);
        table.setRowHeight(20);
        
// create JTextFields------------------------------
        JTextField textName = new JTextField();
        JTextField textAddress = new JTextField();
        JTextField textTelNumber = new JTextField();
        JTextField textSkills = new JTextField();
        JTextField textEmail = new JTextField();
        
        textName.setBounds(200, 220, 100, 25);
        textAddress.setBounds(200, 250, 100, 25);
        textTelNumber.setBounds(200, 280, 100, 25);
        textSkills.setBounds(200, 310, 100, 25);
        textEmail.setBounds(200, 340, 100, 25);
        
        
// creating JButtons-----------------------------------
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnEdit = new JButton("Edit"); 
        JButton btnreturn = new JButton("Return");
        
        btnAdd.setBounds(400, 220, 100, 25);
        btnEdit.setBounds(400, 280, 100, 25);
        btnDelete.setBounds(400, 335, 100, 25);
        btnreturn.setBounds(600, 335, 200, 25);

        
// creating JLabel -----------------------------------        
        
        JLabel Name = new JLabel("Name");
        JLabel Address = new JLabel("Address");
        JLabel TelNumber = new JLabel("TelNumber");
        JLabel Skills = new JLabel("Skills");
        JLabel Email = new JLabel("Email");
        
        Name.setBounds(50, 220, 100, 25);
        Address.setBounds(50, 250, 100, 25);
        TelNumber.setBounds(50, 280, 100, 25);
        Skills.setBounds(50, 310, 100, 25);
        Email.setBounds(50, 340, 100, 25);
        
        frame.add(Name);
        frame.add(Address);
        frame.add(TelNumber);
        frame.add(Skills);
        frame.add(Email);
       
    
               
// creating JScrollPane ---------------------------------
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        frame.add(pane);
        
// adding JTextFields to the jframe --------------------------
        frame.add(textName);
        frame.add(textAddress);
        frame.add(textTelNumber);
        frame.add(textSkills);
        frame.add(textEmail);
    
        
// adding JButtons to the jframe------------------------------
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnEdit);
        frame.add(btnreturn);
        
        
// creating an array of objects to set the row data
        Object[] row = new Object[5];
        
// button add row----------------------------------------------
        btnAdd.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {

            Instructor instr = new Instructor(textName.getText(), textAddress.getText(), textSkills.getText(), textTelNumber.getText(), textEmail.getText());


                // add row to the model
                model.addRow(row);
            }
        });
        
// button remove row ---------------------------------------
        btnDelete.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
        int i = table.getSelectedRow();
        if(i >= 0){
// remove a row from jtable -------------------------------
        model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
// get selected row data From table to textfields ---------- 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textName.setText(model.getValueAt(i, 0).toString());
            textAddress.setText(model.getValueAt(i, 1).toString());
            textTelNumber.setText(model.getValueAt(i, 2).toString());
            textSkills.setText(model.getValueAt(i, 3).toString());
            textEmail.setText(model.getValueAt(i, 4).toString());
        }
        });
        
// button Edit row---------------------------------------------------
        btnEdit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
// i = the index of the selected row ----------------------------------
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textName.getText(), i, 0);
                   model.setValueAt(textAddress.getText(), i, 1);
                   model.setValueAt(textTelNumber.getText(), i, 2);
                   model.setValueAt(textSkills.getText(), i, 3);
                   model.setValueAt(textEmail.getText(), i, 4);
                }
                else{
                    System.out.println("Edit Error");
                }
            }
        });
        frame.setTitle("Instructor");
        frame.setSize(900,450);
        frame.setLocationRelativeTo(null);
        btnreturn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
           {
              frame.dispose();
           }
       });
        frame.setVisible(true);   

        updateInstructorBox();
    }

    public void updateInstructorBox(){
        InstructorList instructors = adapter.getAllInstructors();
        Object[][] data = new Object[instructors.size()][5];

        for(int i = 0; i<instructors.size(); i++){

            data[i][0] = instructors.get(i).getName();
            data[i][1] = instructors.get(i).getAddress();
            data[i][2] = instructors.get(i).getTelNumber();
            data[i][3] = instructors.get(i).getSkills();
            data[i][4] = instructors.get(i).getEmail();
        }

        model = new DefaultTableModel(data, columns);
        table.setModel(model);
    }



}
