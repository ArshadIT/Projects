import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
public class Main extends JFrame {
   
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private MyButtonListener Listener;
   private JButton btn1;
   private JButton btn2;
   private JButton btn3;
   private JLabel lbl1;
   private JButton btn4;
   private Adapter adapter, adapter1;
  
  
   
  
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
               frame.setVisible(true);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   
   public Main() {
      setTitle("ViaFit");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 700, 400);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      this.Listener= new MyButtonListener();
      
      
      
      btn1 = new JButton("Member");
      btn1.setForeground(Color.BLACK);
      
      btn1.setBounds(90, 200, 100, 110);
      contentPane.add(btn1);
      btn1.addActionListener(Listener);
      
      btn2 = new JButton("Instructor");
      btn2.setForeground(Color.BLACK);
      btn2.setBounds(220, 200, 100, 110);
      contentPane.add(btn2);
      btn2.addActionListener(Listener);
         
      btn3 = new JButton("Classes");
      btn3.setForeground(Color.BLACK);
      btn3.setBounds(350, 200, 100, 110);
      contentPane.add(btn3);
      btn3.addActionListener(Listener);
      
      btn4 = new JButton("Schedule");
      btn4.setForeground(Color.BLACK);
      btn4.setBounds(480, 200, 100, 110);
      contentPane.add(btn4);
      btn4.addActionListener(Listener);
      
      lbl1 = new JLabel();
      lbl1.setForeground(Color.BLACK);
      lbl1.setBounds(10, 5, 650, 40);
      contentPane.add(lbl1);
      lbl1.setText("Welcome to ViaFitness center");
      lbl1.setHorizontalAlignment(JLabel.CENTER);
      lbl1.setVisible(true);
      lbl1.setFont(lbl1.getFont().deriveFont(30.0f));
      
     
         
      
      
      
   
   }

   
   private class MyButtonListener implements ActionListener
   {  
         public void actionPerformed(ActionEvent e) {
            
         if(e.getSource()==btn1) {
            MembersGUI frame = new MembersGUI(adapter);
            frame.setVisible(true);
            }
         else {
               if(e.getSource()==btn2) {
               InstructorGUI  frame = new InstructorGUI(adapter);
               frame.setVisible(true);
               }
            else {
               if(e.getSource()==btn3) {
               ClassesGUI frame = new ClassesGUI(adapter,adapter1);
               frame.setVisible(true);}
                           
}
}
}
}
}