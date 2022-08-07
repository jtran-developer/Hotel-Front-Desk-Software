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
import javax.swing.JTextField;

import controller.checkout.ClientCheckOut;
import system.JavaApp;
 
@SuppressWarnings("serial")
public class CheckOut extends JPanel{
 private JLabel header, confirmationLabel;
 private JTextField confirmationID;
 private JButton submit,back;
 ClientCheckOut clientCheckout= new ClientCheckOut();
 private String name,status,startdate,enddate,confirmationIDLabel,errormsg="";

 public CheckOut() {
  JFrame frame = new JFrame("Check-out Form");
  frame.setLayout(new BorderLayout());
  frame.setContentPane(new JLabel(new ImageIcon("4.jpg")));
  frame.setLayout(new FlowLayout());
  header = new JLabel("Please enter Confirmation ID for check-out");
  header.setForeground(Color.white);
  header.setFont(new Font("Serif", Font.BOLD, 20));
 
  confirmationLabel = new JLabel("Confirmation ID:");
  confirmationLabel.setForeground(Color.white);
  confirmationLabel.setFont(new Font("Serif", Font.BOLD, 16));
  confirmationID = defaultTextField();
  submit = submitButton();
  back = backButton();
  header.setBounds(100, 30, 400,70);
  confirmationLabel.setBounds(100, 105, 200, 30);
  confirmationID.setBounds(300, 105, 200, 30);
  back.setBounds(100, 160, 100, 30);
  submit.setBounds(300, 160, 100, 30);
 
  frame.add(header);
  frame.add(confirmationLabel);
  frame.add(confirmationID);
  frame.add(back);
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
				JavaApp.loadScreen(new view.startup.Receptionist());
			}

			});
		return back;
	}
	
 public JTextField defaultTextField()
	{
		confirmationID = new JTextField();
		return confirmationID;
	}
 public JButton submitButton()
 {
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Checkout"+confirmationID.getText());
				if(confirmationID.getText().isEmpty()){	
					errormsg="Please enter confirmation id before clicking on the submit button";
					JavaApp.loadScreen1(new view.checkout.Errorpage(errormsg));
				}
				else
				{
					 ResultSet rs= clientCheckout.checkout(confirmationID.getText());
					 while(rs.next()){
						System.out.println(rs.getString("name"));
						name =rs.getString("name");
						status = rs.getString("status");
						startdate =rs.getString("startdate");
						enddate = rs.getString("enddate");
						confirmationIDLabel =rs.getString("confirmationid");
					}
				
				if(name!=""){
					 JavaApp.loadScreen1(new view.checkout.checkoutConfirmation(name,status, confirmationIDLabel, startdate,enddate));
				
				}else{
					errormsg="Wrong confirmation id,Please enter correct confirmation id";
					 JavaApp.loadScreen1(new view.checkout.Errorpage(errormsg));
				}
				}
				}catch (Exception e1) {
					errormsg="Request not executed.. Please try again";
					 JavaApp.loadScreen1(new view.checkout.Errorpage(errormsg));
				}
			}});
		return submit;
	}
}