package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CreateInvoiceDAO;
import model.Customer;
import model.DetailedInvoice;
import model.Invoice;

public class CreateInvoiceController {
	private Invoice invoice;
	
	

	public CreateInvoiceController() {
		super();
		createInvoice();
	}
	public void createInvoice() {
		invoice = new Invoice();
	}
	public void addItem(String idPro, int quantity) throws SQLException {
		// TODO Auto-generated method stub
		invoice.addItem(idPro, quantity);
	}
	public ArrayList<DetailedInvoice> getListDetailed() {
		// TODO Auto-generated method stub
		return invoice.getListItem();
	}
	public double getPriceOfInvoice() {
		// TODO Auto-generated method stub
		return invoice.getPrice();
	}
	public void removeItem(int selectedIndex) {
		// TODO Auto-generated method stub
		invoice.removeItem( selectedIndex);
	}
	public Customer findCustomerByID(String id) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		invoice.addCustomerByID(id);
		return invoice.getCustomer();
		
	}
	public Customer findCustomerByPhone(String phone) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		invoice.addCustomerByPhone(phone);
		return invoice.getCustomer();
	}
	public void addItem(DetailedInvoice d, int selectedIndex) {
		// TODO Auto-generated method stub
		invoice.addItem(d, selectedIndex);
	}
	public int getMessage() {
		// TODO Auto-generated method stub
		return invoice.getMessage();
	}
	public boolean checkInvoice() {
		// TODO Auto-generated method stub
		if(invoice.getCustomer()==null) return false;
		if(invoice.getListItem()==null||invoice.getListItem().size()==0) return false;
		return true;
	}
	public void saveInvoiceToDB() throws SQLException {
		// TODO Auto-generated method stub
		CreateInvoiceDAO.saveInvoice(this.invoice);;
	}
	public void resetInvoice() {
		// TODO Auto-generated method stub
		createInvoice();
	}
	public void setMessageDefaultValue() {
		// TODO Auto-generated method stub
		invoice.setMessage(0);
	}
	public void setDiscount(double discount) {
		// TODO Auto-generated method stub
		invoice.setDiscount(discount);
		
	}
	public void setPriceInvoice(double cost) {
		// TODO Auto-generated method stub
		invoice.setPrice_Invoice(cost);
	}
	public void setPointUsed(double point_used) {
		// TODO Auto-generated method stub
		invoice.setPoint_used(point_used);
	}
	
	public void updatePoint( double point_used) throws SQLException {
		// TODO Auto-generated method stub
		CreateInvoiceDAO.updatePointToCustomer(this.invoice,  point_used);
	}
	public boolean hasCustomer() {
		// TODO Auto-generated method stub
		if(invoice.getCustomer()!=null) return true;
		return false;
	}
	public void setCustomerIsNull() {
		// TODO Auto-generated method stub
		invoice.setCustomer(null);
	}
}
