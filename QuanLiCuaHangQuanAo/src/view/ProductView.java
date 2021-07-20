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
import javax.swing.border.TitledBorder;
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
		setTitle("Quản lí sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(238,238,238));
		panel.setBounds(0, 0, 800, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		

		JButton btnTrangChu = new JButton("TRANG CH\u1EE6");
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBackground(new Color(110, 211, 170));
		btnTrangChu.setBounds(5, 225, 172, 70);
		panel.add(btnTrangChu);

		JButton btnProduct = new JButton("S\u1EA2N PH\u1EA8M");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setBackground(SystemColor.desktop);
		btnProduct.setBounds(5, 295, 172, 70);
		panel.add(btnProduct);

		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setBackground(new Color(110, 211, 170));
		btnHoaDon.setBounds(5, 435, 172, 70);
		panel.add(btnHoaDon);
		
		JButton btnStaff = new JButton("NH\u00C2N VI\u00CAN");
		btnStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setBackground(new Color(110, 211, 170));
		btnStaff.setBounds(5, 365, 172, 70);
		panel.add(btnStaff);
		
		//ACTION
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
		btnTrangChu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainView frame = new MainView();
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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(180, 13, 650, 540);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_sp = new JPanel();
		panel_sp.setBackground(Color.white);
		panel_sp.setBounds(5, 40, 600, 200);
		panel_sp.setLayout(null);
		panel_1.add(panel_sp);
		panel_sp.setBorder(new TitledBorder(null, "THÔNG TIN SẢN PHẨM", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

		JLabel lblSanPham = new JLabel("S\u1EA2N PH\u1EA8M");
		lblSanPham.setBounds(22, 13, 95, 26);
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSanPham.setForeground(SystemColor.desktop);
		panel_1.add(lblSanPham);;

		JLabel lblMSnPhm = new JLabel("M\u00C3 S\u1EA2N PH\u1EA8M:");
		lblMSnPhm.setBounds(32, 25, 89, 16);
		panel_sp.add(lblMSnPhm);

		txt_idSanpham = new JTextField();
		txt_idSanpham.setBounds(141, 22, 168, 22);
		txt_idSanpham.setEditable(false);
		panel_sp.add(txt_idSanpham);
		txt_idSanpham.setColumns(10);

		JLabel label_tenSanpham = new JLabel("T\u00CAN S\u1EA2N PH\u1EA8M:");
		label_tenSanpham.setBounds(32, 60, 97, 16);
		panel_sp.add(label_tenSanpham);

		txt_tenSanPham = new JTextField();
		txt_tenSanPham.setBounds(141, 57, 168, 22);
		txt_tenSanPham.setColumns(10);
		panel_sp.add(txt_tenSanPham);

		JLabel label_tenSanpham_1 = new JLabel("GI\u00C1 S\u1EA2N PH\u1EA8M:");
		label_tenSanpham_1.setBounds(32, 95, 97, 16);
		panel_sp.add(label_tenSanpham_1);

		txt_gia = new JTextField();
		txt_gia.setBounds(141, 92, 168, 22);
		txt_gia.setColumns(10);
		panel_sp.add(txt_gia);

		JLabel lblNgyThm = new JLabel("NG\u00C0Y NH\u1EACP:");
		lblNgyThm.setBounds(338, 25, 89, 16);
		panel_sp.add(lblNgyThm);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(430, 22, 150, 22);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel_sp.add(dateChooser);

		JLabel lblSLng = new JLabel("S\u1ED0 L\u01AF\u1EE2NG:");
		lblSLng.setBounds(338, 60, 89, 16);
		panel_sp.add(lblSLng);

		txt_SoLuong = new JTextField();
		txt_SoLuong.setBounds(430, 57, 150, 22);
		txt_SoLuong.setColumns(10);
		panel_sp.add(txt_SoLuong);

		JLabel lblTnhTrng = new JLabel("T\u00CCNH TR\u1EA0NG:");
		lblTnhTrng.setBounds(338, 95, 89, 16);
		panel_sp.add(lblTnhTrng);

		txt_TinhTrang = new JTextField();
		txt_TinhTrang.setBounds(430, 92, 150, 22);
		txt_TinhTrang.setColumns(10);
		panel_sp.add(txt_TinhTrang);

		JButton btnThem = new JButton("TH\u00CAM");
		btnThem.setBounds(212, 135, 76, 25);
		btnThem.setBackground(SystemColor.desktop);
		btnThem.setForeground(Color.WHITE);
		panel_sp.add(btnThem);

		JButton btnXoa = new JButton("X\u00D3A");
		btnXoa.setBounds(300,135, 76, 25);
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(182,0,59));
		panel_sp.add(btnXoa);

		JButton btnSua = new JButton("S\u1EECA");
		btnSua.setBounds(398, 135, 76, 25);
		btnSua.setBackground(SystemColor.desktop);
		btnSua.setForeground(Color.WHITE);
		panel_sp.add(btnSua);

		JButton btnTm = new JButton("T\u00CCM");
		btnTm.setBounds(498, 135, 76, 25);
		btnTm.setBackground(SystemColor.desktop);
		btnTm.setForeground(Color.WHITE);
		panel_sp.add(btnTm);
		

		listProduct = getProduct();

		AbstractTableModel tableModel = new AbstractTableModel() {
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Product product = listProduct.get(rowIndex);
				if (columnIndex == 0) {
					return product.getId();
				} else if (columnIndex == 1) {
					return product.getName();
				} else if (columnIndex == 2) {
					return product.getPrice();
				} else if (columnIndex == 3) {
					return product.getAddDate();
				} else if (columnIndex == 4) {
					return product.getQuatity();
				} else if (columnIndex == 5) {
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

		// phan header cua jtable
		DefaultTableColumnModel tableColumnModel = new DefaultTableColumnModel();

		TableColumn clMaSP = new TableColumn();
		clMaSP.setHeaderValue("Mã SP");
		clMaSP.setWidth(99);
		tableColumnModel.addColumn(clMaSP);

		TableColumn clTenSP = new TableColumn();
		clTenSP.setHeaderValue("Tên SP");
		clTenSP.setWidth(99);
		tableColumnModel.addColumn(clTenSP);

		TableColumn clGia = new TableColumn();
		clGia.setHeaderValue("Giá");
		clGia.setWidth(99);
		tableColumnModel.addColumn(clGia);

		TableColumn clNgayNhap = new TableColumn();
		clNgayNhap.setHeaderValue("Ngày Nhập");
		clNgayNhap.setWidth(98);
		tableColumnModel.addColumn(clNgayNhap);

		TableColumn clSoLuong = new TableColumn();
		clSoLuong.setHeaderValue("Số lượng");
		clSoLuong.setWidth(99);
		tableColumnModel.addColumn(clSoLuong);

		TableColumn clTinhTrang = new TableColumn();
		clTinhTrang.setHeaderValue("Tình trạng");
		clTinhTrang.setWidth(105);
		tableColumnModel.addColumn(clTinhTrang);

		table = new JTable();
		table.setModel(tableModel);
		JTableHeader header = new JTableHeader(tableColumnModel);
		table.setTableHeader(header);

		JScrollPane scollPane = new JScrollPane(table);
		scollPane.setBounds(10, 276, 610, 200);
		panel_1.add(scollPane);

		// bat su kien click vao jtable
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
					String name = txt_tenSanPham.getText().trim();
					String price = txt_gia.getText().trim();
					String quatity = txt_SoLuong.getText().trim();
					String status = txt_TinhTrang.getText().trim();
					
					if(txt_idSanpham.getText().equals("")) {
						JOptionPane.showMessageDialog(panel, "Phải chọn sản phẩm trong bảng trước khi nhấn nút Sửa");
					}
					else {
						if(name.equals("") || price.equals("") || quatity.equals("") || status.equals("")) {
							JOptionPane.showMessageDialog(panel, "Vui lòng nhập đầy đủ thông tin trước khi nhấn nút Sửa");
						}
						else {
							if(Double.parseDouble(txt_gia.getText().trim()) <= 0) {
								JOptionPane.showMessageDialog(panel, "Giá bán phải > 0");
								txt_gia.setText("");
							}
							else if(Integer.parseInt(txt_SoLuong.getText().trim()) <0) {
								JOptionPane.showMessageDialog(panel, "Số lượng không được phép là số âm");
								txt_SoLuong.setText("");
							}
							else {
								try {
									if(dateChooser.getDate().compareTo(new Date()) > 0) {
										JOptionPane.showMessageDialog(panel, "Ngày nhập chưa hợp lệ");
									}else {
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
										if (!check) {
											JOptionPane.showMessageDialog(panel,
													"Cập nhật thông tin sản phẩm thất bại, vui lòng cập nhật lại!");

										} else {
											JOptionPane.showMessageDialog(panel, "Sản phẩm đã cập nhật thông tin thành công");
										}
									}
									
								} catch (Exception e) {
									JOptionPane.showMessageDialog(panel, "Ngày nhập không đúng theo định dạng, vui lòng nhập lại");
									
								}
								
							}
							
						}
						
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel, "Dữ liệu sửa phải là số, vui lòng cập nhật lại!");
				}

			}
		});

	}

	public ArrayList<Product> getProduct() {
		return controller.getListProduct();
	}

}
