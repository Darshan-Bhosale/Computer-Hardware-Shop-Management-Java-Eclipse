package com.chsm.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import com.chsm.form.db.DBProduct;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AddProduct extends JFrame {

    private JPanel contentPane, panelProductinfo, panelOperation;
    private JLabel lblProductID, lblCompanyName, lblProductName, lblProductModelNo, lblProductDescription, lblProductColor, lblProductPrise;
    private JTextField txtProductID, txtProductModelNo, txtProductColor, txtCompanyName, txtProductName, txtProductPrise;
    private JTextArea txtProductDescription;
    private JButton btnSave, btnClear, btnExit;
    private DBProduct db = new DBProduct();

    public AddProduct() {
        setTitle("Adding_Product_Information");
        setBounds(100, 100, 550, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelProductinfo = new JPanel();
        panelProductinfo.setBorder(new TitledBorder(null, "Product_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelProductinfo.setBounds(10, 10, 514, 455);
        contentPane.add(panelProductinfo);
        panelProductinfo.setLayout(null);

        lblProductID = new JLabel("Product ID :");
        lblProductID.setForeground(Color.BLACK);
        lblProductID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductID.setBounds(18, 27, 189, 25);
        panelProductinfo.add(lblProductID);

        txtProductID = new JTextField();
        txtProductID.setBounds(225, 27, 270, 25);
        panelProductinfo.add(txtProductID);
        txtProductID.setText(db.setID());
        txtProductID.setEditable(false);

        lblCompanyName = new JLabel("Company Name :");
        lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCompanyName.setBounds(18, 78, 189, 25);
        panelProductinfo.add(lblCompanyName);

        txtCompanyName = new JTextField();
        txtCompanyName.setBounds(225, 78, 270, 25);
        panelProductinfo.add(txtCompanyName);

        lblProductName = new JLabel("Product Name :");
        lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductName.setBounds(18, 129, 189, 25);
        panelProductinfo.add(lblProductName);

        txtProductName = new JTextField();
        txtProductName.setBounds(225, 129, 270, 25);
        panelProductinfo.add(txtProductName);

        lblProductModelNo = new JLabel("Product Model No :");
        lblProductModelNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductModelNo.setBounds(18, 180, 189, 25);
        panelProductinfo.add(lblProductModelNo);

        txtProductModelNo = new JTextField();
        txtProductModelNo.setBounds(225, 180, 270, 25);
        panelProductinfo.add(txtProductModelNo);

        lblProductDescription = new JLabel("Product Description :");
        lblProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductDescription.setBounds(18, 282, 189, 25);
        panelProductinfo.add(lblProductDescription);

        txtProductDescription = new JTextArea();
        txtProductDescription.setBounds(225, 282, 270, 91);
        panelProductinfo.add(txtProductDescription);

        lblProductColor = new JLabel("Product Color :");
        lblProductColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductColor.setBounds(18, 231, 189, 25);
        panelProductinfo.add(lblProductColor);

        txtProductColor = new JTextField();
        txtProductColor.setBounds(225, 231, 270, 25);
        panelProductinfo.add(txtProductColor);

        lblProductPrise = new JLabel("Product Price :");
        lblProductPrise.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductPrise.setBounds(18, 399, 189, 25);
        panelProductinfo.add(lblProductPrise);

        txtProductPrise = new JTextField();
        txtProductPrise.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtProductPrise.setBounds(225, 399, 270, 25);
        panelProductinfo.add(txtProductPrise);

        panelOperation = new JPanel();
        panelOperation.setLayout(null);
        panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelOperation.setBounds(10, 475, 514, 125);
        contentPane.add(panelOperation);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                db.addproduct(Integer.parseInt(txtProductID.getText()), txtCompanyName.getText(), txtProductName.getText(), txtProductModelNo.getText(), txtProductColor.getText(),
                        txtProductDescription.getText(), Integer.parseInt(txtProductPrise.getText()));
                JOptionPane.showMessageDialog(null, "Product Data Save Sucesfull....");
                dispose();
            }
        });
        btnSave.setForeground(Color.BLACK);
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBackground(new Color(230, 230, 250));
        btnSave.setBounds(16, 37, 150, 50);
        panelOperation.add(btnSave);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtProductModelNo.setText(null);
                txtProductColor.setText(null);
                txtCompanyName.setText(null);
                txtProductName.setText(null);
            }
        });
        btnClear.setForeground(Color.BLACK);
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBackground(new Color(230, 230, 250));
        btnClear.setBounds(182, 37, 150, 50);
        panelOperation.add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Do you want to close Add_Product....");
                dispose();
            }
        });
        btnExit.setForeground(Color.BLACK);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(new Color(230, 230, 250));
        btnExit.setBounds(348, 37, 150, 50);
        panelOperation.add(btnExit);
    }
}
