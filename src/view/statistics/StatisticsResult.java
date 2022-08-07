package view.statistics;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.JavaApp;

@SuppressWarnings("serial")
public class StatisticsResult extends JPanel{
	JButton backButton;
	DefaultTableModel statisticTable;
	JTable table;
	JLabel header;
	JFrame frame;
	int loopstatus=0;
	public StatisticsResult(ResultSet rs) throws SQLException {
		frame = new JFrame("Statistic Results");
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new JLabel(new ImageIcon("4.jpg")));
		frame.setLayout(new FlowLayout());
		
		header = new JLabel("Statistic Results");
		header.setForeground(Color.white);
		header.setFont(new Font("Serif", Font.BOLD, 20));
		header.setBounds(100, 30, 400,30);
		JTable table = new JTable();
		String[] columns = {"confirmation id","name","status"}; 
		statisticTable = new DefaultTableModel(columns, 0);
		table = new JTable(statisticTable);
		int colNo = rs.getMetaData().getColumnCount();
		System.out.println(colNo);
		while(rs.next()){
			loopstatus=1;
			 Object[] objects = new Object[colNo];
		 for(int i=0;i<colNo;i++){
		if(rs.getObject(i+1)!="")	 
		  objects[i]=rs.getObject(i+1);
		else{
			JavaApp.loadScreen1(new view.statistics.Errorpage("Request returned no results"));
		}
		  }
		 statisticTable.addRow(objects);
		}
		if(loopstatus==0)
		{
			JavaApp.loadScreen1(new view.statistics.Errorpage("Request returned 'Zero' results..Please change the search criteria"));
		}
		else{
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setForeground(Color.white);
		scrollPane.setFont(new Font("Serif", Font.BOLD, 16));
		scrollPane.setBounds(100, 90, 600,100);
		frame.getContentPane().add(scrollPane);
		
		backButton = backButton();
		backButton.setBounds(100, 300, 100, 30);
		
			frame.add(header);
			frame.add(scrollPane);
			frame.add(backButton);
			frame.setSize(1920, 1080);
			frame.setLayout(null);
			frame.setVisible(true);
		}
	}
	public JButton backButton()
	{
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen1(new view.statistics.Statistics());
			}});
		return back;
	}

}
