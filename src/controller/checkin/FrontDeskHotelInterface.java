package controller.checkin;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.reservation.Reservation;

public class FrontDeskHotelInterface {

	String confirmationID;
	String name;
	
	public FrontDeskHotelInterface()
	{
		
	}
	
	public static Reservation searchForReservation(int c, String n) throws SQLException
	{
		if( CheckIn.checkUser(c, n) )
		{
			return CheckIn.findReservation(c,n);
		}
		return null;
	}
	public static boolean checkInConfirmed(int c, String n) throws SQLException
	{
		String m = CheckIn.checkInGuest(c,n); 
		JOptionPane.showMessageDialog( null, m);
		return true;
	}
}