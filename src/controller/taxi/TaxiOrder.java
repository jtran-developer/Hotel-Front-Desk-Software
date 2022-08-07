/**
 * 
 */
package controller.taxi;

import controller.thirdpartypayment.ThirdPartyPaymentBridge;
import model.taxi.TaxiRequest;

/**
 * @author ranib
 *
 */


public class TaxiOrder {

	/**
	 * 
	 */
	public TaxiOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public static String addTaxiOrder(TaxiRequest taxiRequest){
		if(ThirdPartyPaymentBridge.validatePaymentInformation(taxiRequest.getPaymentId()))
		{
			if(controller.taxi.TaxiOrderDatabaseBridge.addTaxiOrderToDatabase(taxiRequest))
			{
				controller.taxi.TaxiServiceBridge.requestTaxiService(taxiRequest);
				return "SUCCESS";
			}
			else
			{
				return "Transaction failed, unable to book Taxi.";
			}
		}
				
		else
		{
			return "Please provide a valid 16 digit payment number.";
		}
			
	}
}
