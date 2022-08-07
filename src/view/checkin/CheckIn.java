package view.checkin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.reservation.Reservation;
import system.JavaApp;
import view.startup.Receptionist;

public class CheckIn extends JPanel {
	
	JTextField confirmationIDJTextField;
	JTextField nameJTextField;
	JButton searchButton;
	JLabel startDateLabel;
	JLabel endDateLabel;
	JLabel rnLabel;
	JLabel confirmationIDTextLabel;
	JLabel nameTextLabel;
	JButton confirmButton;
	JButton backButton;
	
	public CheckIn()
	{
		confirmationIDJTextField = defaultTextField();
		nameJTextField = defaultTextField();
		searchButton = searchButton();
		confirmationIDTextLabel = new JLabel("Confirmation ID:");
		nameTextLabel = new JLabel("Name:");
		startDateLabel = new JLabel();
		endDateLabel = new JLabel();
		rnLabel = new JLabel();
		confirmButton = confirmButton();
		backButton = backButton();
		
		add(backButton);
		add(nameTextLabel);
		add(nameJTextField);
		add(confirmationIDTextLabel);
		add(confirmationIDJTextField);
		add(searchButton);
		add(startDateLabel);
		add(endDateLabel);
		add(rnLabel);
		add(confirmButton);
	}
	
	public JButton searchButton()
	{
		JButton s = new JButton("SEARCH");
		s.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					displayReservationInfo( controller.checkin.FrontDeskHotelInterface.
							searchForReservation(Integer.parseInt(confirmationIDJTextField.getText()), nameJTextField.getText() ) );
				} catch (Exception e) {
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Guest not found");
				}
			} } );
		return s;		
	}
	public JButton backButton()
	{
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.Receptionist());
			}});
		return back;
	}
	public JButton confirmButton()
	{
		JButton c = new JButton("CONFIRM");
		c.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					controller.checkin.FrontDeskHotelInterface.checkInConfirmed( Integer.parseInt(confirmationIDJTextField.getText()), nameJTextField.getText() );
				} catch(SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}} );
		return c;
	}
	public JTextField defaultTextField()
	{
		JTextField f = new JTextField();
		//f.setSize(400, 20);
		f.setPreferredSize(new Dimension(200, 20));
		return f;
	}
	
	public void displayReservationInfo(Reservation r)
	{
		//clear label for next or possible no info.
		startDateLabel.setText("");
		endDateLabel.setText("");
		rnLabel.setText("");
		
		startDateLabel.setText(r.getStartDate().toString());
		endDateLabel.setText(r.getEndDate().toString());
		rnLabel.setText(r.getRoomNumber() + "");
	}
}
