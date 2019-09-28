package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import client.controller.IBookingController;

public class Calendar extends JFrame implements ActionListener {

	private JPanel contentPane;
	private IBookingController bookingController;
	private JButton btnShowCalendar;
	private JTextPane textPane;

	public Calendar(IBookingController bookingController2) {

		bookingController = bookingController2;
		setUpGUI();
	}
		
	public void setUpGUI() {
		
	
		setTitle("Booking Calendar");
		
		setBounds(100, 100, 917, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textPane = new JTextPane();
		textPane.setBounds(37, 16, 784, 339);
		contentPane.add(textPane);

		btnShowCalendar = new JButton("Show Calendar");
		btnShowCalendar.setBounds(72, 371, 196, 29);
		btnShowCalendar.addActionListener(this);
		contentPane.add(btnShowCalendar);
		setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
			System.out.println(6789);
			if (e.getSource() == btnShowCalendar) {

				try {
					textPane.setText(bookingController.getAllBookings() + "\n");
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			

		}
		
	}


	

}
