package Resturant.model;

public class Admin {
	private String firstName;
	  private String LastName;
	   private String adminuserName;
       private String password;
       private String re_password;
       private String gender;
       private String Address;
       private long Phone;
       private String Email;
    
   public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fitstName) {
		this.firstName = fitstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
    public String getadminUserName() {
		return adminuserName;
	}
	public void setadminUserName(String adminuserName) {
		this.adminuserName = adminuserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRe_password() {
		return re_password;
	}
	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
