package controller.checkin;

import java.sql.SQLException;

import controller.global.VerifyUserInformation;
import model.reservation.Reservation;

public class CheckIn {
	
	static public boolean checkUser(int confirmationID, String name) throws SQLException
	{
		return VerifyUserInformation.verifyUser(confirmationID, name);
	}
	
	static public Reservation findReservation(int confirmationID, String name) throws SQLException
	{
		return CheckInDatabaseBridge.getReservation(confirmationID, name);
	}
	
	static public String checkInGuest(int confirmationID, String name) throws SQLException
	{
		if( CheckInDatabaseBridge.updateCheckInStatus(confirmationID, name) )
			return "Check In Successful";
		else
			return "Check In Not Successful, try a different confirmation ID";
	}
}
