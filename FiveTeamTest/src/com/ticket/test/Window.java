package com.ticket.test;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Window extends JFrame implements ActionListener{
	
	/**
	 * Window app
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan;
	private JButton buttonCreate;
	private JButton buttonUpdate;
	private JButton buttonDelete;
	private JButton buttonList;
	private JButton buttonTotByMonth;
	private JButton buttonTotal;
	private JTextField result;
	private JLabel result_label;
	private JTextField title;
	private JLabel title_label;
	private JFormattedTextField format;
	private JLabel date_label;
	private JTextField price;
	private JLabel price_label;
	private JLabel combLbel;
	private JComboBox combo;
	Table table;
	/**
	 * 
	 */
	Window(){
		this.setTitle("Ticket Manager");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		this.setVisible(true);
		
		pan = new JPanel();
		
		
		buttonCreate = new JButton("Create Ticket");
		buttonUpdate = new JButton("Update Ticket");
		buttonDelete = new JButton("Delete Ticket");
		buttonList = new JButton("Tickets List");
		buttonTotByMonth = new JButton("Total by month");
		buttonTotal = new JButton("Total");
		result = new  JTextField();
		title = new  JTextField();
		format = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		price = new  JTextField();
		result_label = new JLabel();
		title_label = new JLabel();
		price_label = new JLabel();
		date_label = new JLabel();
		combo = new JComboBox();
		combLbel = new JLabel();
		
		pan.setLayout(null);
		pan.setBounds(1, 1, 400, 400);
		
		buttonList.setBounds(200, 20, 140, 30);
		buttonList.addActionListener(this);
		
		title.setBounds(70, 60, 100, 30);
		price.setBounds(70, 140, 100, 30);
		format.setBounds(70, 100, 100, 30);
	
		format.setValue(new Date());
		format.setFocusLostBehavior(JFormattedTextField.REVERT);
		title_label.setText("Title :");
		title_label.setBounds(30, 60, 40, 30);
		date_label.setText("Date :");
		date_label.setBounds(30, 100, 40, 30);
		price_label.setText("Price :");
		price_label.setBounds(30, 140, 40, 30);
		
		buttonCreate.setBounds(20, 190, 110, 30);
		buttonCreate.setBackground(Color.GREEN);
		buttonCreate.addActionListener(this);
		
		buttonUpdate.setBounds(140, 190, 110, 30);
		buttonUpdate.setBackground(Color.CYAN);
		buttonUpdate.addActionListener(this);
		
		buttonDelete.setBounds(260, 190, 110, 30);
		buttonDelete.setBackground(Color.RED);
		buttonDelete.addActionListener(this);
		
		
		
		buttonTotByMonth.setBounds(250, 240, 120, 30);
		buttonTotByMonth.addActionListener(this);
		
		buttonTotal.setBounds(250, 280, 120, 30);
		buttonTotal.addActionListener(this);
		
		result.setBounds(250, 320, 120, 30);
		result_label.setBounds(180, 120, 160, 30);
		
		combo.setPreferredSize(new Dimension(100, 20));
		//combo.addItemListener(aListener);
		combo.setBounds(150, 240, 70, 30);
		for(int i=1; i<13;i++){
			combo.addItem(i);
		}
		combLbel.setText("Month");
		combLbel.setBounds(90, 240, 50, 30);
		
		pan.add(buttonCreate);
		pan.add(buttonUpdate);
		pan.add(buttonDelete);
		pan.add(buttonList);
		pan.add(buttonTotByMonth);
		pan.add(buttonTotal);
		pan.add(result);
		pan.add(title);
		pan.add(price);
		pan.add(format);
		pan.add(title_label);
		pan.add(price_label);
		pan.add(date_label);
		pan.add(result_label);
		pan.add(combo);
		pan.add(combLbel);
		this.setContentPane(pan); 
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JOptionPane jop = new JOptionPane();
		if(e.getSource() == buttonTotByMonth){
			int totalByMonth = TicketList.getInstance().getTotalByMonthTicket(Integer.parseInt(combo.getSelectedItem().toString()));
			result.setText("Tickets ByMonth : "+Integer.toString(totalByMonth));
		}
		if(e.getSource() == buttonTotal){
			int total = TicketList.getInstance().getTotalTicket();
			result.setText("Tickets Number : "+Integer.toString(total));
		}
		if(e.getSource() == buttonCreate){
			if(title.getText().isEmpty() && format.getText().isEmpty() && price.getText().isEmpty()){
				jop.showMessageDialog(null, "Pleas Fill all fields ", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			if(!TicketList.getInstance().findTicket((Date)format.getValue())){
				TicketList.getInstance().addTicket(title.getText(), (Date)format.getValue(), Double.parseDouble(price.getText()));
			}else{
				jop.showMessageDialog(null, "Pleas take another day ", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			this.initialiseFields();
		}
		if(e.getSource() == buttonUpdate){
			if(!TicketList.getInstance().findTicket((Date)format.getValue()))
				jop.showMessageDialog(null, "Ticket not exist ", "Warning", JOptionPane.WARNING_MESSAGE);
			else{
				TicketList.getInstance().updateTicket(title.getText(), (Date)format.getValue(), Double.parseDouble(price.getText()));
			}
			this.initialiseFields();
		}
		if(e.getSource() == buttonDelete){
			if(!TicketList.getInstance().findTicket((Date)format.getValue()))
				jop.showMessageDialog(null, "Ticket not exist ", "Warning", JOptionPane.WARNING_MESSAGE);
			else{
				TicketList.getInstance().deleteTicket(title.getText(), (Date)format.getValue(), Double.parseDouble(price.getText()));
			}
			this.initialiseFields();
		}
		if(e.getSource() == buttonList){
			if(TicketList.getInstance().getTicketList().isEmpty())
				jop.showMessageDialog(null, "List is empty ", "Warning", JOptionPane.WARNING_MESSAGE);
			else{
				table = new Table();
			}
		}
	}
	private void initialiseFields(){
		title.setText("");
		price.setText("");
		
	}
}
