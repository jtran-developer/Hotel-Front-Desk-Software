package system;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import controller.booking.ClientHotelSystemBookReservationInterface;
import controller.global.DatabaseBridge;
import controller.global.VerifyUserInformation;
import controller.service.FrontDeskHotelSystemHMServiceOrderInterface;


public class Prototype {
	public Prototype() throws SQLException, ParseException
	{
		run();
	}
	public void run() throws SQLException, ParseException
	{
		System.out.println("Starting Prototype");
		System.out.println("Please select an option below");
		System.out.println("1. Book a reservation");
		System.out.println("2. verify user information");
		System.out.println("3. database bridge");
		System.out.println("4. housekeeping service");
		System.out.println("5. maintenance service");
		System.out.println("6. ");
		System.out.println("7. ");
		System.out.println("8. ");
        Scanner in = new Scanner(System.in);
        while (true)
        {
	        String s = in.nextLine();
	        switch(s) {
	        case "1":
	        	System.out.println("Starting: ClientHotelSystemReservationInterface");
	        	ClientHotelSystemBookReservationInterface c = new ClientHotelSystemBookReservationInterface();
	        	
	        	Date start = Date.valueOf("2019-01-1");
	    		Date end = Date.valueOf("2019-01-3");
	
	    		c.resetReservation();
	    		//if (c.createReservation("test name", "1234-5678-9012-3456", start, end))
	    		
	 
	    		
	    		
	        	break;
	        case "2":
	        	System.out.println("2");
	        	System.out.println("User found: " + VerifyUserInformation.verifyUser(12345670, "testname3"));
	        	break;
	        case "3":
	        	DatabaseBridge.insertStatement("insert into guests\r\n" + 
	        			"values('12345674', 'testname7', STR_TO_DATE('18-4-2019', '%d-%m-%Y'), STR_TO_DATE('25-4-2019', '%d-%m-%Y'), 'booked')");
	        	break;
	        case "4":
	        	FrontDeskHotelSystemHMServiceOrderInterface h = new FrontDeskHotelSystemHMServiceOrderInterface();
	        	h.sendHousekeepingService(1);
	        	break;
	        case "5":
	        	FrontDeskHotelSystemHMServiceOrderInterface m = new FrontDeskHotelSystemHMServiceOrderInterface();
	        	m.sendMaintenanceService(1, "testissue");
	        	break;
	        default:
	        	System.out.println("Something else");
	        }
        }
	    //in.close();
	}
}
