package controller.booking;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.reservation.Reservation;

public class ClientHotelSystemBookReservationInterface {
	private Reservation r;
	public ClientHotelSystemBookReservationInterface()
	{
		// Default construction
	}
	public void resetReservation()
	{
		r = new Reservation();
	}
	public String createReservation(String n, String p, Date s, Date e) throws SQLException
	{
		//System.out.println("In createReservation");
		r.setName(n);
		r.setPayment(p);
		r.setStartDate(s);
		r.setEndDate(e);
		r.setPricePerDay(BookReservation.getPrice());
		int room = BookReservation.findRoom(s, e);
		r.setRoomNumber(room);
		if (room == -1)
		{
			//System.out.println("Err1");
			return "There are no rooms available.  Please select a different date or try again later.";
		}
		else if (room == -2)
		{
			return "The Start Date is after the End Date.  Please try again.";
		}
		return sendReservation();
	}
	public String sendReservation() throws SQLException
	{
		return BookReservation.addBookReservation(this.r);
	}
	
}
