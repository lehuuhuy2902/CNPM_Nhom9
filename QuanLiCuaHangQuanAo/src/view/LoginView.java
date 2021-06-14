package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.UserController;

public class LoginView extends JFrame{
	private JPanel panel;
	private JButton buttonExit, buttonLogin;
	private JLabel title, header, usernameLabel, passwordLabel;
	private JTextField usernameTF;
	private JPasswordField passwordF;
	private UserController controller;
	
	public LoginView() {
		controller = new UserController();
		
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Phần mềm quản lí cửa hàng quần áo");
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(250, 250, 250));
		
		title = new JLabel("QUẢN LÝ CỬA HÀNG QUẦN ÁO");
		title.setBounds(40, 40, 700, 75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		title.setForeground(new Color(0, 11, 106));
		panel.add(title);
		
		
		usernameLabel = new JLabel("Tài khoản: ");
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		panel.add(usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(330, 220, 220, 30);
		usernameTF.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		panel.add(usernameTF);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		panel.add(passwordLabel);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(330, 280, 220, 30);
		passwordF.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		panel.add(passwordF);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(230, 345, 300, 30);
		buttonLogin.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonLogin.setBackground(new Color(0, 11, 106));
		buttonLogin.setForeground(new Color(255, 255, 255));
		panel.add(buttonLogin);
		
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(230, 400, 300, 30);
		buttonExit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		buttonExit.setBackground(new Color(208, 208, 208));
		buttonExit.setForeground(new Color(0, 0, 0));
		panel.add(buttonExit);
		this.add(panel);
		
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String password = passwordF.getText();
				boolean result = controller.checkLogin(username, password);
				if(result) {
					setVisible(false);
					new MainView(username).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(panel, "Đăng nhập không thành công, vui lòng đăng nhập lại");
					
				}
				
			}
		});
		
	}


	public static void main(String[] args) {
		LoginView lv = new LoginView();
		lv.setVisible(true);
	}

}
