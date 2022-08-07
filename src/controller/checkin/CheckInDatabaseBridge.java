package controller.checkin;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import model.reservation.Reservation;

public class CheckInDatabaseBridge {
	private static String checkedInString = "CHECKEDIN";
	static public boolean updateCheckInStatus(int confirmationID, String name) throws SQLException
	{
		String sql = "UPDATE `hotelsystemdatabase`.`guests` SET `status` = '" + checkedInString + "' "
				+ "WHERE (`confirmationid` = '" + confirmationID + "' AND `name` = '" + name + "');";
		int i = controller.global.DatabaseBridge.updateStatement(sql);
		return (i==1 ? true : false);
	}
	public static Reservation getReservation(int confirmationID, String name) throws SQLException
	{
		int rn=-1;
		ArrayList<Date> d = new ArrayList<Date>();
		
		String sql = "SELECT * FROM hotelsystemdatabase.occupation WHERE confirmationID = " + confirmationID + ";";
		ResultSet rs = controller.global.DatabaseBridge.selectStatement(sql);
		while(rs.next()) {
			rn = rs.getInt(2);
			d.add( rs.getDate(3) );
		}
		
		Reservation r = new Reservation();
		r.setName(name);
		r.setStartDate( Collections.min(d) );
		r.setEndDate( Collections.max(d) );
		r.setRoomNumber(rn);
		return r;
	}
	public static void setCheckedInString(String c)
	{
		checkedInString = c;
	}
	
}