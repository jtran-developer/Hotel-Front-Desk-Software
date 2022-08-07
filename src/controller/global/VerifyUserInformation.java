package controller.global;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyUserInformation {

	public static boolean verifyUser(int confirmationID, String name) throws SQLException
	{
		String sql = "SELECT * "
				+ "FROM hotelsystemdatabase.guests "
				+ "WHERE confirmationID = '" + confirmationID + "' and name = '" + name + "'";
		ResultSet rs = DatabaseBridge.selectStatement(sql);
		
		return rs.next();
	}
	public static boolean verifyUserOnStatus(int c, String n, String status) throws SQLException
	{
		String sql = "SELECT * "
				+ "FROM hotelsystemdatabase.guests "
				+ "WHERE confirmationID = '" + c + "' "
						+ "AND name = '" + n + "'"
						+ "AND `status` = '" + status + "';";
		ResultSet rs = DatabaseBridge.selectStatement(sql);
		
		return rs.next();
		
		
	}
}
