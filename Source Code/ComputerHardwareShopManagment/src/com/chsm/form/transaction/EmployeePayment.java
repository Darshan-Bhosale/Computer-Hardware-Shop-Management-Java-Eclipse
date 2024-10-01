package com.chsm.form.transaction;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.chsm.form.db.DBEmployee;
import DBmodel.sqlconnection;

import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class EmployeePayment extends JFrame 
{
	private JPanel contentPane, panelEmployeeInformation, panelOpration;
	private JTextField txtEmployeeName, txtAdvanceSalary, txtBonacSalary, txtTotalSalary, txtEmployeeSalary;
	private JLabel lblEmployeeId, lblAdvanceSalary, lblBonacSalary, lblEmployeeSalaryDate, lblTotalSalary, lblEmployeeSalary, lblEmployeeName;
	@SuppressWarnings("rawtypes")
	private JComboBox txtEmployeeID; 
	private JDateChooser txtEmployeeSalaryDate;
	private JButton btnSave, btnClear, btnExit;
	private DBEmployee db = new DBEmployee();
	
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
		try 
		{
			Connection c =sqlconnection.getConnection();
			String sql = "Select * from employee";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
			{
				JOptionPane.showMessageDialog(null, "there is no data of Employee in table....");
			}
			else 
			{
				while(rs.next())
				{	txtEmployeeID.addItem(rs.getInt("id"));		}	
			}
			pst.close();
			
			/*DateFormat df = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
			Date d = new Date();
			String s = df.format(d);
			txtEmployeeSalaryDate.setText(s);*/
			
		} catch (SQLException e) {	e.printStackTrace();	}
	}
	
	public EmployeePayment() 
	{
		//setAlwaysOnTop(true);
		setTitle("Employee_Payment");
		setBounds(100, 100, 580, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelEmployeeInformation = new JPanel();
		panelEmployeeInformation.setLayout(null);
		panelEmployeeInformation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee_Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEmployeeInformation.setBounds(17, 10, 530, 380);
		contentPane.add(panelEmployeeInformation);
		
		lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(23, 25, 189, 25);
		panelEmployeeInformation.add(lblEmployeeId);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setBounds(235, 75, 270, 25);
		panelEmployeeInformation.add(txtEmployeeName);
		txtEmployeeName.setEditable(false);
		
		lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeName.setBounds(23, 75, 189, 25);
		panelEmployeeInformation.add(lblEmployeeName);
		
		lblEmployeeSalaryDate = new JLabel("Employee Salary Date :");
		lblEmployeeSalaryDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeSalaryDate.setBounds(23, 125, 189, 25);
		panelEmployeeInformation.add(lblEmployeeSalaryDate);
		
		lblAdvanceSalary = new JLabel("Advance Salary :");
		lblAdvanceSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdvanceSalary.setBounds(23, 225, 189, 25);
		panelEmployeeInformation.add(lblAdvanceSalary);
		
		lblTotalSalary = new JLabel("Total Salary :");
		lblTotalSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalSalary.setBounds(23, 325, 189, 25);
		panelEmployeeInformation.add(lblTotalSalary);
		
		txtEmployeeID = new JComboBox<String>();
		txtEmployeeID.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) { 
				int eid=Integer.parseInt(txtEmployeeID.getSelectedItem().toString());
				   
				try
				{
					final Connection c =sqlconnection.getConnection();
					final String sql = "Select * from employee where id=?";
					final PreparedStatement pst = c.prepareStatement(sql);
					pst.setInt(1, eid);
					final ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						txtEmployeeName.setText(rs.getString("name"));
						txtEmployeeSalary.setText(rs.getString("salary"));
					}
					}
					catch(final Exception ex)
					{
						ex.printStackTrace();
					}
				}
		});
		txtEmployeeID.setMaximumRowCount(20);
		txtEmployeeID.setBounds(235, 25, 270, 25);
		panelEmployeeInformation.add(txtEmployeeID);
		
		txtAdvanceSalary = new JTextField();
		txtAdvanceSalary.setText("0");
		txtAdvanceSalary.setBounds(235, 225, 270, 25);
		panelEmployeeInformation.add(txtAdvanceSalary);
		
		lblBonacSalary = new JLabel("Bonus Salary :");
		lblBonacSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBonacSalary.setBounds(23, 275, 189, 25);
		panelEmployeeInformation.add(lblBonacSalary);
		
		txtBonacSalary = new JTextField();
		txtBonacSalary.setText("0");
		txtBonacSalary.setBounds(235, 275, 270, 25);
		panelEmployeeInformation.add(txtBonacSalary);
		
		txtTotalSalary = new JTextField();
		txtTotalSalary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i= ((Integer.parseInt(txtEmployeeSalary.getText()) + Integer.parseInt(txtBonacSalary.getText())) - Integer.parseInt(txtAdvanceSalary.getText()));
				txtTotalSalary.setText(String.valueOf(i));
			}
		});
		txtTotalSalary.setBounds(235, 325, 270, 25);
		panelEmployeeInformation.add(txtTotalSalary);
		txtTotalSalary.setEditable(false);
		
		lblEmployeeSalary = new JLabel("Employee Salary :");
		lblEmployeeSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeSalary.setBounds(23, 175, 189, 25);
		panelEmployeeInformation.add(lblEmployeeSalary);
		
		txtEmployeeSalary = new JTextField();
		txtEmployeeSalary.setBounds(235, 175, 270, 25);
		panelEmployeeInformation.add(txtEmployeeSalary);
		txtEmployeeSalary.setEditable(false);
		
		txtEmployeeSalaryDate = new JDateChooser();
		txtEmployeeSalaryDate.setBounds(235, 125, 270, 25);
		panelEmployeeInformation.add(txtEmployeeSalaryDate);
		
		panelOpration = new JPanel();
		panelOpration.setLayout(null);
		panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOpration.setBounds(17, 400, 530, 130);
		contentPane.add(panelOpration);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = Integer.parseInt((txtEmployeeID.getSelectedItem()).toString());
				
				db.empsal(i, txtEmployeeName.getText(), datemethad(txtEmployeeSalaryDate.getDate()), Integer.parseInt(txtEmployeeSalary.getText()), 
						Integer.parseInt(txtAdvanceSalary.getText()), Integer.parseInt(txtBonacSalary.getText()), Integer.parseInt(txtTotalSalary.getText()));
				JOptionPane.showMessageDialog(null, "Employee Payment Save Sucesfull....");
				dispose();
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBackground(new Color(230, 230, 250));
		btnSave.setBounds(20, 40, 150, 50);
		panelOpration.add(btnSave);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtEmployeeName.setText(null);
				txtAdvanceSalary.setText("0");
				txtBonacSalary.setText("0");
				txtTotalSalary.setText(null);
				txtEmployeeSalary.setText(null);
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(190, 40, 150, 50);
		panelOpration.add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(360, 40, 150, 50);
		panelOpration.add(btnExit);
		
		data();
	}
}
