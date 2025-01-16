package ConnetToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountLogin {
	public static boolean checkAccount(String username, String pass, boolean type) {
		Connection con = ConnectAccDB.getConnection();
		if (con != null) {
			String query = "SELECT * FROM ACCOUNT WHERE TaiKhoan = '" + username +"';";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if (!rs.isBeforeFirst()) {
					ConnectAccDB.closeConnection(con);
					return false;
				} else {
					rs.next();
					boolean res = pass.equals(rs.getString("MatKhau").trim()) && (type == rs.getBoolean("Loai"));
					ConnectAccDB.closeConnection(con);
					return res;
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;
	}
	
	public static boolean addAcount(String username, String pass, boolean type,String id) {
		if (checkAccount(username, pass, type)) {
			return false;
		}
		try {
			Connection con = ConnectAccDB.getConnection();
			String addValue = "Insert into account(Taikhoan, Matkhau, Loai, UserID) values (?,?,?,?)";
			try {
			PreparedStatement ps = con.prepareStatement(addValue);
			
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setBoolean(3, type);
			ps.setString(4, id);
			ps.executeUpdate();
			
			if (ps != null) ps.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			ConnectAccDB.closeConnection(con);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateAccountByID(String id,String account,String password) {
			try {
				Connection con = ConnectAccDB.getConnection();
				String sql = "UPDATE Account SET TaiKhoan = ?, MatKhau = ? WHERE UserID = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, account);
				ps.setString(2, password);
				ps.setString(3, id);
				
				int updateRow = ps.executeUpdate();
				ConnectAccDB.closeConnection(con);
				return ( updateRow == 1 );
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return false;
	}
	
	public static boolean deleteAccountByID(String id) {
		try {
			Connection con = ConnectAccDB.getConnection();
			
			String sql = "DELETE FROM Account WHERE UserID = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			int res = ps.executeUpdate();
			
			ConnectAccDB.closeConnection(con);
			return res != 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		return false;
	}
}
