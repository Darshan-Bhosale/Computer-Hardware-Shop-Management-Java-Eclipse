package com.chsm.form.modify;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import com.chsm.form.db.DBCustomer;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class ModifyCustomer extends JFrame 
{
	private JPanel panelCustoi, panel, panelCustpi, panelOperation, panelCustomerS;
	private JLabel lblCustomerId, lblCustomerEmailId, lblCustomerCreditAmount, lblCustomerContact, lblCustomerDebitAmount, lblCustomerName, lblCustomerBalanceAmount, lblCustomerRegisteredDate, lblCustomerGender, lblCustomerAddress;
	private JTextField txtCustomerName, txtCustomerBAmount, txtCustomerDeAmount, txtCustomerCrAmount, txtCustomerEmailId, txtCustomerContact;
	private JDateChooser txtCustomerRDate;
	@SuppressWarnings("rawtypes")
	private JComboBox txtCustomerId;
	private ButtonGroup buttonGroup;
	private JRadioButton rbMale, rbFemale;
	private JScrollPane scrollPane;
	private JTextArea txtCustomerAddress;
	private JButton btnExit, btnDelete, btnUpadate, btnClear;
	private int cid; 
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
			String sql = "Select * from customer";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of Customer in table....");
			}
			else 
			{
				while(rs.next())
				{	txtCustomerId.addItem(rs.getInt("id"));		}	
			}
			pst.close();
		} catch (SQLException e) {	e.printStackTrace();	}
	}
	
	@SuppressWarnings("rawtypes")
	public ModifyCustomer() 
	{
		
		setResizable(false);
		setTitle("Searching_Customer_Information");
		setBounds(100, 100, 1200, 525);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panelCustpi = new JPanel();
		panelCustpi.setLayout(null);
		panelCustpi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCustpi.setBounds(22, 163, 564, 307);
		panel.add(panelCustpi);
		
		lblCustomerRegisteredDate = new JLabel("Customer Registered Date :");
		lblCustomerRegisteredDate.setForeground(Color.BLACK);
		lblCustomerRegisteredDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerRegisteredDate.setBounds(35, 24, 189, 25);
		panelCustpi.add(lblCustomerRegisteredDate);
		
		lblCustomerGender = new JLabel("Customer Gender :");
		lblCustomerGender.setForeground(Color.BLACK);
		lblCustomerGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerGender.setBounds(35, 68, 189, 25);
		panelCustpi.add(lblCustomerGender);
		
		buttonGroup = new ButtonGroup();
		
		rbMale = new JRadioButton("Male");
		rbMale.setBackground(null);
		buttonGroup.add(rbMale);
		rbMale.setHorizontalAlignment(SwingConstants.CENTER);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbMale.setBounds(273, 69, 64, 23);
		panelCustpi.add(rbMale);
		rbMale.setActionCommand("Male");
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(null);
		buttonGroup.add(rbFemale);
		rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbFemale.setBounds(388, 69, 73, 23);
		panelCustpi.add(rbFemale);
		rbFemale.setActionCommand("Female");
		
		lblCustomerAddress = new JLabel("Customer Address :");
		lblCustomerAddress.setForeground(Color.BLACK);
		lblCustomerAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerAddress.setBounds(35, 110, 189, 25);
		panelCustpi.add(lblCustomerAddress);
		
		lblCustomerContact = new JLabel("Customer Contact :");
		lblCustomerContact.setForeground(Color.BLACK);
		lblCustomerContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerContact.setBounds(35, 219, 189, 25);
		panelCustpi.add(lblCustomerContact);
		
		txtCustomerContact = new JTextField();
		txtCustomerContact.setEditable(true);
		txtCustomerContact.setColumns(10);
		txtCustomerContact.setBackground(new Color(230, 230, 250));
		txtCustomerContact.setBounds(259, 219, 270, 25);
		panelCustpi.add(txtCustomerContact);
		
		lblCustomerEmailId = new JLabel("Customer Email ID :");
		lblCustomerEmailId.setForeground(Color.BLACK);
		lblCustomerEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerEmailId.setBounds(35, 263, 189, 25);
		panelCustpi.add(lblCustomerEmailId);
		
		txtCustomerEmailId = new JTextField();
		txtCustomerEmailId.setEditable(true);
		txtCustomerEmailId.setColumns(10);
		txtCustomerEmailId.setBackground(new Color(230, 230, 250));
		txtCustomerEmailId.setBounds(259, 263, 270, 25);
		panelCustpi.add(txtCustomerEmailId);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 110, 270, 90);
		panelCustpi.add(scrollPane);
		
		txtCustomerAddress = new JTextArea();
		scrollPane.setViewportView(txtCustomerAddress);
		
		txtCustomerRDate = new JDateChooser();
		txtCustomerRDate.setBounds(259, 24, 262, 25);
		panelCustpi.add(txtCustomerRDate);
		
		panelCustoi = new JPanel();
		panelCustoi.setLayout(null);
		panelCustoi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCustoi.setBounds(608, 20, 564, 244);
		panel.add(panelCustoi);
		
		lblCustomerCreditAmount = new JLabel("Customer Credit Amount :");
		lblCustomerCreditAmount.setForeground(Color.BLACK);
		lblCustomerCreditAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerCreditAmount.setBounds(38, 42, 189, 25);
		panelCustoi.add(lblCustomerCreditAmount);
		
		txtCustomerCrAmount = new JTextField();
		txtCustomerCrAmount.setEditable(true);
		txtCustomerCrAmount.setColumns(10);
		txtCustomerCrAmount.setBackground(new Color(230, 230, 250));
		txtCustomerCrAmount.setBounds(253, 42, 270, 25);
		panelCustoi.add(txtCustomerCrAmount);
		
		lblCustomerDebitAmount = new JLabel("Customer Debit Amount :");
		lblCustomerDebitAmount.setForeground(Color.BLACK);
		lblCustomerDebitAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerDebitAmount.setBounds(38, 109, 189, 25);
		panelCustoi.add(lblCustomerDebitAmount);
		
		txtCustomerDeAmount = new JTextField();
		txtCustomerDeAmount.setEditable(true);
		txtCustomerDeAmount.setText("0");
		txtCustomerDeAmount.setColumns(10);
		txtCustomerDeAmount.setBackground(new Color(230, 230, 250));
		txtCustomerDeAmount.setBounds(253, 109, 270, 25);
		panelCustoi.add(txtCustomerDeAmount);
		
		lblCustomerBalanceAmount = new JLabel("Customer Balance Amount :");
		lblCustomerBalanceAmount.setForeground(Color.BLACK);
		lblCustomerBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerBalanceAmount.setBounds(38, 176, 189, 25);
		panelCustoi.add(lblCustomerBalanceAmount);
		
		txtCustomerBAmount = new JTextField();
		txtCustomerBAmount.setEditable(false);
		txtCustomerBAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=(Integer.parseInt(txtCustomerCrAmount.getText())-Integer.parseInt(txtCustomerDeAmount.getText()));
				txtCustomerBAmount.setText(String.valueOf(i));
			}
		});
		txtCustomerBAmount.setColumns(10);
		txtCustomerBAmount.setBackground(new Color(230, 230, 250));
		txtCustomerBAmount.setBounds(253, 176, 270, 25);
		panelCustoi.add(txtCustomerBAmount);
		
		panelOperation = new JPanel();
		panelOperation.setLayout(null);
		panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOperation.setBounds(608, 275, 564, 195);
		panel.add(panelOperation);
		
		btnUpadate = new JButton("Update ");
		btnUpadate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt((txtCustomerId.getSelectedItem()).toString());
				db.updatecust(i, txtCustomerName.getText(), datemethad(txtCustomerRDate.getDate()), buttonGroup.getSelection().getActionCommand(),
						 txtCustomerAddress.getText(),  txtCustomerContact.getText(), txtCustomerEmailId.getText(), Integer.parseInt(txtCustomerCrAmount.getText()),
						 Integer.parseInt(txtCustomerBAmount.getText()));
				JOptionPane.showMessageDialog(null, "Update Customer Data Sucesfull....");
				dispose();
			}
		});
		btnUpadate.setForeground(Color.BLACK);
		btnUpadate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpadate.setBackground(new Color(230, 230, 250));
		btnUpadate.setBounds(88, 31, 150, 50);
		panelOperation.add(btnUpadate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt((txtCustomerId.getSelectedItem()).toString());
				db.dlcust(i);
				JOptionPane.showMessageDialog(null, "Employee Data delete Successfully....");
				dispose();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBackground(new Color(230, 230, 250));
		btnDelete.setBounds(88, 112, 150, 50);
		panelOperation.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCustomerName.setText(null);
				txtCustomerRDate.setDate(null);
				txtCustomerContact.setText(null);
				txtCustomerAddress.setText(null);
				txtCustomerContact.setText(null);
				txtCustomerEmailId.setText(null);
				txtCustomerCrAmount.setText(null);
				txtCustomerDeAmount.setText("0");
				txtCustomerBAmount.setText(null);
				buttonGroup.clearSelection();
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(326, 31, 150, 50);
		panelOperation.add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Do you want to close Modify Customer....");
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(326, 112, 150, 50);
		panelOperation.add(btnExit);
		
		panelCustomerS = new JPanel();
		panelCustomerS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer_Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCustomerS.setBounds(22, 20, 564, 132);
		panel.add(panelCustomerS);
		panelCustomerS.setLayout(null);
		
		lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setForeground(Color.BLACK);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerId.setBounds(35, 27, 189, 25);
		panelCustomerS.add(lblCustomerId);
		
		txtCustomerId = new JComboBox();
		txtCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cid=Integer.parseInt(txtCustomerId.getSelectedItem().toString());
				   
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
						txtCustomerRDate.setDate(rs.getDate("reg_date"));
						txtCustomerContact.setText(rs.getString("contact"));
						txtCustomerAddress.setText(rs.getString("address"));
						txtCustomerContact.setText(rs.getString("contact"));
						txtCustomerEmailId.setText(rs.getString("email"));
						txtCustomerCrAmount.setText(rs.getString("balance"));
						final String gender1=rs.getString("gender");
						if(gender1.equals("Male"))
						{
							rbMale.setSelected(true);
						}
						else 
						{
							rbFemale.setSelected(true);
						}
					}
				}
				catch(final Exception ex)
				{
					ex.printStackTrace();
				}
				}
			});
		txtCustomerId.setBounds(259, 27, 270, 25);
		panelCustomerS.add(txtCustomerId);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setForeground(Color.BLACK);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(35, 79, 189, 25);
		panelCustomerS.add(lblCustomerName);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(true);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBackground(new Color(230, 230, 250));
		txtCustomerName.setBounds(259, 79, 270, 25);
		panelCustomerS.add(txtCustomerName);
		
		data();
	}
}
