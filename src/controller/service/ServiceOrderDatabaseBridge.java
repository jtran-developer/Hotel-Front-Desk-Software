package controller.service;

import java.sql.SQLException;

import controller.global.DatabaseBridge;
import model.service.HouseKeepingService;
import model.service.MaintenanceService;
import model.service.Service;

public class ServiceOrderDatabaseBridge {
	private static final String pending = "PENDING";
	private static final String inProgress = "INPROGRESS";
	private static final String complete = "COMPLETE";
	
	public static boolean addServiceOrderToDatabase(Service s) throws SQLException
	{
		String sql = "INSERT INTO `hotelsystemdatabase`.`services` (`servicetype`, `roomnumber`, `issue`, `status`) "
				+ "VALUES ('" + s.getType() + "', '" + s.getRoomNumber() + "', '" + s.getIssue() + "', '" + pending + "');";

		int i = DatabaseBridge.insertStatement(sql);
		return (i == 1 ? true : false);
	}
}
