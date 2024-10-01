package com.chsm.form.modify;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import DBmodel.sqlconnection;

import com.chsm.form.db.DBEmployee;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ModifyEmployee extends JFrame 
{

	private JPanel panel, panelEmployeeS, panelOperation, panelEmployeepi, panelEmployeeof;
	private JLabel lblEmployeeid, lblEmployeeName, lblEmployeeSalary, lblEmployeeDesignation, lblEmployeeJoiningDate, lblEmployeeAddress, lblGenderGender, lblEmployeeBirthDate, lblEmployeeContact, lblEmployeeEmailId;
	private JTextField txtEmployeeName, txtEmployeeSalary, txtEmployeeDesignation, txtEmployeeEmailID,txtEmployeeContact;
	private JRadioButton rbMale, rbFemale;
	private JTextArea txtaEmployeeAddress;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JComboBox txtemployeeid;
	private JDateChooser txtEmployeeJDate, txtEmployeeBDate;
	private ButtonGroup buttonGroup;
	private JButton btnUpadate, btnDelete, btnClear, btnExit;
	private int eid;
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
				{	txtemployeeid.addItem(rs.getInt("id"));		}	
			}
			pst.close();
		} catch (SQLException e) {	e.printStackTrace();	}
	}
	
	@SuppressWarnings("rawtypes")
	public ModifyEmployee() 
	{
		
		setTitle("Searching_Employee_Information");
		setBounds(100, 100, 1200, 525);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panelEmployeepi = new JPanel();
		panelEmployeepi.setLayout(null);
		panelEmployeepi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmployeepi.setBounds(22, 163, 564, 307);
		panel.add(panelEmployeepi);
		
		lblEmployeeBirthDate = new JLabel("Employee Birth Date :");
		lblEmployeeBirthDate.setForeground(Color.BLACK);
		lblEmployeeBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeBirthDate.setBounds(35, 24, 189, 25);
		panelEmployeepi.add(lblEmployeeBirthDate);
		
		lblGenderGender = new JLabel("Employee Gender :");
		lblGenderGender.setForeground(Color.BLACK);
		lblGenderGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenderGender.setBounds(35, 68, 189, 25);
		panelEmployeepi.add(lblGenderGender);
		
		buttonGroup = new ButtonGroup();
		
		rbMale = new JRadioButton("Male");
		rbMale.setBackground(null);
		buttonGroup.add(rbMale);
		rbMale.setHorizontalAlignment(SwingConstants.CENTER);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbMale.setBounds(273, 69, 64, 23);
		panelEmployeepi.add(rbMale);
		rbMale.setActionCommand("Male");
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(null);
		buttonGroup.add(rbFemale);
		rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbFemale.setBounds(388, 69, 73, 23);
		panelEmployeepi.add(rbFemale);
		rbFemale.setActionCommand("Female");
		
		lblEmployeeAddress = new JLabel("Employee Address :");
		lblEmployeeAddress.setForeground(Color.BLACK);
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeAddress.setBounds(35, 110, 189, 25);
		panelEmployeepi.add(lblEmployeeAddress);
		
		lblEmployeeContact = new JLabel("Employee Contact :");
		lblEmployeeContact.setForeground(Color.BLACK);
		lblEmployeeContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeContact.setBounds(35, 219, 189, 25);
		panelEmployeepi.add(lblEmployeeContact);
		
		txtEmployeeContact = new JTextField();
		txtEmployeeContact.setEditable(true);
		txtEmployeeContact.setToolTipText("First name");
		txtEmployeeContact.setColumns(10);
		txtEmployeeContact.setBackground(new Color(230, 230, 250));
		txtEmployeeContact.setBounds(259, 219, 270, 25);
		panelEmployeepi.add(txtEmployeeContact);
		
		lblEmployeeEmailId = new JLabel("Employee Email ID :");
		lblEmployeeEmailId.setForeground(Color.BLACK);
		lblEmployeeEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeEmailId.setBounds(35, 263, 189, 25);
		panelEmployeepi.add(lblEmployeeEmailId);
		
		txtEmployeeEmailID = new JTextField();
		txtEmployeeEmailID.setEditable(true);
		txtEmployeeEmailID.setColumns(10);
		txtEmployeeEmailID.setBackground(new Color(230, 230, 250));
		txtEmployeeEmailID.setBounds(259, 263, 270, 25);
		panelEmployeepi.add(txtEmployeeEmailID);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 110, 270, 90);
		panelEmployeepi.add(scrollPane);
		
		txtaEmployeeAddress = new JTextArea();
		txtaEmployeeAddress.setEditable(true);
		txtaEmployeeAddress.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(txtaEmployeeAddress);
		
		txtEmployeeBDate = new JDateChooser();
		txtEmployeeBDate.setBounds(259, 24, 270, 25);
		panelEmployeepi.add(txtEmployeeBDate);
		
		panelEmployeeof = new JPanel();
		panelEmployeeof.setLayout(null);
		panelEmployeeof.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmployeeof.setBounds(608, 20, 564, 244);
		panel.add(panelEmployeeof);
		
		lblEmployeeJoiningDate = new JLabel("Employee Joining Date :");
		lblEmployeeJoiningDate.setForeground(Color.BLACK);
		lblEmployeeJoiningDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeJoiningDate.setBounds(38, 42, 189, 25);
		panelEmployeeof.add(lblEmployeeJoiningDate);
		
		lblEmployeeDesignation = new JLabel("Employee Designation :");
		lblEmployeeDesignation.setForeground(Color.BLACK);
		lblEmployeeDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeDesignation.setBounds(38, 109, 189, 25);
		panelEmployeeof.add(lblEmployeeDesignation);
		
		txtEmployeeDesignation = new JTextField();
		txtEmployeeDesignation.setEditable(true);
		txtEmployeeDesignation.setColumns(10);
		txtEmployeeDesignation.setBackground(new Color(230, 230, 250));
		txtEmployeeDesignation.setBounds(253, 109, 270, 25);
		panelEmployeeof.add(txtEmployeeDesignation);
		
		lblEmployeeSalary = new JLabel("Employee Salary :");
		lblEmployeeSalary.setForeground(Color.BLACK);
		lblEmployeeSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeSalary.setBounds(38, 176, 189, 25);
		panelEmployeeof.add(lblEmployeeSalary);
		
		txtEmployeeSalary = new JTextField();
		txtEmployeeSalary.setColumns(10);
		txtEmployeeSalary.setBackground(new Color(230, 230, 250));
		txtEmployeeSalary.setBounds(253, 176, 270, 25);
		panelEmployeeof.add(txtEmployeeSalary);
		
		txtEmployeeJDate = new JDateChooser();
		txtEmployeeJDate.setBounds(253, 42, 270, 25);
		panelEmployeeof.add(txtEmployeeJDate);
		
		panelOperation = new JPanel();
		panelOperation.setLayout(null);
		panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOperation.setBounds(608, 275, 564, 195);
		panel.add(panelOperation);
		
		btnUpadate = new JButton("Update ");
		btnUpadate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int i = Integer.parseInt((txtemployeeid.getSelectedItem()).toString());
				db.updateemp(i, txtEmployeeContact.getText(), Integer.parseInt(txtEmployeeSalary.getText()), 
						txtEmployeeName.getText(), buttonGroup.getSelection().getActionCommand(), txtaEmployeeAddress.getText(), txtEmployeeEmailID.getText(), 
						txtEmployeeDesignation.getText(), datemethad(txtEmployeeBDate.getDate()), datemethad(txtEmployeeJDate.getDate()));
				JOptionPane.showMessageDialog(null, "Update Employee Data Sucesfull....");
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
				int i = Integer.parseInt((txtemployeeid.getSelectedItem()).toString());
				db.dlemp(i);
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
				txtEmployeeJDate.setDate(null);
				txtEmployeeBDate.setDate(null);
				txtaEmployeeAddress.setText(null);
				txtEmployeeName.setText(null);
				txtEmployeeSalary.setText(null);
				txtEmployeeDesignation.setText(null);
				txtEmployeeEmailID.setText(null);
				txtEmployeeContact.setText(null);
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
				JOptionPane.showMessageDialog(null, "Do you want to close Modify_Employee....");
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(new Color(230, 230, 250));
		btnExit.setBounds(326, 112, 150, 50);
		panelOperation.add(btnExit);
		
		panelEmployeeS = new JPanel();
		panelEmployeeS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee_Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmployeeS.setBounds(22, 20, 564, 132);
		panel.add(panelEmployeeS);
		panelEmployeeS.setLayout(null);
		
		lblEmployeeid = new JLabel("Employee Id:");
		lblEmployeeid.setForeground(Color.BLACK);
		lblEmployeeid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeid.setBounds(35, 27, 189, 25);
		panelEmployeeS.add(lblEmployeeid);
		
		lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setForeground(Color.BLACK);
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeName.setBounds(35, 79, 189, 25);
		panelEmployeeS.add(lblEmployeeName);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setEditable(true);
		txtEmployeeName.setBackground(new Color(230, 230, 250));
		txtEmployeeName.setBounds(259, 79, 270, 25);
		panelEmployeeS.add(txtEmployeeName);
		txtEmployeeName.setColumns(10);
		
		txtemployeeid = new JComboBox();
		txtemployeeid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eid=Integer.parseInt(txtemployeeid.getSelectedItem().toString());
				   
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
						txtEmployeeBDate.setDate(rs.getDate("birth_date"));
						txtEmployeeContact.setText(rs.getString("contact"));
						txtEmployeeEmailID.setText(rs.getString("email"));
						txtEmployeeJDate.setDate(rs.getDate("joining_date"));
						txtEmployeeDesignation.setText(rs.getString("designation"));
						txtEmployeeSalary.setText(rs.getString("salary"));
						txtaEmployeeAddress.setText(rs.getString("address"));
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
		txtemployeeid.setBounds(259, 27, 270, 25);
		panelEmployeeS.add(txtemployeeid);
		data();
		
	}
}
