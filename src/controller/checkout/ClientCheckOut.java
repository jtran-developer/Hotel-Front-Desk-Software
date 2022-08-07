package controller.checkout;

import java.sql.ResultSet;

public class ClientCheckOut {
	ClientCheckoutDatabaseBridge clientcheckoutDatabaseBridge = new ClientCheckoutDatabaseBridge();

	public ResultSet checkout(String confirmationID) throws Exception
	{
		ResultSet rs= clientcheckoutDatabaseBridge.getClientData(confirmationID);
		return rs;
	}
	public ResultSet updateStatustoCheckout(String confirmationID) throws Exception
	{
		return clientcheckoutDatabaseBridge.updateStatustoCheckout(confirmationID);
	}
}
