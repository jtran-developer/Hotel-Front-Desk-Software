package model.service;

public abstract class Service {
	private int roomNumber;
	private Issue issue;
	public Service(int r, Issue i)
	{
		this.roomNumber = r;
		this.issue = i;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getIssue()
	{
		return this.issue.getComment();
	}
	public abstract String getType();
}
