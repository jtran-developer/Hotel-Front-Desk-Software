package model.reservation;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

		private String name;
		private String paymentNumber;
		private Date startDate;
		private Date endDate;
		private double pricePerDay;
		private int roomNumber;
		
		public Reservation()
		{
			this.name = null;
			this.paymentNumber = null;
			this.startDate = null;
			this.endDate = null;
			this.pricePerDay = -1;		
		}
		
		public double getTotalPrice()
		{
			long diff = endDate.getTime() - startDate.getTime();
			int durationOfStay = (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
			return this.pricePerDay * durationOfStay;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPayment() {
			return paymentNumber;
		}

		public void setPayment(String payment) {
			this.paymentNumber = payment.replace("-", "");
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date date) {
			this.startDate = date;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public double getPricePerDay() {
			return pricePerDay;
		}

		public void setPricePerDay(double pricePerDay) {
			this.pricePerDay = pricePerDay;
		}
		public int getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
}
