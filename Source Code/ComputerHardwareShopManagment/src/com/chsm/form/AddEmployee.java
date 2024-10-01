package com.chsm.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

import com.chsm.form.db.DBEmployee;
import com.chsm.tool.EmailValidator;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AddEmployee extends JFrame {

    private JPanel panel, panelEmppi, panelEmpoc, panelOperation;
    private JTextField txtEmployeeID, txtEmployeeName, txtEmployeeContact, txtEmployeeEmailID, txtEmployeeDesignation,
            txtEmployeeSalary, txtEmployeeUserName, txtEmployeePassword;
    private JLabel lblEmployeeId, lblEmployeeName, lblEmployeeBirthDate, lblEmployeeGender, lblEmployeeAddress,
            lblEmployeeContact, lblEmployeeEmailID, lblEmployeePassword;
    private JLabel lblEmployeeJoiningDate, lblEmployeeDesignation, lblEmployeeSalary, lblEmployeeUserName;
    private JRadioButton rbMale, rbFemale;
    private JButton btnSave, btnClear, btnExit;
    private ButtonGroup buttonGroup;
    private JTextArea txtaEmployeeAddress;
    private JScrollPane scrollPane;
    private JDateChooser txtEmployeeBirthDate, txtEmployeeJoiningDate;
    private DBEmployee db = new DBEmployee();

    public static java.sql.Date datemethad(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqld = new Date(date.getTime());
            return sqld;
        }
        return null;
    }

    public AddEmployee() {
        setResizable(false);
        // setAlwaysOnTop(true);
        setTitle("Adding_Employee_Information");
        setBounds(100, 100, 1200, 525);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        panelEmppi = new JPanel();
        panelEmppi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Employee_Personal_Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelEmppi.setBounds(22, 19, 564, 458);
        panel.add(panelEmppi);
        panelEmppi.setLayout(null);

        lblEmployeeId = new JLabel("Employee ID :");
        lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeId.setBounds(38, 44, 150, 25);
        panelEmppi.add(lblEmployeeId);

        txtEmployeeID = new JTextField();
        txtEmployeeID.setColumns(10);
        txtEmployeeID.setBounds(253, 44, 270, 25);
        panelEmppi.add(txtEmployeeID);
        txtEmployeeID.setText(db.setID());
        txtEmployeeID.setEditable(false);

        lblEmployeeName = new JLabel("Employee Name :");
        lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeName.setBounds(38, 89, 150, 25);
        panelEmppi.add(lblEmployeeName);

        txtEmployeeName = new JTextField();
        txtEmployeeName.setColumns(10);
        txtEmployeeName.setBounds(253, 89, 270, 25);
        panelEmppi.add(txtEmployeeName);

        lblEmployeeBirthDate = new JLabel("Employee Birth Date :");
        lblEmployeeBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeBirthDate.setBounds(38, 134, 150, 25);
        panelEmppi.add(lblEmployeeBirthDate);

        lblEmployeeGender = new JLabel("Employee Gender :");
        lblEmployeeGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeGender.setBounds(38, 183, 150, 25);
        panelEmppi.add(lblEmployeeGender);

        buttonGroup = new ButtonGroup();
        rbMale = new JRadioButton("Male");
        rbMale.setBackground(null);
        buttonGroup.add(rbMale);
        rbMale.setHorizontalAlignment(SwingConstants.CENTER);
        rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbMale.setBounds(273, 184, 64, 23);
        panelEmppi.add(rbMale);
        rbMale.setActionCommand("Male");

        rbFemale = new JRadioButton("Female");
        rbFemale.setBackground(null);
        buttonGroup.add(rbFemale);
        rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
        rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbFemale.setBounds(388, 184, 73, 23);
        panelEmppi.add(rbFemale);
        rbFemale.setActionCommand("Female");

        lblEmployeeAddress = new JLabel("Employee Address :");
        lblEmployeeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeAddress.setBounds(38, 232, 150, 25);
        panelEmppi.add(lblEmployeeAddress);

        lblEmployeeContact = new JLabel("Employee Contact :");
        lblEmployeeContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeContact.setBounds(38, 345, 150, 25);
        panelEmppi.add(lblEmployeeContact);

        txtEmployeeContact = new JTextField();
        txtEmployeeContact.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                } else {
                    if (txtEmployeeContact.getText().length() <= 9) {

                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Mobile number should be 10 numbers long", "Mobile Error", JOptionPane.ERROR_MESSAGE);
                        txtEmployeeContact.setEditable(false);
                    }

                }
            }
        });
        txtEmployeeContact.setColumns(10);
        txtEmployeeContact.setBounds(253, 345, 270, 25);
        panelEmppi.add(txtEmployeeContact);

        lblEmployeeEmailID = new JLabel("Employee Email ID :");
        lblEmployeeEmailID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeEmailID.setBounds(38, 390, 150, 25);
        panelEmppi.add(lblEmployeeEmailID);

        txtEmployeeEmailID = new JTextField();
        txtEmployeeEmailID.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
            }
        });
        txtEmployeeEmailID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                txtEmployeeContact.setEditable(true);
            }
        });
        txtEmployeeEmailID.setColumns(10);
        txtEmployeeEmailID.setBounds(253, 390, 270, 25);
        panelEmppi.add(txtEmployeeEmailID);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 234, 270, 90);
        panelEmppi.add(scrollPane);

        txtaEmployeeAddress = new JTextArea();
        scrollPane.setViewportView(txtaEmployeeAddress);

        txtEmployeeBirthDate = new JDateChooser();
        txtEmployeeBirthDate.setBounds(253, 134, 270, 25);
        panelEmppi.add(txtEmployeeBirthDate);

        panelEmpoc = new JPanel();
        panelEmpoc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Employee_Official_Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelEmpoc.setBounds(608, 19, 564, 289);
        panel.add(panelEmpoc);
        panelEmpoc.setLayout(null);

        lblEmployeeJoiningDate = new JLabel("Employee Joining Date :");
        lblEmployeeJoiningDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeJoiningDate.setBounds(38, 27, 169, 25);
        panelEmpoc.add(lblEmployeeJoiningDate);

        lblEmployeeDesignation = new JLabel("Employee Designation :");
        lblEmployeeDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeDesignation.setBounds(38, 79, 169, 25);
        panelEmpoc.add(lblEmployeeDesignation);

        txtEmployeeDesignation = new JTextField();
        txtEmployeeDesignation.setColumns(10);
        txtEmployeeDesignation.setBounds(253, 79, 270, 25);
        panelEmpoc.add(txtEmployeeDesignation);

        lblEmployeeSalary = new JLabel("Employee Salary :");
        lblEmployeeSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeSalary.setBounds(38, 235, 150, 25);
        panelEmpoc.add(lblEmployeeSalary);

        txtEmployeeSalary = new JTextField();
        txtEmployeeSalary.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent a) {
                char c = a.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    a.consume();
                }
            }
        });
        txtEmployeeSalary.setColumns(10);
        txtEmployeeSalary.setBounds(253, 235, 270, 25);
        panelEmpoc.add(txtEmployeeSalary);

        lblEmployeeUserName = new JLabel("Employee User Name :");
        lblEmployeeUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeeUserName.setBounds(38, 131, 169, 25);
        panelEmpoc.add(lblEmployeeUserName);

        txtEmployeeUserName = new JTextField();
        txtEmployeeUserName.setColumns(10);
        txtEmployeeUserName.setBounds(253, 131, 270, 25);
        panelEmpoc.add(txtEmployeeUserName);

        lblEmployeePassword = new JLabel("Employee Password :");
        lblEmployeePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmployeePassword.setBounds(38, 183, 169, 25);
        panelEmpoc.add(lblEmployeePassword);

        txtEmployeePassword = new JTextField();
        txtEmployeePassword.setColumns(10);
        txtEmployeePassword.setBounds(253, 183, 270, 25);
        panelEmpoc.add(txtEmployeePassword);

        txtEmployeeJoiningDate = new JDateChooser();
        txtEmployeeJoiningDate.setBackground(SystemColor.text);
        txtEmployeeJoiningDate.setBounds(253, 27, 270, 25);
        panelEmpoc.add(txtEmployeeJoiningDate);

        panelOperation = new JPanel();
        panelOperation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation ",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelOperation.setBounds(608, 327, 564, 150);
        panel.add(panelOperation);
        panelOperation.setLayout(null);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EmailValidator emailValidator = new EmailValidator();
                if (!emailValidator.validate(txtEmployeeEmailID.getText().trim())) {
                    JOptionPane.showMessageDialog(getRootPane(), "Invalid Email address", "Mobile Error", JOptionPane.ERROR_MESSAGE);
                    //JOptionPane.showMessageDialog(null, "Customer Data No added....");

                } else {
                    db.addemployee(Integer.parseInt(txtEmployeeID.getText()), txtEmployeeContact.getText(),
                            Integer.parseInt(txtEmployeeSalary.getText()), txtEmployeeName.getText(),
                            buttonGroup.getSelection().getActionCommand(), txtaEmployeeAddress.getText(),
                            txtEmployeeEmailID.getText(), txtEmployeeDesignation.getText(),
                            datemethad(txtEmployeeBirthDate.getDate()), datemethad(txtEmployeeJoiningDate.getDate()));

                    db.addlogin(Integer.parseInt(txtEmployeeID.getText()), txtEmployeeUserName.getText(),
                            txtEmployeePassword.getText());
                    JOptionPane.showMessageDialog(null, "Employee Data Save Sucesfull....");
                    dispose();
                }
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBackground(new Color(230, 230, 250));
        btnSave.setBounds(28, 50, 150, 50);
        panelOperation.add(btnSave);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtEmployeeName.setText(null);
                txtEmployeeContact.setText(null);
                txtEmployeeEmailID.setText(null);
                txtEmployeeDesignation.setText(null);
                txtEmployeeSalary.setText(null);
                txtEmployeeUserName.setText(null);
                txtEmployeePassword.setText(null);
                txtaEmployeeAddress.setText(null);
                buttonGroup.clearSelection();
                txtEmployeeBirthDate.setCalendar(null);
                txtEmployeeJoiningDate.setCalendar(null);
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBackground(new Color(230, 230, 250));
        btnClear.setBounds(206, 50, 150, 50);
        panelOperation.add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Do you want to close Add_Employee....");
                dispose();
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(new Color(230, 230, 250));
        btnExit.setBounds(384, 50, 150, 50);
        panelOperation.add(btnExit);

    }
}
