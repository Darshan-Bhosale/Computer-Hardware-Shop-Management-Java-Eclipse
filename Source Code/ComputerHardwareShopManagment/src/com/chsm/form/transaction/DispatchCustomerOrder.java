package com.chsm.form.transaction;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import com.chsm.form.db.DBCustomer;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;
import java.awt.event.*;


@SuppressWarnings("serial")
public class DispatchCustomerOrder extends JFrame {

	private JPanel panel, panelDI, panelCI, panelPI, panelOpration;
	private JTextField txtDispatchID, txtCustomerContactNo, txtOrderAmount, txtDriverName, txtAddTax, txtTotalAmount, txtCustomerName, txtVehicalNumber;
	private JLabel lblDispatchID, lblDispatchDate, lblCustomerContactNo, lblOrderAmount, lblDriverName, lblTotalAmount, lblCustomerName, lblVehicalNumber,
					lblCustomerAddress, lblOrderID;
	private JTextArea txtCustomerAddress;
	private JComboBox<Integer> txtOrderID;
	private JScrollPane scrollPane;
	private JButton btnAddTax, btnSave, btnClear, btnExit;
	private JDateChooser txtDispatchDate;
	private DBCustomer db = new DBCustomer();
	
	public static java.sql.Date datemethad(java.util.Date date)
	{
	if(date != null)
	{
		java.sql.Date sqld = new Date(date.getTime());
		return sqld;
	}
	return null;
	}
	
	

	public void data()
	{
		try {
			Connection c =sqlconnection.getConnection();
			PreparedStatement pst = c.prepareStatement("SELECT * FROM CUST_ORDER");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				
				int temp = rs.getInt("id");
				//txtOrderID.addItem(rs1.getInt("id"));
				if(rs.wasNull())
				{
					JOptionPane.showMessageDialog(null, "there is no order of Customer in table....");
					dispose();
						
				}
				else 
				{
					txtOrderID.addItem(temp);					
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public DispatchCustomerOrder() 
	{
		//setAlwaysOnTop(true);
		setTitle("Dispatch_Customer_Order");
		setBounds(100, 100, 1200, 480);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panelDI = new JPanel();
		panelDI.setLayout(null);
		panelDI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dispatch_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDI.setBounds(24, 18, 564, 130);
		panel.add(panelDI);
		
		lblDispatchID = new JLabel("Dispatch ID :");
		lblDispatchID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDispatchID.setBounds(35, 26, 189, 25);
		panelDI.add(lblDispatchID);
		
		txtDispatchID = new JTextField();
		txtDispatchID.setBounds(259, 26, 270, 25);
		txtDispatchID.setText(db.setDOID());
		panelDI.add(txtDispatchID);
		txtDispatchID.setEditable(false);
		
		lblDispatchDate = new JLabel("Dispatch Date :");
		lblDispatchDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDispatchDate.setBounds(35, 77, 189, 25);
		panelDI.add(lblDispatchDate);
		
		txtDispatchDate = new JDateChooser();
		txtDispatchDate.setBounds(259, 77, 270, 25);
		panelDI.add(txtDispatchDate);
		
		panelCI = new JPanel();
		panelCI.setLayout(null);
		panelCI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCI.setBounds(24, 161, 564, 261);
		panel.add(panelCI);
		
		lblOrderID = new JLabel("Order ID :");
		lblOrderID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderID.setBounds(35, 24, 189, 25);
		panelCI.add(lblOrderID);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(35, 73, 189, 25);
		panelCI.add(lblCustomerName);
		
		lblCustomerAddress = new JLabel("Customer Address :");
		lblCustomerAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerAddress.setBounds(35, 122, 189, 25);
		panelCI.add(lblCustomerAddress);
		
		lblCustomerContactNo = new JLabel("Customer Contact No. : ");
		lblCustomerContactNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerContactNo.setBounds(35, 208, 189, 25);
		panelCI.add(lblCustomerContactNo);
		
		txtCustomerContactNo = new JTextField();
		txtCustomerContactNo.setBounds(259, 208, 270, 25);
		panelCI.add(txtCustomerContactNo);
		txtCustomerContactNo.setEditable(false);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(259, 73, 270, 25);
		panelCI.add(txtCustomerName);
		txtCustomerName.setEditable(false);
		
		txtOrderID = new JComboBox<Integer>();
		txtOrderID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					final Connection c =sqlconnection.getConnection();
					final PreparedStatement pst = c.prepareStatement("SELECT * FROM CUST_ORDER WHERE ID=?");
					int i =(int) txtOrderID.getSelectedItem();
					pst.setInt(1, i);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtCustomerName.setText(rs.getString("cust_name"));
						txtCustomerAddress.setText(rs.getString("address"));
						txtCustomerContactNo.setText(rs.getString("cust_contact"));
						txtOrderAmount.setText(rs.getString("tot_amount"));
						txtTotalAmount.setText(rs.getString("tot_amount"));
					}
				}
				catch(final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		txtOrderID.setBounds(259, 24, 270, 25);
		panelCI.add(txtOrderID);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 122, 268, 62);
		panelCI.add(scrollPane);
		
		txtCustomerAddress = new JTextArea();
		scrollPane.setViewportView(txtCustomerAddress);
		txtCustomerAddress.setEditable(false);
		
		panelPI = new JPanel();
		panelPI.setLayout(null);
		panelPI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Product_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPI.setBounds(598, 18, 564, 279);
		panel.add(panelPI);
		
		lblOrderAmount = new JLabel("Order Amount :");
		lblOrderAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderAmount.setBounds(35, 25, 189, 25);
		panelPI.add(lblOrderAmount);
		
		txtOrderAmount = new JTextField();
		txtOrderAmount.setBounds(259, 25, 270, 25);
		panelPI.add(txtOrderAmount);
		txtOrderAmount.setEditable(false);
		
		lblVehicalNumber = new JLabel("Vehical Number :");
		lblVehicalNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVehicalNumber.setBounds(35, 75, 189, 25);
		panelPI.add(lblVehicalNumber);
		
		lblDriverName = new JLabel("Driver Name :");
		lblDriverName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDriverName.setBounds(35, 125, 189, 25);
		panelPI.add(lblDriverName);
		
		txtDriverName = new JTextField();
		txtDriverName.setBounds(259, 125, 270, 25);
		panelPI.add(txtDriverName);
		
		txtAddTax = new JTextField();
		txtAddTax.setText("0");
		txtAddTax.setBounds(259, 175, 270, 25);
		panelPI.add(txtAddTax);
		txtAddTax.setEditable(false);
		
		lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(35, 225, 189, 25);
		panelPI.add(lblTotalAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.setBounds(259, 225, 270, 25);
		panelPI.add(txtTotalAmount);
		txtTotalAmount.setEditable(false);
		
		btnAddTax = new JButton("Add 5% Tax");
		btnAddTax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtAddTax.setText(String.valueOf(Integer.parseInt(txtOrderAmount.getText())*5/100));
				String totle=String.valueOf(Integer.parseInt(txtAddTax.getText()) + Integer.parseInt(txtOrderAmount.getText()));
				txtTotalAmount.setText(totle);
			}
		});
		btnAddTax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddTax.setBounds(35, 168, 117, 39);
		panelPI.add(btnAddTax);
		
