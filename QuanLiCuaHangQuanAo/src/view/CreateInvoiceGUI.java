package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.CreateInvoiceController;
import model.Customer;
import model.Date;
import model.DetailedInvoice;

public class CreateInvoiceGUI extends JFrame {

	private CreateInvoiceController controller;

	private JPanel contentPane;
	private JTextField txtIdCus;
	private JTextField txtNameCus;
	private JTextField txtPhoneCus;
	private JTextField txtIdProduct;
	private JTextField txtQuantity;
	private JTextField txtTotal;
	private JTextField txtCost;
	private JTextField txtDiscount;
	private JTextField txtUsePoint;
	private JTextField txtMustPay;
	private JTextField txtCus_Pay;
	private JTextField txtType;
	private JTextField txtPoint;
	private JTextField txtHSD;
	private JTextField txtEmail;
	private JTextField txtDOB;
	private JTextField txtExcess;
	private JTextField txtDF;
	private JTextField textNumHD;
	private JTextField txtEmployee;
	private JTextField txtUnitName;
	private JTable table;
	private DefaultTableModel tblModel;
	private ArrayList<DetailedInvoice> listItem;
	private int selectedIndex;
	private Customer customer;
	private JCheckBox cbxTD;

	
	public static void main(String[] args) {
		//System.out.println(CreateInvoiceGUI.changeToPoint((int)1568120));
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

	public CreateInvoiceGUI() {
		init();
		tblModel = (DefaultTableModel) table.getModel();
		controller = new CreateInvoiceController();
	}

	public void init() {
		// SET FRAME

		setSize(1261, 890);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		///
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(12, 13, 183, 787);
		panel.setPreferredSize(new Dimension(100, 100));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnProduct = new JButton("S\u1EA2N PH\u1EA8M");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setBackground(new Color(110, 211, 170));
		btnProduct.setBounds(12, 571, 160, 72);
		panel.add(btnProduct);
		
		JButton btnCustomer = new JButton("KH\u00C1CH H\u00C0NG");
		btnCustomer.setForeground(Color.WHITE);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomer.setBackground(new Color(110, 211, 170));
		btnCustomer.setBounds(12, 643, 160, 72);
		panel.add(btnCustomer);
		
		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setBackground(new Color(110, 211, 170));
		btnHoaDon.setBounds(12, 715, 160, 72);
		panel.add(btnHoaDon);
		JButton btnTrangChu = new JButton("TRANG CH\u1EE6");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBackground(SystemColor.desktop);
		btnTrangChu.setBounds(12, 500, 160, 72);
		panel.add(btnTrangChu);
		
		btnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductView().setVisible(true);
			}
		});

		// PANEL HEADER (CREATE INVOICE)

		JPanel panel_HD = new JPanel();
		panel_HD.setBounds(202, 10, 1015, 400);
		panel_HD.setPreferredSize(new Dimension(1000, 400));
		panel_HD.setBorder(new TitledBorder(null, "HÓA ĐƠN", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.add(panel_HD);
		panel_HD.setLayout(new BorderLayout(0, 0));

		JPanel panel_ItemOrder = new JPanel();
		panel_ItemOrder.setPreferredSize(new Dimension(900, 35));
		panel_HD.add(panel_ItemOrder, BorderLayout.NORTH);
		panel_ItemOrder.setLayout(null);

		JLabel lblNameProduct = new JLabel("Mã sản phẩm");
		lblNameProduct.setBounds(5, 9, 77, 16);
		panel_ItemOrder.add(lblNameProduct);

		txtIdProduct = new JTextField();
		txtIdProduct.setBounds(87, 6, 116, 22);
		txtIdProduct.setColumns(10);
		panel_ItemOrder.add(txtIdProduct);

		JLabel lblQuantity = new JLabel("Số lượng");
		lblQuantity.setBounds(208, 9, 65, 16);
		panel_ItemOrder.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setText("1");
		txtQuantity.setBounds(285, 6, 116, 22);
		txtQuantity.setColumns(10);
		panel_ItemOrder.add(txtQuantity);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(414, 5, 77, 25);
		panel_ItemOrder.add(btnAdd);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(875, 5, 70, 25);
		panel_ItemOrder.add(btnDelete);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.setBounds(777, 5, 70, 25);
		panel_ItemOrder.add(btnEdit);

		JPanel panel_Table = new JPanel();
		FlowLayout fl_panel_Table = (FlowLayout) panel_Table.getLayout();
		fl_panel_Table.setAlignment(FlowLayout.RIGHT);
		panel_HD.add(panel_Table, BorderLayout.SOUTH);

		JLabel lblNewLabel_7 = new JLabel("Tổng tiền");
		panel_Table.add(lblNewLabel_7);

		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtTotal.setDisabledTextColor(Color.RED);
		txtTotal.setForeground(Color.BLACK);
		txtTotal.setCaretColor(Color.BLACK);
		txtTotal.setEnabled(false);
		panel_Table.add(txtTotal);
		txtTotal.setColumns(10);

		JPanel panel_Total = new JPanel();
		panel_HD.add(panel_Total, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setPreferredSize(new Dimension(900, 300));
		panel_Total.add(scrollPane);

		table = new JTable();
		table.setRowHeight(25);
		table.setSelectionBackground(new Color(0, 120, 215));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn vị", "Đơn giá", "Số lượng", "Thành tiền" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(375);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		// PANEL BODY (CUSTOMER INFOMATION & PAYMENT INFORMATION)
		JPanel panel_body = new JPanel();
		panel_body.setBounds(202, 423, 1015, 272);
		panel_body.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		//// CUSTOMER INFOMATION
		JPanel panel_InfoCus = new JPanel();
		panel_InfoCus.setPreferredSize(new Dimension(600, 240));
		panel_InfoCus.setSize(new Dimension(500, 0));
		panel_InfoCus.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_body.add(panel_InfoCus);

		JLabel lblIdCus = new JLabel("Mã khách hàng");
		lblIdCus.setBounds(13, 57, 86, 16);

		txtIdCus = new JTextField();
		txtIdCus.setLocation(125, 53);
		txtIdCus.setSize(new Dimension(146, 24));
		txtIdCus.setPreferredSize(new Dimension(100, 25));
		txtIdCus.setColumns(10);

		panel_InfoCus.setLayout(null);
		panel_InfoCus.add(lblIdCus);
		panel_InfoCus.add(txtIdCus);

		JButton btnSearchCus_ID = new JButton("");
		// ACTION
		btnSearchCus_ID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSearchCus_ID.setIcon(new ImageIcon("D:\\ISE_2021\\icon\\find.png"));
		btnSearchCus_ID.setLocation(283, 52);
		btnSearchCus_ID.setPreferredSize(new Dimension(25, 25));
		btnSearchCus_ID.setSize(new Dimension(25, 25));

		panel_InfoCus.add(btnSearchCus_ID);

		JLabel lblHSD = new JLabel("Ngày hết hạn");
		lblHSD.setBounds(348, 92, 83, 16);
		panel_InfoCus.add(lblHSD);

		txtHSD = new JTextField();
		txtHSD.setSize(new Dimension(146, 24));
		txtHSD.setPreferredSize(new Dimension(100, 25));
		txtHSD.setColumns(10);
		txtHSD.setBounds(443, 89, 146, 24);
		panel_InfoCus.add(txtHSD);

		JLabel lblNameCus = new JLabel("Tên khách hàng");
		lblNameCus.setBounds(13, 92, 91, 16);
		panel_InfoCus.add(lblNameCus);

		txtNameCus = new JTextField();
		txtNameCus.setBounds(125, 88, 146, 24);
		txtNameCus.setColumns(10);
		panel_InfoCus.add(txtNameCus);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(348, 129, 56, 16);
		panel_InfoCus.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setSize(new Dimension(146, 24));
		txtEmail.setPreferredSize(new Dimension(100, 25));
		txtEmail.setColumns(10);
		txtEmail.setBounds(443, 126, 146, 24);
		panel_InfoCus.add(txtEmail);

		JLabel lblPhoneCus = new JLabel("Số điện thoại");
		lblPhoneCus.setBounds(13, 129, 75, 16);
		lblPhoneCus.setHorizontalAlignment(SwingConstants.LEFT);
		panel_InfoCus.add(lblPhoneCus);

		txtPhoneCus = new JTextField();
		txtPhoneCus.setBounds(125, 125, 146, 25);
		txtPhoneCus.setColumns(10);
		panel_InfoCus.add(txtPhoneCus);

		JButton btnSearchCus_Phone = new JButton("");
		btnSearchCus_Phone.setIcon(new ImageIcon("D:\\ISE_2021\\icon\\find.png"));
		btnSearchCus_Phone.setBounds(283, 125, 25, 25);
		btnSearchCus_Phone.setPreferredSize(new Dimension(25, 25));
		panel_InfoCus.add(btnSearchCus_Phone);

		JLabel lblType = new JLabel("Loại ");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setBounds(12, 167, 56, 16);
		panel_InfoCus.add(lblType);

		txtType = new JTextField();
		txtType.setBounds(125, 163, 146, 24);
		txtType.setColumns(10);
		panel_InfoCus.add(txtType);

		JLabel lblDOB = new JLabel("Ngày sinh");
		lblDOB.setBounds(348, 167, 56, 16);
		panel_InfoCus.add(lblDOB);

		txtDOB = new JTextField();
		txtDOB.setSize(new Dimension(146, 24));
		txtDOB.setPreferredSize(new Dimension(100, 25));
		txtDOB.setColumns(10);
		txtDOB.setBounds(443, 164, 146, 24);
		panel_InfoCus.add(txtDOB);

		JLabel lblPoint = new JLabel("Điểm tích lũy");
		lblPoint.setBounds(348, 57, 83, 16);
		panel_InfoCus.add(lblPoint);

		txtPoint = new JTextField();
		txtPoint.setSize(new Dimension(146, 24));
		txtPoint.setPreferredSize(new Dimension(100, 25));
		txtPoint.setColumns(10);
		txtPoint.setBounds(443, 53, 146, 24);
		panel_InfoCus.add(txtPoint);

		//// PAYMENT INFORMATION
		JPanel panel_Payment = new JPanel();
		panel_Payment.setPreferredSize(new Dimension(400, 240));
		panel_Payment.setSize(new Dimension(500, 200));
		panel_Payment.setBorder(new TitledBorder(null, "Thông tin thanh toán", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_body.add(panel_Payment);
		panel_Payment.setLayout(null);

		JLabel lblCost = new JLabel("Tổng tiền ");
		lblCost.setBounds(12, 50, 191, 25);
		panel_Payment.add(lblCost);

		txtCost = new JTextField();
		txtCost.setBounds(208, 50, 191, 25);
		txtCost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCost.setColumns(10);
		panel_Payment.add(txtCost);

		JLabel lblDiscount = new JLabel("Chiết khấu");
		lblDiscount.setBounds(12, 80, 191, 25);
		panel_Payment.add(lblDiscount);

		txtDiscount = new JTextField();
		txtDiscount.setBounds(208, 80, 191, 25);
		txtDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiscount.setColumns(10);
		panel_Payment.add(txtDiscount);

		JLabel lblUse_Point = new JLabel("Sử dụng điểm tích lũy (*)");
		lblUse_Point.setBounds(12, 110, 191, 25);
		panel_Payment.add(lblUse_Point);

		txtUsePoint = new JTextField();
		txtUsePoint.setBounds(208, 110, 191, 25);
		txtUsePoint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsePoint.setColumns(10);
		panel_Payment.add(txtUsePoint);

		JLabel lblMust_Pay = new JLabel("Số tiền cần thanh toán");
		lblMust_Pay.setBounds(12, 140, 191, 25);
		panel_Payment.add(lblMust_Pay);

		txtMustPay = new JTextField();
		txtMustPay.setBounds(208, 140, 191, 25);
		txtMustPay.setForeground(Color.RED);
		txtMustPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMustPay.setColumns(10);
		panel_Payment.add(txtMustPay);

		JLabel lblCus_pay = new JLabel("Tiền khách đưa");
		lblCus_pay.setBounds(12, 170, 191, 25);
		panel_Payment.add(lblCus_pay);

		txtCus_Pay = new JTextField();
		txtCus_Pay.setBounds(208, 170, 191, 25);
		txtCus_Pay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCus_Pay.setColumns(10);
		panel_Payment.add(txtCus_Pay);

		JLabel lblExcess = new JLabel("Tiền thói");
		lblExcess.setBounds(12, 200, 191, 25);
		panel_Payment.add(lblExcess);

		txtExcess = new JTextField();
		txtExcess.setBounds(208, 200, 191, 25);
		txtExcess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtExcess.setColumns(10);
		panel_Payment.add(txtExcess);
		
		cbxTD = new JCheckBox("Tích điểm vào thẻ Khách hàng");
		cbxTD.setBounds(8, 22, 261, 25);
		panel_Payment.add(cbxTD);

		// PANEL FOOTER (INFORMATION OF INVOICE)
		JPanel panel_InfoHD = new JPanel();
		panel_InfoHD.setBounds(202, 696, 1015, 154);
		panel_InfoHD.setPreferredSize(new Dimension(1000, 120));
		panel_InfoHD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin hóa đơn",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.setLayout(null);

		contentPane.add(panel_body);

		JLabel lblNotice = new JLabel("(*) Lưu ý: 1 điểm tương ướng với 10 đồng");

		panel_body.add(lblNotice);
		contentPane.add(panel_InfoHD);
		panel_InfoHD.setLayout(null);

		JLabel lblDateFounded = new JLabel("Ngày lập");
		lblDateFounded.setBounds(40, 39, 88, 19);
		lblDateFounded.setHorizontalAlignment(SwingConstants.LEFT);
		panel_InfoHD.add(lblDateFounded);

		txtDF = new JTextField();
		txtDF.setText(new Date().currrentDate().toString());
		txtDF.setBounds(140, 36, 199, 22);
		txtDF.setColumns(10);
		panel_InfoHD.add(txtDF);

		JLabel lblnum_HD = new JLabel("Số hóa đơn");
		lblnum_HD.setHorizontalAlignment(SwingConstants.LEFT);
		lblnum_HD.setBounds(40, 74, 88, 19);
		panel_InfoHD.add(lblnum_HD);

		textNumHD = new JTextField();
		textNumHD.setColumns(10);
		textNumHD.setBounds(140, 71, 199, 22);
		panel_InfoHD.add(textNumHD);

		JLabel lblEmployee = new JLabel("Nhân viên");
		lblEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployee.setBounds(440, 40, 69, 18);
		panel_InfoHD.add(lblEmployee);

		txtEmployee = new JTextField();
		txtEmployee.setText("Nguyễn Thị Hoa Cúc");
		txtEmployee.setColumns(10);
		txtEmployee.setBounds(545, 37, 258, 22);
		panel_InfoHD.add(txtEmployee);

		JLabel lblUnitName = new JLabel("Tên đơn vị");
		lblUnitName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnitName.setBounds(440, 75, 81, 18);
		panel_InfoHD.add(lblUnitName);

		txtUnitName = new JTextField();
		txtUnitName.setText("Cửa hàng 01, Đường Nguyễn Trung Trực");
		txtUnitName.setColumns(10);
		txtUnitName.setBounds(545, 72, 258, 21);
		panel_InfoHD.add(txtUnitName);

		JButton btnSave = new JButton("Lưu");
		btnSave.setBounds(555, 116, 97, 25);
		panel_InfoHD.add(btnSave);

		JButton btnSave_Print = new JButton("Lưu và In");
		btnSave_Print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave_Print.setBounds(706, 116, 97, 25);
		panel_InfoHD.add(btnSave_Print);

		// action
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String idPro = txtIdProduct.getText().trim();
				String quan = txtQuantity.getText().trim();
				// System.out.println(idPro);
				if (idPro.equals("") || quan.equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin để thêm vào hóa đơn!");
				} else {
					try {
						int quantity = Integer.parseInt(quan);
						if (quantity <= 0)
							JOptionPane.showMessageDialog(rootPane, "Số lượng phải lớn hơn 0");
						else {

							controller.addItem(idPro, quantity);
							listItem = controller.getListDetailed();

							if (controller.getMessage() == 1) {
								JOptionPane.showMessageDialog(rootPane, "Sản phẩm không tồn tại!");
								controller.setMessageDefaultValue();
							} else {
								showData();
								// Cập nhật giá tiền hóa đơn
								txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
								txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
								// Cập nhật thanh toán, tiền trả khách sau khi chiết khấu giảm giá
								updatePayment();
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số!");
					}

				}

			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listItem = controller.getListDetailed();
				selectedIndex = table.getSelectedRow();
				if (listItem.size() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Không có chi tiết đơn hàng để xóa!");
				} else if (selectedIndex == -1) {
					JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng có chi tiết đơn hàng cần xóa rồi ấn Xóa!");
				} else { // chon dong can xoa va nhan nut
					controller.removeItem(selectedIndex);
					listItem = controller.getListDetailed();
					showData();
					// Cập nhật giá tiền hóa đơn
					txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
					txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
					// Cập nhật thanh toán, tiền trả khách sau khi chiết khấu giảm giá
					updatePayment();
				}
			}
		});
		btnSearchCus_ID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				customer = null;
				String idCus = txtIdCus.getText().trim();
				if (idCus.equals(""))
					JOptionPane.showMessageDialog(rootPane,
							"Vui lòng nhập số điện thoại hoặc mã khách hàng để tìm kiếm!");
				else {
					try {
						customer = controller.findCustomerByID(idCus);
					} catch (NumberFormatException | SQLException e1) {

						e1.printStackTrace();
					}
					if (customer == null)
						JOptionPane.showMessageDialog(rootPane, "Khách hàng không tồn tại trong hệ thống!");
					else {
						txtIdCus.setText(customer.getId());
						txtNameCus.setText(customer.getName());
						txtPhoneCus.setText(customer.getPhone());
						txtEmail.setText(customer.getEmail());
						txtPoint.setText(customer.getPoint() + "");
						txtHSD.setText(customer.getDateSD().toString());
						txtType.setText(customer.getType());
						txtDOB.setText(customer.getDob().toString());
					}
				}
			}
		});
		btnSearchCus_Phone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				customer = null;
				String phone = txtPhoneCus.getText().trim();
				if (phone.equals(""))
					JOptionPane.showMessageDialog(rootPane,
							"Vui lòng nhập số điện thoại hoặc mã khách hàng để tìm kiếm!");
				else {
					try {
						customer = controller.findCustomerByPhone(phone);
					} catch (NumberFormatException | SQLException e1) {

						e1.printStackTrace();
					}
					if (customer == null)
						JOptionPane.showMessageDialog(rootPane, "Khách hàng không tồn tại trong hệ thống!");
					else {
						txtIdCus.setText(customer.getId());
						txtNameCus.setText(customer.getName());
						txtPhoneCus.setText(customer.getPhone());
						txtEmail.setText(customer.getEmail());
						txtPoint.setText(customer.getPoint() + "");
						txtHSD.setText(customer.getDateSD().toString());
						txtType.setText(customer.getType());
						txtDOB.setText(customer.getDob().toString());
					}
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionEdit();

			}
		});
		txtDiscount.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {

				updatePayment();
			}
		});
		txtUsePoint.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {

				updatePayment();
			}
		});
		txtCus_Pay.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {

				updatePayment();
			}
		});
		
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.checkInvoice()) {
					// Lưu tiền và các giảm giá của hóa đơn
					double cost = formatDouble(txtMustPay.getText());
					double discount = formatDouble(txtDiscount.getText());
					double point_used = formatDouble(txtUsePoint.getText());
					controller.setDiscount(discount);
					controller.setPriceInvoice(cost);
					controller.setPointUsed(point_used);
					// Cập nhật điểm tích lũy cho KH
					int pointAdd = 0;
					
					if (cbxTD.isSelected()) {
						pointAdd= changeToPoint(cost);
					}
					try {
						
						controller.updatePoint(point_used-pointAdd);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				
					// Lưu vào dB
					try {
						controller.saveInvoiceToDB();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(rootPane, "Lưu hóa đơn thành công!");
					// reset
					controller.resetInvoice();
					resetGUI();
				} else {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin để lưu hóa đơn!");
				}

			}
		});
		txtIdCus.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				txtNameCus.setText("");
				txtPhoneCus.setText("");
				txtType.setText("");
				txtPoint.setText("");
				txtHSD.setText("");
				txtEmail.setText("");
				txtDOB.setText("");
				//set lại customer là null để ngăn chặn lỗi khi chưa nhập lại khách hàng mà lại lưu.
				//Nếu ko set lại thì hệ thống sẽ lấy thông tin của kH trước đó.
				controller.setCustomerIsNull();
			}
		});
		txtPhoneCus.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				txtIdCus.setText("");
				txtNameCus.setText("");
				txtType.setText("");
				txtPoint.setText("");
				txtHSD.setText("");
				txtEmail.setText("");
				txtDOB.setText("");
				controller.setCustomerIsNull();
			}
		});

	}

	protected void resetGUI() {

		txtIdCus.setText("");
		txtNameCus.setText("");
		txtPhoneCus.setText("");
		txtIdProduct.setText("");
		txtQuantity.setText("1");
		txtTotal.setText("");
		txtCost.setText("");
		txtDiscount.setText("");
		txtUsePoint.setText("");
		txtMustPay.setText("");
		txtCus_Pay.setText("");
		txtType.setText("");
		txtPoint.setText("");
		txtHSD.setText("");
		txtEmail.setText("");
		txtDOB.setText("");
		txtExcess.setText("");
		cbxTD.setSelected(false);

		listItem = controller.getListDetailed();
		showData();
	}

	protected void actionEdit() {
		listItem = controller.getListDetailed();
		selectedIndex = table.getSelectedRow();
		if (listItem.size() == 0) {
			JOptionPane.showMessageDialog(rootPane, "Không có chi tiết đơn hàng để sửa!");
		} else if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng có chi tiết đơn hàng cần sửa rồi ấn Sửa!");
		} else { // chon dong can sua va nhan nut
			EditDetailed edit = new EditDetailed(this);
			edit.setDataDetailed(listItem.get(selectedIndex));
			edit.setVisible(true);

		}

	}

	public void updateDetaiedInvoice(DetailedInvoice d) {
		// selectedIndex = table.getSelectedRow();
		controller.removeItem(selectedIndex);
		controller.addItem(d, selectedIndex);
		listItem = controller.getListDetailed();
		showData();
		// Cập nhật giá tiền hóa đơn
		txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
		txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
		// Cập nhật thanh toán, tiền trả khách sau khi chiết khấu giảm giá
		updatePayment();
	}

	private void showData() {
		tblModel.setRowCount(0); // reset nd trong bang ve 0;
		int stt = 0;
		for (DetailedInvoice d : listItem) {
			stt++;
			tblModel.addRow(
					new Object[] { stt, d.getProduct().getId(), d.getProduct().getName(), d.getProduct().getUnit(),
							d.getProduct().getPrice(), d.getQuantity(), d.getProduct().getPrice() * d.getQuantity() });
		}

	}

	public String formatCurrency(double s) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat vn = NumberFormat.getInstance(localeVN);
		return vn.format(s);
	}

	public double formatDouble(String s) {
		if (s.contentEquals(""))
			return 0;
		StringBuffer st = new StringBuffer();
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (c == '.')
				;
			else if (c == ',')
				st.append('.');
			else
				st.append(c);
		}
		return Double.parseDouble(st.toString());
	}

	public void updatePayment() {
		// Tính tiền cần thanh toán
		if (listItem.size() == 0) {
			txtDiscount.setText("");
			txtUsePoint.setText("");
		}
		String discount = txtDiscount.getText();
		double d = 0;

		String p = txtUsePoint.getText();
		double point = 0;

		boolean isOK = true;
		// Nếu chiết khấu và giảm giá bỏ trống thì tính tiền cần trả,
		// nếu 1 trong 2 ko trống thì phải tính lại tiền sau khi giảm giá
		// Yêu cầu trước khi nhập giảm giá hay sử dụng điểm phải nhập khách hàng trước
		// để so khớp
		// điểm sử dụng vs điểm tích lũy của KH
		if (!discount.equals("")) {
			if (controller.hasCustomer()) {
				try {
					d = formatDouble(discount);
					txtDiscount.setText(formatCurrency(d));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Số tiền phải là số và không chứa kí tự khác!");
					txtDiscount.setText("");
					isOK = false;
				}
			} else {
				JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập thông khách hàng trước khi thanh toán!");
				txtDiscount.setText("");
			}
		}
		if (!p.equals("")) {
			if (controller.hasCustomer()) {
				try {
					point = formatDouble(p);

					double po = Double.parseDouble(txtPoint.getText());// điểm tích lũy của KH
					
					if (po < point) {
						JOptionPane.showMessageDialog(rootPane, "Số điểm sử dụng vượt số điểm tích lũy!");
						txtUsePoint.setText("");
					} else {
						txtUsePoint.setText(formatCurrency(point));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Số điểm tích lũy phải là số và không chứa kí tự khác!");
					txtUsePoint.setText("");
					isOK = false;
				}
			} else {
				JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập thông khách hàng trước khi thanh toán!");
				txtUsePoint.setText("");
			}

		}
		if (isOK) {

			txtMustPay.setText(formatCurrency(controller.getPriceOfInvoice() - (d + point * 10)));
		}
		// Tính tiền thói khách hàng
		String cusPay = txtCus_Pay.getText();
		double cash = 0;
		boolean isOK1 = true;
		if (!cusPay.equals("")) {

			try {

				cash = formatDouble(cusPay);
				txtCus_Pay.setText(formatCurrency(cash));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(rootPane, "Số tiền phải là số và không chứa kí tự khác!");
				txtCus_Pay.setText("");
				isOK1 = false;
			}
			if (isOK1) {
				double cost = formatDouble(txtMustPay.getText());
				txtExcess.setText(formatCurrency(cash - cost));
			}
		}
	}
	public  int changeToPoint(double money) {
		int mon = (int)money;
		return (mon/1000);
	}
}
