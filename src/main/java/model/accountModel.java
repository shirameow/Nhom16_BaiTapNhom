package model;

public class accountModel {
	private String username;
	private String password;
	private String role;
	
	public accountModel(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		if(role.equals("Sinh viên") || role.equals("Giảng viên") || role.equals("Admin"))
			this.role = role;
	}
}
