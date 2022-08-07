package controller.statistics;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelStatistics {

	HotelStatisticsDatabaseBridge hotelStatisticsDatabaseBridge= new HotelStatisticsDatabaseBridge();
	
	public  ResultSet getroomdetailsbasedondateandstatus(Date startDate, Date endDate, String status) throws SQLException {
		return hotelStatisticsDatabaseBridge.getroomdetailsbasedondateandstatus(startDate, endDate, status);
	}
	public  ResultSet getroomdetailsbasedondate(Date startDate, Date endDate) throws SQLException {
		return hotelStatisticsDatabaseBridge.getroomdetailsbasedondate(startDate, endDate);
	}
	

}
