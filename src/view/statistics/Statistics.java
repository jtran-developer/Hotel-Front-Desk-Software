package view.statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import system.JavaApp;
import controller.global.DateChooserPanel;
import controller.statistics.HotelStatistics;

@SuppressWarnings("serial")
public class Statistics extends JPanel {
	 private JLabel header, typeLabel,startDateLabel;
	 private JButton submit, backButton;
	 private JFrame frame;
	   private String type;
	  private DateChooserPanel startPicker,endPicker;  
	  private JRadioButton radioButton1,radioButton2,radioButton3;
	
	public Statistics() {
		type="";
		frame = new JFrame("Statistics");
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new JLabel(new ImageIcon("4.jpg")));
		frame.setLayout(new FlowLayout());
		
		header = new JLabel("Please select the type of statistic data");
		header.setForeground(Color.white);
		header.setFont(new Font("Serif", Font.BOLD, 20));
		header.setBounds(100, 30, 400,30);
		
		typeLabel = new JLabel("Select type:");
		typeLabel.setForeground(Color.white);
		typeLabel.setFont(new Font("Serif", Font.BOLD, 18));
		typeLabel.setBounds(100, 70, 400,30);
		
		radioButton1= new JRadioButton("Check-in");
		radioButton1.setBackground(Color.BLACK);
		radioButton1.setForeground(Color.white);
		radioButton1.setFont(new Font("Serif", Font.BOLD, 18));
	    radioButton1.setBounds(300, 70, 100, 30);
	    frame.getContentPane().add(radioButton1);
	    
	    radioButton2= new JRadioButton("Check-out");
	    radioButton2.setBackground(Color.BLACK);
	    radioButton2.setForeground(Color.white);
	    radioButton2.setFont(new Font("Serif", Font.BOLD, 18));
	    radioButton2.setBounds(300, 100, 105, 30);
	    frame.getContentPane().add(radioButton2);
	    
	    radioButton3= new JRadioButton("Booked");
	    radioButton3.setBackground(Color.BLACK);
	    radioButton3.setForeground(Color.white);
	    radioButton3.setFont(new Font("Serif", Font.BOLD, 18));
	    radioButton3.setBounds(300, 130, 100, 30);
	    frame.getContentPane().add(radioButton3);
	    
	    ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radioButton1);
        bgroup.add(radioButton2);
        bgroup.add(radioButton3);
        
	    startDateLabel = new JLabel("Date range:");
	    startDateLabel.setForeground(Color.white);
	    startDateLabel.setFont(new Font("Serif", Font.BOLD, 18));
	    startDateLabel.setBounds(100, 180, 100, 30);
	    frame.getContentPane().add(startDateLabel);
	    
		startPicker = new DateChooserPanel(); 
		startPicker.setBackground(Color.BLACK);
		startPicker.setBounds(300, 180, 200, 200);
		frame.getContentPane().add(startPicker);
		
	    
		endPicker = new DateChooserPanel();  
		endPicker.setBackground(Color.BLACK);
		endPicker.setBounds(550, 180, 200, 200);
		frame.getContentPane().add(endPicker);
		
		submit = submitButton();
		submit.setBounds(300, 410, 100, 30);
		
		backButton = backButton();
		backButton.setBounds(100, 410, 100, 30);
		  
		frame.add(header);
		  frame.add(typeLabel);
		  frame.add(radioButton1);
		  frame.add(radioButton2);
		  frame.add(radioButton3);
		  frame.add(startDateLabel);
		  frame.add(startPicker);
				  frame.add(endPicker);
		  frame.add(backButton);
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
			}});
		return back;
	}
	public JButton submitButton()
	{
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if (radioButton1.isSelected()) { 
					  
	                 type = "CHECKEDIN"; 
	             } 
				 else if (radioButton2.isSelected()) { 
					  
	                 type = "CHECKEDOUT"; 
	             } 
				 else if(radioButton3.isSelected())
				 {
					 type="BOOKED";
				 }
				java.util.Date startDateRaw = startPicker.getDate();
				java.util.Date endDateRaw = endPicker.getDate();
				
				String startString = (1900+startDateRaw.getYear()) + "-" + (1+startDateRaw.getMonth()) + "-" + startDateRaw.getDate();
				String endString = (1900+endDateRaw.getYear()) + "-" + (1+endDateRaw.getMonth()) + "-" + endDateRaw.getDate();
				
				Date startDate = Date.valueOf(startString);
				Date endDate = Date.valueOf(endString);
				
				try
				{
					if(type !="" && (startString!="" && endString !=""))
					{
						HotelStatistics hotelStatistics1= new HotelStatistics();
						JavaApp.loadScreen1(new view.statistics.StatisticsResult(hotelStatistics1.getroomdetailsbasedondateandstatus(startDate, endDate, type)));
					}
					else if(type =="" && (startString!="" && endString !=""))
					{
						HotelStatistics hotelStatistics1= new HotelStatistics();
						JavaApp.loadScreen1(new view.statistics.StatisticsResult(hotelStatistics1.getroomdetailsbasedondate(startDate, endDate)));
					}
				}
				catch (Exception ex)
				{
					JavaApp.loadScreen1(new view.statistics.Errorpage("Request not executed.. Please try again"));
				}
				
			}});
		return submit;
	}
}
