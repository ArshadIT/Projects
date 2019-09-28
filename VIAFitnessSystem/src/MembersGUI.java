import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MembersGUI extends JFrame {

    private Adapter adapter;
    private LoadButtonListener lbuttonListener;
    private GetRowData ro;
    private SaveRowData sro;
    private SaveTableData stb;
    private AddNewMember addm;
    private RemoveMember del;
   // private Search src;
   // private TableRowSorter<TableModel> rowSorter;


    private JTable membersTable;
    private String[] columnNames;
    private DefaultTableModel dtm;


    private JScrollPane membersScrollPane;
    private JPanel btnPanel, textFieldsPanel;
    private JButton loadButton, saveButton, saveToFile, addNewMember, deleteMember, search;

    private JTextField name, address, telNr, email, mmbr, srchf;


    public MembersGUI(Adapter adapter) {
        super("Members");
        this.adapter = adapter;
        lbuttonListener = new LoadButtonListener();
        ro = new GetRowData();
        sro = new SaveRowData();
        stb = new SaveTableData();
        addm = new AddNewMember();
        del = new RemoveMember();

        //src = new Search();

        btnPanel = new JPanel();
        textFieldsPanel = new JPanel();

        columnNames = new String[5];
        columnNames[0] = "Name";
        columnNames[1] = "Address";
        columnNames[2] = "Telephone Number";
        columnNames[3] = "Email";
        columnNames[4] = "Membership";

        dtm = new DefaultTableModel(columnNames, 0);
        //rowSorter = new TableRowSorter<TableModel>(dtm);
        setLayout(new BorderLayout());

        membersTable = new JTable(dtm);
        membersTable.getTableHeader().setReorderingAllowed(false);
        membersTable.getTableHeader().setResizingAllowed(false);
        membersTable.setPreferredScrollableViewportSize(new Dimension(500, membersTable.getRowHeight()));
        //membersTable.setRowSorter(rowSorter);

        membersScrollPane = new JScrollPane(membersTable);
        membersScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(membersScrollPane, BorderLayout.CENTER);

        name = new JTextField("           ");
        address = new JTextField("            ");
        telNr = new JTextField("             ");
        email = new JTextField("             ");
        mmbr = new JTextField("              ");
        srchf = new JTextField("                   ");


        saveButton = new JButton("Save Edits");
        saveButton.addActionListener(sro);

        loadButton = new JButton("Load All members");
        loadButton.addActionListener(lbuttonListener);

        saveToFile = new JButton("Save To File");
        saveToFile.addActionListener(stb);

        addNewMember = new JButton("Add New Member");
        addNewMember.addActionListener(addm);

        deleteMember = new JButton("Delete Member");
        deleteMember.addActionListener(del);

//        search = new JButton("Search");
//        search.addActionListener(src);


        add(btnPanel, BorderLayout.SOUTH);

        btnPanel.add(textFieldsPanel, BorderLayout.WEST);
        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));

        textFieldsPanel.add(name);
        textFieldsPanel.add(address);
        textFieldsPanel.add(telNr);
        textFieldsPanel.add(email);
        textFieldsPanel.add(mmbr);


        btnPanel.add(loadButton, BorderLayout.EAST);
        btnPanel.add(saveButton, BorderLayout.EAST);
        btnPanel.add(saveToFile, BorderLayout.EAST);
        btnPanel.add(addNewMember, BorderLayout.EAST);
        btnPanel.add(deleteMember, BorderLayout.EAST);
        //btnPanel.add(search, BorderLayout.NORTH);
        //btnPanel.add(srchf, BorderLayout.NORTH);


        membersScrollPane.setVisible(true);


        setSize(800, 600);
        setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        membersTable.addMouseListener(ro);



    }


    public void updateMembersTable() {

        MemberList mbm = adapter.getAllMembers();
        Object[][] data = new Object[mbm.size()][5];

        for (int i = 0; i < mbm.size(); i++) {
            data[i][0] = mbm.get(i).getName();
            data[i][1] = mbm.get(i).getAddress();
            data[i][2] = mbm.get(i).getTelNumber();
            data[i][3] = mbm.get(i).getEmail();
            data[i][4] = mbm.get(i).getMembership();
        }

        dtm = new DefaultTableModel(data, columnNames);  
        
        /*{
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
        membersTable.setModel(dtm);


    }

    private class LoadButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loadButton) {

                updateMembersTable();
            }
        }
    }

    private class GetRowData extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == membersTable) {

                int i = membersTable.getSelectedRow();

                name.setText(membersTable.getValueAt(i, 0).toString());
                address.setText(membersTable.getValueAt(i, 1).toString());
                telNr.setText(membersTable.getValueAt(i, 2).toString());
                email.setText(membersTable.getValueAt(i, 3).toString());
                mmbr.setText(membersTable.getValueAt(i, 4).toString());




            }
        }
    }

    private class SaveRowData implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            try {
                if (e.getSource() == saveButton) {

                    int i = membersTable.getSelectedRow();

                    membersTable.setValueAt(name.getText(), i, 0);
                    membersTable.setValueAt(address.getText(), i, 1);
                    membersTable.setValueAt(telNr.getText(), i, 2);
                    membersTable.setValueAt(email.getText(), i, 3);
                    membersTable.setValueAt(mmbr.getText(), i, 4);

                }
            } catch (ArrayIndexOutOfBoundsException i){
                    JOptionPane.showMessageDialog(null, "Please Select a Member", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

    }

    private class SaveTableData implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == saveToFile) {


                MemberList temp = new MemberList();

                for (int i = 0; i < membersTable.getRowCount(); i++) {

                    Object o1 = membersTable.getValueAt(i, 0);
                    Object o2 = membersTable.getValueAt(i, 1);
                    Object o3 = membersTable.getValueAt(i, 2);
                    Object o4 = membersTable.getValueAt(i, 3);
                    Object o5 = membersTable.getValueAt(i, 4);

                    temp.addMember(new Member(o1.toString(), o2.toString(), o3.toString(), o4.toString(), o5.toString()));

                }

                adapter.saveMembers(temp);

            }


        }


    }

    public class AddNewMember implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == addNewMember) {


                String name = JOptionPane.showInputDialog(null, "Member's Name:", "Add New Member", JOptionPane.QUESTION_MESSAGE);
                String address = JOptionPane.showInputDialog(null, "Address:", "Add New Member", JOptionPane.QUESTION_MESSAGE);
                String telNumber = JOptionPane.showInputDialog(null, "Telephone Number:", "Add New Member", JOptionPane.QUESTION_MESSAGE);
                String email = JOptionPane.showInputDialog(null, "Email Address:", "Add New Member", JOptionPane.QUESTION_MESSAGE);
                String mbms = JOptionPane.showInputDialog(null, "Membership Type:", "Add New Member", JOptionPane.QUESTION_MESSAGE);

                Member temp = new Member(name, address, telNumber, email, mbms);


                MemberList tempList = adapter.getAllMembers();
                tempList.addMember(temp);
                adapter.saveMembers(tempList);
                updateMembersTable();


            }

        }
    }

    public class RemoveMember implements ActionListener {

        public void actionPerformed(ActionEvent e){

           if(e.getSource() == deleteMember){

               String name = JOptionPane.showInputDialog(null, "Member's Name:", "Remove Member", JOptionPane.WARNING_MESSAGE);

               MemberList tempList = adapter.getAllMembers();

               Member temp = tempList.getMemberByName(name);

               tempList.removeMember(temp);

               adapter.saveMembers(tempList);
               updateMembersTable();

           }


        }

    }

   /* public class Search implements ActionListener{
        public void actionPerformed(ActionEvent e){

            String text = srchf.getText();
            if (text.length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter(text));
            }

        }
    }
*/



    public static void main(String[] args) {
        Adapter a = new Adapter("test.bin");
        MembersGUI test = new MembersGUI(a);
    }




}


