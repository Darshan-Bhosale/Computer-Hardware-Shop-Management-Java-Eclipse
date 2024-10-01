package com.chsm.form.modify;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

import com.chsm.form.db.DBSupplier;
import com.toedter.calendar.JDateChooser;

import DBmodel.sqlconnection;

@SuppressWarnings("serial")
public class ModifySupplier extends JFrame {
	
	private JPanel panel, panelSupplierpi, panelSupplieroi, panelOperation, panelSupplierS;
	private JLabel lblSupplierName, lblSupplierRegisteredDate, lblSupplierId, lblSupplierBalanceAmount, lblSupplierGender, lblSupplierDebitAmount, lblSupplierCreditAmount, lblSupplierAddress, lblSupplierContact, lblSupplierEmailId;
	private JTextField txtSupplierName, txtSupplierContact, txtSupplierEmailId, txtSupplierCrAmount, txtSupplierDeAmount, txtSupplierBAmount;
	@SuppressWarnings("rawtypes")
	private JComboBox txtSuppliedId;
	private JDateChooser txtSupplierRDate;
	private JScrollPane scrollPane;
	private JRadioButton rbMale, rbFemale;
	private ButtonGroup buttonGroup;
	final JTextArea txtSupplierAddress ;
	private JButton btnUpadate, btnClear, btnExit, btnDelete;
	private int sid;
	private DBSupplier db = new DBSupplier();
	
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
				{	txtSuppliedId.addItem(rs.getInt("id"));		}	
			}
			pst.close();
		} catch (SQLException e) {	e.printStackTrace();	}
	}


	@SuppressWarnings("rawtypes")
	public ModifySupplier() 
	{
		setTitle("Searching_Supplier_Information");
		setBounds(100, 100, 1200, 525);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panelSupplierpi = new JPanel();
		panelSupplierpi.setLayout(null);
		panelSupplierpi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSupplierpi.setBounds(22, 163, 564, 307);
		panel.add(panelSupplierpi);
		
		lblSupplierRegisteredDate = new JLabel("Supplier Registered Date :");
		lblSupplierRegisteredDate.setForeground(Color.BLACK);
		lblSupplierRegisteredDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierRegisteredDate.setBounds(35, 24, 189, 25);
		panelSupplierpi.add(lblSupplierRegisteredDate);
		
		lblSupplierGender = new JLabel("Supplier Gender :");
		lblSupplierGender.setForeground(Color.BLACK);
		lblSupplierGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierGender.setBounds(35, 68, 189, 25);
		panelSupplierpi.add(lblSupplierGender);
		
		buttonGroup = new ButtonGroup();
		
		rbMale = new JRadioButton("Male");
		rbMale.setBackground(null);
		buttonGroup.add(rbMale);
		rbMale.setHorizontalAlignment(SwingConstants.CENTER);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbMale.setBounds(273, 69, 64, 23);
		panelSupplierpi.add(rbMale);
		rbMale.setActionCommand("Male");
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(null);
		buttonGroup.add(rbFemale);
		rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbFemale.setBounds(388, 69, 73, 23);
		panelSupplierpi.add(rbFemale);
		rbFemale.setActionCommand("Female");
		
		lblSupplierAddress = new JLabel("Supplier Address :");
		lblSupplierAddress.setForeground(Color.BLACK);
		lblSupplierAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierAddress.setBounds(35, 110, 189, 25);
		panelSupplierpi.add(lblSupplierAddress);
		
		lblSupplierContact = new JLabel("Supplier Contact :");
		lblSupplierContact.setForeground(Color.BLACK);
		lblSupplierContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierContact.setBounds(35, 219, 189, 25);
		panelSupplierpi.add(lblSupplierContact);
		
		txtSupplierContact = new JTextField();
		txtSupplierContact.setEditable(true);
		txtSupplierContact.setColumns(10);
		txtSupplierContact.setBackground(new Color(230, 230, 250));
		txtSupplierContact.setBounds(259, 219, 270, 25);
		panelSupplierpi.add(txtSupplierContact);
		
		lblSupplierEmailId = new JLabel("Supplier Email ID :");
		lblSupplierEmailId.setForeground(Color.BLACK);
		lblSupplierEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierEmailId.setBounds(35, 263, 189, 25);
		panelSupplierpi.add(lblSupplierEmailId);
		
		txtSupplierEmailId = new JTextField();
		txtSupplierEmailId.setEditable(true);
		txtSupplierEmailId.setColumns(10);
		txtSupplierEmailId.setBackground(new Color(230, 230, 250));
		txtSupplierEmailId.setBounds(259, 263, 270, 25);
		panelSupplierpi.add(txtSupplierEmailId);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 110, 270, 90);
		panelSupplierpi.add(scrollPane);
		
		txtSupplierAddress = new JTextArea();
		txtSupplierAddress.setEditable(true);
		txtSupplierAddress.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(txtSupplierAddress);
		
		txtSupplierRDate = new JDateChooser();
		txtSupplierRDate.setBounds(259, 24, 270, 25);
		panelSupplierpi.add(txtSupplierRDate);
		
		panelSupplieroi = new JPanel();
		panelSupplieroi.setLayout(null);
		panelSupplieroi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSupplieroi.setBounds(608, 20, 564, 244);
		panel.add(panelSupplieroi);
		
		lblSupplierCreditAmount = new JLabel("Supplier Credit Amount :");
		lblSupplierCreditAmount.setForeground(Color.BLACK);
		lblSupplierCreditAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierCreditAmount.setBounds(38, 42, 189, 25);
		panelSupplieroi.add(lblSupplierCreditAmount);
		
		txtSupplierCrAmount = new JTextField();
		txtSupplierCrAmount.setEditable(true);
		txtSupplierCrAmount.setColumns(10);
		txtSupplierCrAmount.setBackground(new Color(230, 230, 250));
		txtSupplierCrAmount.setBounds(253, 42, 270, 25);
		panelSupplieroi.add(txtSupplierCrAmount);
		
		lblSupplierDebitAmount = new JLabel("Supplier Debit Amount :");
		lblSupplierDebitAmount.setForeground(Color.BLACK);
		lblSupplierDebitAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierDebitAmount.setBounds(38, 109, 189, 25);
		panelSupplieroi.add(lblSupplierDebitAmount);
		
		txtSupplierDeAmount = new JTextField();
		txtSupplierDeAmount.setEditable(true);
		txtSupplierDeAmount.setText("0");
		txtSupplierDeAmount.setColumns(10);
		txtSupplierDeAmount.setBackground(new Color(230, 230, 250));
		txtSupplierDeAmount.setBounds(253, 109, 270, 25);
		panelSupplieroi.add(txtSupplierDeAmount);
		
		lblSupplierBalanceAmount = new JLabel("Supplier Balance Amount :");
		lblSupplierBalanceAmount.setForeground(Color.BLACK);
		lblSupplierBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierBalanceAmount.setBounds(38, 176, 189, 25);
		panelSupplieroi.add(lblSupplierBalanceAmount);
		
		txtSupplierBAmount = new JTextField();
		txtSupplierBAmount.setEditable(false);
		txtSupplierBAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=(Integer.parseInt(txtSupplierCrAmount.getText())-Integer.parseInt(txtSupplierDeAmount.getText()));
				txtSupplierBAmount.setText(String.valueOf(i));
			}
		});
		txtSupplierBAmount.setColumns(10);
		txtSupplierBAmount.setBackground(new Color(230, 230, 250));
		txtSupplierBAmount.setBounds(253, 176, 270, 25);
		panelSupplieroi.add(txtSupplierBAmount);
		
		panelOperation = new JPanel();
		panelOperation.setLayout(null);
		panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOperation.setBounds(608, 275, 564, 195);
		panel.add(panelOperation);
		
		btnUpadate = new JButton("Update ");
		btnUpadate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = Integer.parseInt((txtSuppliedId.getSelectedItem()).toString());
				
				db.updatesupplier(i, txtSupplierName.getText(), datemethad(txtSupplierRDate.getDate()), 
						buttonGroup.getSelection().getActionCommand(), txtSupplierAddress.getText(),
						txtSupplierContact.getText(), txtSupplierEmailId.getText(), Integer.parseInt(txtSupplierCrAmount.getText()), 
						Integer.parseInt(txtSupplierBAmount.getText()));
				
				JOptionPane.showMessageDialog(null, "Update Supplier Data Sucesfull....");
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
				
				int i = Integer.parseInt((txtSuppliedId.getSelectedItem()).toString());
				db.dlsup(i);
				JOptionPane.showMessageDialog(null, "Supplier Data delete Successfully....");
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
				txtSupplierAddress.setText(null);
				txtSupplierName.setText(null);
				txtSupplierContact.setText(null);
				txtSupplierEmailId.setText(null);
				txtSupplierCrAmount.setText(null);
				txtSupplierDeAmount.setText("0");
				txtSupplierBAmount.setText(null);
				txtSupplierRDate.setDate(null);
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
				JOptionPane.showMessageDialog(null, "Do you want to close Modify_Supplier....");
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(326, 112, 150, 50);
		panelOperation.add(btnExit);
		
		panelSupplierS = new JPanel();
		panelSupplierS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSupplierS.setBounds(22, 20, 564, 132);
		panel.add(panelSupplierS);
		panelSupplierS.setLayout(null);
		
		lblSupplierId = new JLabel("Supplier Id :");
		lblSupplierId.setForeground(Color.BLACK);
		lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierId.setBounds(35, 27, 189, 25);
		panelSupplierS.add(lblSupplierId);
		
		
		lblSupplierName = new JLabel();
		lblSupplierName.setText("Supplier Name :");
		lblSupplierName.setForeground(Color.BLACK);
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSupplierName.setBounds(35, 79, 189, 25);
		panelSupplierS.add(lblSupplierName);
		
		txtSupplierName = new JTextField();
		txtSupplierName.setEditable(true);
		txtSupplierName.setBackground(new Color(230, 230, 250));
		txtSupplierName.setBounds(259, 79, 270, 25);
		panelSupplierS.add(txtSupplierName);
		txtSupplierName.setColumns(10);
		
		txtSuppliedId = new JComboBox();
		txtSuppliedId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sid=Integer.parseInt(txtSuppliedId.getSelectedItem().toString());
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
						txtSupplierRDate.setDate(rs.getDate("reg_date"));
						txtSupplierContact.setText(rs.getString("contact"));
						txtSupplierAddress.setText(rs.getString("address"));
						txtSupplierContact.setText(rs.getString("contact"));
						txtSupplierEmailId.setText(rs.getString("email"));
						txtSupplierCrAmount.setText(rs.getString("balance"));
						txtSupplierDeAmount.setText("0");
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
		txtSuppliedId.setBounds(259, 27, 270, 25);
		panelSupplierS.add(txtSuppliedId);

		data();
	}
}
