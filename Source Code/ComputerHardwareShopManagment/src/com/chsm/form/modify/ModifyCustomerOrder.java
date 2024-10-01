package com.chsm.form.modify;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import com.chsm.form.db.DBCustomer;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ModifyCustomerOrder extends JFrame {

	private JPanel contentPane, panelOrderS, panelCustomerI, panelProductInfo, panelOperation;
	private JLabel lblCustOrderId, lblCustOrderDate, lblCustomerId, lblProductQuntity, lblTotalAmount, lblProductRate, lblCustomerName, lblCustomer, lblDriverName, lblProductCode, lblProductName;
	private JTextField txtCustomerID, txtCustomerContactNo, txtCustomerBalanceAmount, txtProductId, txtProductQuantity, txtProductRate, txtTotalAmount, txtPModelNo, txtCustomerName;
	@SuppressWarnings("rawtypes")
	private JComboBox txtCustOrderId;
	private JDateChooser txtCustOrderDate;
	private JButton btnUpdate, btnDelete, btnExit;
	private int eid;
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
	

	@SuppressWarnings("unchecked")
	public void data()
	{
		try 
		{
			Connection c =sqlconnection.getConnection();
			String sql = "Select * from cust_order";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of customer Order in table....");
			}
			else 
			{
				while(rs.next())
				{	txtCustOrderId.addItem(rs.getInt("id"));		}	
			}
			pst.close();
		} catch (SQLException e) {	e.printStackTrace();	}
	}

		
	@SuppressWarnings("rawtypes")
	public ModifyCustomerOrder() 
	{
		setTitle("Searching_Customer_Order");
		setBounds(100, 100, 1200, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelOrderS = new JPanel();
		panelOrderS.setLayout(null);
		panelOrderS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search_Order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrderS.setBounds(24, 18, 564, 155);
		contentPane.add(panelOrderS);
		
		lblCustOrderId = new JLabel("Customer Order ID :");
		lblCustOrderId.setForeground(Color.BLACK);
		lblCustOrderId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustOrderId.setBounds(38, 35, 189, 25);
		panelOrderS.add(lblCustOrderId);
		
		lblCustOrderDate = new JLabel("Customer Order Date :");
		lblCustOrderDate.setForeground(Color.BLACK);
		lblCustOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustOrderDate.setBounds(38, 95, 189, 25);
		panelOrderS.add(lblCustOrderDate);
		
		txtCustOrderId = new JComboBox();
		txtCustOrderId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eid=Integer.parseInt(txtCustOrderId.getSelectedItem().toString());
				   
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from cust_order where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, eid);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtCustOrderDate.setDate(rs.getDate("date"));
						txtCustomerID.setText(rs.getString("cust_id"));
						txtCustomerName.setText(rs.getString("cust_name"));
						txtCustomerContactNo.setText(rs.getString("cust_contact"));
						txtCustomerBalanceAmount.setText(rs.getString("cust_bamount"));
						txtProductId.setText(rs.getString("pro_id"));
						txtPModelNo.setText(rs.getString("pro_mno"));
						txtProductQuantity.setText(rs.getString("pro_quntity"));
						txtProductRate.setText(rs.getString("pro_rate"));
						txtTotalAmount.setText(rs.getString("tot_amount"));
					}
					}
					catch(final Exception ex)
					{
						ex.printStackTrace();
					}
					}
				});
		txtCustOrderId.setBounds(253, 35, 270, 25);
		panelOrderS.add(txtCustOrderId);
		
		txtCustOrderDate = new JDateChooser();
		txtCustOrderDate.setBounds(253, 95, 270, 25);
		panelOrderS.add(txtCustOrderDate);
		
		panelCustomerI = new JPanel();
		panelCustomerI.setLayout(null);
		panelCustomerI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCustomerI.setBounds(24, 184, 564, 238);
		contentPane.add(panelCustomerI);
		
		lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setForeground(Color.BLACK);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerId.setBounds(38, 28, 189, 25);
		panelCustomerI.add(lblCustomerId);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setEditable(true);
		txtCustomerID.setColumns(10);
		txtCustomerID.setBackground(new Color(230, 230, 250));
		txtCustomerID.setBounds(253, 28, 270, 25);
		panelCustomerI.add(txtCustomerID);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setForeground(Color.BLACK);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(38, 79, 189, 25);
		panelCustomerI.add(lblCustomerName);
		
		lblCustomer = new JLabel("Customer Contact No. :");
		lblCustomer.setForeground(Color.BLACK);
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomer.setBounds(38, 129, 189, 25);
		panelCustomerI.add(lblCustomer);
		
		txtCustomerContactNo = new JTextField();
		txtCustomerContactNo.setEditable(true);
		txtCustomerContactNo.setColumns(10);
		txtCustomerContactNo.setBackground(new Color(230, 230, 250));
		txtCustomerContactNo.setBounds(253, 129, 270, 25);
		panelCustomerI.add(txtCustomerContactNo);
		
		lblDriverName = new JLabel("Customer Balance Amount : ");
		lblDriverName.setForeground(Color.BLACK);
		lblDriverName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDriverName.setBounds(38, 182, 189, 25);
		panelCustomerI.add(lblDriverName);
		
		txtCustomerBalanceAmount = new JTextField();
		txtCustomerBalanceAmount.setEditable(true);
		txtCustomerBalanceAmount.setColumns(10);
		txtCustomerBalanceAmount.setBackground(new Color(230, 230, 250));
		txtCustomerBalanceAmount.setBounds(253, 182, 270, 25);
		panelCustomerI.add(txtCustomerBalanceAmount);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(true);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBackground(new Color(230, 230, 250));
		txtCustomerName.setBounds(253, 79, 270, 25);
		panelCustomerI.add(txtCustomerName);
		
		panelProductInfo = new JPanel();
		panelProductInfo.setLayout(null);
		panelProductInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Product_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProductInfo.setBounds(598, 18, 564, 279);
		contentPane.add(panelProductInfo);
		
		lblProductCode = new JLabel("Product Id :");
		lblProductCode.setForeground(Color.BLACK);
		lblProductCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductCode.setBounds(38, 25, 189, 25);
		panelProductInfo.add(lblProductCode);
		
		txtProductId = new JTextField();
		txtProductId.setEditable(true);
		txtProductId.setColumns(10);
		txtProductId.setBackground(new Color(230, 230, 250));
		txtProductId.setBounds(253, 25, 270, 25);
		panelProductInfo.add(txtProductId);
		
		lblProductName = new JLabel("Product Model No. :");
		lblProductName.setForeground(Color.BLACK);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductName.setBounds(38, 75, 189, 25);
		panelProductInfo.add(lblProductName);
		
		lblProductQuntity = new JLabel("Product Quantity :");
		lblProductQuntity.setForeground(Color.BLACK);
		lblProductQuntity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductQuntity.setBounds(38, 125, 189, 25);
		panelProductInfo.add(lblProductQuntity);
		
		txtProductQuantity = new JTextField();
		txtProductQuantity.setEditable(true);
		txtProductQuantity.setColumns(10);
		txtProductQuantity.setBackground(new Color(230, 230, 250));
		txtProductQuantity.setBounds(253, 125, 270, 25);
		panelProductInfo.add(txtProductQuantity);
		
		lblProductRate = new JLabel("Product Rate :");
		lblProductRate.setForeground(Color.BLACK);
		lblProductRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductRate.setBounds(38, 175, 189, 25);
		panelProductInfo.add(lblProductRate);
		
		txtProductRate = new JTextField();
		txtProductRate.setEditable(false);
		txtProductRate.setColumns(10);
		txtProductRate.setBackground(new Color(230, 230, 250));
		txtProductRate.setBounds(253, 175, 270, 25);
		panelProductInfo.add(txtProductRate);
		
		lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(38, 225, 189, 25);
		panelProductInfo.add(lblTotalAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=(Integer.parseInt(txtProductRate.getText()) * Integer.parseInt(txtProductQuantity.getText()));
				txtTotalAmount.setText(String.valueOf(i));
			}
		});
		txtTotalAmount.setEditable(false);
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBackground(new Color(230, 230, 250));
		txtTotalAmount.setBounds(253, 225, 270, 25);
		panelProductInfo.add(txtTotalAmount);
		
		txtPModelNo = new JTextField();
		txtPModelNo.setColumns(10);
		txtPModelNo.setBackground(new Color(230, 230, 250));
		txtPModelNo.setBounds(253, 75, 270, 25);
		panelProductInfo.add(txtPModelNo);
		
		panelOperation = new JPanel();
		panelOperation.setLayout(null);
		panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperation.setBounds(598, 308, 564, 114);
		contentPane.add(panelOperation);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oid= (int) txtCustOrderId.getSelectedItem();
				db.updatecustorder(oid, datemethad(txtCustOrderDate.getDate()), Integer.parseInt(txtCustomerID.getText()), 
						txtCustomerName.getText(), txtCustomerContactNo.getText(), Integer.parseInt(txtCustomerBalanceAmount.getText()), 
						Integer.parseInt(txtProductId.getText()), txtPModelNo.getText(), Integer.parseInt(txtProductQuantity.getText()), 
						Integer.parseInt(txtProductRate.getText()), Integer.parseInt(txtTotalAmount.getText()));
				
				JOptionPane.showMessageDialog(null, "Customer Order Update Sucesfull....");
				dispose();
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBackground(new Color(230, 230, 250));
		btnUpdate.setBounds(28, 32, 150, 50);
		panelOperation.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt((txtCustOrderId.getSelectedItem()).toString());
				db.dlcustorder(i);
				
				JOptionPane.showMessageDialog(null, "Customer Order Data delete Successfully....");
				dispose();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBackground(new Color(230, 230, 250));
		btnDelete.setBounds(206, 32, 150, 50);
		panelOperation.add(btnDelete);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Do you want to close Modify_Customer_Order....");
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(384, 32, 150, 50);
		panelOperation.add(btnExit);
		
		data();
	}
}
