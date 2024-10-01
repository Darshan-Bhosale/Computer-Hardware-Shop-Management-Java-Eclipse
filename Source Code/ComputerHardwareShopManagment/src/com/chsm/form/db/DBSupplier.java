package com.chsm.form.db;

import java.awt.*;
import java.sql.*;


public class DBSupplier {
	
	private String query1, query2;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private String id=null;
	
	public DBSupplier() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chsm", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String setID() {
		try 
		{
			query1 = "select id from supplier";
			pst = con.prepareStatement(query1);
			rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
				id="1";
			else 
			{
				rs.last();
				id = String.valueOf(rs.getInt(1) + 1);
			}
			pst.close();
		} 
		catch (HeadlessException | SQLException e) 
		{		e.printStackTrace();		}
		 
		return id;
	}

	
	public String setSOID() {
		try 
		{
			query1 = "select id from sup_order";
			pst = con.prepareStatement(query1);
			rs = pst.executeQuery();
			if(!rs.isBeforeFirst())
				id="1";
			else 
			{
				rs.last();
				id = String.valueOf(rs.getInt(1) + 1);
			}
			pst.close();
		} 
		catch (HeadlessException | SQLException e) 
		{		e.printStackTrace();		}
		 
		return id;
	}
	
	
	
	
	public void addsupplier(int id, String name, Date reg_date, String gender, 
			String address, String contact, String email, int cr_amount, int balance) 
	{
		try {
			query2="insert into supplier value(?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(query2);
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDate(3, reg_date);
			pst.setString(4, gender);
			pst.setString(5, address);
			pst.setString(6, contact);
			pst.setString(7, email);
			pst.setInt(8, cr_amount);
			pst.setInt(9, balance);

			pst.executeUpdate();
			
			pst.close();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	

	public void addsupporder(int id, Date date, int sup_id, String sup_name, int pro_id, String pro_mn, int pro_qn,
			int pro_rate, int tot_amount) {
		try {
			query2="insert into sup_order value(?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(query2);
			
			pst.setInt(1, id);
			pst.setDate(2, date);
			pst.setInt(3, sup_id);
			pst.setString(4, sup_name);
			pst.setInt(5, pro_id);
			pst.setString(6, pro_mn);
			pst.setInt(7, pro_qn);
			pst.setInt(8, pro_rate);
			pst.setInt(9, tot_amount);
			
			
			pst.executeUpdate();
			pst.close();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
		
	}



		
	public void updatesupplier(int id, String name, Date reg_date, String gender, 
			String address, String contact, String email, int cr_amount, int balance) 
	{
		try {
			query2="UPDATE supplier SET name = ?, reg_date = ?, gender = ?, address = ?, contact = ?, email = ?, cr_amount = ?, balance = ? where id = ? ";
			pst=con.prepareStatement(query2);
			
			pst.setString(1, name);
			pst.setDate(2, reg_date);
			pst.setString(3, gender);
			pst.setString(4, address);
			pst.setString(5, contact);
			pst.setString(6, email);
			pst.setInt(7, cr_amount);
			pst.setInt(8, balance);
			pst.setInt(9, id);
			

			pst.executeUpdate();
			
			pst.close();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void updatesupporder(int id, Date date, int sup_id, String sup_name, int pro_id, String pro_mn, int pro_qn,
			int pro_rate, int tot_amount) {
		try {
			query2="UPDATE sup_order SET date = ?, sup_id = ?, sup_name = ?, pro_id = ?, pro_mn = ?, pro_qn = ?, pro_rate = ?, tot_amount = ? where id = ? ";
			pst=con.prepareStatement(query2);
			
			pst.setDate(1, date);
			pst.setInt(2, sup_id);
			pst.setString(3, sup_name);
			pst.setInt(4, pro_id);
			pst.setString(5, pro_mn);
			pst.setInt(6, pro_qn);
			pst.setInt(7, pro_rate);
			pst.setInt(8, tot_amount);
			pst.setInt(9, id);
			
			
			pst.executeUpdate();
			pst.close();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void dlsup(int id) 
	{
		try {
			query2="delete from supplier where id = ?";
			pst=con.prepareStatement(query2);
			
			pst.setInt(1, id);
			
			pst.execute();
			pst.close();
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void dlsuporder(int id) 
	{
		try {
			query2="delete from sup_order where id = ?";
			pst=con.prepareStatement(query2);
			
			pst.setInt(1, id);
			
			pst.execute();
			pst.close();
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
		
	}


	

}
