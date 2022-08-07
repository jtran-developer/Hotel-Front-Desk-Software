package system;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaApp {
	private static JFrame frame;
	private static JPanel currentPanel;
	public JavaApp()
	{
		run();
	}
	public void run()
	{
		 setUpJFrame();
		 currentPanel = new view.startup.InitialScreen();
		 loadScreen(currentPanel);
	}
	public static void loadScreen(JPanel p)
	{
		frame.remove(currentPanel);
		currentPanel = p;
		frame.add(p);
		frame.setVisible(true);
	}
	public static void loadScreen1(JPanel p)
	{
		frame.remove(currentPanel);
		currentPanel = p;
		
	}
	public void setUpJFrame()
	{
		frame = new JFrame();
		frame.setLocation(0, 0);
		frame.setSize(1350, 700);
	}
}
