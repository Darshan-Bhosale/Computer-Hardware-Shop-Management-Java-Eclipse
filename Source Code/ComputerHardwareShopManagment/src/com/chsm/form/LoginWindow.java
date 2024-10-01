package com.chsm.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

import com.chsm.form.db.DBLoginWindow;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

    private JPanel contentPane;
    private JTextField txtLoginname;
    private JPasswordField txtPassword;
    private String name, pass;

    public LoginWindow() {
        setBounds(100, 100, 516, 362);
        //setAlwaysOnTop(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(null);
        panel.setBounds(10, 11, 480, 306);
        getContentPane().add(panel);

        txtLoginname = new JTextField();
        txtLoginname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLoginname.setColumns(10);
        txtLoginname.setBackground(new Color(230, 230, 250));
        txtLoginname.setBounds(154, 84, 284, 44);
        panel.add(txtLoginname);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @SuppressWarnings({"deprecation"})
            public void actionPerformed(ActionEvent arg0) {
                name = txtLoginname.getText();
                pass = txtPassword.getText();
                DBLoginWindow db = new DBLoginWindow();
                int i = db.checkLogin(name, pass);
                if (i == 0) {
                    setVisible(false);
                }
            }
        });
        btnLogin.setForeground(SystemColor.controlDkShadow);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.setBackground(new Color(230, 230, 250));
        btnLogin.setBounds(263, 229, 175, 50);

        panel.add(btnLogin);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtPassword.setBackground(new Color(230, 230, 250));
        txtPassword.setBounds(154, 153, 284, 44);
        panel.add(txtPassword);

        JLabel label = new JLabel("Login Form");
        label.setForeground(new Color(230, 230, 250));
        label.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.setBackground(Color.BLACK);
        label.setBounds(169, 11, 141, 50);
        panel.add(label);

        JLabel loginIcon = new JLabel("");
        Image img1 = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
        loginIcon.setIcon(new ImageIcon(img1));
        loginIcon.setBounds(42, 81, 50, 50);
        panel.add(loginIcon);

        JLabel passIcon = new JLabel("");
        Image img2 = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
        passIcon.setIcon(new ImageIcon(img2));
        passIcon.setBounds(42, 150, 50, 50);
        panel.add(passIcon);

        JButton btnClear = new JButton("Clear");
        btnClear.setForeground(SystemColor.controlDkShadow);
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnClear.setBackground(new Color(230, 230, 250));
        btnClear.setBounds(42, 229, 175, 50);
        panel.add(btnClear);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtLoginname.setText(null);
                txtPassword.setText(null);
            }
        });
    }

}
