package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame{
	private JPanel panel;
//	private Employee employee;
	private JButton buttonLogout, buttonProfile, buttonViewProduct;
	private JButton buttonViewCustomer, buttonViewEmployee, buttonCreateOrder;
	private JLabel title, header;
	public MainView(String userId) {
		super("Dashboard - Employee");
		
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(250, 250, 250));
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		title.setForeground(new Color(0, 11, 106));
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(640, 40, 100,30);
		buttonLogout.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(new Color(0, 11, 106));
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(640, 80, 100,30);
		buttonProfile.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonProfile.setBackground(new Color(0, 11, 106));
		buttonProfile.setForeground(new Color(255, 255, 255));
		panel.add(buttonProfile);
		
		buttonViewProduct = new JButton("Quản lý sản phẩm");
		buttonViewProduct.setBounds(60, 160, 200, 30);
		buttonViewProduct.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonViewProduct.setBackground(new Color(0, 11, 106));
		buttonViewProduct.setForeground(new Color(255, 255, 255));
		panel.add(buttonViewProduct);
		
		buttonViewCustomer = new JButton("Quản lí khách hàng");
		buttonViewCustomer.setBounds(60, 220, 200, 30);
		buttonViewCustomer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonViewCustomer.setBackground(new Color(0, 11, 106));
		buttonViewCustomer.setForeground(new Color(255, 255, 255));
		
		panel.add(buttonViewCustomer);
		
		buttonCreateOrder = new JButton("Tạo hóa đơn");
		buttonCreateOrder.setBounds(60, 280, 200, 30);
		buttonCreateOrder.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonCreateOrder.setBackground(new Color(0, 11, 106));
		buttonCreateOrder.setForeground(new Color(255, 255, 255));
		
		panel.add(buttonCreateOrder);
		
		
//		if (employee.getRole().equals("Manager")) {
//			buttonViewEmployee = new JButton("View Employee");
//			buttonViewEmployee.setBounds(60, 220, 200, 30);
//			buttonViewEmployee.setFont(Theme.FONT_BUTTON);
//			buttonViewEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
//			buttonViewEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
//			buttonViewEmployee.addActionListener(this);
//			panel.add(buttonViewEmployee);
//		}
		
		header = new JLabel();
		header.setBackground(new Color(0, 11, 106));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 75);
		panel.add(header);
		
		this.add(panel);
	}

}
