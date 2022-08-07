package controller.taxi;

import model.taxi.TaxiRequest;

public class TaxiServiceBridge {

	public TaxiServiceBridge() {
		// TODO Auto-generated constructor stub
	}
	public static boolean requestTaxiService(TaxiRequest tr)
	{
		return controller.taxi.TaxiServiceDummy.bookTaxiService(tr);
	
	}

}
