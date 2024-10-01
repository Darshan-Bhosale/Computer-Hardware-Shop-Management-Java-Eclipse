package com.chsm.form.db;

import java.awt.*;
import java.sql.*;

public class DBCustomer {

    private String query1, query2, query3, query4;
    private Connection con;
    private PreparedStatement pst, pst1, pst2;
    private ResultSet rs;
    private String id = null;

    public DBCustomer() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chsm", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String setID() {
        try {
            query1 = "select id from customer";
            pst = con.prepareStatement(query1);
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                id = "1";
            } else {
                rs.last();
                id = String.valueOf(rs.getInt(1) + 1);
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public String setOID() {
        try {
            query1 = "select id from cust_order";
            pst = con.prepareStatement(query1);
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                id = "1";
            } else {
                rs.last();
                id = String.valueOf(rs.getInt(1) + 1);
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public String setDOID() {
        try {
            query1 = "select id from dispatch_custorder";
            pst = con.prepareStatement(query1);
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                id = "1";
            } else {
                rs.last();
                id = String.valueOf(rs.getInt(1) + 1);
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public void addcustomer(int id, String name, Date reg_date, String gender, String address, String contact, String email, int cr_amount, int balance) {

        try {
            query2 = "insert into customer value(?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query2);

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

    public void addcustorder(int id, Date date, int cust_id, String cust_name, String cust_contact, int cust_bamount, int pro_id,
            String pro_mno, int pro_quntity, int pro_rate, int tot_amount, String address) {
        try {
            query2 = "insert into cust_order value(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query2);

            pst.setInt(1, id);
            pst.setDate(2, date);
            pst.setInt(3, cust_id);
            pst.setString(4, cust_name);
            pst.setString(5, cust_contact);
            pst.setInt(6, cust_bamount);
            pst.setInt(7, pro_id);
            pst.setString(8, pro_mno);
            pst.setInt(9, pro_quntity);
            pst.setInt(10, pro_rate);
            pst.setInt(11, tot_amount);
            pst.setString(12, address);

            pst.executeUpdate();
            pst.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void decustorder(int id, Date date, int order_id, String cust_name, String cust_address,
            String cust_contact, int order_amount, String vehical_number, String driver_name, int tot_amount) {
        try {
            query4 = "insert into dispatch_custorder value(?,?,?,?,?,?,?,?,?,?)";
            pst2 = con.prepareStatement(query4);

            pst2.setInt(1, id);
            pst2.setDate(2, date);
            pst2.setInt(3, order_id);
            pst2.setString(4, cust_name);
            pst2.setString(5, cust_address);
            pst2.setString(6, cust_contact);
            pst2.setInt(7, order_amount);
            pst2.setString(8, vehical_number);
            pst2.setString(9, driver_name);
            pst2.setInt(10, tot_amount);

            pst2.execute();

            pst2.close();
        } catch (HeadlessException | SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void updatecust(int id, String name, Date reg_date, String gender, String address, String contact,
            String email, int cr_amount, int balance) {
        try {
            query3 = "UPDATE customer SET name = ?, reg_date = ?, gender = ?, address = ?, contact = ?, email = ?, cr_amount = ?, balance = ? where id = ? ";
            pst1 = con.prepareStatement(query3);

            pst1.setString(1, name);
            pst1.setDate(2, reg_date);
            pst1.setString(3, gender);
            pst1.setString(4, address);
            pst1.setString(5, contact);
            pst1.setString(6, email);
            pst1.setInt(7, cr_amount);
            pst1.setInt(8, balance);
            pst1.setInt(9, id);

            pst1.executeUpdate();
            pst1.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatecustorder(int id, Date date, int cust_id, String cust_name, String cust_contact, int cust_bamount,
            int pro_id, String pro_mno, int pro_quntity, int pro_rate, int tot_amount) {

        try {
            query2 = "UPDATE cust_order SET date = ?, cust_id = ?, cust_name = ?, cust_contact = ?, cust_bamount = ?, pro_id = ?, pro_mno = ?, pro_quntity = ?, pro_rate = ?, tot_amount = ? where id = ? ";
            pst = con.prepareStatement(query2);

            pst.setDate(1, date);
            pst.setInt(2, cust_id);
            pst.setString(3, cust_name);
            pst.setString(4, cust_contact);
            pst.setInt(5, cust_bamount);
            pst.setInt(6, pro_id);
            pst.setString(7, pro_mno);
            pst.setInt(8, pro_quntity);
            pst.setInt(9, pro_rate);
            pst.setInt(10, tot_amount);
            pst.setInt(11, id);

            pst.executeUpdate();
            pst.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void dlcust(int id) {
        try {
            query2 = "delete from customer where id = ?";
            pst = con.prepareStatement(query2);

            pst.setInt(1, id);

            pst.execute();
            pst.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void dlcustorder(int id) {
        try {
            query2 = "delete from cust_order where id = ?";
            pst = con.prepareStatement(query2);

            pst.setInt(1, id);

            pst.execute();
            pst.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

}
