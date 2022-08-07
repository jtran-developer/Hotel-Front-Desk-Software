/*package view.movie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.movie.Movie;
import model.movie.Order;
import system.JavaApp;
import controller.movie.ClientHotelSystemMovieOrderInterface;

public class OrderMovie extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultTableModel movietable;
	ClientHotelSystemMovieOrderInterface chmoi;
	private JTable table;
	private JTextField room;
	private JTextField paymentId;
	
	public OrderMovie() {
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 55, 1092, 442);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(158, 504, 816, 326);
		
		String[] columns = {"", "Movie Id", "Title", "Price", "Description"};
		movietable = new DefaultTableModel(columns, 0);
		table = new JTable(movietable){

            private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
             }
        };
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		chmoi = new ClientHotelSystemMovieOrderInterface();
		Order moviesAvailableToRent = chmoi.getMoviesAvailableToRent();
		for (Iterator<Movie> iterator = moviesAvailableToRent.getMovies().iterator(); iterator
				.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Object[] row = {false , movie.getMovieId(), movie.getTitle(), movie.getPrice(), movie.getDesc()};
			movietable.addRow(row);

		}
		panel.add(scrollPane);

		JButton btnOrderMovie = new JButton("Order Movie");
		btnOrderMovie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		btnOrderMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedMovies = new ArrayList<>();
				double amount = 0;
				for (int i = 0; i < movietable.getRowCount(); i++) {
					if((boolean) movietable.getValueAt(i, 0)){
						selectedMovies.add(movietable.getValueAt(i, 1).toString());
						amount = amount + Double.valueOf(movietable.getValueAt(i, 3).toString());
					}
				}
				String roomNumber = room.getText();
				String payment = paymentId.getText();
				if(roomNumber != null && !roomNumber.isEmpty()){
					String confirmationId = JOptionPane.showInputDialog("Please provide your confirmation id to proceed?");
					String outputRoom = chmoi.validateRoomNUmber(confirmationId);
					if(outputRoom != null && !outputRoom.isEmpty()) {
						if(outputRoom.trim().equals(roomNumber)) {
							if(payment != null && !payment.isEmpty()){
								ArrayList<Movie> selMovie = new ArrayList<>();
								for (Iterator<String> iterator = selectedMovies
										.iterator(); iterator.hasNext();) {
									String string = (String) iterator.next();
									Movie movie = new Movie();
									movie.setMovieId((String) iterator.next());
									selMovie.add(movie);
								}
								String result = chmoi.sendMovieOrder(payment, amount,roomNumber, new Order(selMovie));
								if(result == "SUCCESS"){
									JOptionPane.showMessageDialog(null, "Payment succesful for $" + amount + " against room " + roomNumber +". Movies accesible in room media.");
									JavaApp.loadScreen(new view.startup.PrivateComputer());
								}else{
									JOptionPane.showMessageDialog(null, result);
								}
							}else{
								JOptionPane.showMessageDialog(null, "Payment Id can not be blank.");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
					}

				}else{
					JOptionPane.showMessageDialog(null, "Room number can not be blank.");
				}


			}});
		panel_1.add(btnOrderMovie);
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.PrivateComputer());
			}});
		panel_1.add(back);
		this.setLayout(null);
		this.add(panel);
		this.add(panel_1);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(337, 29, 56, 16);
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(lblRoom);

		room = new JTextField();
		room.setBounds(381, 26, 116, 22);
		this.add(room);
		room.setColumns(10);

		JLabel lblPaymentId = new JLabel("Payment Id");
		lblPaymentId.setBounds(545, 29, 82, 16);
		lblPaymentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(lblPaymentId);

		paymentId = new JTextField();
		paymentId.setBounds(626, 26, 116, 22);
		this.add(paymentId);
		paymentId.setColumns(14);

		JLabel lblOrderMovie = new JLabel("Order Movie");
		lblOrderMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderMovie.setBounds(523, -3, 104, 22);
		this.add(lblOrderMovie);
	}

}
*/
package view.movie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.movie.Movie;
import model.movie.Order;
import system.JavaApp;
import controller.movie.ClientHotelSystemMovieOrderInterface;

