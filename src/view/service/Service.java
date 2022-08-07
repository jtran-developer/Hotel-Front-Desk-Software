package view.service;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.service.FrontDeskHotelSystemHMServiceOrderInterface;
import system.JavaApp;

public class Service extends JPanel{
	JButton backButton;
	JLabel roomNumberLabel;
	JTextField roomNumberJTextField;
	JButton houseKeepingButton;
	JButton maintenanceButton;
	JTextArea maintenanceIssue;
	FrontDeskHotelSystemHMServiceOrderInterface i;
	
	public Service()
	{
		i = new FrontDeskHotelSystemHMServiceOrderInterface();
		backButton = backButton();
		roomNumberLabel = new JLabel("Enter the room number:");
		roomNumberJTextField = defaultTextField();
		houseKeepingButton = HouseKeepingButton();
		maintenanceButton = MaintenanceButton();
		maintenanceIssue = defaultTextArea();
		
		add(backButton);
		add(roomNumberLabel);
		add(roomNumberJTextField);
		add(houseKeepingButton);
		add(maintenanceButton);
		add(maintenanceIssue);
	}	
	public JButton HouseKeepingButton()
	{
		JButton h = new JButton("HOUSEKEEPING");
		h.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					int room = Integer.parseInt(roomNumberJTextField.getText());
					i.sendHousekeepingService(room);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				
			}});
		return h;
	}
	public JButton MaintenanceButton()
	{
		JButton m = new JButton("MAINTENANCE");
		m.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					int room = Integer.parseInt(roomNumberJTextField.getText());
					String issue = maintenanceIssue.getText();
					i.sendMaintenanceService(room, issue);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}});
		return m;
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.Receptionist());
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
	public JTextArea defaultTextArea()
	{
		JTextArea f = new JTextArea();
		//f.setSize(400, 20);
		f.setPreferredSize(new Dimension(200, 20));
		return f;
	}
	
	
}
