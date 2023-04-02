package at.paulh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {
	private static final String host = "localhost";
	private static final String port = "3306";
	private static final String database = "mysql.test";
	private static final String password = "";
	private static final String username = "roor";
	
	
	private static Connection con;
	
	public static boolean isConnected() {
		return(con == null ? false : true);
	}
	
	public static void connect() throws ClassNotFoundException {
		
		if(!isConnected()) {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[MySQL] Verbunden!");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[MySQL] Verbindung Geschlossen!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void update(String query) {
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
