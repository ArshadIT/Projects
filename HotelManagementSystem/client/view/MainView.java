package client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.net.MalformedURLException;
import java.nio.channels.NetworkChannel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.Client;
import client.controller.BookingController;
import client.controller.GuestController;
import client.controller.IBookingController;
import client.controller.IGuestController;
import client.controller.IRoomController;
import client.controller.RoomController;
import shared.model.CheckToday;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MainView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewReservation;
	JButton btnTodayBooking;
	JButton btnCalendar;
	JButton btnHousekeeper;
	JPanel panel_1;
	private IBookingController bookingController;
	private IRoomController roomController;
	private IGuestController guestController;
	public JList<CheckToday> list;
	private JTextArea text, text1;

	private DefaultListModel<CheckToday> listModel;

	public MainView() throws RemoteException, SQLException {

		setUpGui();

		setBController(bookingController);
		setGuestController(guestController);

	}

	public void setUpGui() throws RemoteException, SQLException {

		setBounds(100, 100, 1108, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1071, 110);
		contentPane.add(panel);
		panel.setLayout(null);

		btnNewReservation = new JButton("New Reservation");
		btnNewReservation.setBounds(100, 50, 178, 29);
		btnNewReservation.addActionListener(this);
		panel.add(btnNewReservation);

		btnCalendar = new JButton("Calendar");
		btnCalendar.setBounds(350, 50, 115, 29);
		btnCalendar.addActionListener(this);
		panel.add(btnCalendar);

		btnHousekeeper = new JButton("HouseKeeper");
		btnHousekeeper.setBounds(559, 50, 149, 29);
		btnHousekeeper.addActionListener(this);
		panel.add(btnHousekeeper);

		JButton btnManageRoom = new JButton("Manage Room");
		btnManageRoom.setBounds(815, 50, 149, 29);
		btnManageRoom.addActionListener(this);
		panel.add(btnManageRoom);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 136, 521, 433);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnTodayBooking = new JButton("Load Data");
		btnTodayBooking.setBounds(200, 35, 149, 29);
		btnTodayBooking.addActionListener(this);
		panel_1.add(btnTodayBooking);

		JLabel lblTodayArrivals = new JLabel("Today Check In");
		lblTodayArrivals.setBounds(162, 16, 138, 20);
		panel_1.add(lblTodayArrivals);

		text = new JTextArea();
		text.setVisible(true);

		text.setBounds(28, 62, 464, 355);
		panel_1.add(text);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(564, 136, 507, 433);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTodayCheckOut = new JLabel("Today Check Out");
		lblTodayCheckOut.setBounds(172, 16, 141, 20);
		panel_2.add(lblTodayCheckOut);

		text1 = new JTextArea();
		text1.setVisible(true);

		text1.setBounds(28, 62, 464, 355);
		panel_2.add(text1);

		setVisible(true);
		setTitle("Hotel");

	}

	public void setBController(IBookingController bookingController2) {

		bookingController = bookingController2;

	}

	public void setRController(IRoomController roomController) {

		this.roomController = roomController;

	}

	public void setGuestController(IGuestController guestController) {

		this.guestController = guestController;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTodayBooking) {

			try {
				text.append(bookingController.getAllCheckInTodayList() + "\n");
				text1.append(bookingController.getAllCheckOutTodayList() + "\n");
			} catch (RemoteException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnNewReservation) {
			try {
				AddNewReservation addRes = new AddNewReservation(roomController, guestController, bookingController);
			} catch (RemoteException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == btnCalendar) {
			
			Calendar calendar= new Calendar(bookingController);
		}

	}

}
