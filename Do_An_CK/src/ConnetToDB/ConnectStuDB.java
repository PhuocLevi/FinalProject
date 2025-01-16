package ConnetToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectStuDB {
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLi;encrypt=true;trustServerCertificate=true;";
		String user = "demo";
		String pass = "123456";
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
