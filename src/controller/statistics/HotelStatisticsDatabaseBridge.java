package controller.statistics;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.global.DatabaseBridge;

public class HotelStatisticsDatabaseBridge {

	public ResultSet getroomdetailsbasedondateandstatus(Date startDate, Date endDate, String status) throws SQLException {
		String sql = "SELECT distinct g.confirmationid, g.name, g.status  "+
		  "FROM hotelsystemdatabase.occupation as o  JOIN hotelsystemdatabase.guests as g "+
		 "ON o.confirmationid=g.confirmationid WHERE date BETWEEN '"+startDate+"' AND '"+endDate+"' AND status='"+status+"'";
		return DatabaseBridge.selectStatement(sql);
		
	}
	public ResultSet getroomdetailsbasedondate(Date startDate, Date endDate) throws SQLException {
		String sql = "SELECT distinct g.confirmationid, g.name, g.status "+
		  "FROM hotelsystemdatabase.occupation as o  JOIN hotelsystemdatabase.guests as g "+
		 "ON o.confirmationid=g.confirmationid WHERE date BETWEEN '"+startDate+"' AND '"+endDate+"'";
		return DatabaseBridge.selectStatement(sql);
		
	}
}