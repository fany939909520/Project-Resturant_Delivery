package Resturant.model;

public class Order {
	String user_name;
    String Admin_User_name;
    int credit_Card_Number;
    int secure_code;
    long cardzipCode;
    String itemname;
    double item_price;
    int item_quantity;
    String location_name;
    String address;
    String city;
    public long getCardzipCode() {
		return cardzipCode;
	}
	public void setCardzipCode(long cardzipCode) {
		this.cardzipCode = cardzipCode;
	}
	public long getAddresszipcode() {
		return addresszipcode;
	}
	public void setAddresszipcode(long addresszipcode) {
		this.addresszipcode = addresszipcode;
	}
	long addresszipcode;
    String item_image;
     public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAdmin_User_name() {
		return Admin_User_name;
	}
	public void setAdmin_User_name(String admin_User_name) {
		Admin_User_name = admin_User_name;
	}
	public int getCredit_Card_Number() {
		return credit_Card_Number;
	}
	public void setCredit_Card_Number(int credit_Card_Number) {
		this.credit_Card_Number = credit_Card_Number;
	}
	public int getSecure_code() {
		return secure_code;
	}
	public void setSecure_code(int secure_code) {
		this.secure_code = secure_code;
	}

	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
