package controller.service;

import java.sql.SQLException;

import model.service.Service;

public class ServiceOrder {
	public static boolean addServiceOrder(Service s) throws SQLException
	{
		return ServiceOrderDatabaseBridge.addServiceOrderToDatabase(s);
	}
}
