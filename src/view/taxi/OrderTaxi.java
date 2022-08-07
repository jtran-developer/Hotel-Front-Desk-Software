package view.taxi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.taxi.TaxiRequest;
import system.JavaApp;
import controller.global.DateChooserPanel;
import controller.taxi.FrontDeskHotelSystemTaxiOrderInterface;

public class OrderTaxi extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private DateChooserPanel datePicker;
	private JTextField textFieldRoom;
	private JTextField textFieldDest;
	private JTextField textFieldDate;
	private JTextField textFieldPay;
	private JTextField textFieldName;
	private JTextField textFieldPass;

	public OrderTaxi() {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 1368, 886);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calendar cal = Calendar.getInstance();
		
		JPanel panel = new JPanel();
		//frame.getContentPane().
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{511, 102, 93, 728, 0};
		gbl_panel.rowHeights = new int[]{49, 22, 22, 25, 22, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOrderTaxi = new JLabel("Order Taxi");
		lblOrderTaxi.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblOrderTaxi = new GridBagConstraints();
		gbc_lblOrderTaxi.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderTaxi.gridx = 1;
		gbc_lblOrderTaxi.gridy = 0;
		panel.add(lblOrderTaxi, gbc_lblOrderTaxi);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 0;
		gbc_lblRoom.gridy = 1;
		panel.add(lblRoom, gbc_lblRoom);
		
		textFieldRoom = new JTextField();
		textFieldRoom.setColumns(5);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textFieldRoom, gbc_textField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		panel.add(lblName, gbc_lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(5);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.gridwidth = 2;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 2;
		panel.add(textFieldName, gbc_textFieldName);
		
		JLabel lblPass = new JLabel("Passenger's");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 0;
		gbc_lblPass.gridy = 3;
		panel.add(lblPass, gbc_lblPass);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(5);
		GridBagConstraints gbc_textFieldPass = new GridBagConstraints();
		gbc_textFieldPass.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldPass.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPass.gridwidth = 2;
		gbc_textFieldPass.gridx = 1;
		gbc_textFieldPass.gridy = 3;
		panel.add(textFieldPass, gbc_textFieldPass);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.EAST;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 4;
		panel.add(lblDestination, gbc_lblDestination);
		
		textFieldDest = new JTextField();
		textFieldDest.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel.add(textFieldDest, gbc_textField_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 5;
		panel.add(lblDate, gbc_lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(20);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		panel.add(textFieldDate, gbc_textField_2);
		
		datePicker = new DateChooserPanel();
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.gridx = 1;
		gbc_datePicker.gridy = 6;
		panel.add(datePicker, gbc_datePicker);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 7;
		panel.add(lblTime, gbc_lblTime);
		
		String[] hoursArray = {"00:00","00:30", "01:00","01:30", "02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30",
				"07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
				"13:00","13:30", "14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30",
				"19:00","19:30", "20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
		final JComboBox<String> hoursCombo = new JComboBox<>(hoursArray);
		//hoursCombo.setColumns(10);
		GridBagConstraints gbc_hoursCombo = new GridBagConstraints();
		gbc_hoursCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_hoursCombo.insets = new Insets(0, 0, 5, 5);
		gbc_hoursCombo.gridwidth = 2;
		gbc_hoursCombo.gridx = 1;
		gbc_hoursCombo.gridy = 7;
		
        String selectedHour = (String) hoursCombo.getSelectedItem();
        Date pickedDate = datePicker.getDate();	
        cal.setTime(pickedDate);
        if(pickedDate != null)
        	textFieldDate.setText(cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE) + "/"  + cal.get(Calendar.YEAR) + " " + selectedHour);
        
		panel.add(hoursCombo, gbc_hoursCombo);
		
		hoursCombo.addActionListener(new ActionListener() {
			 
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        String selectedHour = (String) hoursCombo.getSelectedItem();
		        Date pickedDate = datePicker.getDate();	
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(pickedDate);
		        textFieldDate.setText(cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE) + "/"  + cal.get(Calendar.YEAR) + " " + selectedHour);

		    }
		});
		
		JLabel lblPayment = new JLabel("Payment Id");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPay = new GridBagConstraints();
		gbc_lblPay.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPay.insets = new Insets(0, 0, 5, 5);
		gbc_lblPay.gridx = 0;
		gbc_lblPay.gridy = 8;
		panel.add(lblPayment, gbc_lblPay);
		
		textFieldPay = new JTextField();
		textFieldPay.setColumns(20);
		GridBagConstraints gbc_textFieldPay = new GridBagConstraints();
		gbc_textFieldPay.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textFieldPay.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPay.gridwidth = 2;
		gbc_textFieldPay.gridx = 1;
		gbc_textFieldPay.gridy = 8;
		panel.add(textFieldPay, gbc_textFieldPay);
		
		JButton btnSubmit = new JButton("Order Taxi");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 9;
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrontDeskHotelSystemTaxiOrderInterface fdtoi = new FrontDeskHotelSystemTaxiOrderInterface();
				String roomNumber = textFieldRoom.getText();
				String name = textFieldName.getText();
				String passengers = textFieldPass.getText();
				String payment = textFieldPay.getText();
				String destination = textFieldDest.getText();
				String bookingDate = textFieldDate.getText();
				if(roomNumber != null && !roomNumber.isEmpty()){
					if(name != null && !name.isEmpty()){
						if(passengers != null && !passengers.isEmpty()){
							if(bookingDate != null && !bookingDate.isEmpty()){
								if(destination != null && !destination.isEmpty()){
									if(payment != null && !payment.isEmpty()){
										TaxiRequest tr = new TaxiRequest();
										tr.setBookingDate(bookingDate);
										tr.setDestination(destination);
										tr.setName(name);
										tr.setPassengers(Integer.valueOf(passengers));
										tr.setPaymentId(payment);
										tr.setRoomNumber(roomNumber);
										String result = fdtoi.sendTaxiOrder(tr);
										if(result == "SUCCESS"){
											JOptionPane.showMessageDialog(null, "Taxi booking confirmed on " + bookingDate + " against room " + roomNumber );
											JavaApp.loadScreen(new view.startup.Receptionist());
										}else{
											JOptionPane.showMessageDialog(null, result);
										}
									}else{
										JOptionPane.showMessageDialog(null, "Payment Id can not be blank.");
									}
								}else{
									JOptionPane.showMessageDialog(null, "Destination can not be blank.");
								}
							}else{
								JOptionPane.showMessageDialog(null, "Booking date can not be blank.");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Passengers must not be blank");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Name can not be blank.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Room number can not be blank.");
				}

				
			}});

		panel.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.Receptionist());
			}});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 9;
		panel.add(btnBack, gbc_btnCancel);
	}

}
