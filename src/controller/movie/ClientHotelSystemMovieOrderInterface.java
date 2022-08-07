/**
 * 
 */
package controller.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.movie.Movie;
import model.movie.Order;
import controller.global.DatabaseBridge;
import controller.thirdpartypayment.ThirdPartyPaymentBridge;

/**
 * @author ranib
 *
 */
public class ClientHotelSystemMovieOrderInterface {
	
	
	/**
	 * Public method to retrieve movies available to rent
	 * @return Array list of movie object
	 * @author ranib
	 */
	public Order getMoviesAvailableToRent(){
		return controller.movie.MovieOrder.getMoviesAvailable();
	}
	
	public String sendMovieOrder(String paymentId, double amount, String roomNumber, Order order){
		return controller.movie.MovieOrder.addMovieOrder(paymentId, amount, roomNumber, order);
	}
	
	/**
	 * Public method to validate room number
	 * @return Array list of movie object
	 * @author ranib
	 */
	public String validateRoomNUmber(String confirmationId){
		
		// SQL to retrieve room number from confirmationId
		String sql = "SELECT roomnumber FROM hotelsystemdatabase.occupation where confirmationid = '"+ confirmationId +"';";
		try {
			ResultSet result = DatabaseBridge.selectStatement(sql);
			while (result.next()) {
				return result.getString("roomnumber");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
