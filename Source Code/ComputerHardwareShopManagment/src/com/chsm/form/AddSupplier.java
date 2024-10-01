package com.chsm.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import com.chsm.form.db.*;
import com.chsm.form.transaction.SupplierOrder;
import com.chsm.tool.EmailValidator;
//import com.google.i18n.phonenumbers.NumberParseException;
//import com.google.i18n.phonenumbers.PhoneNumberUtil;
//import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class AddSupplier extends JFrame {

    private JPanel panel, panelSupplierpi, panelOpration, panelSupplierOI;
    private JLabel lblSupplierId, lblSupplierName, lblSupplierRegisteredDate, lblSupplierGender, lblSupplierAddress, lblSupplierContact, lblSupplierEmailId, lblSupplierDeposit, lblSupplierBalanceAmount;
    private JTextField txtSupplierId, txtSupplierName, txtSupplierContact, txtSupplierEmailId, txtSupplierDeposit, txtSupplierBalanceAmount;
    private JTextArea txtSupplierAddress;
    private JButton btnSave, btnClear, btnExit, btnPlaceOrder;
    private JRadioButton rbMale, rbFemale;
    private JDateChooser txtSupplierRegisteredDate;
    private JScrollPane scrollPane;
    private ButtonGroup buttonGroup;
    private DBSupplier db = new DBSupplier();

    public static java.sql.Date datemethad(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqld = new Date(date.getTime());
            return sqld;
        }
        return null;
    }

    public AddSupplier() {
        setTitle("Adding_Supplier_Information");
        setBounds(100, 100, 1200, 525);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        panelSupplierpi = new JPanel();
        panelSupplierpi.setLayout(null);
        panelSupplierpi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelSupplierpi.setBounds(18, 20, 564, 450);
        panel.add(panelSupplierpi);

        lblSupplierId = new JLabel("Supplier ID :");
        lblSupplierId.setForeground(Color.BLACK);
        lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierId.setBounds(38, 44, 189, 25);
        panelSupplierpi.add(lblSupplierId);

        txtSupplierId = new JTextField();
        txtSupplierId.setText(db.setID());
        txtSupplierId.setColumns(10);
        txtSupplierId.setBounds(253, 44, 270, 25);
        panelSupplierpi.add(txtSupplierId);
        txtSupplierId.setEditable(false);

        lblSupplierName = new JLabel("Supplier Name :");
        lblSupplierName.setForeground(Color.BLACK);
        lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierName.setBounds(38, 89, 189, 25);
        panelSupplierpi.add(lblSupplierName);

        txtSupplierName = new JTextField();
        txtSupplierName.setColumns(10);
        txtSupplierName.setBounds(253, 89, 270, 25);
        panelSupplierpi.add(txtSupplierName);

        lblSupplierRegisteredDate = new JLabel("Supplier Registered Date :");
        lblSupplierRegisteredDate.setForeground(Color.BLACK);
        lblSupplierRegisteredDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierRegisteredDate.setBounds(38, 134, 189, 25);
        panelSupplierpi.add(lblSupplierRegisteredDate);

        lblSupplierGender = new JLabel("Supplier Gender :");
        lblSupplierGender.setForeground(Color.BLACK);
        lblSupplierGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierGender.setBounds(38, 183, 189, 25);
        panelSupplierpi.add(lblSupplierGender);

        buttonGroup = new ButtonGroup();

        rbMale = new JRadioButton("Male");
        rbMale.setBackground(null);
        buttonGroup.add(rbMale);
        rbMale.setHorizontalAlignment(SwingConstants.CENTER);
        rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbMale.setBounds(273, 184, 64, 23);
        panelSupplierpi.add(rbMale);
        rbMale.setActionCommand("Male");

        rbFemale = new JRadioButton("Female");
        rbFemale.setBackground(null);
        buttonGroup.add(rbFemale);
        rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
        rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbFemale.setBounds(388, 184, 73, 23);
        panelSupplierpi.add(rbFemale);
        rbFemale.setActionCommand("Female");

        lblSupplierAddress = new JLabel("Supplier Address :");
        lblSupplierAddress.setForeground(Color.BLACK);
        lblSupplierAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierAddress.setBounds(38, 232, 189, 25);
        panelSupplierpi.add(lblSupplierAddress);

        lblSupplierContact = new JLabel("Supplier Contact :");
        lblSupplierContact.setForeground(Color.BLACK);
        lblSupplierContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierContact.setBounds(38, 345, 189, 25);
        panelSupplierpi.add(lblSupplierContact);

        txtSupplierContact = new JTextField();
        txtSupplierContact.setColumns(10);
        txtSupplierContact.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                } else {
                    if (txtSupplierContact.getText().length() <= 9) {

                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Mobile number should be 10 numbers long", "Mobile Error", JOptionPane.ERROR_MESSAGE);
                        txtSupplierContact.setEditable(false);
                    }

                }
            }

        });
        txtSupplierContact.setBounds(253, 345, 270, 25);
        panelSupplierpi.add(txtSupplierContact);

        lblSupplierEmailId = new JLabel("Supplier Email ID :");
        lblSupplierEmailId.setForeground(Color.BLACK);
        lblSupplierEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierEmailId.setBounds(38, 390, 189, 25);
        panelSupplierpi.add(lblSupplierEmailId);

        txtSupplierEmailId = new JTextField();
        txtSupplierEmailId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                txtSupplierContact.setEditable(true);
            }
        });
        txtSupplierEmailId.setColumns(10);
        txtSupplierEmailId.setBounds(253, 390, 270, 25);
        panelSupplierpi.add(txtSupplierEmailId);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 234, 270, 90);
        panelSupplierpi.add(scrollPane);

        txtSupplierAddress = new JTextArea();
        scrollPane.setViewportView(txtSupplierAddress);

        txtSupplierRegisteredDate = new JDateChooser();
        txtSupplierRegisteredDate.setDate(new java.util.Date());
        txtSupplierRegisteredDate.setBounds(253, 134, 270, 25);
        panelSupplierpi.add(txtSupplierRegisteredDate);

        panelSupplierOI = new JPanel();
        panelSupplierOI.setLayout(null);
        panelSupplierOI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelSupplierOI.setBounds(600, 20, 564, 210);
        panel.add(panelSupplierOI);

        lblSupplierDeposit = new JLabel("Supplier Deposit :");
        lblSupplierDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierDeposit.setBounds(38, 53, 189, 25);
        panelSupplierOI.add(lblSupplierDeposit);

        txtSupplierDeposit = new JTextField();
        txtSupplierDeposit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtSupplierDeposit.setBounds(253, 53, 270, 25);
        panelSupplierOI.add(txtSupplierDeposit);

        lblSupplierBalanceAmount = new JLabel("Supplier Balance Amount :");
        lblSupplierBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplierBalanceAmount.setBounds(38, 131, 189, 25);
        panelSupplierOI.add(lblSupplierBalanceAmount);

        txtSupplierBalanceAmount = new JTextField();
        txtSupplierBalanceAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtSupplierBalanceAmount.setBounds(253, 131, 270, 25);
        panelSupplierOI.add(txtSupplierBalanceAmount);

        panelOpration = new JPanel();
        panelOpration.setLayout(null);
        panelOpration.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelOpration.setBounds(600, 253, 564, 217);
        panel.add(panelOpration);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EmailValidator emailValidator = new EmailValidator();

                if (!emailValidator.validate(txtSupplierEmailId.getText().trim())) {
                    JOptionPane.showMessageDialog(getRootPane(), "Invalid Email address", "Mobile Error", JOptionPane.ERROR_MESSAGE);
                    //JOptionPane.showMessageDialog(null, "Customer Data No added....");

                } else {
                    db.addsupplier(Integer.parseInt(txtSupplierId.getText()), txtSupplierName.getText(), datemethad(txtSupplierRegisteredDate.getDate()), buttonGroup.getSelection().getActionCommand(),
                            txtSupplierAddress.getText(), txtSupplierContact.getText(), txtSupplierEmailId.getText(), Integer.parseInt(txtSupplierDeposit.getText()),
                            Integer.parseInt(txtSupplierBalanceAmount.getText()));
                }
                JOptionPane.showMessageDialog(null, "Supplier Data Save Sucesfull....");
                dispose();
            }

        }
        );
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBackground(new Color(230, 230, 250));
        btnSave.setBounds(88, 39, 150, 50);

        panelOpration.add(btnSave);

        btnClear = new JButton("Clear");

        btnClear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtSupplierName.setText(null);
                txtSupplierContact.setText(null);
                txtSupplierEmailId.setText(null);
                txtSupplierDeposit.setText(null);
                txtSupplierBalanceAmount.setText(null);
                txtSupplierAddress.setText(null);
                buttonGroup.clearSelection();
                txtSupplierRegisteredDate.setCalendar(null);
            }
        }
        );
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBackground(new Color(230, 230, 250));
        btnClear.setBounds(326, 39, 150, 50);
        panelOpration.add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Do you want to close Add_Supplier....");
                dispose();
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(new Color(230, 230, 250));
        btnExit.setBounds(88, 128, 150, 50);
        panelOpration.add(btnExit);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                db.addsupplier(Integer.parseInt(txtSupplierId.getText()), txtSupplierName.getText(), datemethad(txtSupplierRegisteredDate.getDate()), buttonGroup.getSelection().getActionCommand(),
                        txtSupplierAddress.getText(), txtSupplierContact.getText(), txtSupplierEmailId.getText(), Integer.parseInt(txtSupplierDeposit.getText()),
                        Integer.parseInt(txtSupplierBalanceAmount.getText()));
                JOptionPane.showMessageDialog(null, "Supplier Data Save Sucesfull....");
                dispose();
                new SupplierOrder().setVisible(true);
            }
        });
        btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlaceOrder.setBackground(new Color(230, 230, 250));
        btnPlaceOrder.setBounds(88, 39, 150, 50);
        //panelOpration.add(btnPlaceOrder);

    }
}
