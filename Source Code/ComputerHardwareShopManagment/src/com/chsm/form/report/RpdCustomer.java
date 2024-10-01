package com.chsm.form.report;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBmodel.sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.text.MessageFormat;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class RpdCustomer extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    void view() {
        try {
            Connection c = sqlconnection.getConnection();
            String s = "select * from customer";
            PreparedStatement pst = c.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RpdCustomer() {
        setTitle("Customer Reports");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(68, 28, 688, 277);
        contentPane.add(scrollPane);

        table = new JTable() {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        scrollPane.setViewportView(table);

        JButton btnPrint = new JButton("print");
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                MessageFormat header = new MessageFormat("Report print");
                MessageFormat footer = new MessageFormat("Page{0,number,integer}");

                try {
                    table.print(JTable.PrintMode.NORMAL, header, footer);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("Can not print %s %n", e.getMessage());
                }
            }
        });
        btnPrint.setBounds(126, 334, 89, 23);
        contentPane.add(btnPrint);
        view();

    }
}
