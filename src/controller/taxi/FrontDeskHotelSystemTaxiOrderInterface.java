/**
 * 
 */
package controller.taxi;

import model.taxi.TaxiRequest;

/**
 * @author ranib
 *
 */
public class FrontDeskHotelSystemTaxiOrderInterface {
	
	public FrontDeskHotelSystemTaxiOrderInterface() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Public method to place a movie order
	 * @param movieList
	 * @param roomnumber
	 * @return true/false
	 * @author ranib
	 */
	public String sendTaxiOrder(TaxiRequest taxiRequest){
		return controller.taxi.TaxiOrder.addTaxiOrder(taxiRequest);
	}

}
