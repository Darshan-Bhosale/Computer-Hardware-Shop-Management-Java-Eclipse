package com.chsm.form.modify;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import DBmodel.sqlconnection;
import com.chsm.form.db.DBSupplier;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ModifySupplierOrder extends JFrame {

	private JPanel panel, panelMNRInformation, panelSI, panelPI, panelOpration;
	private JTextField txtSupplierName, txtProductModelNo, txtSupplierID, txtProductID, txtProductQuntity, txtProductRate, txtTotalAmount;
	private JLabel lblMRNID, lblMRNDate, lblSupplierID, lblProductId, lblProductQuntity, lblProductRate, lblTotalAmount, lblSupplierName, lblProductModelNo;
	private JButton btnUpdate, btnDelete, btnExit;
	private JDateChooser txtMRNDate;
	@SuppressWarnings("rawtypes")
	private JComboBox txtMRNID;
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
			String sql = "Select * from sup_order";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of supplier order in table....");
			}
			else 
			{
				while(rs.next())
				{	txtMRNID.addItem(rs.getInt("id"));		}	
			}
			pst.close();
		} catch (SQLException e) {	e.printStackTrace();	}
	}
		
		
		


		@SuppressWarnings("rawtypes")
		public ModifySupplierOrder() 
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
		
		lblMRNDate = new JLabel("MRN Date :");
		lblMRNDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMRNDate.setBounds(35, 67, 189, 25);
		panelMNRInformation.add(lblMRNDate);
		
		txtMRNDate = new JDateChooser();
		txtMRNDate.setBounds(259, 67, 270, 25);
		panelMNRInformation.add(txtMRNDate);
		
		txtMRNID = new JComboBox();
		txtMRNID.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
			{
				int id=Integer.parseInt(txtMRNID.getSelectedItem().toString());
				
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from sup_order where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, id);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtMRNDate.setDate(rs.getDate("date"));
						txtSupplierID.setText(rs.getString("sup_id"));
						txtSupplierName.setText(rs.getString("sup_name"));
						txtProductID.setText(rs.getString("pro_id"));
						txtProductModelNo.setText(rs.getString("pro_mn"));
						txtProductQuntity.setText(rs.getString("pro_qn"));
						txtProductRate.setText(rs.getString("pro_rate"));
						txtTotalAmount.setText(rs.getString("tot_amount"));
					}
				}
				catch(final Exception e4)
				{
					e4.printStackTrace();
				}
			}

		});
		txtMRNID.setBounds(259, 21, 270, 25);
		panelMNRInformation.add(txtMRNID);
		
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
		
		lblSupplierName = new JLabel("Supplier Name :");
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierName.setBounds(35, 67, 189, 25);
		panelSI.add(lblSupplierName);
		
		txtSupplierID = new JTextField();
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
		
		lblProductModelNo = new JLabel("Product Model No. :");
		lblProductModelNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductModelNo.setBounds(35, 63, 189, 25);
		panelPI.add(lblProductModelNo);
		
		lblProductQuntity = new JLabel("Product Quantity :");
		lblProductQuntity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductQuntity.setBounds(35, 107, 189, 25);
		panelPI.add(lblProductQuntity);
		
		txtProductQuntity = new JTextField();
		txtProductQuntity.setText("0");
		txtProductQuntity.setBounds(259, 107, 270, 25);
		panelPI.add(txtProductQuntity);
		
		lblProductRate = new JLabel("Product Rate :");
		lblProductRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductRate.setBounds(35, 151, 189, 25);
		panelPI.add(lblProductRate);
		
		txtProductRate = new JTextField();
		txtProductRate.setEditable(false);
		txtProductRate.setBounds(259, 151, 270, 25);
		panelPI.add(txtProductRate);
		
		lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(35, 195, 189, 25);
		panelPI.add(lblTotalAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.setEditable(false);
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
		
		txtProductID = new JTextField();
		txtProductID.setBounds(259, 19, 270, 25);
		panelPI.add(txtProductID);
		
		panelOpration = new JPanel();
		panelOpration.setLayout(null);
		panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOpration.setBounds(25, 514, 564, 114);
		panel.add(panelOpration);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int mrnid = (int) txtMRNID.getSelectedItem();
				db.updatesupporder(mrnid, datemethad(txtMRNDate.getDate()), Integer.parseInt(txtSupplierID.getText()), 
						txtSupplierName.getText(), Integer.parseInt(txtProductID.getText()), txtProductModelNo.getText(), 
						Integer.parseInt(txtProductQuntity.getText()), Integer.parseInt(txtProductRate.getText()), Integer.parseInt(txtTotalAmount.getText()));
				
				JOptionPane.showMessageDialog(null, "Supplier Order Update Sucesfull....");
				dispose();
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBackground(new Color(230, 230, 250));
		btnUpdate.setBounds(28, 32, 150, 50);
		panelOpration.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int i = Integer.parseInt((txtMRNID.getSelectedItem()).toString());
				db.dlsuporder(i);
				JOptionPane.showMessageDialog(null, "Supplier Order Data delete Successfully....");
				dispose();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBackground(new Color(230, 230, 250));
		btnDelete.setBounds(206, 32, 150, 50);
		panelOpration.add(btnDelete);
		
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
