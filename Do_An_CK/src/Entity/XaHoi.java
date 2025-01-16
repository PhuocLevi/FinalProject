package Entity;

import java.util.ArrayList;

public class XaHoi extends ToHop {
	public XaHoi() {
		super();
		ArrayList<MonHoc> tohop = new ArrayList<MonHoc>();
		tohop.add(new MonHoc("toan","Toan",0));
		tohop.add(new MonHoc("van","Ngu van",0));
		tohop.add(new MonHoc("anh","Anh van",0));
		tohop.add(new MonHoc("su","Lich su",0));
		tohop.add(new MonHoc("dia","Dia ly",0));
		tohop.add(new MonHoc("gdcd","Giao duc cong dan",0));
		
		super.setId("XH");
		super.setTen("Xa hoi");
		super.setDSMon(tohop);
	}
}
