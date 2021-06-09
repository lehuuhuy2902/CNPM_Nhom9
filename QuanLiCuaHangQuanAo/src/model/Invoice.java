package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Invoice {
	private Date dateFounded;
	private ArrayList<DetailedInvoice> listItem;
	private Customer customer;
	private double price;
	private double point_used;
	private double discount;
	private double price_Invoice;
	// class
	private int message = 0;

	public Invoice(Date dateFounded, ArrayList<DetailedInvoice> listItemArrayList) {
		super();
		this.dateFounded = dateFounded;
		this.listItem = listItemArrayList;
	}

	public Invoice() {
		this.dateFounded = new Date().currrentDate();
		this.listItem = new ArrayList<DetailedInvoice>();
		this.price = 0;
	}

	public Invoice(Date dateFounded) {
		super();
		this.dateFounded = dateFounded.currrentDate();
		this.listItem = new ArrayList<DetailedInvoice>();
	}

	public Date getDateFounded() {
		return dateFounded;
	}

	public void setDateFounded(Date dateFounded) {
		this.dateFounded = dateFounded;
	}

	public ArrayList<DetailedInvoice> getListItem() {
		return listItem;
	}

	public void setListItem(ArrayList<DetailedInvoice> listItem) {
		this.listItem = listItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPrice() {
		return price;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPoint_used() {
		return point_used;
	}

	public void setPoint_used(double point_used) {
		this.point_used = point_used;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice_Invoice() {
		return price_Invoice;
	}

	public void setPrice_Invoice(double price_Invoice) {
		this.price_Invoice = price_Invoice;
	}

	// updatePrice
	public double cost() {
		price = 0;
		for (DetailedInvoice d : listItem) {
			price += d.price();
		}
		return price;
	}

	// updatePrice
	public double updateCost(DetailedInvoice d) {
		if (!listItem.contains(d)) {
			price = price + d.price();
		}
		return price;
	}

	// add DetailItem
	public void addItem(String idProduct, int quantity) throws SQLException {
		boolean check = false;// kiểm tra sản phẩm đã có trong hóa đơn chưa
		// create detailed invoice object
		DetailedInvoice detail = new DetailedInvoice();
		// create product
		Product product = CreateInvoiceDAO.searchProductByID(idProduct);
		// set detailed invoice
		if (product != null) {

			detail.setProduct(product);
			detail.setQuantity(quantity);
			// add detailed to invoice
			for (DetailedInvoice d : listItem) {
				if (d.getProduct().equals(product)) {
					check = true;
					d.setQuantity(d.getQuantity() + quantity);
					break;
				}
			}
			if (!check)
				listItem.add(detail);

			// update price for invoice
			// updateCost(detail);
			cost();

		} else {
			message = 1;
		}

	}

	public void addItem(DetailedInvoice d, int index) {

		listItem.add(index, d);
		cost();

	}

	// remove Item
	public void removeItem(DetailedInvoice d) {
		listItem.remove(d);
		cost();
	}

	public void removeItem(int selectedIndex) {
		// TODO Auto-generated method stub
		listItem.remove(selectedIndex);
		cost();
	}

	// add Customer
	public void addCustomerByID(String id) throws NumberFormatException, SQLException {
		// create object
		Customer c = CreateInvoiceDAO.searchCustomerByID(id);
		setCustomer(c);

	}

	public void addCustomerByPhone(String phone) throws NumberFormatException, SQLException {
		// create object
		Customer c = CreateInvoiceDAO.searchCustomerByPhone(phone);
		setCustomer(c);
	}

	public static void main(String[] args) throws SQLException {
		Invoice i = new Invoice();
		i.addItem("SP001", 1);
	}

}
