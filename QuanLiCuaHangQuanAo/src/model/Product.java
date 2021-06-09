package model;

import java.util.Date;



public class Product {
	private String id;
	private String name;
	private double price;
	private String unit;
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
	
	public Product() {
		super();
	}


	public Product(String id, String name, double price, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unit=" + unit + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}


}
