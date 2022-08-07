package view.checkout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import system.JavaApp;

@SuppressWarnings("serial")
public class Errorpage extends JPanel{
	 JLabel errorLabel, errorValue;
	 JButton back;
	public Errorpage(String errormsg) {
		 JFrame frame = new JFrame("Error details");
		  frame.setLayout(new BorderLayout());
		  frame.setContentPane(new JLabel(new ImageIcon("4.jpg")));
		  frame.setLayout(new FlowLayout());
		  errorLabel = new JLabel("Error:");
		  errorValue = new JLabel(errormsg);
		  back = backButton();
		  errorLabel.setForeground(Color.red);
		  errorLabel.setFont(new Font("Serif", Font.BOLD, 18));
		  errorLabel.setBounds(100, 30, 200, 70);
		  errorValue.setForeground(Color.red);
		  errorValue.setBounds(300, 30, 500, 70);
		  errorValue.setFont(new Font("Serif", Font.BOLD, 18));
		  back.setBounds(100, 100, 100, 30);
		  frame.add(errorLabel);
		  frame.add(errorValue);
		  frame.add(back);
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
				JavaApp.loadScreen1(new view.checkout.CheckOut());
			}

			});
		return back;
	}
	

}
