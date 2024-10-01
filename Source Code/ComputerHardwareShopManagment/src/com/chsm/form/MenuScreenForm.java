package com.chsm.form;


import java.awt.event.*;
import javax.swing.*;

import com.chsm.form.modify.*;
import com.chsm.form.report.*;
import com.chsm.form.transaction.*;

@SuppressWarnings("serial")
public class MenuScreenForm extends JFrame 
{
	private JMenuBar menuBar;
	private JMenu mnFile, mnMaster, mnNewMenu, mnSearch, mnReport, mnUtilites, mnHelp;
	private JMenuItem mntmPasswordChange, mntmLogoutUser, mntmSystemExit, mntmAddEmployee, mntmAddSupplier, mntmAddProduct, mntmAddCustomer, mntmSupplierOrder,
			mntmCustomerOrder, mntmDispatchProduct, mntmSearchSupplier, mntmSearchCustomer, mntmSearchCustomerOrder, mntmSearchEmployee,
			mntmSearchSupplierOrder, mntmEmployeeReport, mntmCustomerReport, mntmSupplierReport, mntmProductReport, mntmCustOrderReport, mntmNotepad,
			mntmCalculator, mntmSystemInfo, mntmContactUs;
	private JSeparator s1, s2;
	private JMenuItem mntmEmployeepaymnet;
	private JMenuItem mntmEmployeepayment;

	
	
