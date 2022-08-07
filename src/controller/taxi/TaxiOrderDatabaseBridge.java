package controller.taxi;

import java.sql.SQLException;
import java.time.LocalDate;

import controller.global.DatabaseBridge;
import model.taxi.TaxiRequest;

public class TaxiOrderDatabaseBridge{

	public TaxiOrderDatabaseBridge() {
		// TODO Auto-generated constructor stub
	}
public static boolean addTaxiOrderToDatabase(TaxiRequest tr){
		String sql = "INSERT INTO hotelsystemdatabase.taxiorder (roomnumber, name, passengers, bookingdate, destination, taxiorderdate ) VALUES ( '"+ tr.getRoomNumber() + "', '" + tr.getName() + "','" + tr.getPassengers()  + "', '" + tr.getBookingDate() + "', '"+ tr.getDestination()+ "', '" + LocalDate.now() + "');";
		System.out.println("sql" + sql);
		try {
			DatabaseBridge.insertStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
}
}