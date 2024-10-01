package com.chsm.form.report;

import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import DBmodel.sqlconnection;

@SuppressWarnings("serial")
public class RpdEmpPayment extends JFrame {

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

    public RpdEmpPayment() {
        setTitle("Employee_Payment_Report");
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 100, 800, 300);
        contentPane.add(scrollPane);

        table = new JTable() {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        scrollPane.setViewportView(table);

        JLabel lblEmployeePaymentReport = new JLabel("Employee Payment Report ");
        lblEmployeePaymentReport.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblEmployeePaymentReport.setBounds(40, 36, 400, 30);
        contentPane.add(lblEmployeePaymentReport);

        JButton btnPrint = new JButton("Print");
        btnPrint.addActionListener(new ActionListener() {
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
        btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrint.setBackground(new Color(230, 230, 250));
        btnPrint.setBounds(740, 36, 100, 30);
        contentPane.add(btnPrint);

        view();
    }
}
