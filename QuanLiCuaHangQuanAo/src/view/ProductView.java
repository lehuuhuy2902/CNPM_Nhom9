package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import controller.ProductController;
import model.*;

public class ProductView extends JFrame {
	private JPanel contentPane;
	private JTextField txt_idSanpham;
	private JTextField txt_tenSanPham;
	private JTextField txt_gia;
	private JTextField txt_SoLuong;
	private JTextField txt_TinhTrang;
	private JTable table;
	private JDateChooser dateChooser;
	private ArrayList<Product> listProduct;
	private ProductController controller;
	
	public ProductView() {
		listProduct = new ArrayList<Product>();
		controller = new ProductController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 782, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnStaff = new JButton("NH\u00C2N VI\u00CAN");
		btnStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setBackground(UIManager.getColor("desktop"));
		
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
		btnProduct.setBackground(UIManager.getColor("desktop"));
		btnProduct.setBounds(0, 304, 172, 65);
		panel.add(btnProduct);
		
		JButton btnCustomer = new JButton("KH\u00C1CH H\u00C0NG");
		btnCustomer.setForeground(Color.WHITE);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomer.setBackground(UIManager.getColor("desktop"));
		btnCustomer.setBounds(0, 365, 172, 65);
		panel.add(btnCustomer);
		
		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnHoaDon.setBackground(UIManager.getColor("desktop"));
		btnHoaDon.setBounds(0, 488, 172, 65);
		panel.add(btnHoaDon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(172, 13, 610, 540);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSanPham = new JLabel("S\u1EA2N PH\u1EA8M");
		lblSanPham.setBounds(22, 13, 95, 26);
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSanPham.setForeground(SystemColor.desktop);
		panel_1.add(lblSanPham);
		
		JLabel label_ttsp = new JLabel("TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
		label_ttsp.setBounds(22, 46, 139, 16);
		label_ttsp.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(label_ttsp);
		
		JLabel lblMSnPhm = new JLabel("M\u00C3 S\u1EA2N PH\u1EA8M:");
		lblMSnPhm.setBounds(32, 75, 89, 16);
		panel_1.add(lblMSnPhm);
		
		txt_idSanpham = new JTextField();
		txt_idSanpham.setBounds(141, 75, 168, 22);
		txt_idSanpham.setEditable(false);
		panel_1.add(txt_idSanpham);
		txt_idSanpham.setColumns(10);
		
		JLabel label_tenSanpham = new JLabel("T\u00CAN S\u1EA2N PH\u1EA8M:");
		label_tenSanpham.setBounds(32, 110, 97, 16);
		panel_1.add(label_tenSanpham);
		
		txt_tenSanPham = new JTextField();
		txt_tenSanPham.setBounds(141, 107, 168, 22);
		txt_tenSanPham.setColumns(10);
		panel_1.add(txt_tenSanPham);
		
		JLabel label_tenSanpham_1 = new JLabel("GI\u00C1 S\u1EA2N PH\u1EA8M:");
		label_tenSanpham_1.setBounds(32, 142, 97, 16);
		panel_1.add(label_tenSanpham_1);
		
		txt_gia = new JTextField();
		txt_gia.setBounds(141, 139, 168, 22);
		txt_gia.setColumns(10);
		panel_1.add(txt_gia);
		
		JLabel lblNgyThm = new JLabel("NG\u00C0Y NH\u1EACP:");
		lblNgyThm.setBounds(338, 75, 89, 16);
		panel_1.add(lblNgyThm);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(430, 72, 150, 22);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel_1.add(dateChooser);
		
		JLabel lblSLng = new JLabel("S\u1ED0 L\u01AF\u1EE2NG:");
		lblSLng.setBounds(338, 107, 89, 16);
		panel_1.add(lblSLng);
		
		txt_SoLuong = new JTextField();
		txt_SoLuong.setBounds(430, 104, 150, 22);
		txt_SoLuong.setColumns(10);
		panel_1.add(txt_SoLuong);
		
		JLabel lblTnhTrng = new JLabel("T\u00CCNH TR\u1EA0NG:");
		lblTnhTrng.setBounds(338, 139, 89, 16);
		panel_1.add(lblTnhTrng);
		
		txt_TinhTrang = new JTextField();
		txt_TinhTrang.setBounds(430, 136, 150, 22);
		txt_TinhTrang.setColumns(10);
		panel_1.add(txt_TinhTrang);
		
		JButton btnThem = new JButton("TH\u00CAM");
		btnThem.setBounds(212, 192, 76, 25);
		btnThem.setBackground(SystemColor.desktop);
		panel_1.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00D3A");
		btnXoa.setBounds(300, 192, 76, 25);
		
		btnXoa.setBackground(SystemColor.desktop);
		panel_1.add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EECA");
		btnSua.setBounds(398, 192, 76, 25);
		btnSua.setBackground(SystemColor.desktop);
		panel_1.add(btnSua);
		
		JButton btnTm = new JButton("T\u00CCM");
		btnTm.setBounds(498, 192, 76, 25);
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTm.setBackground(SystemColor.desktop);
		panel_1.add(btnTm);
		
		
		
		listProduct = getProduct();
		
		AbstractTableModel tableModel = new AbstractTableModel() {
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Product product = listProduct.get(rowIndex);
				if(columnIndex == 0) {
					return product.getId();
				}
				else if(columnIndex == 1) {
					return product.getName();
				}
				else if(columnIndex == 2) {
					return product.getPrice();
				}
				else if(columnIndex == 3) {
					return product.getAddDate();
				}
				else if(columnIndex == 4) {
					return product.getQuatity();
				}
				else if(columnIndex == 5) {
					return product.getStatus();
					
				}
				return null;
			}
			
			@Override
			public int getRowCount() {
				return listProduct.size();
			}
			
			@Override
			public int getColumnCount() {
				return 6;
			}
		};
		
		
		//phan header cua jtable
		DefaultTableColumnModel tableColumnModel = new DefaultTableColumnModel();

		TableColumn clMaSP = new TableColumn();
		clMaSP.setHeaderValue("Mã SP");
		clMaSP.setWidth(101);
		tableColumnModel.addColumn(clMaSP);
		
		
		TableColumn clTenSP = new TableColumn();
		clTenSP.setHeaderValue("Tên SP");
		clTenSP.setWidth(101);
		tableColumnModel.addColumn(clTenSP);
		
		TableColumn clGia = new TableColumn();
		clGia.setHeaderValue("Gia");
		clGia.setWidth(101);
		tableColumnModel.addColumn(clGia);
		
		TableColumn clNgayNhap = new TableColumn();
		clNgayNhap.setHeaderValue("Ngày Nhập");
		clNgayNhap.setWidth(101);
		tableColumnModel.addColumn(clNgayNhap);
		
		TableColumn clSoLuong = new TableColumn();
		clSoLuong.setHeaderValue("Số lượng");
		clSoLuong.setWidth(101);
		tableColumnModel.addColumn(clSoLuong);
		
		TableColumn clTinhTrang = new TableColumn();
		clTinhTrang.setHeaderValue("Tình trạng");
		clTinhTrang.setWidth(101);
		tableColumnModel.addColumn(clTinhTrang);
	
		
		table = new JTable();
		table.setModel(tableModel);
		JTableHeader header = new JTableHeader(tableColumnModel);
		table.setTableHeader(header);

		JScrollPane scollPane = new JScrollPane(table);
		scollPane.setBounds(0, 276, 610, 264);
		panel_1.add(scollPane);

		//bat su kien click vao jtable
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int[] rows = table.getSelectedRows();
				
				String idSP = String.valueOf(table.getValueAt(rows[0], 0));
				txt_idSanpham.setText(idSP);
				
				String tenSP = String.valueOf(table.getValueAt(rows[0], 1));
				txt_tenSanPham.setText(tenSP);
				
				String gia = String.valueOf(table.getValueAt(rows[0], 2));
				txt_gia.setText(gia);
				
				String dateValue = String.valueOf(table.getValueAt(rows[0], 3));

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String soluong = String.valueOf(table.getValueAt(rows[0], 4));
				txt_SoLuong.setText(soluong);
				
				String tinhtrang = String.valueOf(table.getValueAt(rows[0], 5));
				txt_TinhTrang.setText(tinhtrang);
				
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = table.getSelectedRow();
					Product p = listProduct.get(row);
					p.setName(txt_tenSanPham.getText().trim());
					p.setPrice(Double.parseDouble(txt_gia.getText().trim()));
					p.setQuatity(Integer.parseInt(txt_SoLuong.getText().trim()));
					p.setStatus(txt_TinhTrang.getText().trim());
					
					String date = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
					p.setAddDate(date);
					table.repaint();
					

					boolean check = controller.updateProduct(p);
					
					if(!check) {
						JOptionPane.showMessageDialog(panel, "Cập nhật thông tin sản phẩm thất bại, vui lòng cập nhật lại!");
						
					}
					else {
						JOptionPane.showMessageDialog(panel, "Sản phẩm đã cập nhật thông tin thành công");
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel, "Dữ liệu sửa phải là số, vui lòng cập nhật lại!");
				}
				
			}
		});
		
	}
	
	public ArrayList<Product> getProduct(){
		return controller.getListProduct();
	}

	
}

	
	