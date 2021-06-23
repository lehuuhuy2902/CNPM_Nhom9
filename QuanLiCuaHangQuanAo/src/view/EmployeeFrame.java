package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.EmployeeModify;

/**
 *
 * @author Diep.Tran
 */
public class EmployeeFrame extends javax.swing.JFrame {
	DefaultTableModel tableModel;

	List<Employee> employeeList = new ArrayList<>();

	/**
	 * Creates new form EmployeeFrame
	 */
	public EmployeeFrame() {
		initComponents();
		tableModel = (DefaultTableModel) tblEmployee.getModel();
		showEmployee();
		setLocationRelativeTo(null);
	}

	private void showEmployee() {
		employeeList = EmployeeModify.findAll();

		tableModel.setRowCount(0);

		employeeList.forEach((employee) -> {
			tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, employee.getFullname(), employee.getGender(),
					employee.getPosition(), employee.getPhoneNumber() });
		});
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtFullname = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		cbGender = new javax.swing.JComboBox<>();
		jLabel3 = new javax.swing.JLabel();
		txtAge = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtPosition = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtPhoneNumber = new javax.swing.JTextField();
		btnSave = new javax.swing.JButton();
		btnReset = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnFind = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblEmployee = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Employee Manager");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Employee's Detail Information"));

		jLabel1.setText("Full Name:");

		jLabel2.setText("Gender: ");

		cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

		jLabel3.setText("Age:");

		jLabel4.setText("Position:");

		jLabel5.setText("Phone Number:");

		btnSave.setText("Save");
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		btnReset.setText("Reset");
		btnReset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetActionPerformed(evt);
			}
		});

		btnDelete.setText("Delete");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnFind.setText("Cancel");
		btnFind.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFindActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2))
								.addGap(77, 77, 77)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtFullname)))
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3).addGap(116, 116, 116)
								.addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 330,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel5).addComponent(jLabel4))
								.addGap(48, 48, 48)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtPosition)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnSave)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnReset)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnDelete)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnFind))
										.addComponent(txtPhoneNumber))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSave).addComponent(btnReset).addComponent(btnDelete)
								.addComponent(btnFind))
						.addContainerGap(19, Short.MAX_VALUE)));

		tblEmployee.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Full Name", "Gender", "Position", "Address" }) {
			boolean[] canEdit = new boolean[] { false, false, false, true, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblEmployee);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		txtFullname.setText("");
		cbGender.setSelectedIndex(0);
		txtAge.setText("");
		txtPosition.setText("");
		txtPhoneNumber.setText("");
	}

	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String fullname = txtFullname.getText();
		String gender = cbGender.getSelectedItem().toString();
		int age = Integer.parseInt(txtAge.getText());
		String position = txtPosition.getText();
		String phoneNumber = txtPhoneNumber.getText();

		Employee std = new Employee(fullname, gender, position, phoneNumber, age);

		EmployeeModify.insert(std);

		showEmployee();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		int selectedIndex = tblEmployee.getSelectedRow();
		if (selectedIndex < 0) {
			JOptionPane.showMessageDialog(this, "Select the employee line you want to delete and press Delete!");
		}

		if (selectedIndex >= 0) {
			Employee std = employeeList.get(selectedIndex);

			int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this item?");
			System.out.println("option : " + option);

			if (option == 0) {

				EmployeeModify.delete(std.getId());

				showEmployee();
			}
		}
	}

	private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		new MainView().setVisible(true);

		// TODO add your handling code here:
//        String input = JOptionPane.showInputDialog(this, "Enter full name to search");
//        if(input != null && input.length() > 0) {
//            employeeList = EmployeeModify.findByFullname(input);
//            
//            tableModel.setRowCount(0);
//        
//            employeeList.forEach((employee) -> {
//                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, employee.getFullname(), 
//                    employee.getGender(), employee.getPosition(), employee.getPhoneNumber()});
//            });
//        } else {
//            showEmployee();
//        }
	}

	/**
	 * @param args the command line arguments
	 */
////    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EmployeeFrame().setVisible(true);
//            }
//        });
//    }

	// Variables declaration - do not modify
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnFind;
	private javax.swing.JButton btnReset;
	private javax.swing.JButton btnSave;
	private javax.swing.JComboBox<String> cbGender;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tblEmployee;
	private javax.swing.JTextField txtAge;
	private javax.swing.JTextField txtPosition;
	private javax.swing.JTextField txtFullname;
	private javax.swing.JTextField txtPhoneNumber;
	// End of variables declaration
}
