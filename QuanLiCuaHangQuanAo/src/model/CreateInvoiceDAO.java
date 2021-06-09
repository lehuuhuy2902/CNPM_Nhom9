package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionDB;

public class CreateInvoiceDAO {

	public static Product searchProductByID(String id) throws SQLException {
		String sql = "select * from product where id= ?";
		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql);
		pre.setString(1, id);
		ResultSet rs = pre.executeQuery();
		Product p;
		while (rs.next()) {

			String idd = rs.getString("id");
			String name = rs.getString("name");
			String unit = rs.getString("unit");
			double price = Double.parseDouble(rs.getString("price"));
			p = new Product(idd, name, price, unit);
			return p;

		}
		return null;

	}

	public static Customer searchCustomerByID(String id) throws NumberFormatException, SQLException {
		String sql = "select * from customer where id= ?";
		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql);
		pre.setString(1, id);
		ResultSet rs = pre.executeQuery();
		Customer c;
		while (rs.next()) {

			String idd = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String type = rs.getString("typeCard");
			String email = rs.getString("email");
			Date dateSD = new Date().convertFormatDate(rs.getString("dateSD"));
			Date dob = new Date().convertFormatDate(rs.getString("dob"));
			int point = Integer.parseInt(rs.getString("point"));
			c = new Customer(idd, name, phone, type, point, dateSD, email, dob);
			return c;

		}
		return null;
	}

	public static Customer searchCustomerByPhone(String phone) throws NumberFormatException, SQLException {
		String sql = "select * from customer where phone= ?";
		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql);
		pre.setString(1, phone);
		ResultSet rs = pre.executeQuery();
		Customer c;
		while (rs.next()) {

			String idd = rs.getString("id");
			String name = rs.getString("name");
			String phonee = rs.getString("phone");
			String type = rs.getString("typeCard");
			String email = rs.getString("email");
			Date dateSD = new Date().convertFormatDate(rs.getString("dateSD"));
			Date dob = new Date().convertFormatDate(rs.getString("dob"));
			int point = Integer.parseInt(rs.getString("point"));
			c = new Customer(idd, name, phonee, type, point, dateSD, email, dob);
			return c;

		}
		return null;

	}

	public static void saveInvoice(Invoice invoice) throws SQLException {
		String id_Invoice = createID_Invoice();
		// Lưu vào bảng Hóa đơn
		String sql_0 = "INSERT INTO invoice (id_Invoice,id_Cus,date,price,discount,usePoint,price_Invoice) VALUES (\""
				+ id_Invoice + "\",\"" + invoice.getCustomer().getId() + "\",\"" + invoice.getDateFounded().toStringToDB()
				+ "\"," + invoice.getPrice() + "," + invoice.getDiscount() + "," + invoice.getPoint_used() + ","
				+ invoice.getPrice_Invoice() + ")";

		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql_0);
		pre.executeUpdate();
		pre.close();
		// Lưu vào bảng detailedInvoice
		String sql = "INSERT INTO detailedInvoice (id_Invoice,id_Product,quantity) VALUES ";
		int i = 0;
		for (DetailedInvoice d : invoice.getListItem()) {

			if (++i < invoice.getListItem().size())
				sql += "(\"" + id_Invoice + "\",\"" + d.getProduct().getId() + "\"," + d.getQuantity() + "),";
			else
				sql += "(\"" + id_Invoice + "\",\"" + d.getProduct().getId() + "\"," + d.getQuantity() + ")";
		}
		PreparedStatement pre1 = ConnectionDB.connectDB().prepareStatement(sql);
		pre1.executeUpdate();
		pre1.close();
	}

	private static String createID_Invoice() throws SQLException {
		String sql = "select count(*) from invoice";
		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		String result="HD";
		while (rs.next()) {
			result+=rs.getString(1);
			

		}
		pre.close();
		return result;
	}

	public static void updatePointToCustomer(Invoice invoice, double point_used) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE  customer SET point = ? WHERE id = \""+invoice.getCustomer().getId()+"\";";
		
		int point = (int) Math.round(invoice.getCustomer().getPoint()-point_used);
		PreparedStatement pre = ConnectionDB.connectDB().prepareStatement(sql);
		pre.setInt(1, point);
		pre.executeUpdate();
		pre.close();
	}



}
