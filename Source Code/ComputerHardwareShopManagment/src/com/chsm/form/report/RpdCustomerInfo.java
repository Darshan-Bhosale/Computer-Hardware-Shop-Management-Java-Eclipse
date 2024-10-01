package com.chsm.form.report;

import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import DBmodel.sqlconnection;

@SuppressWarnings("serial")
public class RpdCustomerInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblCustomerInformationReport;
	private JButton button;

	void view()
	{
		try
		{
			Connection c=sqlconnection.getConnection();
			String s="select * from customer";
			PreparedStatement pst=c.prepareStatement(s);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}  
	
	public RpdCustomerInfo() {
		setTitle("Customer_Info_Report");
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 100, 800, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblCustomerInformationReport = new JLabel("Customer Information Report");
		lblCustomerInformationReport.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCustomerInformationReport.setBounds(40, 36, 400, 30);
		contentPane.add(lblCustomerInformationReport);
		
		button = new JButton("Print");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Report print");
			    MessageFormat footer = new MessageFormat("Page{0,number,integer}");
			    
			    try{
			      table .print(JTable.PrintMode.NORMAL,header,footer);
			    } catch (java.awt.print.PrinterException ex){
			        System.err.format("Can not print %s %n",ex.getMessage());
			    }
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(740, 36, 100, 30);
		contentPane.add(button);
		view();
		
	}
}