public class OrderMovie extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultTableModel movietable;
	ClientHotelSystemMovieOrderInterface chmoi;
	private JTable table;
	private JTextField room;
	private JTextField paymentId;
	
	public OrderMovie() {
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 55, 1092, 442);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(158, 504, 816, 326);
		
		String[] columns = {"", "Movie Id", "Title", "Price", "Description"};
		movietable = new DefaultTableModel(columns, 0);
		table = new JTable(movietable){

            private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
             }
        };
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		chmoi = new ClientHotelSystemMovieOrderInterface();
		Order moviesAvailableToRent = chmoi.getMoviesAvailableToRent();
		for (Iterator<Movie> iterator = moviesAvailableToRent.getMovies().iterator(); iterator
				.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Object[] row = {false , movie.getMovieId(), movie.getTitle(), movie.getPrice(), movie.getDesc()};
			movietable.addRow(row);

		}
		panel.add(scrollPane);

		JButton btnOrderMovie = new JButton("Order Movie");
		btnOrderMovie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		btnOrderMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedMovies = new ArrayList<>();
				double amount = 0;
				for (int i = 0; i < movietable.getRowCount(); i++) {
					if((boolean) movietable.getValueAt(i, 0)){
						selectedMovies.add(movietable.getValueAt(i, 1).toString());
						amount = amount + Double.valueOf(movietable.getValueAt(i, 3).toString());
					}
				}
				String roomNumber = room.getText();
				String payment = paymentId.getText();
				if(roomNumber != null && !roomNumber.isEmpty()){
					String confirmationId = JOptionPane.showInputDialog("Please provide your confirmation id to proceed?");
					String outputRoom = chmoi.validateRoomNUmber(confirmationId);
					if(outputRoom != null && !outputRoom.isEmpty()) {
						if(outputRoom.trim().equals(roomNumber)) {
							if(payment != null && !payment.isEmpty()){
								ArrayList<Movie> selMovie = new ArrayList<>();
								for (Iterator<String> iterator = selectedMovies
										.iterator(); iterator.hasNext();) {
									//String string = (String) iterator.next();
									Movie movie = new Movie();
									movie.setMovieId((String) iterator.next());
									selMovie.add(movie);
								}
								String result = chmoi.sendMovieOrder(payment, amount,roomNumber, new Order(selMovie));
								if(result == "SUCCESS"){
									JOptionPane.showMessageDialog(null, "Payment succesful for $" + amount + " against room " + roomNumber +". Movies accesible in room media.");
									JavaApp.loadScreen(new view.startup.PrivateComputer());
								}else{
									JOptionPane.showMessageDialog(null, result);
								}
							}else{
								JOptionPane.showMessageDialog(null, "Payment Id can not be blank.");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
					}

				}else{
					JOptionPane.showMessageDialog(null, "Room number can not be blank.");
				}


			}});
		panel_1.add(btnOrderMovie);
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JavaApp.loadScreen(new view.startup.PrivateComputer());
			}});
		panel_1.add(back);
		this.setLayout(null);
		this.add(panel);
		this.add(panel_1);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(337, 29, 56, 16);
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(lblRoom);

		room = new JTextField();
		room.setBounds(381, 26, 116, 22);
		this.add(room);
		room.setColumns(10);

		JLabel lblPaymentId = new JLabel("Payment Id");
		lblPaymentId.setBounds(545, 29, 82, 16);
		lblPaymentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(lblPaymentId);

		paymentId = new JTextField();
		paymentId.setBounds(626, 26, 116, 22);
		this.add(paymentId);
		paymentId.setColumns(14);

		JLabel lblOrderMovie = new JLabel("Order Movie");
		lblOrderMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderMovie.setBounds(523, -3, 104, 22);
		this.add(lblOrderMovie);
	}

}
