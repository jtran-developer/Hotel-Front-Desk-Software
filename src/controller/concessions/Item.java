package controller.concessions;

public class Item {

	private String identifier;
	private String description;
	private double price;
	
	public Item(String iden, String desc, double p)
	{
		this.identifier = iden;
		this.description = desc;
		this.price = p;
	}
	
	public String getIdentifier() 
	{
		return identifier;
	}

	public String getDescription() 
	{
		return description;
	}

	public double getPrice() 
	{
		return price;
	}
}
