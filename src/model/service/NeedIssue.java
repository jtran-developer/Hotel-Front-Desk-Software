package model.service;

public class NeedIssue implements Issue{
	String issue;
	public NeedIssue(String i)
	{
		this.issue = i;
	}

	public String getComment() {
		return this.issue;
	}
	
}
