package com.chsm.form.report;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.*;
import java.awt.*;
import DBmodel.sqlconnection;

@SuppressWarnings("serial")
public class RpdSupplierInfo extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane_1;
    private JButton button;
    private JLabel lblSupplierInformationReport;

    void view() {
        try {
            Connection c = sqlconnection.getConnection();
            String s = "select * from supplier";
            PreparedStatement pst = c.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RpdSupplierInfo() {
        setTitle("Supplier_Info_Report");
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 100, 800, 300);
        contentPane.add(scrollPane_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane_1.setViewportView(scrollPane);

        table = new JTable() {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        scrollPane.setViewportView(table);

        button = new JButton("Print");
        button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button.setBackground(new Color(230, 230, 250));
        button.setBounds(740, 36, 100, 30);
        contentPane.add(button);

        lblSupplierInformationReport = new JLabel("Supplier Information Report");
        lblSupplierInformationReport.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblSupplierInformationReport.setBounds(40, 36, 400, 30);
        contentPane.add(lblSupplierInformationReport);
        view();
    }

}
