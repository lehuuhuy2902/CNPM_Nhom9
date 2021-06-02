package model;

public class User {
	private String username;
	private String password;
	private int status;
	public User(String username, String password, int status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public boolean checkLogin(String username, String password){
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}
		return false;	
	}
	
	

}
