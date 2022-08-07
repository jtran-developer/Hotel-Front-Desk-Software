package controller.booking;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import model.reservation.Reservation;

public class BookReservation {
	private static double roomPrice = 100;
	private static int maxRoom = 100;
	public static String addBookReservation(Reservation r) throws SQLException
	{
		int confirmationID = -1;
		if (controller.thirdpartypayment.ThirdPartyPaymentBridge.validatePaymentInformation(r.getPayment()))
		{
			if(controller.thirdpartypayment.ThirdPartyPaymentBridge.chargePayment(r.getTotalPrice()))
			{
				boolean attemptBookReservation = true;
				boolean success = false;
				while (attemptBookReservation)
				{		
					confirmationID = generateConfirmationID();
					success = BookReservationDatabaseBridge.addReservationToDatabase(r, confirmationID);
					if (success)
					{
						attemptBookReservation = false;
					}
				}
			}
			else
			{
				return "Payment was denied";
			}
		}
		else
		{
			//Payment information not correct
			return "Payment Information Not Correct";
		}
		return "Reservation complete.  This is your confirmation ID:" + confirmationID;
	}
	private static int generateConfirmationID()
	{
		return new Random().nextInt(100000000);
	}
	
	public static int findRoom(Date s, Date e) throws SQLException
	{
		//System.out.println("In findRoom - parameters are: " + s.toString() + ", " + e.toString());
		ArrayList<Date> allDatesCustomerWants = getArrayListOfDatesUsingStartAndEndDate(s, e);
		if (allDatesCustomerWants == null)
		{
			return -2;
		}
		/*
		System.out.println("Checking dates seeking");
		for (Date dateCustomerWants : allDatesCustomerWants)
		{
			System.out.println(dateCustomerWants.toString());
		}
		System.out.println("Ending dates seeking");
		*/
		ResultSet rs = BookReservationDatabaseBridge.getAllRoomData();
	
		HashMap<String, ArrayList<Date>> rooms = new HashMap<String, ArrayList<Date>>();
		
		while (rs.next())
		{
			String room = rs.getInt(2) + "";
			Date date = rs.getDate(3);
			if (!rooms.containsKey(room))
			{
				rooms.put(room, new ArrayList<Date>());
			}
			rooms.get(room).add(date);
		}
		/*
		System.out.println("starting rooms check");
		for (String room : rooms.keySet())
		{
			System.out.println("Data for room: " + room);
			for (Date d : rooms.get(room))
			{
				System.out.println("- " + d.toString());
			}
		}
		System.out.println("ending rooms check");
		*/
		int roomChecking = 0;
		ArrayList<Date> allDatesTheRoomIsOccupied;
		boolean continueSearch = true;
		boolean roomAvailable = true;
		
		while (continueSearch)
		{
			roomChecking++;
			roomAvailable = true;
			allDatesTheRoomIsOccupied = rooms.get(roomChecking+"");
			if (allDatesTheRoomIsOccupied != null)
			{
				//System.out.println("Checking room:" + roomChecking);
				for (Date dateTheRoomIsOccupied : allDatesTheRoomIsOccupied)
				{
					for (Date dateCustomerWants : allDatesCustomerWants)
					{
						//System.out.println("*comparing dates: " +dateCustomerWants.toString() + " and " + dateTheRoomIsOccupied.toString());
						if (dateCustomerWants.equals(dateTheRoomIsOccupied))
						{
							roomAvailable = false;
							break;
						}
					}
					if (roomAvailable == false)
					{
						break;
					}
				}
			}
			if (roomAvailable == true)
			{
				continueSearch = false;
			}
		}
		if (roomChecking > maxRoom)
		{
			return -1;
		}
		return roomChecking;
	}
	public static ArrayList<Date> getArrayListOfDatesUsingStartAndEndDate(Date s, Date e)
	{
		if (s.after(e))
		{
			return null;
		}
		ArrayList<Date> allDates = new ArrayList<Date>();
		
		Date dateToAdd = s;
		boolean continueAddingDate = true;
		while (continueAddingDate)
		{
			allDates.add(dateToAdd);
			dateToAdd = addDay(dateToAdd);
			if (dateToAdd.equals(e))
			{
				continueAddingDate = false;
			}
		}
		return allDates;
	}
	private static Date addDay(Date d)
    {
		Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        return new Date(c.getTimeInMillis());
    }
	public static void setMaxRoom(int r)
	{
		maxRoom = r;
	}
	public static void setPrice(double p)
	{
		roomPrice = p;
	}
	public static double getPrice()
	{
		return roomPrice;
	}
}
