package model.service;

public class MaintenanceService extends Service {
	public MaintenanceService(int r, String c)
	{
		super(r, new NeedIssue(c));	
	}
	public String getType() {
		return "M";
	}
}
