package model;

import java.util.Date;

public class Product {
	private String id;
	private String name;
	private String category;
	private int quatity;
	private Date addDate;
	private boolean status;
	public Product(String id, String name, String category, int quatity, Date addDate, boolean status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.quatity = quatity;
		this.addDate = addDate;
		this.status = status;
	}
	
	

}
