package bean;

public class BookOrder {
	private String username;
	private String zipcode;
	private String phone;
	private String creditcard;
	private double total;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String credicard) {
		this.creditcard = credicard;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
