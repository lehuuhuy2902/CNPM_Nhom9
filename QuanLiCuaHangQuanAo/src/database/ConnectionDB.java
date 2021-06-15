package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	static Connection con;
    public static Statement connect() throws SQLException, ClassNotFoundException {
        if (con==null||con.isClosed()){
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/qlcuahangquanao1","root","");
            return con.createStatement();
        }
        else {
            return con.createStatement();
        }

    }
    
    public static PreparedStatement connect(String sql) throws SQLException, ClassNotFoundException {
        if (con==null||con.isClosed()){
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/qlcuahangquanao1","root","");
            return con.prepareStatement(sql);
        }
        else {
            return con.prepareStatement(sql);
        }

    }
    
    public static Connection connectDB() {
		Connection con = null;
		try {
			String dbURL = "jdbc:mysql://localhost:3306/qlcuahangquanao";
			String username = "root";
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,username,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
    

}
