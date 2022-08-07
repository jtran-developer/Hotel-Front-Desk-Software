package view.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import system.JavaApp;

public class Receptionist extends JPanel{
	public Receptionist()
	{
		this.add(backButton());
		this.add(checkInButton());
		this.add(checkOutButton());
		this.add(serviceButton());
		this.add(taxiButton() );
		this.add(statisticsButton());
	}

	private JButton checkInButton() 
	{
		JButton b = new JButton("Check In");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.checkin.CheckIn());
			}});
		return b;
	}
	private JButton checkOutButton() 
	{
		JButton b = new JButton("Check Out");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen1(new view.checkout.CheckOut());
			}});
		return b;
	}
	private JButton taxiButton() 
	{
		JButton b = new JButton("Order Taxi");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.taxi.OrderTaxi());
			}});
		return b;
	}
	private JButton serviceButton() 
	{
		JButton b = new JButton("Order Service");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.service.Service());
			}});
		return b;
	}
	private JButton statisticsButton() 
	{
		JButton b = new JButton("View Statistics");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen1(new view.statistics.Statistics());
			}});
		return b;
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.InitialScreen());
			}});
		return back;
	}
}
