package model.service;

public class HouseKeepingService extends Service{
	public HouseKeepingService(int r)
	{
		super(r, new NoIssue());
	}
	public String getType() {
		return "H";
	}
}
