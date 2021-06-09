package model;

public class Customer {
	private String id;//Mã KH
	private String name;//Tên KH
	private String phone;//Số điện thoạiKH
	private String type;// Loại KH(Vàng Bạc �?ồng)
	private int point;//�?iểm tích lũy
	private Date dateSD;//Hạn sử dụng điểm
	private String email;//Email KH
	private Date dob;// Ngày sinh
	public Customer() {
		
	}
	public Customer(String id, String name, String phone, String type, int point, Date dateSD, String email, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.type = type;
		this.point = point;
		this.dateSD = dateSD;
		this.email = email;
		this.dob = dob;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getDateSD() {
		return dateSD;
	}
	public void setDateSD(Date dateSD) {
		this.dateSD = dateSD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	// addPoint
	public void addPoint(double priceOfInvoice) {
		if (priceOfInvoice<500000);
		else if (priceOfInvoice<1000000) point+=500;
		else if (priceOfInvoice<2000000) point+=1000;
		else if (priceOfInvoice<3000000) point+=2000;
		else if (priceOfInvoice<4000000) point+=3000;
		else if (priceOfInvoice<5000000) point+=4000;
		else if (priceOfInvoice>5000000) point+=5000;
	}
	
}
