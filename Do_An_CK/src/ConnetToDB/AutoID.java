package ConnetToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AutoID {
	public static String lastID() {
		String LastID = null;
		Connection con = ConnectStuDB.getConnection();
		try {
			String sql = "SELECT HocSinhID FROM HocSinh ORDER BY HocSinhID DESC;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				LastID = rs.getString(1);
			}
			
			ConnectStuDB.closeConnection(con);
			return LastID;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ConnectStuDB.closeConnection(con);
		return LastID;
	}
	
	public static String nextID() {
		String id = lastID();
		String res = null;
		
		if (id != null) {
			id = id.trim();
			String chars = id.replaceAll("[0-9]","");
			String numbers = id.replaceAll("[^0-9]", "");
			
			int NumID = Integer.parseInt(numbers);
			NumID++;
			
			numbers = Integer.toString(NumID);
			
			id = numbers.substring(0,2) + chars + numbers.substring(2);
			res = id;
		} else {
			res = "24HS001";
		}
		return res;
	}
}
