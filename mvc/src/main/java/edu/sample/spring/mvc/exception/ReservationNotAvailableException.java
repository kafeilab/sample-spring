package edu.sample.spring.mvc.exception;

import java.util.Date;

public class ReservationNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = -5996062515801957658L;
	
	private String courtName;
	private Date date;
	private int hour;
	
	public ReservationNotAvailableException(String name, Date date, int hour) {
		setCourtName(name);
		setDate(date);
		setHour(hour);
	}
	
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}

}
