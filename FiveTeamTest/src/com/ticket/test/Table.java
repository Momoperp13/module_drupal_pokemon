package com.ticket.test;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Table extends JFrame {
	
	/**
	 * Ticket list Window
	 */
	private static final long serialVersionUID = 1L;

	Table(){
		this.setTitle("Ticket List");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		this.setVisible(true);
		
		JTable table;
		SimpleDateFormat formatDate;
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		table = new JTable();
		String[] header = {"Title", "Date", "Price"};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		Object[] row = new Object[3];
		for (Ticket ticket : TicketList.getInstance().getTicketList()) {
			row[0] = ticket.getTitle();
			row[1] = formatDate.format(ticket.getDate());
			row[2] = ticket.getPrice();
			model.addRow(row);	
		}	
	
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(100,180));
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane();
		add(scroll);
		this.setContentPane(table);
	}

}
