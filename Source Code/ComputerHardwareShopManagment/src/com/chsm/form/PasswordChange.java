package com.chsm.form;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



import DBmodel.sqlconnection;

//import com.chsm.form.db.DBLoginWindow;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class PasswordChange extends JFrame {

	private JPanel panel;
	private JLabel lblEmployeeUserID, lblEmployeeUserName, lblEnterOldPassword, lblEnterNewPassword, lblConfirmNewPassword;
	private JTextField txtEmployeeUserName, txtEnterOldPassword, txtEnterNewPassword, txtConfirmNewPassword;
	private JButton btnUpatePassword, btnClear;
	@SuppressWarnings("rawtypes")
	private JComboBox txtEmployeeUserId ;
	private int lid;
	private String temp_pass;
	
	@SuppressWarnings("unchecked")
	public void data()
	{
		try {
			final Connection c =sqlconnection.getConnection();
			final String sql = "Select * from login";

			final PreparedStatement pst = c.prepareStatement(sql);
			
			final ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				txtEmployeeUserId.addItem(rs.getInt("id"));
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("rawtypes")
	public PasswordChange() 
	{
		setBackground(SystemColor.text);
		setTitle("Password_Change");
		setBounds(100, 100, 520, 430);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		lblEmployeeUserID = new JLabel("Employee User ID :");
		lblEmployeeUserID.setForeground(Color.BLACK);
		lblEmployeeUserID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeUserID.setBounds(31, 29, 141, 25);
		panel.add(lblEmployeeUserID);
		
		txtEmployeeUserName = new JTextField();
		txtEmployeeUserName.setColumns(10);
		txtEmployeeUserName.setBounds(203, 83, 270, 25);
		panel.add(txtEmployeeUserName);
		txtEmployeeUserName.setEditable(false);
		
		txtEmployeeUserId = new JComboBox();
		txtEmployeeUserId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lid=Integer.parseInt(txtEmployeeUserId.getSelectedItem().toString());
					 Connection c =sqlconnection.getConnection();
					 String sql1 = "Select * from login where id=?";
					 PreparedStatement pst1 = c.prepareStatement(sql1);
					pst1.setInt(1, lid);
					 ResultSet rs1 = pst1.executeQuery();
					while(rs1.next())
					{
						txtEmployeeUserName.setText(rs1.getString("lname"));
						temp_pass=rs1.getString("lpass");
					}
				} catch (NumberFormatException | SQLException e) {
						e.printStackTrace();
				}
			}
		});
 		txtEmployeeUserId.setBounds(203, 29, 270, 25);
		panel.add(txtEmployeeUserId);
		
		lblEnterOldPassword = new JLabel("Enter Old Password :");
		lblEnterOldPassword.setForeground(Color.BLACK);
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterOldPassword.setBounds(31, 137, 141, 25);
		panel.add(lblEnterOldPassword);
		
		txtEnterOldPassword = new JPasswordField();
		txtEnterOldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtEnterOldPassword.getText().equals(temp_pass))
				{
					JOptionPane.showMessageDialog(null, "You Entered a wrong Old Password....");
					txtEnterOldPassword.setText(null);
					txtEnterNewPassword.setText(null);
					txtConfirmNewPassword.setText(null);
				}
			}
		});
				
		txtEnterOldPassword.setBounds(203, 137, 270, 25);
		panel.add(txtEnterOldPassword);
		
		lblEnterNewPassword = new JLabel("Enter New Password :");
		lblEnterNewPassword.setForeground(Color.BLACK);
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNewPassword.setBounds(31, 191, 151, 25);
		panel.add(lblEnterNewPassword);
		
		txtEnterNewPassword = new JPasswordField();
		txtEnterNewPassword.setBounds(203, 191, 270, 25);
		panel.add(txtEnterNewPassword);
		
		lblConfirmNewPassword = new JLabel("Confirm New Password :");
		lblConfirmNewPassword.setForeground(Color.BLACK);
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmNewPassword.setBounds(31, 245, 163, 25);
		panel.add(lblConfirmNewPassword);
		
		txtConfirmNewPassword = new JPasswordField();
		txtConfirmNewPassword.setBounds(203, 245, 270, 25);
		panel.add(txtConfirmNewPassword);
		
		btnUpatePassword = new JButton("Update Password");
		btnUpatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				/*if(!(txtEnterNewPassword.getText().equals(txtConfirmNewPassword.getText())))
				{
					JOptionPane.showMessageDialog(null, "New Password Configuration fail Please re-enter new password");
					txtEnterOldPassword.setText(null);
					txtEnterNewPassword.setText(null);
					txtConfirmNewPassword.setText(null);
				}
				else 
				{
					
				}*/
				try
				{
					
				
				String oldpass=txtEnterOldPassword.getText();
				String newpass=txtEnterNewPassword.getText();
				String cpass=txtConfirmNewPassword.getText();
			
				Connection con=sqlconnection.getConnection();
				Statement st1=con.createStatement();
			        ResultSet rs = st1.executeQuery("Select * from login");
			        while(rs.next())
			        {
			        	String p=rs.getString("lpass");
			        
			   
					if(oldpass.equals(p))
		            {

		                if(newpass.equals(cpass))
		                {
		                   st1 = con.createStatement();
		                    ResultSet rs1 = st1.executeQuery("UPDATE login SET lpass="+newpass+" where id='"+lid+"'");//query i am using to update the password
		                    JOptionPane.showMessageDialog(null, "PASSWORD UPDATE SUCCESSFUL");

		                }

		                else
		                {
		                    JOptionPane.showMessageDialog(null, "PLEASE CONFIRM PASSWORD");
		                }}
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		}
		});
		btnUpatePassword.setForeground(Color.BLACK);
		btnUpatePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpatePassword.setBackground(new Color(230, 230, 250));
		btnUpatePassword.setBounds(68, 311, 150, 50);
		panel.add(btnUpatePassword);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmployeeUserName.setText(null);
				txtEnterOldPassword.setText(null);
				txtEnterNewPassword.setText(null);
				txtConfirmNewPassword.setText(null);
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(286, 311, 150, 50);
		panel.add(btnClear);
		
		lblEmployeeUserName = new JLabel("Employee User Name :");
		lblEmployeeUserName.setForeground(Color.BLACK);
		lblEmployeeUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeUserName.setBounds(31, 83, 163, 25);
		panel.add(lblEmployeeUserName);
		
		
		data();
	}
}
