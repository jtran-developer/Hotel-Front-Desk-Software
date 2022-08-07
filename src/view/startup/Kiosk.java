package view.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

import system.JavaApp;

public class Kiosk extends JPanel{
	public Kiosk()
	{
		this.add(backButton());
		this.add(kiosk());
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
	public JButton kiosk()
	{
		JButton b = new JButton("Kiosk button");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JavaApp.loadScreen(new view.concession.KioskLogIn());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		return b;
	}
}
