package controller.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class DatabaseBridge {
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/hotelsystemdatabase?useSSL=false";	
	
	static final String USER = "root";
	static final String PASS = "root";
	
	static Connection conn = null;
	static Statement stmt = null;
	   
	public static void initializeDatabase() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
	}
	public static ResultSet selectStatement(String sql) throws SQLException
	{
		// Returns the data found
		
		/* For reference, the syntax is as follows:
			SELECT * 
			FROM hotelsystemdatabase.guests
			WHERE confirmationid="12345670"; 
		 */
		return stmt.executeQuery(sql);
	}
	public static int updateStatement(String sql) throws SQLException
	{
		// Returns 1 if a change is possible, meaning the WHERE clause found rows that matched
		// Returns 0 if a change is not possible
		
		/* For reference, the syntax is as follows:
			UPDATE hotelsystemdatabase.guests 
			SET name="testname4"
			WHERE confirmationid="12345670";    
		*/
		return stmt.executeUpdate(sql);	
	}
	public static int insertStatement(String sql) throws SQLException
	{
		//System.out.println("In insertStatement");
		// Returns 1 if a change is possible, meaning the WHERE clause found rows that matched
		// Returns 0 if a change is not possible
		
		/* For reference, the syntax is as follows:
			insert into guests
			values('12345676', 'testname8', STR_TO_DATE('18-4-2019', '%d-%m-%Y'), STR_TO_DATE('25-4-2019', '%d-%m-%Y'), 'booked');
		
			(the order of the values is confirmationid, name, startdate, enddate, status, for this table)
		*/
		return stmt.executeUpdate(sql);	
	}
		 
}
