/**
 * 
 */
package controller.movie;

import java.sql.SQLException;

import model.movie.Order;
import controller.global.DatabaseBridge;
import controller.thirdpartypayment.ThirdPartyPaymentBridge;

/**
 * @author ranib
 *
 */
public class MovieOrder {

	/**
	 * 
	 */
	public MovieOrder() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Public method to retrieve movies available to rent
	 * @return Array list of movie object
	 * @author ranib
	 */
	public static Order getMoviesAvailable(){
		return controller.movie.MovieOrderDatabaseBridge.getAvailableMoviesFromDatabase();
	}
	
	/**
	 * Public method to place a movie order
	 * @param movieList
	 * @param roomnumber
	 * @return true/false
	 * @author ranib
	 */
	public static String addMovieOrder(String paymentId, double amount, String roomNumber, Order order ){
		
		if(!ThirdPartyPaymentBridge.validatePaymentInformation(paymentId)){
			return "Please provide a valid 16 digit payment number.";
		}
		if(!ThirdPartyPaymentBridge.chargePayment(amount)){
			return "Transaction failed, please try again.";
		}
		String movieOrderId = controller.movie.MovieOrderDatabaseBridge.addMovieOrderToDatabase(roomNumber); 
		if(movieOrderId == null || movieOrderId.isEmpty()){
			return "Transaction failed, unable to add movie order.";
		}
		// Adding access to movies
		if(controller.movie.MediaAccess.addAccess(order,movieOrderId)){
			String sql = "update hotelsystemdatabase.movieorder set moviestatus = 'COMP' where movieorderid =" +  movieOrderId +" ;";
			try {
				DatabaseBridge.updateStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Unable to add media access.";
			}
		}
		return "SUCCESS";
	}


}
