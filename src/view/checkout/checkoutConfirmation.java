package view.checkout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.checkout.ClientCheckOut;
import system.JavaApp;

@SuppressWarnings("serial")
public class checkoutConfirmation extends JPanel{
	private JLabel header, confirmationLabel, confirmationID, nameLabel,statusLabel,nameValue, statusValue, startdateLabel, startdatevalue,enddatelabel,enddatevalue ;
	private JButton submit,back;
	private ClientCheckOut clientCheckout= new ClientCheckOut();
	private String name;
	private String status,startdate,enddate,confirmationIDLabel;

	public checkoutConfirmation(String name, String status,String confirmation, String startdate, String enddate) {
		  JFrame frame = new JFrame("Check-out Customer details");
		  frame.setLayout(new BorderLayout());
		  frame.setContentPane(new JLabel(new ImageIcon("4.jpg")));
		  frame.setLayout(new FlowLayout());
		  
		  
		  if(status.equalsIgnoreCase("CHECKEDOUT"))
			  header = new JLabel("Check-out status");
		  else
			  header = new JLabel("Verify Customer details before check-out");
		  
		  header.setForeground(Color.white);
		  header.setFont(new Font("Serif", Font.BOLD, 20));
		  header.setBounds(100, 30, 400,70);
		  
		  confirmationLabel = new JLabel("Confirmation ID:");
		  confirmationID = new JLabel(confirmation);
		 
			  nameLabel = new JLabel("Guest name:");
		  	  nameValue = new JLabel(name);
		  	 startdateLabel = new JLabel("Start Date:");
		  	  startdatevalue = new JLabel(startdate);
		  	 enddatelabel = new JLabel("End Date:");
		  	  enddatevalue = new JLabel(enddate);
		  	 submit = submitButton();
		 
		  
		  statusLabel = new JLabel("Booking Status:");
		  statusValue = new JLabel(status);
		 
		  back = backButton();
		  confirmationLabel.setForeground(Color.white);
		  confirmationLabel.setBounds(100, 90, 200, 70);
		  confirmationID.setForeground(Color.white);
		  confirmationID.setBounds(300, 90, 200, 70);
		  nameLabel.setForeground(Color.white);
		  nameLabel.setBounds(100, 120, 200, 70);
		  nameValue.setForeground(Color.white);
		  nameValue.setBounds(300, 120, 200, 70);
		  statusLabel.setForeground(Color.white);
		  statusLabel.setBounds(100, 150, 200, 70);
		  statusValue.setForeground(Color.white);
		  statusValue.setBounds(300, 150, 200, 70);
		  startdateLabel.setForeground(Color.white);
		  startdateLabel.setBounds(100, 180, 200, 70);
		  startdatevalue.setForeground(Color.white);
		  startdatevalue.setBounds(300, 180, 200, 70);
		  enddatelabel.setForeground(Color.white);
		  enddatelabel.setBounds(100, 210, 200, 70);
		  enddatevalue.setForeground(Color.white);
		  enddatevalue.setBounds(300, 210, 200, 70);
		  back.setBounds(100, 300, 100, 30);
		  submit.setBounds(300, 300, 100, 30);
		
		  frame.add(header);
		  frame.add(confirmationLabel);
		  frame.add(confirmationID);
		  if(name!="successfully"){
		  frame.add(nameLabel);
		  frame.add(nameValue);}
		  frame.add(statusLabel);
		  frame.add(statusValue);
		  frame.add(startdateLabel);
		  frame.add(startdatevalue);
		  frame.add(enddatelabel);
		  frame.add(enddatevalue);
		  frame.add(back);
		  if(status.equalsIgnoreCase("CHECKEDIN"))
			  frame.add(submit);
		  frame.setSize(1920, 1080);
		  frame.setLayout(null);
		  frame.setVisible(true);
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.checkout.CheckOut());
			}});
		return back;
	}
	public JButton submitButton()
	{
		JButton submit = new JButton("Checkout");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					ResultSet rs=clientCheckout.updateStatustoCheckout(confirmationID.getText());
					 while(rs.next()){
							System.out.println(rs.getString("name"));
							name =rs.getString("name");
							status = rs.getString("status");
							startdate =rs.getString("startdate");
							enddate = rs.getString("enddate");
							confirmationIDLabel =rs.getString("confirmationid");
						}
					 JavaApp.loadScreen1(new view.checkout.checkoutConfirmation(name,status, confirmationIDLabel, startdate,enddate));
				} catch (Exception e1) {
					 JavaApp.loadScreen1(new view.checkout.Errorpage("Request not executed.. Please try again"));
				}
			}});
		return submit;
	}
}
