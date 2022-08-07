package view.concession;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.concessions.KioskClientInterface;
import system.JavaApp;
import view.startup.Kiosk;

public class KioskLogIn extends JPanel {

	JLabel confirmationidLabel;
	JLabel nameLabel;
	JTextField confirmationIDTextField;
	JTextField nameTextField;
	JButton logInButton;
	JButton backButton;
	JButton clearButton;
	KioskClientInterface k;
	
	public KioskLogIn() throws SQLException
	{
		k = new KioskClientInterface();
		confirmationIDTextField = defaultTextField();
		nameTextField = defaultTextField();
		confirmationidLabel= new JLabel("Confirmation ID:");
		nameLabel = new JLabel("Name:");
		logInButton = logInButton();
		backButton = backButton();
		
		add(backButton);
		add(nameLabel);
		add(nameTextField);
		add(confirmationidLabel);
		add(confirmationIDTextField);
		add(logInButton);
	}
	
	public JButton logInButton()
	{
		JButton li = new JButton("LOG IN");
		li.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if( k.logInForKiosk(Integer.parseInt(confirmationIDTextField.getText()), nameTextField.getText()))
					{
						JavaApp.loadScreen(new view.concession.KioskOrder(k));	
					}
					else
					{
						JOptionPane.showMessageDialog(
								null, "User not found, try again.");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}} );
		
		return li;
	}
	
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.Kiosk());
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
	
	
}
