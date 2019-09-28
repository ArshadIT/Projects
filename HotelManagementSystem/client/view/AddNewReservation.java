package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

import client.controller.IBookingController;
import client.controller.IGuestController;
import client.controller.IRoomController;
import shared.model.Booking;
import shared.model.Guest;
import shared.model.GuestList;

public class AddNewReservation extends JFrame implements ActionListener, PropertyChangeListener {

	private IBookingController bookingController;
	private IRoomController roomController;
	private IGuestController guestController;
	private MainView mainView;

	JLocaleChooser localeChooser;
	JDateChooser dateChooser;
	JDateChooser dateChooser_1;

	JButton btnCancel;
	public JComboBox<String> comboBox;
	private JPanel contentPane;
	public JTextField txtfname;
	public JTextField txtlname;
	public JTextField txtaddress;
	public JTextField txtphone;
	public JTextField txtpassportnr;
	public JTextField txtemail;
	public JTextField txtBookedRoom;
	public JTextField txtprice;
	public JTextArea text;
	JButton btnSaveReservation;
	Date startDate;
	Date endDate;

	public AddNewReservation(IRoomController roomCrl, IGuestController guestCtrl, IBookingController bookingCtrl)
			throws RemoteException, SQLException {

		this.roomController = roomCrl;
		this.guestController = guestCtrl;
		this.bookingController = bookingCtrl;
		bookingController.set(this);
		
		setUpGUI();
		guestController.displayGuestsToComboBox(comboBox);
		setCalendar();
	}

