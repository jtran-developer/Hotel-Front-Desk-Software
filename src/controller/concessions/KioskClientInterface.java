package controller.concessions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class KioskClientInterface {
	static HashMap<String, Item> itemMap = new HashMap<String, Item>();
	Order o;
	private int confirmationID;
	private String name;
	
		public KioskClientInterface() throws SQLException
		{
			o = new Order();
		}
		public static void initiateItemMap(ArrayList<Item> ml)
		{
			for (Item i: ml) 
			{
				itemMap.put(i.getIdentifier()+"", i);
			}
		}
		public void buildOrder(ArrayList<String> i) 
		{
			o.clearOrder();
			for (String j : i)
			{
				o.addItemToOrder(itemMap.get(j));
			}
		}
		public String sendOrder(String paymentInfo)
		{
			return ConcessionOrder.sendUserRequest(o, paymentInfo, confirmationID);
		}
		public HashMap<String, Item> getMenuItems()
		{
			return itemMap;
		}
		public boolean logInForKiosk(int c, String n) throws SQLException
		{
			confirmationID = c;
			name = n;
			return ConcessionOrder.certifyUserInformation(c, n);
		}
		
}
