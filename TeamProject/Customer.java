package entity;

public class Customers {
	private int customer_id;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	
	public Customers(int customer_id, String name, String address, 
				String phone, String email) {
		this.setCustomer_Id(customer_id);
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
		this.setEmail(email);
	}

	public int getCustomer_Id() {
		return customer_id;
	}

	public void setCustomer_Id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

