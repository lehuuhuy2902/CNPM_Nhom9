package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class MainView extends JFrame{
	private JPanel contentPane;
	private String username;
	public MainView() {
		
		setTitle("Phần mềm quản lí cửa hàng quần áo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 782, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbltitle = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG QUẦN ÁO");
		lbltitle.setBounds(100, 13, 600, 50);
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbltitle.setForeground(SystemColor.desktop);
		panel.add(lbltitle);
		
		JButton btnTrangChu = new JButton("TRANG CH\u1EE6");
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBackground(SystemColor.desktop);
		btnTrangChu.setBounds(20, 220, 172, 70);
		panel.add(btnTrangChu);
		
		JButton btnProduct = new JButton("S\u1EA2N PH\u1EA8M");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setBackground(new Color(110, 211, 170));
		btnProduct.setBounds(20, 290, 172, 70);
		panel.add(btnProduct);
		
		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setBackground(new Color(110, 211, 170));
		btnHoaDon.setBounds(20, 430, 172, 70);
		panel.add(btnHoaDon);
		
		JButton btnStaff = new JButton("NH\u00C2N VI\u00CAN");
		btnStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setBackground(new Color(110, 211, 170));
		btnStaff.setBounds(20, 360, 172, 70);
		panel.add(btnStaff);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setMaximumSize(new Dimension(527, 527));
		lblNewLabel.setIcon(new ImageIcon("icon\\SHOP.png"));
		lblNewLabel.setPreferredSize(new Dimension(527, 527));
		lblNewLabel.setMinimumSize(new Dimension(527, 527));
		lblNewLabel.setBounds(222, 100, 527, 527);
		panel.add(lblNewLabel);
		
		btnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ProductView frame = new ProductView();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateInvoiceGUI frame = new CreateInvoiceGUI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EmployeeFrame frame = new EmployeeFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
	}
}
