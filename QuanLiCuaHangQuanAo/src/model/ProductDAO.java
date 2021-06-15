package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import database.ConnectionDB;

public class ProductDAO {

	public boolean updateProduct(Product p) {
		
		
		String sql = "update product set name = ?, price= ?, addDate = ?, quatity = ?, status = ? where idPro = ?";
		
		PreparedStatement s;
		try {
			s = ConnectionDB.connect(sql);
			s.setString(1, p.getName());
			s.setDouble(2, p.getPrice());
			s.setString(3, p.getAddDate());
			s.setInt(4, p.getQuatity());
			s.setString(5, p.getStatus());
			s.setString(6, p.getId());
			s.executeUpdate();
			s.close();
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return true;

	}

	public ArrayList<Product> getAllProduct() {
		ArrayList<Product> listProduct = new ArrayList<Product>();
		
		Statement s;
		try {
			s = ConnectionDB.connect();
			ResultSet rs = s.executeQuery("select * from product");
			while(rs.next()) {
				listProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
				
			}
			
			
			
			rs.close();
            s.close();
            return listProduct;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return null;
	}
	

}
