package com.chsm.form.db;

import java.awt.*;
import java.sql.*;

public class DBProduct 
{
	
	private String query1, query2;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private String id=null;

	public DBProduct() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chsm", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String setID() 
	{
		try 
		{
			query1 = "select id from product";
			pst = con.prepareStatement(query1);
			rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
				id="1";
			else 
			{
				rs.last();
				id = String.valueOf(rs.getInt(1) + 1);
			}
		} 
		catch (HeadlessException | SQLException e) 
		{		e.printStackTrace();		}
		 
		return id;
	}
	
	public void addproduct(int id, String c_name, String p_name, String model_no, String color, String description, int prise) 
	{
		try {
			query2="insert into product value(?,?,?,?,?,?,?)";
			pst=con.prepareStatement(query2);
			
			pst.setInt(1, id);
			pst.setString(2, c_name);
			pst.setString(3, p_name);
			pst.setString(4, model_no);
			pst.setString(5, color);
			pst.setString(6, description);
			pst.setInt(7, prise);
			pst.executeUpdate();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	}

}
