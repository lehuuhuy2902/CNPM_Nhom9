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

	
//	public static void main(String[] args) {
//		//System.out.println(CreateInvoiceGUI.changeToPoint((int)1568120));
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateInvoiceGUI frame = new CreateInvoiceGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}

	public CreateInvoiceGUI() {
		init();
		tblModel = (DefaultTableModel) table.getModel();
		controller = new CreateInvoiceController();
	}

	public void init() {
		// SET FRAME

		setSize(1261, 799);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		///
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(12, 13, 183, 781);
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
		btnProduct.setBounds(12, 521, 160, 72);
		panel.add(btnProduct);
		
		JButton btnStaff = new JButton("NH??N VI??N");
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStaff.setBackground(new Color(110, 211, 170));
		btnStaff.setBounds(12, 593, 160, 72);
		btnStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EmployeeFrame().setVisible(true);
			}
		});
		panel.add(btnStaff);
		
		JButton btnHoaDon = new JButton("H\u00D3A \u0110\u01A0N");
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setBackground(SystemColor.desktop);
		btnHoaDon.setBounds(12, 665, 160, 72);
		panel.add(btnHoaDon);
		JButton btnTrangChu = new JButton("TRANG CH\u1EE6");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainView().setVisible(true);
			}
		});
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBackground(new Color(110, 211, 170));
		btnTrangChu.setBounds(12, 450, 160, 72);
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
		panel_HD.setBounds(202, 10, 1015, 330);
		panel_HD.setPreferredSize(new Dimension(1000, 400));
		panel_HD.setBorder(new TitledBorder(null, "H??A ????N", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.add(panel_HD);
		panel_HD.setLayout(new BorderLayout(0, 0));

		JPanel panel_ItemOrder = new JPanel();
		panel_ItemOrder.setPreferredSize(new Dimension(900, 35));
		panel_HD.add(panel_ItemOrder, BorderLayout.NORTH);
		panel_ItemOrder.setLayout(null);

		JLabel lblNameProduct = new JLabel("M?? s???n ph???m");
		lblNameProduct.setBounds(5, 9, 77, 16);
		panel_ItemOrder.add(lblNameProduct);

		txtIdProduct = new JTextField();
		txtIdProduct.setBounds(87, 6, 116, 22);
		txtIdProduct.setColumns(10);
		panel_ItemOrder.add(txtIdProduct);

		JLabel lblQuantity = new JLabel("S??? l?????ng");
		lblQuantity.setBounds(208, 9, 65, 16);
		panel_ItemOrder.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setText("1");
		txtQuantity.setBounds(285, 6, 116, 22);
		txtQuantity.setColumns(10);
		panel_ItemOrder.add(txtQuantity);

		JButton btnAdd = new JButton("Th??m");
		btnAdd.setBounds(414, 5, 77, 25);
		panel_ItemOrder.add(btnAdd);

		JButton btnDelete = new JButton("X??a");
		btnDelete.setBounds(875, 5, 70, 25);
		panel_ItemOrder.add(btnDelete);

		JButton btnEdit = new JButton("S???a");
		btnEdit.setBounds(777, 5, 70, 25);
		panel_ItemOrder.add(btnEdit);

		JPanel panel_Table = new JPanel();
		FlowLayout fl_panel_Table = (FlowLayout) panel_Table.getLayout();
		fl_panel_Table.setAlignment(FlowLayout.RIGHT);
		panel_HD.add(panel_Table, BorderLayout.SOUTH);

		JLabel lblNewLabel_7 = new JLabel("T???ng ti???n");
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
		panel_Total.setPreferredSize(new Dimension(900, 250));
		panel_HD.add(panel_Total, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setPreferredSize(new Dimension(900, 220));
		panel_Total.add(scrollPane);

		table = new JTable();
		table.setRowHeight(25);
		table.setSelectionBackground(new Color(0, 120, 215));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M?? s???n ph???m", "T??n s???n ph???m", "????n v???", "????n gi??", "S??? l?????ng", "Th??nh ti???n" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(375);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		// PANEL BODY (CUSTOMER INFOMATION & PAYMENT INFORMATION)
		JPanel panel_body = new JPanel();
		panel_body.setBounds(202, 353, 1015, 272);
		panel_body.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		//// CUSTOMER INFOMATION
		JPanel panel_InfoCus = new JPanel();
		panel_InfoCus.setPreferredSize(new Dimension(600, 240));
		panel_InfoCus.setSize(new Dimension(500, 0));
		panel_InfoCus.setBorder(new TitledBorder(null, "Th??ng tin kh??ch h??ng", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_body.add(panel_InfoCus);

		JLabel lblIdCus = new JLabel("M?? kh??ch h??ng");
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

		JLabel lblHSD = new JLabel("Ng??y h???t h???n");
		lblHSD.setBounds(348, 92, 83, 16);
		panel_InfoCus.add(lblHSD);

		txtHSD = new JTextField();
		txtHSD.setSize(new Dimension(146, 24));
		txtHSD.setPreferredSize(new Dimension(100, 25));
		txtHSD.setColumns(10);
		txtHSD.setBounds(443, 89, 146, 24);
		panel_InfoCus.add(txtHSD);

		JLabel lblNameCus = new JLabel("T??n kh??ch h??ng");
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

		JLabel lblPhoneCus = new JLabel("S??? ??i???n tho???i");
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

		JLabel lblType = new JLabel("Lo???i ");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setBounds(12, 167, 56, 16);
		panel_InfoCus.add(lblType);

		txtType = new JTextField();
		txtType.setBounds(125, 163, 146, 24);
		txtType.setColumns(10);
		panel_InfoCus.add(txtType);

		JLabel lblDOB = new JLabel("Ng??y sinh");
		lblDOB.setBounds(348, 167, 56, 16);
		panel_InfoCus.add(lblDOB);

		txtDOB = new JTextField();
		txtDOB.setSize(new Dimension(146, 24));
		txtDOB.setPreferredSize(new Dimension(100, 25));
		txtDOB.setColumns(10);
		txtDOB.setBounds(443, 164, 146, 24);
		panel_InfoCus.add(txtDOB);

		JLabel lblPoint = new JLabel("??i???m t??ch l??y");
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
		panel_Payment.setBorder(new TitledBorder(null, "Th??ng tin thanh to??n", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_body.add(panel_Payment);
		panel_Payment.setLayout(null);

		JLabel lblCost = new JLabel("T???ng ti???n ");
		lblCost.setBounds(12, 50, 191, 25);
		panel_Payment.add(lblCost);

		txtCost = new JTextField();
		txtCost.setBounds(197, 50, 191, 25);
		txtCost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCost.setColumns(10);
		panel_Payment.add(txtCost);

		JLabel lblDiscount = new JLabel("Chi???t kh???u");
		lblDiscount.setBounds(12, 80, 191, 25);
		panel_Payment.add(lblDiscount);

		txtDiscount = new JTextField();
		txtDiscount.setBounds(197, 80, 191, 25);
		txtDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiscount.setColumns(10);
		panel_Payment.add(txtDiscount);

		JLabel lblUse_Point = new JLabel("S??? d???ng ??i???m t??ch l??y (*)");
		lblUse_Point.setBounds(12, 110, 191, 25);
		panel_Payment.add(lblUse_Point);

		txtUsePoint = new JTextField();
		txtUsePoint.setBounds(197, 110, 191, 25);
		txtUsePoint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsePoint.setColumns(10);
		panel_Payment.add(txtUsePoint);

		JLabel lblMust_Pay = new JLabel("S??? ti???n c???n thanh to??n");
		lblMust_Pay.setBounds(12, 140, 191, 25);
		panel_Payment.add(lblMust_Pay);

		txtMustPay = new JTextField();
		txtMustPay.setBounds(197, 140, 191, 25);
		txtMustPay.setForeground(Color.RED);
		txtMustPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMustPay.setColumns(10);
		panel_Payment.add(txtMustPay);

		JLabel lblCus_pay = new JLabel("Ti???n kh??ch ????a");
		lblCus_pay.setBounds(12, 170, 191, 25);
		panel_Payment.add(lblCus_pay);

		txtCus_Pay = new JTextField();
		txtCus_Pay.setBounds(197, 170, 191, 25);
		txtCus_Pay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCus_Pay.setColumns(10);
		panel_Payment.add(txtCus_Pay);

		JLabel lblExcess = new JLabel("Ti???n th??i");
		lblExcess.setBounds(12, 200, 191, 25);
		panel_Payment.add(lblExcess);

		txtExcess = new JTextField();
		txtExcess.setBounds(197, 200, 191, 25);
		txtExcess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtExcess.setColumns(10);
		panel_Payment.add(txtExcess);
		
		cbxTD = new JCheckBox("T??ch ??i???m v??o th??? Kh??ch h??ng");
		cbxTD.setBounds(8, 22, 261, 25);
		panel_Payment.add(cbxTD);

		// PANEL FOOTER (INFORMATION OF INVOICE)
		JPanel panel_InfoHD = new JPanel();
		panel_InfoHD.setBounds(202, 626, 1015, 126);
		panel_InfoHD.setPreferredSize(new Dimension(1000, 110));
		panel_InfoHD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th??ng tin h??a ????n",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.setLayout(null);

		contentPane.add(panel_body);

		JLabel lblNotice = new JLabel("(*) L??u ??: 1 ??i???m t????ng ?????ng v???i 10 ?????ng");

		panel_body.add(lblNotice);
		contentPane.add(panel_InfoHD);
		panel_InfoHD.setLayout(null);

		JLabel lblDateFounded = new JLabel("Ng??y l???p");
		lblDateFounded.setBounds(40, 26, 88, 19);
		lblDateFounded.setHorizontalAlignment(SwingConstants.LEFT);
		panel_InfoHD.add(lblDateFounded);

		txtDF = new JTextField();
		txtDF.setText(new Date().currrentDate().toString());
		txtDF.setBounds(140, 23, 199, 22);
		txtDF.setColumns(10);
		panel_InfoHD.add(txtDF);

		JLabel lblnum_HD = new JLabel("S??? h??a ????n");
		lblnum_HD.setHorizontalAlignment(SwingConstants.LEFT);
		lblnum_HD.setBounds(40, 61, 88, 19);
		panel_InfoHD.add(lblnum_HD);

		textNumHD = new JTextField();
		textNumHD.setColumns(10);
		textNumHD.setBounds(140, 58, 199, 22);
		panel_InfoHD.add(textNumHD);

		JLabel lblEmployee = new JLabel("Nh??n vi??n");
		lblEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployee.setBounds(440, 27, 69, 18);
		panel_InfoHD.add(lblEmployee);

		txtEmployee = new JTextField();
		txtEmployee.setText("Nguy???n Th??? Hoa C??c");
		txtEmployee.setColumns(10);
		txtEmployee.setBounds(545, 24, 258, 22);
		panel_InfoHD.add(txtEmployee);

		JLabel lblUnitName = new JLabel("T??n ????n v???");
		lblUnitName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnitName.setBounds(440, 62, 81, 18);
		panel_InfoHD.add(lblUnitName);

		txtUnitName = new JTextField();
		txtUnitName.setText("C???a h??ng 01, ???????ng Nguy???n Trung Tr???c");
		txtUnitName.setColumns(10);
		txtUnitName.setBounds(545, 59, 258, 21);
		panel_InfoHD.add(txtUnitName);

		JButton btnSave = new JButton("L??u");
		btnSave.setBounds(555, 93, 97, 25);
		panel_InfoHD.add(btnSave);

		JButton btnSave_Print = new JButton("L??u v?? In");
		btnSave_Print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave_Print.setBounds(706, 93, 97, 25);
		panel_InfoHD.add(btnSave_Print);

		// action
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String idPro = txtIdProduct.getText().trim();
				String quan = txtQuantity.getText().trim();
				// System.out.println(idPro);
				if (idPro.equals("") || quan.equals("")) {
					JOptionPane.showMessageDialog(rootPane, "H??y nh???p ?????y ????? th??ng tin ????? th??m v??o h??a ????n!");
				} else {
					try {
						int quantity = Integer.parseInt(quan);
						if (quantity <= 0)
							JOptionPane.showMessageDialog(rootPane, "S??? l?????ng ph???i l???n h??n 0");
						else {

							controller.addItem(idPro, quantity);
							listItem = controller.getListDetailed();

							if (controller.getMessage() == 1) {
								JOptionPane.showMessageDialog(rootPane, "S???n ph???m kh??ng t???n t???i!");
								controller.setMessageDefaultValue();
							} else {
								showData();
								// C???p nh???t gi?? ti???n h??a ????n
								txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
								txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
								// C???p nh???t thanh to??n, ti???n tr??? kh??ch sau khi chi???t kh???u gi???m gi??
								updatePayment();
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane, "S??? l?????ng ph???i l?? s???!");
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
					JOptionPane.showMessageDialog(rootPane, "Kh??ng c?? chi ti???t ????n h??ng ????? x??a!");
				} else if (selectedIndex == -1) {
					JOptionPane.showMessageDialog(rootPane, "H??y ch???n d??ng c?? chi ti???t ????n h??ng c???n x??a r???i ???n X??a!");
				} else { // chon dong can xoa va nhan nut
					controller.removeItem(selectedIndex);
					listItem = controller.getListDetailed();
					showData();
					// C???p nh???t gi?? ti???n h??a ????n
					txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
					txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
					// C???p nh???t thanh to??n, ti???n tr??? kh??ch sau khi chi???t kh???u gi???m gi??
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
							"Vui l??ng nh???p s??? ??i???n tho???i ho???c m?? kh??ch h??ng ????? t??m ki???m!");
				else {
					try {
						customer = controller.findCustomerByID(idCus);
					} catch (NumberFormatException | SQLException e1) {

						e1.printStackTrace();
					}
					if (customer == null)
						JOptionPane.showMessageDialog(rootPane, "Kh??ch h??ng kh??ng t???n t???i trong h??? th???ng!");
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
							"Vui l??ng nh???p s??? ??i???n tho???i ho???c m?? kh??ch h??ng ????? t??m ki???m!");
				else {
					try {
						customer = controller.findCustomerByPhone(phone);
					} catch (NumberFormatException | SQLException e1) {

						e1.printStackTrace();
					}
					if (customer == null)
						JOptionPane.showMessageDialog(rootPane, "Kh??ch h??ng kh??ng t???n t???i trong h??? th???ng!");
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
					// L??u ti???n v?? c??c gi???m gi?? c???a h??a ????n
					double cost = formatDouble(txtMustPay.getText());
					double discount = formatDouble(txtDiscount.getText());
					double point_used = formatDouble(txtUsePoint.getText());
					controller.setDiscount(discount);
					controller.setPriceInvoice(cost);
					controller.setPointUsed(point_used);
					// C???p nh???t ??i???m t??ch l??y cho KH
					int pointAdd = 0;
					
					if (cbxTD.isSelected()) {
						pointAdd= changeToPoint(cost);
					}
					try {
						
						controller.updatePoint(point_used-pointAdd);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				
					// L??u v??o dB
					try {
						controller.saveInvoiceToDB();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(rootPane, "L??u h??a ????n th??nh c??ng!");
					// reset
					controller.resetInvoice();
					resetGUI();
				} else {
					JOptionPane.showMessageDialog(rootPane, "Vui l??ng ??i???n ?????y ????? th??ng tin ????? l??u h??a ????n!");
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
				//set l???i customer l?? null ????? ng??n ch???n l???i khi ch??a nh???p l???i kh??ch h??ng m?? l???i l??u.
				//N???u ko set l???i th?? h??? th???ng s??? l???y th??ng tin c???a kH tr?????c ????.
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
			JOptionPane.showMessageDialog(rootPane, "Kh??ng c?? chi ti???t ????n h??ng ????? s???a!");
		} else if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(rootPane, "H??y ch???n d??ng c?? chi ti???t ????n h??ng c???n s???a r???i ???n S???a!");
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
		// C???p nh???t gi?? ti???n h??a ????n
		txtTotal.setText(formatCurrency(controller.getPriceOfInvoice()));
		txtCost.setText(formatCurrency(controller.getPriceOfInvoice()));
		// C???p nh???t thanh to??n, ti???n tr??? kh??ch sau khi chi???t kh???u gi???m gi??
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
		// T??nh ti???n c???n thanh to??n
		if (listItem == null||listItem.size() == 0) {
			txtDiscount.setText("");
			txtUsePoint.setText("");
		}
		String discount = txtDiscount.getText();
		double d = 0;

		String p = txtUsePoint.getText();
		double point = 0;

		boolean isOK = true;
		// N???u chi???t kh???u v?? gi???m gi?? b??? tr???ng th?? t??nh ti???n c???n tr???,
		// n???u 1 trong 2 ko tr???ng th?? ph???i t??nh l???i ti???n sau khi gi???m gi??
		// Y??u c???u tr?????c khi nh???p gi???m gi?? hay s??? d???ng ??i???m ph???i nh???p kh??ch h??ng tr?????c
		// ????? so kh???p
		// ??i???m s??? d???ng vs ??i???m t??ch l??y c???a KH
		if (!discount.equals("")) {
			if (controller.hasCustomer()) {
				try {
					d = formatDouble(discount);
					txtDiscount.setText(formatCurrency(d));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "S??? ti???n ph???i l?? s??? v?? kh??ng ch???a k?? t??? kh??c!");
					txtDiscount.setText("");
					isOK = false;
				}
			} else {
				JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p th??ng kh??ch h??ng tr?????c khi thanh to??n!");
				txtDiscount.setText("");
			}
		}
		if (!p.equals("")) {
			if (controller.hasCustomer()) {
				try {
					point = formatDouble(p);

					double po = Double.parseDouble(txtPoint.getText());// ??i???m t??ch l??y c???a KH
					
					if (po < point) {
						JOptionPane.showMessageDialog(rootPane, "S??? ??i???m s??? d???ng v?????t s??? ??i???m t??ch l??y!");
						txtUsePoint.setText("");
					} else {
						txtUsePoint.setText(formatCurrency(point));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "S??? ??i???m t??ch l??y ph???i l?? s??? v?? kh??ng ch???a k?? t??? kh??c!");
					txtUsePoint.setText("");
					isOK = false;
				}
			} else {
				JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p th??ng kh??ch h??ng tr?????c khi thanh to??n!");
				txtUsePoint.setText("");
			}

		}
		if (isOK) {

			txtMustPay.setText(formatCurrency(controller.getPriceOfInvoice() - (d + point * 10)));
		}
		// T??nh ti???n th??i kh??ch h??ng
		String cusPay = txtCus_Pay.getText();
		double cash = 0;
		boolean isOK1 = true;
		if (!cusPay.equals("")) {

			try {

				cash = formatDouble(cusPay);
				txtCus_Pay.setText(formatCurrency(cash));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(rootPane, "S??? ti???n ph???i l?? s??? v?? kh??ng ch???a k?? t??? kh??c!");
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
