package controller.movie;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.movie.Movie;
import model.movie.Order;
import controller.global.DatabaseBridge;

public class MovieOrderDatabaseBridge {

	public MovieOrderDatabaseBridge() {
		// TODO Auto-generated constructor stub
	}
	
	public static Order getAvailableMoviesFromDatabase(){
		// Declare an empty list
		ArrayList<Movie> movieList = new ArrayList<>();
		// SQL to retrieve all available movies
		String sql = "SELECT * FROM hotelsystemdatabase.movieitem;";
		try {
			ResultSet result = DatabaseBridge.selectStatement(sql);
			while (result.next()) {
				Movie movie = new Movie();
				movie.setMovieId(Integer.toString(result.getInt("movieid")));
				movie.setTitle(result.getString("title"));
				movie.setDesc(result.getString("description"));
				movie.setPrice(result.getDouble("price"));
				movie.setFilePath(result.getString("filepath"));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		Order order = new Order(movieList);
		return order;
	}
	
	public static String addMovieOrderToDatabase(String roomNumber){
		
		String sql = "INSERT INTO hotelsystemdatabase.movieorder (roomnumber, moviestatus, movieorderdate ) VALUES ( '"+ roomNumber+ "', 'COMP','" + LocalDate.now() + "');";
		System.out.println("sql" + sql);

		String movieOrderId = null;
		try {
			//movieOrderId = Integer.toString(getGeneratedKeys(sql));
			
			// Insert into database
			controller.global.DatabaseBridge.insertStatement(sql);
			
			// Retrieve the movie order ID
			String sqlForMaxMovieoOrderID = "SELECT MAX(movieorderid) FROM movieorder;";
			ResultSet rs = controller.global.DatabaseBridge.selectStatement(sqlForMaxMovieoOrderID);
			rs.next();
			movieOrderId = rs.getInt(1) + "";
			
			System.out.println("movieOrderId " + movieOrderId);
		} catch (SQLException e) {
			e.printStackTrace();
			return movieOrderId;
		}
		return movieOrderId;
	}
	/*
	 * Private method to return primary key inserted in Database
	 
	private static int getGeneratedKeys(String sql) throws SQLException
	{
		String DB_URL = "jdbc:mysql://localhost/hotelsystemdatabase?useSSL=false";	
		String USER = "root";
		String PASS = "root";
		PreparedStatement ps = DriverManager.getConnection(DB_URL,USER,PASS).prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next())
		{
			return rs.getInt(1);
		}
		return (Integer) null;
			
	}*/
	
}
