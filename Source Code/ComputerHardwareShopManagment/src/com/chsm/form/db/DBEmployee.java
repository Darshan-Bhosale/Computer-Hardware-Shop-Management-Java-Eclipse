package com.chsm.form.db;

import java.awt.*;
import java.sql.*;


public class DBEmployee 
{

	private String query1, query2, query3, query4, query5;
	private Connection con;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5;
	private ResultSet rs;
	private String id=null;


	public DBEmployee() 
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
			query1 = "select id from employee";
			pst1 = con.prepareStatement(query1);
			rs = pst1.executeQuery();
			if(!rs.isBeforeFirst())
				id="1";
			else 
			{
				rs.last();
				id = String.valueOf(rs.getInt(1) + 1);
			}
			pst1.close();
		} 
		catch (HeadlessException | SQLException e) 
		{		e.printStackTrace();		}
		 
		return id;
	}
	
	public void addemployee(int id, String contact, int salary, String name, String gender, String address, String email, String designation, Date birth_date, Date joining_date) 
	{
		try {
			query2="insert into employee value(?,?,?,?,?,?,?,?,?,?)";
			pst2=con.prepareStatement(query2);
			
			pst2.setInt(1, id);
			pst2.setString(2, name);
			pst2.setDate(3, birth_date);
			pst2.setString(4, gender);
			pst2.setString(5, address);
			pst2.setString(6, contact);
			pst2.setString(7, email);
			pst2.setDate(8, joining_date);
			pst2.setString(9, designation);
			pst2.setInt(10, salary);
			
			pst2.execute();
			
			pst2.close();
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addlogin(int id, String lname, String lpass)
	{
		try {
			query3 = "insert into login value(?,?,?)";
			pst3=con.prepareStatement(query3);
			
			pst3.setInt(1, id);
			pst3.setString(2, lname);
			pst3.setString(3, lpass);
			
			pst3.execute();
						
			pst3.close();
				
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
	}




	public void updateemp(int id, String contact, int salary, String name, String gender, String address, String email, 
			String designation, Date birth_date, Date joining_date) 
	{
		try {
			query4="UPDATE employee SET name = ?, birth_date = ?, gender = ?, address = ?, contact = ?, email = ?, joining_date = ?, designation = ?, salary = ? where id = ? ";
			pst4=con.prepareStatement(query4);
			
			pst4.setString(1, name);
			pst4.setDate(2, birth_date);
			pst4.setString(3, gender);
			pst4.setString(4, address);
			pst4.setString(5, contact);
			pst4.setString(6, email);
			pst4.setDate(7, joining_date);
			pst4.setString(8, designation);
			pst4.setInt(9, salary);
			pst4.setInt(10, id);
			
			pst4.executeUpdate();
			pst4.close();
			
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public void empsal(int eid, String ename, Date sdate, int esal, int advsal, int bosal, int totsal)
	{
		try {
			
			query1 = "select id from emp_salary";
			pst1 = con.prepareStatement(query1);
			rs = pst1.executeQuery();
			if(!rs.isBeforeFirst())
				id="1";
			else 
			{
				rs.last();
				id = String.valueOf(rs.getInt(1) + 1);
			}
			pst1.close();
			
			
			
			
			
			query5 = "insert into emp_salary value(?,?,?,?,?,?,?,?)";
			pst5=con.prepareStatement(query5);
			
			pst5.setInt(1, Integer.parseInt(id));
			pst5.setInt(2, eid);
			pst5.setString(3, ename);
			pst5.setDate(4, sdate);
			pst5.setInt(5, esal);
			pst5.setInt(6, advsal);
			pst5.setInt(7, bosal);
			pst5.setInt(8, totsal);
			
			pst5.execute();
						
			pst5.close();
				
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
	}
	
	
	public void dlemp(int id)
	{
		try {
			query2="delete from employee where id = ?";
			pst5=con.prepareStatement(query2);
			
			pst5.setInt(1, id);
			
			pst5.execute();
			pst5.close();
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}