package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class MainView extends JFrame{
	private JPanel contentPane;
	private String username;
	
	public MainView(String username) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 782, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnStaff = new JButton("NH\u00C2N VI\u00CAN");
		btnStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setBackground(new Color(110, 211, 170));
		btnStaff.setBounds(0, 427, 172, 65);
		panel.add(btnStaff);
		
		JButton btnTrangChu = new JButton("TRANG CH\u1EE6");
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBackground(SystemColor.desktop);
		btnTrangChu.setBounds(0, 248, 172, 57);
		panel.add(btnTrangChu);
		
		JButton btnProduct = new JButton("S\u1EA2N PH\u1EA8M");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setBackground(new Color(110, 211, 170));
		btnProduct.setBounds(0, 304, 172, 65);
		panel.add(btnProduct);
		
		JButton btnCustomer = new JButton("KH\u00C1CH H\u00C0NG");
		btnCustomer.setForeground(Color.WHITE);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomer.setBackground(new Color(110, 211, 170));
		btnCustomer.setBounds(0, 365, 172, 65);
		panel.add(btnCustomer);
		
		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setBackground(new Color(110, 211, 170));
		btnHoaDon.setBounds(0, 488, 172, 65);
		panel.add(btnHoaDon);
		
		btnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductView().setVisible(true);
			}
		});
		btnStaff.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new EmployeeFrame().setVisible(true);
			}
		});
		
	}
}
