package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.ProductDAO;
import view.LoginView;
import view.MainView;

public class ProductController {
	LoginView loginView;
	MainView mainView;
	ProductDAO dao;
	
	public ProductController() {
		dao = new ProductDAO();
		
		
	}
	public boolean updateProduct(Product p){
		return dao.updateProduct(p);
	
	}
	public ArrayList<Product> getListProduct() {
		
		return dao.getAllProduct();
	}
	

}
