package controller.service;

import java.sql.SQLException;

import model.service.HouseKeepingService;
import model.service.MaintenanceService;

public class FrontDeskHotelSystemHMServiceOrderInterface {
	public FrontDeskHotelSystemHMServiceOrderInterface()
	{
		
	}
	public void sendHousekeepingService(int r) throws SQLException
	{
		ServiceOrder.addServiceOrder(new HouseKeepingService(r));
	}
	public void sendMaintenanceService(int r, String i) throws SQLException
	{
		ServiceOrder.addServiceOrder(new MaintenanceService(r, i));
	}	
}
