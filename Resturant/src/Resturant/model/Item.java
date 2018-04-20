package Resturant.model;




public class Item {
	private String shop;
	private int quantity;
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private String Username;	
	private String adminUserName;
	private String ItemName;
    private double Price;
    private String Description;
    private String image;
    private int acitve;
    private String category;
    
    public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
     public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public int getAcitve() {
		return acitve;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public int isAcitve() {
		return acitve;
	}
	public void setAcitve(int acitve) {
		this.acitve = acitve;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
