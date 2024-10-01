package com.chsm.form.db;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import com.chsm.form.MenuScreenForm;

public class DBLoginWindow 
{
	private String query, n, p;
	int count;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;


	public DBLoginWindow() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chsm", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int checkLogin(String name, String pass) 
	{
		this.n = name;
		this.p = pass;
			try {
				query="select * from login where lname=? and lpass=?";
				pst=con.prepareStatement(query);
				pst.setString(1, n);
				pst.setString(2, p);
				
				rs=pst.executeQuery();
				count=0;
				
				while(rs.next())
					count = count+1;
				
				if (count==1)
				{
					JOptionPane.showMessageDialog(null, "User_name & Password is Correct..");
					new MenuScreenForm().setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "User_name & Password is not Correct try again....");
				}

				rs.close();
				pst.close();
			} catch (HeadlessException | SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
		
}


