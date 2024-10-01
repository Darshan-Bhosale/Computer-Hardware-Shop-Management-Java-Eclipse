package com.chsm.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.Date;
import com.toedter.calendar.*;
import java.awt.event.*;
import com.chsm.form.db.*;
import com.chsm.form.transaction.*;
import com.chsm.tool.EmailValidator;

@SuppressWarnings("serial")
public class AddCustomer extends JFrame {

    private JPanel panel, panelCustpi, panelCustoi, panelOperation;
    private JTextField txtCustomerId, txtCustomerName, txtCustomerContact, txtCustomerEmailId, txtCustomerDeposit,
            txtCustomerBalanceAmount;
    private JLabel lblCustomerId, lblCustomerName, lblCustomerRegisteredDate, lblCustomerGender, lblCustomerAddress,
            lblCustomerContact, lblCustomerEmailId, lblCustomerDeposit, lblCustomerBalanceAmount;
    private JRadioButton rbMale, rbFemale;
    private JTextArea txtCustomerAddress;
    private JScrollPane scrollPane;
    private JButton btnSave, btnClear, btnExit, btnPlaceOrder;
    private JDateChooser txtCustomerRegisteredDate;
    private ButtonGroup buttonGroup;
    private DBCustomer db = new DBCustomer();

    public static java.sql.Date datemethad(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqld = new Date(date.getTime());
            return sqld;
        }
        return null;
    }

    public AddCustomer() {
        setResizable(false);
        // setAlwaysOnTop(true);
        setTitle("Adding_Customer_Information");
        setBounds(100, 100, 1200, 525);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        panelCustpi = new JPanel();
        panelCustpi.setLayout(null);
        panelCustpi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Customer_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelCustpi.setBounds(22, 20, 564, 450);
        panel.add(panelCustpi);

        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerId.setBounds(38, 44, 189, 25);
        panelCustpi.add(lblCustomerId);

        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(253, 44, 270, 25);
        panelCustpi.add(txtCustomerId);
        txtCustomerId.setText(db.setID());
        txtCustomerId.setEditable(false);

        lblCustomerName = new JLabel("Customer Name :");
        lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerName.setBounds(38, 89, 189, 25);
        panelCustpi.add(lblCustomerName);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(253, 89, 270, 25);
        panelCustpi.add(txtCustomerName);

        lblCustomerRegisteredDate = new JLabel("Customer Registered Date :");
        lblCustomerRegisteredDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerRegisteredDate.setBounds(38, 134, 189, 25);
        panelCustpi.add(lblCustomerRegisteredDate);

        lblCustomerGender = new JLabel("Customer Gender :");
        lblCustomerGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerGender.setBounds(38, 183, 189, 25);
        panelCustpi.add(lblCustomerGender);

        buttonGroup = new ButtonGroup();

        rbMale = new JRadioButton("Male");
        rbMale.setBackground(null);
        buttonGroup.add(rbMale);
        rbMale.setHorizontalAlignment(SwingConstants.CENTER);
        rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbMale.setBounds(273, 184, 64, 23);
        panelCustpi.add(rbMale);
        rbMale.setActionCommand("Male");

        rbFemale = new JRadioButton("Female");
        rbFemale.setBackground(null);
        buttonGroup.add(rbFemale);
        rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
        rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbFemale.setBounds(388, 184, 73, 23);
        panelCustpi.add(rbFemale);
        rbFemale.setActionCommand("Female");

        lblCustomerAddress = new JLabel("Customer Address :");
        lblCustomerAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerAddress.setBounds(38, 232, 189, 25);
        panelCustpi.add(lblCustomerAddress);

        lblCustomerContact = new JLabel("Customer Contact :");
        lblCustomerContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerContact.setBounds(38, 345, 189, 25);
        panelCustpi.add(lblCustomerContact);

        txtCustomerContact = new JTextField();
        txtCustomerContact.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                } else {
                    if (txtCustomerContact.getText().length() <= 9) {

                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Mobile number should be 10 numbers long", "Mobile Error", JOptionPane.ERROR_MESSAGE);
                        txtCustomerContact.setEditable(false);
                    }

                }

            }

        });
        txtCustomerContact.setBounds(253, 345, 270, 25);
        panelCustpi.add(txtCustomerContact);

        lblCustomerEmailId = new JLabel("Customer Email ID :");
        lblCustomerEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerEmailId.setBounds(38, 390, 189, 25);
        panelCustpi.add(lblCustomerEmailId);

        txtCustomerEmailId = new JTextField();
        txtCustomerEmailId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                txtCustomerContact.setEditable(true);
            }
        });
        txtCustomerEmailId.setBounds(253, 390, 270, 25);
        panelCustpi.add(txtCustomerEmailId);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 234, 270, 90);
        panelCustpi.add(scrollPane);

        txtCustomerAddress = new JTextArea();
        scrollPane.setViewportView(txtCustomerAddress);

        txtCustomerRegisteredDate = new JDateChooser();
        txtCustomerRegisteredDate.setBounds(253, 134, 270, 25);
        panelCustpi.add(txtCustomerRegisteredDate);

        panelCustoi = new JPanel();
        panelCustoi.setLayout(null);
        panelCustoi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Customer_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelCustoi.setBounds(608, 20, 564, 210);
        panel.add(panelCustoi);

        lblCustomerDeposit = new JLabel("Customer Deposit :");
        lblCustomerDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerDeposit.setBounds(38, 53, 189, 25);
        panelCustoi.add(lblCustomerDeposit);

        txtCustomerDeposit = new JTextField();
        txtCustomerDeposit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtCustomerDeposit.setBounds(253, 53, 270, 25);
        panelCustoi.add(txtCustomerDeposit);

        lblCustomerBalanceAmount = new JLabel("Customer Balance Amount :");
        lblCustomerBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCustomerBalanceAmount.setBounds(38, 131, 189, 25);
        panelCustoi.add(lblCustomerBalanceAmount);

        txtCustomerBalanceAmount = new JTextField();
        txtCustomerBalanceAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtCustomerBalanceAmount.setBounds(253, 131, 270, 25);
        panelCustoi.add(txtCustomerBalanceAmount);

        panelOperation = new JPanel();
        panelOperation.setLayout(null);
        panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelOperation.setBounds(608, 253, 564, 217);
        panel.add(panelOperation);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EmailValidator emailValidator = new EmailValidator();
                if (!emailValidator.validate(txtCustomerEmailId.getText().trim())) {
                    JOptionPane.showMessageDialog(getRootPane(), "Invalid Email address", "Mobile Error", JOptionPane.ERROR_MESSAGE);

                }

                if (txtCustomerContact.getText().length() != 10) {

                    JOptionPane.showMessageDialog(getRootPane(), "Invalid Contact address", "Mobile Error", JOptionPane.ERROR_MESSAGE);

                }
                db.addcustomer(Integer.parseInt(txtCustomerId.getText()), txtCustomerName.getText(),
                        datemethad(txtCustomerRegisteredDate.getDate()), buttonGroup.getSelection().getActionCommand(),
                        txtCustomerAddress.getText(), txtCustomerContact.getText(), txtCustomerEmailId.getText(),
                        Integer.parseInt(txtCustomerDeposit.getText()),
                        Integer.parseInt(txtCustomerBalanceAmount.getText()));
                JOptionPane.showMessageDialog(null, "Customer Data Save Sucesfull....");
                dispose();
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBackground(new Color(230, 230, 250));
        btnSave.setBounds(88, 39, 150, 50);

        panelOperation.add(btnSave);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtCustomerName.setText(null);
                txtCustomerContact.setText(null);
                txtCustomerEmailId.setText(null);
                txtCustomerAddress.setText(null);
                txtCustomerDeposit.setText(null);
                txtCustomerBalanceAmount.setText(null);
                buttonGroup.clearSelection();
                txtCustomerRegisteredDate.setCalendar(null);
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBackground(new Color(230, 230, 250));
        btnClear.setBounds(326, 39, 150, 50);
        panelOperation.add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Do you want to close Add_Customer....");
                dispose();
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(new Color(230, 230, 250));
        btnExit.setBounds(88, 128, 150, 50);

        panelOperation.add(btnExit);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                db.addcustomer(Integer.parseInt(txtCustomerId.getText()), txtCustomerName.getText(),
                        datemethad(txtCustomerRegisteredDate.getDate()), buttonGroup.getSelection().getActionCommand(),
                        txtCustomerAddress.getText(), txtCustomerContact.getText(), txtCustomerEmailId.getText(),
                        Integer.parseInt(txtCustomerDeposit.getText()),
                        Integer.parseInt(txtCustomerBalanceAmount.getText()));
                JOptionPane.showMessageDialog(null, "Customer Data Save Sucesfull....");

                dispose();

                new CustomerOrder().setVisible(true);
            }
        });
        btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlaceOrder.setBackground(new Color(230, 230, 250));
        btnPlaceOrder.setBounds(88, 39, 150, 50);
        // panelOperation.add(btnPlaceOrder);
    }
}
