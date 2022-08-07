package controller.concessions;

import java.sql.SQLException;

import controller.global.DatabaseBridge;

public class ConcessionDatabaseBridge {
	public static boolean addConcessionOrderToDatabase(Order o, int oID, int cc) 
	{
		int success = 0;
		
		try {
			String sql = "insert into ordersactive values('" + oID + " ', '"+ cc + "', 'INPROGESS');";
			success = DatabaseBridge.insertStatement(sql);
			
			if(success == 1) {
				for (Item i : o.getOrder() )
				{
					sql = "insert into `order` values(" + oID + ", " + i.getIdentifier()  + ");";
					DatabaseBridge.insertStatement(sql);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
        
		return true;
	}
}