	public void setUpGUI() {

		setBackground(Color.BLACK);
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		setForeground(Color.BLACK);

		setBounds(100, 100, 1128, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dates", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, Color.BLACK));
		panel.setBounds(15, 16, 399, 162);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDateOfarrival = new JLabel("Date of Arrival");
		lblDateOfarrival.setBounds(15, 40, 118, 20);
		panel.add(lblDateOfarrival);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(199, 34, 119, 26);
		dateChooser.addPropertyChangeListener(this);

		panel.add(dateChooser);

		JLabel lblDateOfDeparture = new JLabel("Date of Departure");
		lblDateOfDeparture.setBounds(15, 92, 135, 20);
		panel.add(lblDateOfDeparture);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(199, 86, 119, 26);
		dateChooser_1.addPropertyChangeListener(this);
		panel.add(dateChooser_1);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(240, 240, 240));
		panel1.setForeground(Color.BLACK);
		panel1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Guest Information",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, Color.BLACK));
		panel1.setBounds(447, 16, 595, 468);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(27, 65, 113, 20);
		panel1.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(27, 101, 88, 20);
		panel1.add(lblLastName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(27, 143, 77, 20);
		panel1.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(27, 179, 88, 20);
		panel1.add(lblPhone);

		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(27, 311, 88, 20);
		panel1.add(lblNationality);

		localeChooser = new JLocaleChooser();
		localeChooser.setBounds(173, 308, 260, 26);
		localeChooser.addPropertyChangeListener(this);
		panel1.add(localeChooser);

		txtfname = new JTextField();
		txtfname.setBounds(173, 62, 225, 26);
		panel1.add(txtfname);
		txtfname.setColumns(10);

		JLabel lblPassportNr = new JLabel("Passport Nr");
		lblPassportNr.setBounds(27, 213, 113, 20);
		panel1.add(lblPassportNr);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(37, 260, 78, 20);
		panel1.add(lblEmail);

		txtlname = new JTextField();
		txtlname.setBounds(173, 98, 225, 26);
		panel1.add(txtlname);
		txtlname.setColumns(10);

		txtaddress = new JTextField();
		txtaddress.setBounds(173, 140, 225, 26);
		panel1.add(txtaddress);
		txtaddress.setColumns(10);

		txtphone = new JTextField();
		txtphone.setBounds(173, 176, 225, 26);
		panel1.add(txtphone);
		txtphone.setColumns(10);

		txtpassportnr = new JTextField();
		txtpassportnr.setBounds(173, 210, 225, 26);
		panel1.add(txtpassportnr);
		txtpassportnr.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(173, 257, 225, 26);
		panel1.add(txtemail);
		txtemail.setColumns(10);

		JLabel lblBookedRoom = new JLabel("Booked Room");
		lblBookedRoom.setBounds(27, 357, 113, 20);
		panel1.add(lblBookedRoom);

		txtBookedRoom = new JTextField();
		txtBookedRoom.setBounds(173, 354, 177, 26);
		panel1.add(txtBookedRoom);
		txtBookedRoom.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(27, 393, 69, 20);
		panel1.add(lblPrice);

		txtprice = new JTextField();
		txtprice.setBounds(173, 390, 177, 26);
		panel1.add(txtprice);
		txtprice.setColumns(10);

		JLabel lblSelectGuest = new JLabel("Select Guest");
		lblSelectGuest.setBounds(27, 32, 88, 20);
		panel1.add(lblSelectGuest);

		comboBox = new JComboBox();
		comboBox.setBounds(173, 29, 225, 26);
		comboBox.addActionListener(this);
		panel1.add(comboBox);
		comboBox.addActionListener(this);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Available Rooms",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(25, 194, 387, 439);
		contentPane.add(panel2);
		panel2.setLayout(null);

		text = new JTextArea();
		text.setVisible(true);

		text.setBounds(15, 46, 357, 337);

		panel2.add(text);

		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel3.setBounds(447, 510, 595, 136);
		contentPane.add(panel3);
		panel3.setLayout(null);

		btnSaveReservation = new JButton("Save Booking");
		btnSaveReservation.setBounds(406, 89, 164, 29);
		btnSaveReservation.addActionListener(this);
		panel3.add(btnSaveReservation);

		btnCancel = new JButton("Clear Fields");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBounds(250, 89, 141, 29);
		btnCancel.addActionListener(this);
		panel3.add(btnCancel);
		setTitle("Add New Reservation");
		setVisible(true);

	}

	public void setCalendar() {

		dateChooser.getJCalendar().setMinSelectableDate(new Date());
		
		Date dateToday = new Date();

		dateChooser_1.getJCalendar().setMinSelectableDate(new Date(dateToday.getTime() 
																+ (1000 * 60 * 60 * 24)));

	}

	public void clearInput() {
		txtfname.setText("");
		txtlname.setText("");
		txtaddress.setText("");
		txtphone.setText("");
		txtpassportnr.setText("");
		txtemail.setText("");
		txtBookedRoom.setText("");
		text.setText(" ");
		txtprice.setText(" ");
		dateChooser.setCalendar(null);
		dateChooser_1.setCalendar(null);
		text.append(" ");
	}

	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getSource() == dateChooser || evt.getSource() == dateChooser_1) {

			startDate = dateChooser.getDate();
			if (startDate == null)
				return;

			System.out.println(startDate);

			endDate = dateChooser_1.getDate();
			if (endDate == null)
				return;

			System.out.println(endDate);
			boolean result = bookingController.CheckIfStartDateBeforeEndDate(startDate, endDate);
			System.out.println(result);
			if (result) {

				try {
					text.append((roomController.getAvailableRooms(startDate, endDate)) + "\n");

				} catch (RemoteException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null, "Invalide dates", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCancel) {
			clearInput();
		}
	
		if (e.getSource() == btnSaveReservation) {
			if (txtfname.getText().equals("") || txtlname.getText().equals("") || txtaddress.getText().equals("")
					|| txtphone.getText().equals("") || txtpassportnr.getText().equals("") || txtemail.equals("")
					|| txtBookedRoom.equals("") || startDate==null || endDate== null) {

				JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String fname = txtfname.getText();
				String lname = txtlname.getText();
				String address = txtaddress.getText();
				String phone = txtphone.getText();
				String passportnr = txtpassportnr.getText();
				String email = txtemail.getText();
				String roomNo = txtBookedRoom.getText();
				Locale locale = localeChooser.getLocale();

				int room = Integer.parseInt(roomNo);

				try {
					guestController.addNewGuest(locale.toString(), fname, lname, address, phone, passportnr, email);

				} catch (RemoteException | SQLException e1) {

					e1.printStackTrace();
					
					
				}

				try {
					bookingController.addNewBooking(passportnr, room, startDate, endDate);

				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Booking saved", "Booking saved", JOptionPane.INFORMATION_MESSAGE);
				clearInput();

				System.out.println("saved");

			}

		}

	}

}
