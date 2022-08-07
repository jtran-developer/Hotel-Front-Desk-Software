package system;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.booking.BookReservation;
import controller.concessions.Item;
import controller.global.DatabaseBridge;

public class main {
	public static final String booked = "BOOKED";
	public static final String checkedIn = "CHECKEDIN";
	public static final String checkedOut = "CHECKEDOUT";
	
	public static void main(String[] args) throws SQLException {
		// Boots up the system and initializes the database and all variables
		bootUpSystem();
		
		// Start the prototype for testing purposes
		//Prototype p = new Prototype();
		
		// Start the actual Java Application
		JavaApp j = new JavaApp();
	}
	public static void bootUpSystem()
	{
		// Set up variables (optional)
		controller.booking.BookReservationDatabaseBridge.setBookedString(booked);
		controller.checkin.CheckInDatabaseBridge.setCheckedInString(checkedIn);
		
		// Initialize MySQL Database
		try
		{
			DatabaseBridge.initializeDatabase();
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			System.out.println("Unable to connect to the database.");
			System.exit(0);
		}
		
		// Book Reservation variables
		BookReservation.setPrice(100);
		BookReservation.setMaxRoom(100);
		
		// Concessions
		ArrayList<Item> cl = new ArrayList<Item>();
		cl.add(new Item("1", "Burger", 4.99));
		cl.add(new Item("2", "Chip", 1.99));
		cl.add(new Item("3", "Soda", 1.49));
		cl.add(new Item("4", "Hot Dog", 3.49));
		cl.add(new Item("5", "Water", 0.99));
		controller.concessions.KioskClientInterface.initiateItemMap(cl);
	}
}
