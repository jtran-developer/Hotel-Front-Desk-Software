package controller.booking;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.global.DatabaseBridge;
import model.reservation.Reservation;

public class BookReservationDatabaseBridge {

	private static String bookedString = "BOOKED";
	public static boolean addReservationToDatabase(Reservation r, int c)
	{
		//System.out.println("In addReservationToDatabase");
		String name = r.getName();
		int confirmationID = c;
		
		ArrayList<Date> allDatesCustomerWants = BookReservation.getArrayListOfDatesUsingStartAndEndDate(r.getStartDate(), r.getEndDate());
		try
		{
		String sql = "INSERT INTO hotelsystemdatabase.guests\r\n" + 
					"VALUES ('" + confirmationID + "', '" + name + "', '" + bookedString + "');";
			DatabaseBridge.insertStatement(sql);
	        
			for (Date d : allDatesCustomerWants)
			{
				//System.out.println(d.toString());
				sql = "INSERT INTO hotelsystemdatabase.occupation "
						+ "VALUES ('" + confirmationID + "', " + r.getRoomNumber() + ", STR_TO_DATE('" + d.toString() + "', '%Y-%m-%d'));";
				DatabaseBridge.insertStatement(sql);
			}
		}
		catch (SQLException e)
		{
			return false;
		}
		return true;
	}
	public static ResultSet getAllRoomData() throws SQLException
	{
		String sql = "SELECT * FROM hotelsystemdatabase.occupation;";
		return DatabaseBridge.selectStatement(sql);
	}
	public static void setBookedString(String b)
	{
		bookedString = b;
	}
}
