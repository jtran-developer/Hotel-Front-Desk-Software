package view.movie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import system.JavaApp;
import controller.movie.ClientHotelSystemMovieOrderInterface;

public class AccessMedia extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultTableModel movietable;
	ClientHotelSystemMovieOrderInterface chmoi;
	private JTable table;
	private JTextField room;
	private JTextField paymentId;
	private ArrayList<Movie> moviesAvailableToWatch;

	public AccessMedia() {

		final JPanel panel = new JPanel();
		panel.setBounds(12, 55, 1092, 442);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(158, 504, 816, 326);

		String[] columns = {"", "Movie Id", "Title", "Description"};
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		chmoi = new ClientHotelSystemMovieOrderInterface();

		panel.add(scrollPane);

		JButton btnWatchMovie = new JButton("Watch Movie");
		btnWatchMovie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		btnWatchMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> selectedMovies = new ArrayList<>();
				for (int i = 0; i < movietable.getRowCount(); i++) {
					if((boolean) movietable.getValueAt(i, 0)){
						selectedMovies.add(movietable.getValueAt(i, 1).toString());
					}
				}
				System.out.println("Selected movies" + selectedMovies);
				if(selectedMovies.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select a movie to play.");
				}else if(selectedMovies.size() > 1) {
					JOptionPane.showMessageDialog(null, "Please select one movie at a time.");
				}else {
					String playingMovieId = selectedMovies.get(0);
					for (Iterator<Movie> iterator = moviesAvailableToWatch.iterator(); iterator
							.hasNext();) {
						Movie movie = (Movie) iterator.next();
						if (movie.getMovieId().equals(playingMovieId)){
							JOptionPane.showMessageDialog(null, "Playing movie " + movie.getTitle() + " from directory " + movie.getFilePath() + " in room " + room.getText());
						}

					}
				}

			}});
		panel_1.add(btnWatchMovie);
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
		room.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {}

			public void focusLost(FocusEvent e) {

				if(room.getText() != null) {
					String confirmationId = JOptionPane.showInputDialog("Please provide your confirmation id to proceed?");
					String outputRoom = chmoi.validateRoomNUmber(confirmationId);
					System.out.println("Output room "  + outputRoom);
					if(outputRoom != null && !outputRoom.isEmpty()) {
						System.out.println("Inside 1 " + outputRoom + " "+ room.getText());
						if(outputRoom.trim().equals(room.getText())) {
							JOptionPane.showMessageDialog(null, "You can now enjoy your movies!!" );
							moviesAvailableToWatch = chmoi.getMoviesAvailableToRent().getMovies();
							for (Iterator<Movie> iterator = moviesAvailableToWatch.iterator(); iterator
									.hasNext();) {
								Movie movie = (Movie) iterator.next();
								Object[] row = {false , movie.getMovieId(), movie.getTitle(), movie.getDesc()};
								movietable.addRow(row);
								System.out.println(" Movie Id " + movie.getMovieId());

							}
							//movietable.fireTableDataChanged();
							System.out.println("Repainting table");
							//table.setModel(movietable);
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect room number or confirmation identity");
					}
				}
			}

		});
		this.add(room);
		room.setColumns(10);

		JLabel lblOrderMovie = new JLabel("Order Movie");
		lblOrderMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderMovie.setBounds(523, -3, 104, 22);
		this.add(lblOrderMovie);
	}

}
