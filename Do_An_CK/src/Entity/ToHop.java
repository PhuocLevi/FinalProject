package Entity;

import java.util.ArrayList;

public class ToHop {
	private String id,ten;
	ArrayList<MonHoc> DSMon = new ArrayList<MonHoc>();
	
	public ToHop() {}

	public ToHop(String id, String ten, ArrayList<MonHoc> dSMon) {
		this.id = id;
		this.ten = ten;
		DSMon = dSMon;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public ArrayList<MonHoc> getDSMon() {
		return DSMon;
	}

	public void setDSMon(ArrayList<MonHoc> dSMon) {
		DSMon = dSMon;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setScore(ArrayList<MonHoc> DSMon) {
		if (this.DSMon != null) {
			for (int i = 0; i < DSMon.size(); i++) {
				for (int j = 0; j < this.DSMon.size(); j++) {
					if (DSMon.get(i).getMon_id() != null) {
						if (DSMon.get(i).getMon_id().trim().equals(this.DSMon.get(j).getMon_id().trim())) {
							this.DSMon.get(j).setDiem( DSMon.get(i).getDiem());
							break;
						}
					}
				}
			}
		}
	}
	
	public String toString() {
		String str;
		
		str = this.getTen() + ":";
		for (MonHoc mon : DSMon) {
			str += "\n" + mon;
		}
		return str;
	}
	
	public static ToHop Cast_TH(ToHop th) {
		
		ToHop Res = null;
		
		if (th.getId().equals("TN")) {
			Res = new XaHoi();
			
			ArrayList<MonHoc> DSMon = th.getDSMon();
			
			DSMon.get(3).setMon_id("su");
			DSMon.get(3).setTen("Lich su");
			
			DSMon.get(4).setMon_id("dia");
			DSMon.get(4).setTen("Dia ly");
			
			DSMon.get(5).setMon_id("gdcd");
			DSMon.get(5).setTen("Giao duc cong dan");
			
			Res.setDSMon(DSMon);
		} else {
			Res = new TuNhien();
			
			ArrayList<MonHoc> DSMon = th.getDSMon();
			
			DSMon.get(3).setMon_id("ly");
			DSMon.get(3).setTen("Vat ly");
			
			DSMon.get(4).setMon_id("hoa");
			DSMon.get(4).setTen("Hoa hoc");
			
			DSMon.get(5).setMon_id("sinh");
			DSMon.get(5).setTen("Sinh hoc");
			
			Res.setDSMon(DSMon);
		}
		
		return Res;
	}
	
}
