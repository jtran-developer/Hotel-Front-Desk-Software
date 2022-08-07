package controller.concessions;

import java.sql.SQLException;
import java.util.Random;

import controller.booking.BookReservationDatabaseBridge;
import controller.global.VerifyUserInformation;
import model.reservation.Reservation;

public class ConcessionOrder {
	private static String checkedInString = "CHECKEDIN";
	public static int generateOrderID()
	{
		return new Random().nextInt(100000000);
	}
	
	static public boolean certifyUserInformation(int confirmationID, String name) throws SQLException
	{
		return VerifyUserInformation.verifyUserOnStatus(confirmationID, name, checkedInString);
	}
	
	static public String sendUserRequest(Order o, String paymentInformation, int confirmationID)
	{
		if(controller.thirdpartypayment.ThirdPartyPaymentBridge.validatePaymentInformation(paymentInformation))
		{
			if (controller.thirdpartypayment.ThirdPartyPaymentBridge.chargePayment( o.getTotalPrice() ) ) 
			{
				boolean attemptAddOrder = true;
				boolean success = false;
				int orderID = -1;
				while(attemptAddOrder)
				{
					System.out.println(1);
					orderID = generateOrderID();
					success = ConcessionDatabaseBridge.addConcessionOrderToDatabase(o, orderID, confirmationID);
					if(success)
					{
						attemptAddOrder = false;
					}
				}
			}
			else
			{
				return "Credit Card Denied";
			}
		}
		else
		{
			return "Credit Card Number is not valid";
		}
		return "Payment successful, Order Complete";
	}
	public static void setCheckedInString(String c)
	{
		checkedInString = c;
	}
	
	
}
