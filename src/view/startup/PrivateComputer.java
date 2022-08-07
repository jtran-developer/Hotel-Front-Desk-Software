package view.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import system.JavaApp;

public class PrivateComputer extends JPanel {

	public PrivateComputer()
	{
		this.add(backButton());
		this.add(bookReservationButton());
		this.add(orderMovieButton());
		this.add(accessMovieButton());
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//JavaApp.loadScreen(new system.JavaApp().getPreviousPanel());
				JavaApp.loadScreen(new view.startup.InitialScreen());
				//JavaApp.loadPreviousPanel();
			}});
		return back;
	}
	public JButton bookReservationButton()
	{
		JButton b = new JButton("Book Reservation");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.booking.Booking());
			}});
		return b;
	}
	public JButton orderMovieButton()
	{
		JButton b = new JButton("Order Movie");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.movie.OrderMovie());
			}});
		return b;
	}
	public JButton accessMovieButton()
	{
		JButton b = new JButton("Watch Movie");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.movie.AccessMedia());
			}});
		return b;
	}
}
