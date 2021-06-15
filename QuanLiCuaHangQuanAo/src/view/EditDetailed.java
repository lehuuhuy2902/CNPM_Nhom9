package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DetailedInvoice;
import model.Product;

public class EditDetailed extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_EditIDPro;
	private JTextField txt_EditNamePro;
	private JTextField txt_EditPricePro;
	private JTextField txt_EditQuantiPro;
	private CreateInvoiceGUI createInvoice;
	private String unit;// to create Pro Object

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			EditDetailed dialog = new EditDetailed();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public EditDetailed(JFrame parent) {
		init();
		this.setLocationRelativeTo(null);
		createInvoice = (CreateInvoiceGUI) parent;
		this.setTitle("Sửa thông tin CTDH");
	}
	public EditDetailed() {
		
	}

	private void init() {

		setBounds(100, 100, 448, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 432, 208);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEdit_IDPro = new JLabel("Mã sản phẩm");
				lblEdit_IDPro.setBounds(29, 66, 83, 16);
				panel.add(lblEdit_IDPro);
			}
			{
				JLabel lblEdit_CTDH = new JLabel("SỬA THÔNG TIN CHI TIẾT ĐƠN HÀNG");
				lblEdit_CTDH.setBounds(48, 13, 340, 25);
				lblEdit_CTDH.setForeground(Color.BLUE);
				lblEdit_CTDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(lblEdit_CTDH);
			}

			JLabel lblEdit_NamePro = new JLabel("Tên sản phẩm");
			lblEdit_NamePro.setBounds(29, 95, 83, 16);
			panel.add(lblEdit_NamePro);

			JLabel lblEdit_Price = new JLabel("Đơn giá");
			lblEdit_Price.setBounds(29, 127, 83, 16);
			panel.add(lblEdit_Price);

			JLabel lblEdit_Quanti = new JLabel("Số lượng");
			lblEdit_Quanti.setBounds(29, 156, 83, 16);
			panel.add(lblEdit_Quanti);

			txt_EditIDPro = new JTextField();
			txt_EditIDPro.setEnabled(false);
			txt_EditIDPro.setBounds(162, 63, 245, 22);
			panel.add(txt_EditIDPro);
			txt_EditIDPro.setColumns(10);

			txt_EditNamePro = new JTextField();
			txt_EditNamePro.setEnabled(false);
			txt_EditNamePro.setBounds(162, 92, 245, 22);
			panel.add(txt_EditNamePro);
			txt_EditNamePro.setColumns(10);

			txt_EditPricePro = new JTextField();
			txt_EditPricePro.setBounds(162, 124, 245, 22);
			panel.add(txt_EditPricePro);
			txt_EditPricePro.setColumns(10);

			txt_EditQuantiPro = new JTextField();
			txt_EditQuantiPro.setBounds(162, 153, 245, 22);
			panel.add(txt_EditQuantiPro);
			txt_EditQuantiPro.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSaveEdit = new JButton("Lưu");
				buttonPane.add(btnSaveEdit);
				// Sự kiện
				btnSaveEdit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						actionBtnSave();
						
					}
				});
				getRootPane().setDefaultButton(btnSaveEdit);
			}
			{
				JButton btnCancelEdit = new JButton("Hủy");
				
				buttonPane.add(btnCancelEdit);
				btnCancelEdit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						actionCancel();
					}
				});
			}
		}
		// Action

	}

	protected void actionCancel() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	protected void actionBtnSave() {
		// TODO Auto-generated method stub
		
		String id = "";
		String name = "";
		double price = 0;
		int quantity = 0;
		boolean isOK = true;

		id = txt_EditIDPro.getText();
		name = txt_EditNamePro.getText();
		try {
			price = Double.parseDouble(txt_EditPricePro.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane, "Giá phải là số và không chứa kí tự khác!");
			isOK = false;

		}
		try {
			quantity = Integer.parseInt(txt_EditQuantiPro.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số và không chứa kí tự khác!");
			isOK = false;

		}

		if (isOK) {
			
			Product product = new Product(id, name, price, unit);
			DetailedInvoice detailed = new DetailedInvoice(quantity, product);
			createInvoice.updateDetaiedInvoice(detailed);
			JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");
			this.dispose();
		}
	}
	
	public void setDataDetailed(DetailedInvoice d) {
		txt_EditIDPro.setText(d.getProduct().getId());
		txt_EditNamePro.setText(d.getProduct().getName());
		txt_EditPricePro.setText(d.getProduct().getPrice()+"");
		txt_EditQuantiPro.setText(d.getQuantity()+"");
		unit=d.getProduct().getUnit();
	}

}
