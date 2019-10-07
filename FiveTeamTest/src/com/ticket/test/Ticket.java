package com.ticket.test;

import java.util.Date;

public class Ticket {

	private String title;
	private Date date;
	private double price;
	/**
	 * Initialise Ticket
	 * @param title
	 * @param date
	 * @param price
	 */
	public Ticket(String title, Date date, double price) {
		this.title = title;
		this.date = date;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
