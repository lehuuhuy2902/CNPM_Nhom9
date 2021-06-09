package model;

public class DetailedInvoice {
	private int quantity;
	private Product product;
	public DetailedInvoice() {
		
	}
	public DetailedInvoice(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//compute Price for Item
	public double price() {
		return product.getPrice()*quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailedInvoice other = (DetailedInvoice) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
