import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ClassesGui1 extends JPanel {

   private static final long serialVersionUID = 1L;

   private Adapter adapter = new Adapter("Classes.bin");
   private  Object[] columns = {"Name","Date", "Instructor","MaxParticipants", "Duration","Start Date", "End Date"};
   private DefaultTableModel model;
   private JFrame frame;
   private JTable table;
   private JComboBox<Instructor> textInstr;

public static void main(String[] args) {
   EventQueue.invokeLater(new Runnable() {
      public void run() {
         try {
            ClassesGui1 mem = new ClassesGui1();
            mem.setVisible(true);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   });
}
   public ClassesGui1() {
      setName("Classes");

// create JFrame and JTable
        frame = new JFrame();
        table = new JTable();
      
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
        JTextField textDate = new JTextField();
        textInstr = new JComboBox<>();
        JTextField textMaxParticipants = new JTextField();
        JTextField textDuration = new JTextField();
        JTextField textStartTime = new JTextField();
        JTextField textEndTime = new JTextField();
        
        textName.setBounds(200, 220, 100, 25);
        textDate.setBounds(200, 250, 100, 25);
        textInstr.setBounds(200, 280, 100, 25);
        textMaxParticipants.setBounds(200, 310, 100, 25);
        textDuration.setBounds(200, 340, 100, 25);
        textStartTime.setBounds(200, 370, 100, 25);
        textEndTime.setBounds(200, 400, 100, 25);
        
        
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
        JLabel Date = new JLabel("Date");
        JLabel Instr = new JLabel("Instructor");
        JLabel MaxParticipants = new JLabel("MaxParticipants");
        JLabel Duration = new JLabel("Duration");
        JLabel StartTime = new JLabel("StarDate");
        JLabel EndTime = new JLabel("EndDate");
        
        Name.setBounds(50, 220, 100, 25);
        Date.setBounds(50, 250, 100, 25);
        Instr.setBounds(50, 280, 100, 25);
        MaxParticipants.setBounds(50, 310, 100, 25);
        Duration.setBounds(50, 340, 100, 25);
        StartTime.setBounds(50, 370, 100, 25);
        EndTime.setBounds(50, 400, 100, 25);
        
        frame.add(Name);
        frame.add(Date);
        frame.add(Instr);
        frame.add(MaxParticipants);
        frame.add(Duration);
        frame.add(StartTime);
        frame.add(EndTime);
    
               
// creating JScrollPane ---------------------------------
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        frame.add(pane);
        
// adding JTextFields to the jframe --------------------------
        frame.add(textName);
        frame.add(textDate);
        frame.add(textInstr);
        frame.add(textMaxParticipants);
        frame.add(textDuration);
        frame.add(textStartTime);
        frame.add(textEndTime);
    
        
// adding JButtons to the jframe------------------------------
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnEdit);
        frame.add(btnreturn);
        
        
// creating an array of objects to set the row data
        Object[] row = new Object[7];
        
// button add row----------------------------------------------
        btnAdd.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
             
           Classes  c1= new Classes(textName.getText(), textDate.getText(), (Instructor)textInstr.getSelectedItem(), textMaxParticipants.toString(), textDuration.getText(), textStartTime.getText(), textEndTime.getText());



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
            textDate.setText(model.getValueAt(i, 1).toString());
            textMaxParticipants.setText(model.getValueAt(i, 2).toString());
            textDuration.setText(model.getValueAt(i, 3).toString());
            textStartTime.setText(model.getValueAt(i, 4).toString());
            textEndTime.setText(model.getValueAt(i, 5).toString());
        }
        });

// button Edit row---------------------------------------------------
        btnEdit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
//Selected row ----------------------------------
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textName.getText(), i, 0);
                   model.setValueAt(textDate.getText(), i, 1);
                   model.setValueAt(textMaxParticipants.getText(), i, 2);
                   model.setValueAt(textDuration.getText(), i, 3);
                   model.setValueAt(textStartTime.getText(), i, 4);
                   model.setValueAt(textEndTime.getText(), i, 5);


                }
                else{
                    System.out.println("Edit Error");
                }
            }
        });



        updateComboBox();
        updateClassBox();
        
        frame.setTitle("Classes");
        frame.setSize(900,450);
        frame.setLocationRelativeTo(null);
        btnreturn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
           {
              frame.dispose();
           }
       });
        frame.setVisible(true);   
        
    }



    public void updateClassBox() {
        ClassesList classes = adapter.getAllClasses();
        Object[][] data = new Object[classes.size()][6];

        for(int i = 0; i<classes.size();i++)
        {
            data[i][0] = classes.get(i).getName();
            data[i][1] = classes.get(i).getDate();
            data[i][2] = classes.get(i).getMaxParticipant();
            data[i][3] = classes.get(i).getMaxParticipant();
            data[i][4] = classes.get(i).getDuration();
            data[i][5] = classes.get(i).getStartTime();
            data[i][6] = classes.get(i).getEndTime();
        }
        model = new DefaultTableModel(data, columns);
        table.setModel(model);

    }

    public void updateComboBox(){
        textInstr.removeAllItems();
        InstructorList i1 = adapter.getAllInstructors();

        for(int i=0; i<i1.size(); i++){
            textInstr.addItem(i1.get(i));
        }
    }
}
