package controller.concessions;

import java.util.ArrayList;

public class Order {
	
	ArrayList<Item> orderList;
		public Order()
		{
			clearOrder();
		}
		
		public double getTotalPrice()
		{
			double totalPrice = 0;
			for(Item i : orderList)
			{
				totalPrice += i.getPrice();
			}
			return totalPrice;
		}
		public void addItemToOrder(Item i)
		{
			orderList.add(i);
		}
		public ArrayList<Item> getOrder()
		{
			return orderList;
		}
		public void clearOrder()
		{
			orderList = new ArrayList<Item>();
		}
}
