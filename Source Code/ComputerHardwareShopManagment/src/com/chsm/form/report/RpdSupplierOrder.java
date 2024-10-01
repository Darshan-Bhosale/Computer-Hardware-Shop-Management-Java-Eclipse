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
public class RpdSupplierOrder extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton button;
    private JLabel lblSupplierOrderReport;

    void view() {
        try {
            Connection c = sqlconnection.getConnection();
            String s = "select * from sup_order";
            PreparedStatement pst = c.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //table.setc
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RpdSupplierOrder() {
        setTitle("Supplier_Order_Report");
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 100, 800, 300);
        contentPane.add(scrollPane);

        table = new JTable()
        {
    

    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;   //Disallow the editing of any cell
    }
};
scrollPane.setViewportView(table);
		
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
		
		lblSupplierOrderReport = new JLabel("Supplier Order Report");
		lblSupplierOrderReport.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSupplierOrderReport.setBounds(40, 36, 400, 30);
		contentPane.add(lblSupplierOrderReport);
		view();
	}

}
