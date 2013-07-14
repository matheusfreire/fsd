package model;

public class User {
	
	String name;
	int rb;
	String email;
	
	public User() {}
	
	public User(String name, int rb, String email){
		this.name = name;
		this.rb = rb;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRb() {
		return rb;
	}

	public void setRb(int rb) {
		this.rb = rb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
