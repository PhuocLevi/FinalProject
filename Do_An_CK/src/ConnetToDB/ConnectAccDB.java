package ConnetToDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectAccDB {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=Account;encrypt=true;trustServerCertificate=true;";
			String user = "demo";
			String pass = "123456";
			
			con = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
