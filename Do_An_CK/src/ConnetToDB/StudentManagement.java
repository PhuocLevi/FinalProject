package ConnetToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.*;

public class StudentManagement {
	public static ArrayList<HocSinh> getDS() {
		ArrayList<HocSinh> DS = null;
		try {
			 DS = new ArrayList<HocSinh>();
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "SELECT * FROM HocSinh;";
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String id, name, _class, _school, prioritycode, account, password;
				String gender;
				ToHop comb;
				
				id = rs.getString(1);
				name = rs.getString(2);
				gender = rs.getString(3);
				_class = rs.getString(4);
				_school = rs.getString(5);
				prioritycode = rs.getString(6);
				
				if (rs.getString(7).trim().equals("TN")) {
					comb = new TuNhien();
					comb.setScore(StudentManagement.getScoreByID(id));
				} else {
					comb = new XaHoi();
					comb.setScore(StudentManagement.getScoreByID(id));
				}
				account = rs.getString(8);
				password = rs.getString(9);
				
				if (id == null) id = "";
				else id = id.trim();
				
				if (name == null) name = "";
				else name = name.trim();
				
				if (gender == null)	gender = "";
				else gender = gender.trim();
				
				if (_class == null) _class = "";
				else _class = _class.trim();
				
				if (_school == null) _school = "";
				else _school = _school.trim();
				
				if (prioritycode == null) prioritycode = "";
				else prioritycode = prioritycode.trim();
				
				if (account == null) account = "";
				else account = account.trim();
				
				if (password == null) password = "";
				else password = password.trim();
				
				DS.add(new HocSinh(id, name, gender, _class, _school, prioritycode, comb, account, password));
			}
			ConnectStuDB.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return DS;
	}
	
	public static ArrayList<MonHoc> getScoreByID(String id) {
		try {
			
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "SELECT d.MonID, d.Diem FROM  HocSinh hs left join Diem d on hs.HocSinhID = d.HocSinhID WHERE hs.HocSinhID = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.isBeforeFirst()) {
				return null;
			}

			ArrayList<MonHoc> ms = new ArrayList<MonHoc>();
			
			while (rs.next()) {
				String MonID = rs.getString(1);
				MonID = MonID.trim();
				double Diem = rs.getDouble(2);
				ms.add(new MonHoc(MonID,"",Diem));
			}
			
			ConnectStuDB.closeConnection(con);
			return ms;
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean addScoreByID(String id,String tohop, ArrayList<MonHoc> mh) {
		try {
			
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "INSERT INTO Diem(HocSinhID,MonID,ToHopID,Diem) VALUES(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			int count = 0;
			for (MonHoc i : mh) {
				ps.setString(1,id);
				ps.setString(2, i.getMon_id());
				ps.setString(3,tohop);
				ps.setDouble(4, i.getDiem());
				count += ps.executeUpdate();
			}
			
			
			ConnectStuDB.closeConnection(con);
			
			return count != 0;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean updateScoreByID(String id, ArrayList<MonHoc> mh) {
		try {
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "UPDATE Diem SET Diem = ? WHERE HocSinhID = ? AND MonID = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			int count = 0;
			for (MonHoc i : mh) {
				ps.setDouble(1,i.getDiem());
				ps.setString(2,id);
				ps.setString(3,i.getMon_id());
				count += ps.executeUpdate();
			}
			
			ConnectStuDB.closeConnection(con);
			
			return count != 0;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean deleteScoreByID(String id) {
		try {
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "DELETE FROM Diem WHERE HocSinhID = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,id);
			
			int res = ps.executeUpdate();
			
			ConnectStuDB.closeConnection(con);
			
			return res != 0;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean addStu(HocSinh stu) {
		try {
				Connection con = ConnectStuDB.getConnection();
				String sql = "INSERT INTO HocSinh(HocSinhID,TenHocSinh,GioiTinh,Lop,Truong,UuTienID,ToHopID,Account,Password)"
						+ "VALUES(?,?,?,?,?,?,?,?,?);";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,stu.getHocSinhID());
				ps.setString(2, stu.getTen());
				String gender = stu.getGioitinh();
				ps.setString(3, gender);
				ps.setString(4, stu.getLop());
				ps.setString(5, stu.getTruong());
				ps.setString(6,stu.getUu_tien());
				ps.setString(7, stu.getTohop().getId());
				ps.setString(8, stu.getAccount());
				ps.setString(9, stu.getPassword());
				
				ps.executeUpdate();
				
				ConnectStuDB.closeConnection(con);
				return addScoreByID(stu.getHocSinhID(),stu.getTohop().getId(),stu.getTohop().getDSMon())
					&& AccountLogin.addAcount(stu.getAccount(),stu.getPassword() , false, stu.getHocSinhID());
				
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public static boolean updateStu(HocSinh stu, boolean change) {
		try {
			Connection con = ConnectStuDB.getConnection();
				
			String sql = "UPDATE HocSinh Set TenHocSinh = ?,GioiTinh = ?,Lop = ?,Truong = ?,UuTienID = ?,ToHopID = ?,"
					+ "Account = ?,Password = ? WHERE HocSinhID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, stu.getTen());
			String gender = stu.getGioitinh();
			ps.setString(2, gender);
			ps.setString(3, stu.getLop());
			ps.setString(4, stu.getTruong());
			ps.setString(5,stu.getUu_tien());
			ps.setString(6, stu.getTohop().getId());
			ps.setString(7, stu.getAccount());
			ps.setString(8, stu.getPassword());
			ps.setString(9,stu.getHocSinhID());
			
			ps.executeUpdate();
			
			boolean res = false;
			if (change) {
				res = changeCombination(stu.getHocSinhID(),stu.getTohop().getId(),stu.getTohop().getDSMon());
			} else {
				res = updateScoreByID(stu.getHocSinhID(), stu.getTohop().getDSMon());
			}
			return res && AccountLogin.updateAccountByID(stu.getHocSinhID(), stu.getAccount(), stu.getPassword());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	private static boolean changeCombination(String id,String tohop, ArrayList<MonHoc> mh) {
		try {
			boolean c1 = deleteScoreByID(id);
			boolean c2 = addScoreByID(id, tohop, mh);
			return (c1 && c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
 	public static boolean deleteStuByID(String id) {
		
		try {
			Connection con = ConnectStuDB.getConnection();
			
			String sql = "DELETE FROM HocSinh WHERE HocSinhID = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,id);
			
			boolean check = deleteScoreByID(id) && AccountLogin.deleteAccountByID(id);
			
			int res = ps.executeUpdate();
			
			ConnectStuDB.closeConnection(con);
			
			return (check && res > 0);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}

}