import javax.swing.*;

public class MainGUI extends JFrame {

    private Adapter adapter,adapter1;
    private MembersGUI mbminfo;
    private InstructorGUI instinfo;
    private ClassesGUI classgui;


    private JFrame frame;



    public MainGUI(){

        super("MainGUI");

        adapter = new Adapter("memberstest.bin");

        mbminfo = new MembersGUI(adapter);
        
        adapter = new Adapter("instructor.bin");
        
        instinfo = new InstructorGUI(adapter);
        
        adapter = new Adapter("classes1.bin");
        classgui = new ClassesGUI(adapter1, adapter1);
        


        frame = new JFrame();

       // frame.add(mbminfo);

        mbminfo.setVisible(true);
        setSize(575, 452);
        setVisible(true);
        setResizable(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);






    }


    public static void main(String[] args)
    {
        MainGUI test = new MainGUI();
    }




}