		txtVehicalNumber = new JTextField();
		txtVehicalNumber.setBounds(259, 75, 270, 25);
		panelPI.add(txtVehicalNumber);
		
		panelOpration = new JPanel();
		panelOpration.setLayout(null);
		panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOpration.setBounds(598, 308, 564, 114);
		panel.add(panelOpration);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int i = (int) txtOrderID.getSelectedItem();
				db.decustorder(Integer.parseInt(txtDispatchID.getText()), datemethad(txtDispatchDate.getDate()), 
						i, txtCustomerName.getText(), txtCustomerAddress.getText(), txtCustomerContactNo.getText(), 
						Integer.parseInt(txtOrderAmount.getText()), txtVehicalNumber.getText(), txtDriverName.getText(), 
						Integer.parseInt(txtTotalAmount.getText()));
				
				JOptionPane.showMessageDialog(null, "Customer Order Dispatch Save Sucesfull....");
				dispose();
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBackground(new Color(230, 230, 250));
		btnSave.setBounds(28, 32, 150, 50);
		panelOpration.add(btnSave);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtDispatchDate.setCalendar(null);
				txtCustomerContactNo.setText(null);
				txtOrderAmount.setText(null);
				txtDriverName.setText(null);
				txtAddTax.setText(null);
				txtTotalAmount.setText(null);
				txtCustomerName.setText(null);
				txtVehicalNumber.setText(null);
				txtCustomerAddress.setText(null);
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(206, 32, 150, 50);
		panelOpration.add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Do you want to close Dispatch Customer Order....");
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(384, 32, 150, 50);
		panelOpration.add(btnExit);
		
		data();
	}
}
