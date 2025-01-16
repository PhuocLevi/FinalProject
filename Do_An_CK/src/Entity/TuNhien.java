package Entity;

import java.util.ArrayList;

public class TuNhien extends ToHop{
	public TuNhien() {
		super();
		ArrayList<MonHoc> tohop = new ArrayList<MonHoc>();
		tohop.add(new MonHoc("toan","Toan",0));
		tohop.add(new MonHoc("van","Ngu van",0));
		tohop.add(new MonHoc("anh","Anh van",0));
		tohop.add(new MonHoc("ly","Vat ly",0));
		tohop.add(new MonHoc("hoa","Hoa hoc",0));
		tohop.add(new MonHoc("sinh","Sinh hoc",0));
		super.setId("TN");
		super.setTen("Tu nhien");
		super.setDSMon(tohop);
	}
}
