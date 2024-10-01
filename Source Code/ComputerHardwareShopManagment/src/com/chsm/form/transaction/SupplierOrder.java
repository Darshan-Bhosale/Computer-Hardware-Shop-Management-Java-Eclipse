package com.chsm.form.transaction;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import com.chsm.form.db.DBSupplier;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SupplierOrder extends JFrame {

	private JPanel panel, panelMNRInformation, panelSI, panelPI, panelOpration;
	private JTextField txtMRNID, txtSupplierName, txtProductModelNo, txtProductQuntity, txtProductRate, txtTotalAmount;
	private JLabel lblMRNID, lblMRNDate, lblSupplierID, lblProductId, lblProductQuntity, lblProductRate, lblTotalAmount, lblSupplierName, lblProductModelNo;
	private JButton btnSave, btnClear, btnExit;
	private JDateChooser txtMRNDate;
	@SuppressWarnings("rawtypes")
	private JComboBox txtSupplierID, txtProductID;
	private DBSupplier db=new DBSupplier();
	
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
			String sql = "Select * from supplier";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of Supplier in table....");
			}
			else 
			{
				while(rs.next())
				{	txtSupplierID.addItem(rs.getInt("id"));		}	
			}
			rs.close();
			pst.close();
			c.close();
		} catch (SQLException e) {	e.printStackTrace();	}
		
		try 
		{
			Connection c =sqlconnection.getConnection();
			String sql = "Select * from product";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of product in table....");
			}
			else 
			{
				while(rs.next())
				{	txtProductID.addItem(rs.getInt("id"));		}	
			}
			rs.close();
			pst.close();
			c.close();
		} catch (SQLException e) {	e.printStackTrace();	}
		
	}
	
	@SuppressWarnings("rawtypes")
	public SupplierOrder() 
	{
		setTitle("Supplier_Order");
		setBounds(100, 100, 630, 680);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panelMNRInformation = new JPanel();
		panelMNRInformation.setLayout(null);
		panelMNRInformation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MRN_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMNRInformation.setBounds(25, 11, 564, 115);
		panel.add(panelMNRInformation);
		
		lblMRNID = new JLabel("MRN ID :");
		lblMRNID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMRNID.setBounds(35, 21, 189, 25);
		panelMNRInformation.add(lblMRNID);
		
		txtMRNID = new JTextField();
		txtMRNID.setBounds(259, 21, 270, 25);
		txtMRNID.setText(db.setSOID());
		panelMNRInformation.add(txtMRNID);
		txtMRNID.setEditable(false);
		
		lblMRNDate = new JLabel("MRN Date :");
		lblMRNDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMRNDate.setBounds(35, 67, 189, 25);
		panelMNRInformation.add(lblMRNDate);
		
		txtMRNDate = new JDateChooser();
		txtMRNDate.setBounds(259, 67, 270, 25);
		panelMNRInformation.add(txtMRNDate);
		
		panelSI = new JPanel();
		panelSI.setLayout(null);
		panelSI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSI.setBounds(25, 137, 564, 115);
		panel.add(panelSI);
		
		lblSupplierID = new JLabel("Supplier ID :");
		lblSupplierID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierID.setBounds(35, 21, 189, 25);
		panelSI.add(lblSupplierID);
		
		txtSupplierName = new JTextField();
		txtSupplierName.setBounds(259, 67, 270, 25);
		panelSI.add(txtSupplierName);
		txtSupplierName.setEditable(false);
		
		lblSupplierName = new JLabel("Supplier Name :");
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierName.setBounds(35, 67, 189, 25);
		panelSI.add(lblSupplierName);
		
		txtSupplierID = new JComboBox();
		txtSupplierID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int sid=Integer.parseInt(txtSupplierID.getSelectedItem().toString());
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from supplier where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, sid);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtSupplierName.setText(rs.getString("name"));
					}
				}
				catch(final Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		txtSupplierID.setBounds(259, 21, 270, 25);
		panelSI.add(txtSupplierID);
		
		panelPI = new JPanel();
		panelPI.setLayout(null);
		panelPI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Product_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPI.setBounds(25, 263, 564, 240);
		panel.add(panelPI);
		
		lblProductId = new JLabel("Product Id :");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductId.setBounds(35, 19, 189, 25);
		panelPI.add(lblProductId);
		
		txtProductModelNo = new JTextField();
		txtProductModelNo.setBounds(259, 63, 270, 25);
		panelPI.add(txtProductModelNo);
		txtProductModelNo.setEditable(false);
		
		lblProductModelNo = new JLabel("Product Model No. :");
		lblProductModelNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductModelNo.setBounds(35, 63, 189, 25);
		panelPI.add(lblProductModelNo);
		
		lblProductQuntity = new JLabel("Product Quantity :");
		lblProductQuntity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductQuntity.setBounds(35, 107, 189, 25);
		panelPI.add(lblProductQuntity);
		
		txtProductQuntity = new JTextField();
		txtProductQuntity.setText("1");
		txtProductQuntity.setBounds(259, 107, 270, 25);
		panelPI.add(txtProductQuntity);
		
		lblProductRate = new JLabel("Product Rate :");
		lblProductRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductRate.setBounds(35, 151, 189, 25);
		panelPI.add(lblProductRate);
		
		txtProductRate = new JTextField();
		txtProductRate.setBounds(259, 151, 270, 25);
		panelPI.add(txtProductRate);
		txtProductRate.setEditable(false);
		
		lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(35, 195, 189, 25);
		panelPI.add(lblTotalAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int i=(Integer.parseInt(txtProductRate.getText()) * Integer.parseInt(txtProductQuntity.getText()));
				txtTotalAmount.setText(String.valueOf(i));
			}
		});
		txtTotalAmount.setBounds(259, 195, 270, 25);
		panelPI.add(txtTotalAmount);
		txtTotalAmount.setEditable(false);
		
		txtProductID = new JComboBox();
		txtProductID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int pid=Integer.parseInt(txtProductID.getSelectedItem().toString());
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
		txtProductID.setBounds(259, 19, 270, 25);
		panelPI.add(txtProductID);
		
		panelOpration = new JPanel();
		panelOpration.setLayout(null);
		panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOpration.setBounds(25, 514, 564, 114);
		panel.add(panelOpration);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i = (int) txtSupplierID.getSelectedItem();
				int s = (int) txtProductID.getSelectedItem();
				db.addsupporder(Integer.parseInt(txtMRNID.getText()), datemethad(txtMRNDate.getDate()), i, 
						txtSupplierName.getText(), s, txtProductModelNo.getText(), Integer.parseInt(txtProductQuntity.getText()), 
						Integer.parseInt(txtProductRate.getText()), Integer.parseInt(txtTotalAmount.getText()));
				
				JOptionPane.showMessageDialog(null, "Supplier Order Data Save Sucesfull....");
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
				txtSupplierName.setText(null);
				txtProductModelNo.setText(null);
				txtProductQuntity.setText("1");
				txtProductRate.setText(null);
				txtTotalAmount.setText(null);
				txtMRNDate.setCalendar(null);
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
				JOptionPane.showMessageDialog(null, "Do you want to close Supplier Order....");
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
