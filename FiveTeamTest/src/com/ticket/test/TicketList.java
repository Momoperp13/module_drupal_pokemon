package com.ticket.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public final class TicketList {
	/**
	 * Use patterne singleton for the ticket list 
	 */
	ArrayList<Ticket> ticketList;
	private static TicketList instance = null;
	private TicketList(){
		ticketList = new ArrayList<Ticket>();
	}
	public final static TicketList getInstance(){
		if (TicketList.instance == null) {
            synchronized(TicketList.class) {
              if (TicketList.instance == null) {
            	  TicketList.instance = new TicketList();
              }
            }
         }
         return TicketList.instance;
	}
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}
	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	public boolean findTicket(Date date){
		for(Ticket ticket:ticketList){
			if (ticket.getDate().equals(date))
				return true;
		}
		return false;
	}
	public void addTicket(String title, Date date, double price){
		ticketList.add(new Ticket(title, date, price));	
	}
	public void updateTicket(String title, Date date, double price){
		Ticket ticket = getTicket(date);
				ticket.setPrice(price);
				ticket.setTitle(title);
	
	}
	public void deleteTicket(String text, Date date, double parseDouble) {
		Ticket ticket = getTicket(date);
		ticketList.remove(ticket);
	}
	public int getTotalTicket(){
		return ticketList.size();
	}
	public int getTotalByMonthTicket(int month) {
		int total = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		for(Ticket ticket:ticketList){	
			if (Integer.parseInt(dateFormat.format(ticket.getDate())) == month){
				
				total++;
			}		
		}
		return total;
	}
	
	public Ticket getTicket(Date date){
		for(Ticket ticket:ticketList){
			if (ticket.getDate().equals(date)){
				return ticket;
			}		
		}
		return null;
	}
	

}
