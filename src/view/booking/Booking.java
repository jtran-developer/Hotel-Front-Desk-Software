package view.booking;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.booking.ClientHotelSystemBookReservationInterface;
import controller.global.DateChooserPanel;
import system.JavaApp;

public class Booking extends JPanel {
	ClientHotelSystemBookReservationInterface c;

	JButton backButton;
	JLabel header;
	JLabel empty;
	JLabel nameLabel;
	JTextField nameJTextField;
	JLabel paymentLabel;
	JTextField paymentJTextField;
	JLabel startDateLabel;
	DateChooserPanel startPicker;  
	JLabel endDateLabel;
	DateChooserPanel endPicker;  
	JButton submit;
	
	public Booking()
	{
		c = new ClientHotelSystemBookReservationInterface();
		c.resetReservation();

		backButton = backButton();
		header = new JLabel("Please Enter Your Personal Information");
		empty = new JLabel("");
		nameLabel = new JLabel("Name:");
		nameJTextField = defaultTextField();
		paymentLabel = new JLabel("Payment:");
		paymentJTextField = defaultTextField();
		startDateLabel = new JLabel("Start Date:");
		startPicker = new DateChooserPanel();  
		endDateLabel = new JLabel("End Date:");
		endPicker = new DateChooserPanel();  
		submit = submitButton();

		add(backButton);
		add(header);
		add(empty);
		add(nameLabel);
		add(nameJTextField);
		add(paymentLabel);
		add(paymentJTextField);
		add(startDateLabel);
		add(startPicker);
		add(endDateLabel);
		add(endPicker);
		add(submit);
		
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.PrivateComputer());
			}});
		return back;
	}
	public JTextField defaultTextField()
	{
		JTextField f = new JTextField();
		//f.setSize(400, 20);
		f.setPreferredSize(new Dimension(200, 20));
		return f;
	}
	public JButton submitButton()
	{
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = nameJTextField.getText();
				String paymentInfo = paymentJTextField.getText();
				java.util.Date startDateRaw = startPicker.getDate();
				java.util.Date endDateRaw = endPicker.getDate();
				
				String startString = (1900+startDateRaw.getYear()) + "-" + (1+startDateRaw.getMonth()) + "-" + startDateRaw.getDate();
				String endString = (1900+endDateRaw.getYear()) + "-" + (1+endDateRaw.getMonth()) + "-" + endDateRaw.getDate();
				
				Date startDate = Date.valueOf(startString);
				Date endDate = Date.valueOf(endString);
				
				boolean execute = true;
				if (name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No name inputted.");
					execute = false;
				}
				if (paymentInfo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No payment information inputted.");
					execute = false;
				}
				if (startDate == null)
				{
					JOptionPane.showMessageDialog(null, "Start Date was not selected.");
					execute = false;
				}
				if (endDate == null)
				{
					JOptionPane.showMessageDialog(null, "End Date was not selected.");
					execute = false;
				}
				System.out.println("name = " + name);
				System.out.println("paymentInfo = " + paymentInfo);
				System.out.println("startDate = "  + startDate);
				System.out.println("endDate = " + endDate);
				
				try
				{
					if (execute)
					{
						System.out.println("executing");
						String message = c.createReservation(name, paymentInfo, startDate, endDate);
						JOptionPane.showMessageDialog(null, message);
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				
			}});
		return submit;
	}
	
}
