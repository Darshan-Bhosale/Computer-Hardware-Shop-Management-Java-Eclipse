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

public class Rpd_order extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnPrint;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    void view() {
        try {
            Connection c = sqlconnection.getConnection();
            String s = "select * from cust_order";
            PreparedStatement pst = c.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Rpd_order() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 487);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(114, 94, 477, 121);
        contentPane.add(scrollPane);

        table = new JTable() {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };

        scrollPane.setViewportView(table);

        btnPrint = new JButton("print");
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
        btnPrint.setBounds(120, 332, 89, 23);
        contentPane.add(btnPrint);

        view();
    }

}
