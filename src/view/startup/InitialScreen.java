package view.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitialScreen extends JPanel {
	public InitialScreen()
	{
		this.add(privateComputer());
		this.add(receptionist());
		this.add(kiosk());
	}
	public JButton privateComputer()
	{
		JButton b = new JButton("Private Computer");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				system.JavaApp.loadScreen(new view.startup.PrivateComputer());
			}});
		return b;
	}
	public JButton receptionist()
	{
		JButton r = new JButton("Receptionist");
		r.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				system.JavaApp.loadScreen(new view.startup.Receptionist());
			}});
		return r;
	}
	public JButton kiosk()
	{
		JButton k = new JButton("Kiosk");
		k.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				system.JavaApp.loadScreen(new view.startup.Kiosk());
			}});
		return k;
	}
}
