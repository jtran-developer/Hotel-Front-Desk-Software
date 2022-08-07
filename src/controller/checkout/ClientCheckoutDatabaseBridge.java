package controller.checkout;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.global.DatabaseBridge;

public class ClientCheckoutDatabaseBridge {

	public ClientCheckoutDatabaseBridge() {
		// TODO Auto-generated constructor stub
	}
	
		public static final String checkedOut = "CHECKEDOUT";
		
		public  ResultSet getClientData(String confirmationID) throws Exception	{
			String sql="";
			sql = "SELECT  g.confirmationid, g.name, g.status, min(o.date) as startdate, max(o.date) as enddate  FROM hotelsystemdatabase.occupation as o  JOIN hotelsystemdatabase.guests as g ON o.confirmationid=g.confirmationid WHERE g.confirmationid='"+confirmationID+"'";
			return DatabaseBridge.selectStatement(sql);
		}
		public  ResultSet updateStatustoCheckout(String confirmationID) throws Exception		{
			String sql="";
			sql = "Update hotelsystemdatabase.guests set status = '"+checkedOut+"' where confirmationid = '"+confirmationID+"'";
			int rowsupdated =DatabaseBridge.updateStatement(sql);
			if(rowsupdated==1)
			sql = "SELECT  g.confirmationid, g.name, g.status, min(o.date) as startdate, max(o.date) as enddate  FROM hotelsystemdatabase.occupation as o  JOIN hotelsystemdatabase.guests as g ON o.confirmationid=g.confirmationid WHERE g.confirmationid='"+confirmationID+"'";
			return DatabaseBridge.selectStatement(sql);
		}
		
	}

