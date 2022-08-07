package view.concession;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.booking.BookReservation;
import controller.concessions.Item;
import controller.concessions.KioskClientInterface;
import system.JavaApp;

public class KioskOrder extends JPanel {

	ArrayList<String> currentOrder;
	JButton confirmButton;
	JLabel totalPriceLabel;
	//JButton addButton;
	KioskClientInterface k;
	HashMap<String, Item> itemMap;
	JLabel paymentLabel;
	JTextField paymentTextField;
	JButton backButton;
	JButton clearButton;
	
	public KioskOrder(KioskClientInterface k) throws SQLException
	{
		currentOrder = new ArrayList<String>();
		this.k = k;
		confirmButton = confirmButton();
		totalPriceLabel = new JLabel();
		paymentLabel = new JLabel("Payment Card Number");
		paymentTextField = defaultTextField();
		itemMap = k.getMenuItems();
		backButton = backButton();
		clearButton = clearButton();
		
		add(backButton);
		add(clearButton);
		for (String key : itemMap.keySet() ) 
		{
			add( createItemPanel( itemMap.get(key) ) );
		}
		add(totalPriceLabel);
		add(confirmButton);
		add(paymentLabel);
		add(paymentTextField);		
		calculateTotal();
	}
	private void calculateTotal()
	{
		double total = 0;
		DecimalFormat df2 = new DecimalFormat("0.00");
		
		for (String i : currentOrder)
		{
			total += itemMap.get(i).getPrice();
		}
		totalPriceLabel.setText( "$" + df2.format(total) );
	}
	
	public JTextField defaultTextField()
	{
		JTextField f = new JTextField();
		//f.setSize(400, 20);
		f.setPreferredSize(new Dimension(200, 20));
		return f;
	}
	
	private JButton addButton(final String i, final JLabel quantity) 
	{
		JButton a = new JButton("ADD ITEM");
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentOrder.add(i);
				calculateTotal();
				quantity.setText( Integer.parseInt( quantity.getText() ) + 1 +"" );
		}} );
		return a;
	}
	
	private JButton removeButton(final String i, final JLabel quantity) 
	{
		JButton r = new JButton("REMOVE ITEM");
		r.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentOrder.remove(i);
				calculateTotal();
				if(!quantity.getText().equals("0"))
					quantity.setText( Integer.parseInt( quantity.getText() ) - 1 +"" );
		}} );
		return r;
	}
	
	public JButton confirmButton()
	{
		JButton c = new JButton("Order Complete");
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k.buildOrder(currentOrder);
				JOptionPane.showMessageDialog(null, k.sendOrder(paymentTextField.getText() ));
			}} );
		return c;
	}
	
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JavaApp.loadScreen(new view.concession.KioskLogIn());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		return back;
	}
	
	public JButton clearButton()
	{
		JButton back = new JButton("Clear Order");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JavaApp.loadScreen(new view.concession.KioskOrder(k));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		return back;
	}
	
	public JPanel createItemPanel(Item i)
	{
		JPanel p = new JPanel();
		JLabel quantityTextLabel = new JLabel("Quantity: ");
		JLabel quantityLabel = new JLabel("0");
		JButton addButton = addButton(i.getIdentifier(), quantityLabel);
		JButton removeButton = removeButton(i.getIdentifier(), quantityLabel);
		JLabel nameLabel = new JLabel(i.getDescription());
		JLabel priceLabel = new JLabel(i.getPrice()+"");
		p.add(nameLabel);
		p.add(addButton);
		p.add(removeButton);
		p.add(priceLabel);
		p.add(quantityTextLabel);
		p.add(quantityLabel);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		return p;
	}
}
