package Entity;

public class HocSinh {
	private String HocSinhID,ten,lop,truong,uu_tien,account, password;
	private String gioitinh;
	private ToHop tohop;
	
	public HocSinh(String hocSinhID, String ten,String gioitinh, String lop, String truong, String uu_tien, ToHop tohop,String account, String password) {
		this.HocSinhID = hocSinhID;
		this.ten = ten;
		this.gioitinh = gioitinh;
		this.lop = lop;
		this.truong = truong;
		this.uu_tien = uu_tien;
		this.tohop = tohop;
		this.account = account;
		this.password = password;
	}

	public String getHocSinhID() {
		return HocSinhID;
	}

	public void setHocSinhID(String hocSinhID) {
		HocSinhID = hocSinhID;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getTruong() {
		return truong;
	}

	public void setTruong(String truong) {
		this.truong = truong;
	}

	public String getUu_tien() {
		return uu_tien;
	}

	public void setUu_tien(String uu_tien) {
		this.uu_tien = uu_tien;
	}

	public ToHop getTohop() {
		return tohop;
	}

	public void setTohop(ToHop tohop) {
		this.tohop = tohop;
	}
	
	 public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Double totalScore() {
		double total = 0;
		for (MonHoc mh : tohop.getDSMon()) {
			total += mh.getDiem();
		}
		return total;
	}
	
	public String PriorityOfName() {
		String[] letters = getTen().split(" ");
		String Res = letters[letters.length-1];
		for (int i = 0; i<letters.length - 1; i++) {
			Res += letters[i];
		}
		return Res.toLowerCase();
	}
	
	public String toString() {
		return HocSinhID + " " + ten + " " + lop+ " " + truong + " " + uu_tien + " " 
		+ " " + gioitinh + " " + tohop.getId();
	}
	
}
