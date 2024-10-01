package com.chsm.form.report;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBmodel.sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rpd_emp_payment extends JFrame {

    private JPanel contentPane;
    private JTable table;

    void view() {
        try {
            Connection c = sqlconnection.getConnection();
            String s = "select * from emp_salary";
            PreparedStatement pst = c.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Rpd_emp_payment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 496);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(42, 114, 601, 147);
        contentPane.add(scrollPane);

        table = new JTable() {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("print");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageFormat header = new MessageFormat("Report print");
                MessageFormat footer = new MessageFormat("Page{0,number,integer}");

                try {
                    table.print(JTable.PrintMode.NORMAL, header, footer);
                } catch (java.awt.print.PrinterException ex) {
                    System.err.format("Can not print %s %n", ex.getMessage());
                }
            }
        });
        btnNewButton.setBounds(131, 335, 89, 23);
        contentPane.add(btnNewButton);

        view();
    }

}