	public MenuScreenForm() 
	{
		setTitle("Computer Hardware Shop");
		setBounds(100, 100, 816, 632);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmPasswordChange = new JMenuItem("Password Change");
		mntmPasswordChange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new PasswordChange().setVisible(true);
			}
		});
		mnFile.add(mntmPasswordChange);
		
		mntmLogoutUser = new JMenuItem("Logout User");
		mntmLogoutUser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				new LoginWindow().setVisible(true);
			}
		});
		mnFile.add(mntmLogoutUser);
		
		s1 = new JSeparator();
		mnFile.add(s1);
		
		mntmSystemExit = new JMenuItem("System Exit");
		mntmSystemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnFile.add(mntmSystemExit);
		
		mnMaster = new JMenu("Master");
		menuBar.add(mnMaster);
		
		mntmAddEmployee = new JMenuItem("Add_Employee");
		mntmAddEmployee.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddEmployee().setVisible(true);
			}
		});
		mnMaster.add(mntmAddEmployee);
		
		mntmAddSupplier = new JMenuItem("Add_Supplier");
		mntmAddSupplier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddSupplier().setVisible(true);
			}
		});
		mnMaster.add(mntmAddSupplier);
		
		mntmAddProduct = new JMenuItem("Add_Product");
		mntmAddProduct.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddProduct().setVisible(true);
			}
		});
		mnMaster.add(mntmAddProduct);
		
		mntmAddCustomer = new JMenuItem("Add_Customer");
		mntmAddCustomer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddCustomer().setVisible(true);
			}
		});
		mnMaster.add(mntmAddCustomer);
		
		mnNewMenu = new JMenu("Transaction");
		menuBar.add(mnNewMenu);
		
		mntmSupplierOrder = new JMenuItem("Supplier_Order");
		mntmSupplierOrder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new SupplierOrder().setVisible(true);
			}
		});
		mnNewMenu.add(mntmSupplierOrder);
		
		mntmCustomerOrder = new JMenuItem("Customer_Order");
		mntmCustomerOrder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new CustomerOrder().setVisible(true);
			}
		});
		mnNewMenu.add(mntmCustomerOrder);
		
		mntmDispatchProduct = new JMenuItem("Dispatch_Product");
		mntmDispatchProduct.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new DispatchCustomerOrder().setVisible(true);
			}
		});
		mnNewMenu.add(mntmDispatchProduct);
		
		mntmEmployeepayment = new JMenuItem("Employee_Payment");
		mntmEmployeepayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EmployeePayment().setVisible(true);
			}
		});
		mnNewMenu.add(mntmEmployeepayment);
		
		
		
		mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		
		mntmSearchEmployee = new JMenuItem("Search_Employee");
		mntmSearchEmployee.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ModifyEmployee().setVisible(true);
			}
		});
		mnSearch.add(mntmSearchEmployee);
		
		mntmSearchSupplier = new JMenuItem("Search_Supplier");
		mntmSearchSupplier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ModifySupplier().setVisible(true);
			}
		});
		mnSearch.add(mntmSearchSupplier);
		
		mntmSearchCustomer = new JMenuItem("Search_Customer");
		mntmSearchCustomer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ModifyCustomer().setVisible(true);
			}
		});
		mnSearch.add(mntmSearchCustomer);
		
		mntmSearchCustomerOrder = new JMenuItem("Search_Customer_Order");
		mntmSearchCustomerOrder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ModifyCustomerOrder().setVisible(true);
			}
		});
		
		mntmSearchSupplierOrder = new JMenuItem("Search_Supplier_Order");
		mntmSearchSupplierOrder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ModifySupplierOrder().setVisible(true);
			}
		});
		
		s2 = new JSeparator();
		mnSearch.add(s2);
		mnSearch.add(mntmSearchSupplierOrder);
		mnSearch.add(mntmSearchCustomerOrder);
		
		mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		mntmEmployeeReport = new JMenuItem("Employee_Report");
		mntmEmployeeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdEmployeeInfo().setVisible(true);;
				
			}
		});
		mnReport.add(mntmEmployeeReport);
		
		mntmCustomerReport = new JMenuItem("Customer_Report");
		mntmCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdCustomerInfo().setVisible(true);;
			}
		});
		mnReport.add(mntmCustomerReport);
		
		mntmSupplierReport = new JMenuItem("Supplier_Report");
		mntmSupplierReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdSupplierInfo().setVisible(true);;
			}
		});
		mnReport.add(mntmSupplierReport);
		
		mntmProductReport = new JMenuItem("Product_Report");
		mntmProductReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdProductInfo().setVisible(true);;
			}
		});
		mnReport.add(mntmProductReport);
		
		mntmCustOrderReport = new JMenuItem("Cuctomer_Order_Report");
		mntmCustOrderReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new RpdCustomerOrder().setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		mnReport.add(separator);
		mnReport.add(mntmCustOrderReport);
		
		JMenuItem mntmSupplierOredrReport = new JMenuItem("Supplier_Oredr_Report");
		mntmSupplierOredrReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdSupplierOrder().setVisible(true);
			}
		});
		mnReport.add(mntmSupplierOredrReport);
		
		mntmEmployeepaymnet = new JMenuItem("Employee_Paymnet");
		mntmEmployeepaymnet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RpdEmpPayment().setVisible(true);
			}
		});
		mnReport.add(mntmEmployeepaymnet);
		
		
		
		mnUtilites = new JMenu("Utilites");
		menuBar.add(mnUtilites);
		
		mntmNotepad = new JMenuItem("Notepad");
		mntmNotepad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Runtime.getRuntime().exec("Notepad.exe");
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Error,Cannot start notepad","Application Error",JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		mnUtilites.add(mntmNotepad);
		
		mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Runtime.getRuntime().exec("calc.exe");
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Error,Cannot start calculator","Application Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnUtilites.add(mntmCalculator);
		
//		mnHelp = new JMenu("Help");
//		menuBar.add(mnHelp);
//		
//		mntmSystemInfo = new JMenuItem("System_Info");
//		mnHelp.add(mntmSystemInfo);
//		
//		mntmContactUs = new JMenuItem("Contact_Us");
//		mnHelp.add(mntmContactUs);
		getContentPane().setLayout(null);
		
		/*lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("images.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(326, 158, 46, 14);
		getContentPane().add(lblNewLabel);
		
		*/
		
		
	}
}
