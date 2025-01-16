package Entity;

public class MonHoc {
	private String mon_id, ten;
	private double diem;
	
	public MonHoc() {}

	public MonHoc(String mon_id, String ten, double diem) {
		this.mon_id = mon_id;
		this.ten = ten;
		this.diem = diem;
	}

	public String getMon_id() {
		return mon_id;
	}

	public void setMon_id(String mon_id) {
		this.mon_id = mon_id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}
	
	public String toString() {
		
		String str = Double.toString(this.getDiem());
		
		if (this.getDiem() < 0) {
			str = "null";
		}
		
		return this.getMon_id()+":"+ this.getTen() + ": " + str;
	}
}
