package com.chsm.form.transaction;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

import com.chsm.form.db.DBCustomer;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;



@SuppressWarnings("serial")
public class CustomerOrder extends JFrame {

	private JPanel contentPane, panelOI, panelCI, panelPI, panelOpration;
	private JTextField txtCustomerOrderID, txtCustomerName, txtProductModelNo, txtCustomerContactNo, txtCustomerBalanceAmount, txtProductQuntity, txtProductRate, txtTotalAmount;
	private JLabel lblCustomerName, lblCustomerOrderID, lblCustomerOrderDate, lblCustomerID, lblCustomerContactNo, lblCustomerBalanceAmount, 
						lblProductId, lblProductQuntity, lblProductRate, lblTotalAmount, lblProductModelNo;
	@SuppressWarnings("rawtypes")
	private JComboBox txtCustomerId, txtProductId;
	private JButton btnSave, btnClear, btnExit;
	private JDateChooser txtCustomerOrderDate;
	private DBCustomer db = new DBCustomer();
	String address;
	int pid, cid;
	Integer temp;

	
	public static java.sql.Date datemethad(java.util.Date date)
	{
	if(date != null)
	{
		java.sql.Date sqld = new Date(date.getTime());
		return sqld;
	}
	return null;
	}
	
	@SuppressWarnings({ "unchecked" })
	public void data()
	{
		try {
			Connection c =sqlconnection.getConnection();
			PreparedStatement pst = c.prepareStatement("Select * from customer");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				int temp = rs.getInt("id");
				if(rs.wasNull())
				{
					JOptionPane.showMessageDialog(null, "there is no data of Customer in table....");
					dispose();
				}
				else 
				{
					txtCustomerId.addItem(temp);					
				}
			}
			
			PreparedStatement pst1 = c.prepareStatement("Select * from product");
			ResultSet rs1 = pst1.executeQuery();
			while(rs1.next())
			{
				int temp1 = rs1.getInt("id");
				if(rs1.wasNull())
				{
					JOptionPane.showMessageDialog(null, "there is no data of product in table....");
					dispose();
				}
				else 
				{
					txtProductId.addItem(temp1);
				}
			}
			pst1.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	public CustomerOrder()
	{
	
		setTitle("Customer_Order");
		setBounds(100, 100, 1200, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelOI = new JPanel();
		panelOI.setLayout(null);
		panelOI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOI.setBounds(24, 18, 564, 155);
		contentPane.add(panelOI);
		
		lblCustomerOrderID = new JLabel("Customer Order ID :");
		lblCustomerOrderID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerOrderID.setBounds(35, 35, 189, 25);
		panelOI.add(lblCustomerOrderID);
		
		txtCustomerOrderID = new JTextField();
		txtCustomerOrderID.setBounds(259, 35, 270, 25);
		txtCustomerOrderID.setText(db.setOID());
		panelOI.add(txtCustomerOrderID);
		txtCustomerOrderID.setEditable(false);
		
		lblCustomerOrderDate = new JLabel("Customer Order Date :");
		lblCustomerOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerOrderDate.setBounds(35, 95, 189, 25);
		panelOI.add(lblCustomerOrderDate);
		
		txtCustomerOrderDate = new JDateChooser();
		txtCustomerOrderDate.setBounds(259, 95, 270, 25);
		panelOI.add(txtCustomerOrderDate);
		
		panelCI = new JPanel();
		panelCI.setLayout(null);
		panelCI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCI.setBounds(24, 184, 564, 238);
		contentPane.add(panelCI);
		
		lblCustomerID = new JLabel("Customer ID :");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerID.setBounds(35, 27, 189, 25);
		panelCI.add(lblCustomerID);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(35, 79, 189, 25);
		panelCI.add(lblCustomerName);
		
		txtCustomerId = new JComboBox();
		txtCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cid=(int) (txtCustomerId.getSelectedItem());
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from customer where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, cid);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtCustomerName.setText(rs.getString("name"));
						txtCustomerContactNo.setText(rs.getString("contact"));
						txtCustomerBalanceAmount.setText(rs.getString("balance"));
						address = rs.getString("address");
					}
					
					if (temp != null)
					{
						txtCustomerId.setSelectedItem(temp);
					}
				}
				catch(final Exception ex)
				{
					ex.printStackTrace();
				}	
			}
		});
		txtCustomerId.setBounds(259, 27, 270, 25);
		panelCI.add(txtCustomerId);
		
		lblCustomerContactNo = new JLabel("Customer Contact No. :");
		lblCustomerContactNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerContactNo.setBounds(35, 131, 189, 25);
		panelCI.add(lblCustomerContactNo);
		
		txtCustomerContactNo = new JTextField();
		txtCustomerContactNo.setBounds(259, 131, 270, 25);
		panelCI.add(txtCustomerContactNo);
		txtCustomerContactNo.setEditable(false);
		
		lblCustomerBalanceAmount = new JLabel("Customer Balance Amount : ");
		lblCustomerBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerBalanceAmount.setBounds(35, 183, 189, 25);
		panelCI.add(lblCustomerBalanceAmount);
		
		txtCustomerBalanceAmount = new JTextField();
		txtCustomerBalanceAmount.setBounds(259, 183, 270, 25);
		panelCI.add(txtCustomerBalanceAmount);
		txtCustomerBalanceAmount.setEditable(false);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(false);
		txtCustomerName.setBounds(259, 79, 270, 25);
		panelCI.add(txtCustomerName);
		
		panelPI = new JPanel();
		panelPI.setLayout(null);
		panelPI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Product_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPI.setBounds(598, 18, 564, 279);
		contentPane.add(panelPI);
		
		lblProductId = new JLabel("Product Id :");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductId.setBounds(35, 26, 189, 25);
		panelPI.add(lblProductId);
		
		lblProductModelNo = new JLabel("Product Model No. :");
		lblProductModelNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductModelNo.setBounds(35, 76, 189, 25);
		panelPI.add(lblProductModelNo);
		
		lblProductQuntity = new JLabel("Product Quantity :");
		lblProductQuntity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductQuntity.setBounds(35, 126, 189, 25);
		panelPI.add(lblProductQuntity);
		
		txtProductQuntity = new JTextField();
		txtProductQuntity.setBounds(259, 126, 270, 25);
		panelPI.add(txtProductQuntity);
		
		lblProductRate = new JLabel("Product Rate :");
		lblProductRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductRate.setBounds(35, 176, 189, 25);
		panelPI.add(lblProductRate);
		
		txtProductRate = new JTextField();
		txtProductRate.setBounds(259, 176, 270, 25);
		panelPI.add(txtProductRate);
		txtProductRate.setEditable(false);
		
		lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(35, 226, 189, 25);
		panelPI.add(lblTotalAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=(Integer.parseInt(txtProductRate.getText()) * Integer.parseInt(txtProductQuntity.getText()));
				txtTotalAmount.setText(String.valueOf(i));
			}
		});
		txtTotalAmount.setBounds(259, 226, 270, 25);
		panelPI.add(txtTotalAmount);
		txtTotalAmount.setEditable(false);
		
		txtProductId = new JComboBox();
		txtProductId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pid=(int) (txtProductId.getSelectedItem());
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from product where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, pid);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtProductModelNo.setText(rs.getString("model_no"));
						txtProductRate.setText(rs.getString("prise"));
					}
				}
				catch(final Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		txtProductId.setBounds(259, 26, 270, 25);
		panelPI.add(txtProductId);
		
		txtProductModelNo = new JTextField();
		txtProductModelNo.setEditable(false);
		txtProductModelNo.setBounds(259, 76, 270, 25);
		panelPI.add(txtProductModelNo);
		
		panelOpration = new JPanel();
		panelOpration.setLayout(null);
		panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOpration.setBounds(598, 308, 564, 114);
		contentPane.add(panelOpration);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				db.addcustorder(Integer.parseInt(txtCustomerOrderID.getText()), datemethad(txtCustomerOrderDate.getDate()), cid, txtCustomerName.getText(), txtCustomerContactNo.getText(), Integer.parseInt(txtCustomerBalanceAmount.getText()), pid, txtProductModelNo.getText(),
						Integer.parseInt(txtProductQuntity.getText()), Integer.parseInt(txtProductRate.getText()), Integer.parseInt(txtTotalAmount.getText()), address);
				
				JOptionPane.showMessageDialog(null, "Customer Order Save Sucesfull....");
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
				txtCustomerOrderDate.setCalendar(null);
				txtCustomerName.setText(null);
				txtCustomerContactNo.setText(null);
				txtCustomerBalanceAmount.setText(null);
				txtProductModelNo.setText(null);
				txtProductQuntity.setText(null);
				txtProductRate.setText(null);
				txtTotalAmount.setText(null);
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(206, 32, 150, 50);
		panelOpration.add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Do you want to close Customer Order....");
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
