package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.User;

public class UserController {
	public UserController() {
		
	}
	
	public boolean checkLogin(String username, String password) {
		Statement s = null;
		try {
			s = ConnectionDB.connect();
			ResultSet rs = s.executeQuery("select * from user");
			while(rs.next()) {
				if(rs.getString("password").equals(password) && rs.getString("password").equals(password)){
					return true;
				}
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return false;
		
		
		
		
	}

}
