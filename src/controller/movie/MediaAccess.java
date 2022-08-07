package controller.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.movie.Movie;
import model.movie.Order;
import controller.global.DatabaseBridge;

public class MediaAccess {

	public MediaAccess() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Public method to add  access to movies to watch
	 * @return
	 */
	public static boolean addAccess(Order order, String movieOrderId){
		
		int i = 0;
		for (Iterator<Movie> iterator = order.getMovies().iterator(); iterator.hasNext();) {
			i++;
			String movieId = iterator.next().getMovieId();
			String sql = "INSERT INTO hotelsystemdatabase.mediaaccess VALUES (" + movieOrderId + ", " + i+ ", " + movieId +");";
			System.out.println("sql" + sql);
			try {
				DatabaseBridge.insertStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Public method to retrieve movies available to watch
	 * @return Array list of movie object
	 * @author ranib
	 */
	public static Order checkAccess( String roomNumber){
		// Declare an empty list
		ArrayList<Movie> movieList = new ArrayList<>();
		// SQL to retrieve all available movies to watch
		StringBuilder sqlStrBldr = new StringBuilder();
		sqlStrBldr.append("SELECT DISTINCT C.movieid, C.title, C.description, C.filepath ");
		sqlStrBldr.append("FROM hotelsystemdatabase.movieorder A, hotelsystemdatabase.mediaaccess B, hotelsystemdatabase.movieitem C ");
		sqlStrBldr.append("where A.roomnumber = '" + roomNumber + "' ");
		sqlStrBldr.append("and A.movieorderid = B.movieorderid ");
		sqlStrBldr.append("and B.movieid = C.movieid; ");
		
		String sql = sqlStrBldr.toString();
		System.out.println(sql);
		try {
			ResultSet result = DatabaseBridge.selectStatement(sql);
			while (result.next()) {
				//System.out.println(result);
				Movie movie = new Movie();
				movie.setMovieId(Integer.toString(result.getInt("movieid")));
				movie.setTitle(result.getString("title"));
				movie.setDesc(result.getString("description"));
				movie.setFilePath(result.getString("filepath"));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return new Order(movieList);
	}

}
