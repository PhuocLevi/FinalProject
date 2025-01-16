package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Entity.HocSinh;

import java.awt.*;
import java.util.ArrayList;

public class center1UI extends JPanel {
	
	public DefaultTableModel tbm;
	public JTable table;
	public JScrollPane scroll;
	public center1UI() {
		super();
		setLayout(null);
		setBounds(5,45,695,550);
		des();
	}
	
	public void des() {
		tbm = new DefaultTableModel(new Object[] {"Student ID","Student Name","Gender","Class name","School Name", "Priority code","Combination"} ,0);
		table = new JTable(tbm);
		scroll = new JScrollPane(table);
		scroll.setBounds(5,5,685,540);
		add(scroll);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void showDS(ArrayList<HocSinh> DS) {
		
		for (HocSinh hs : DS) {
			addTableRow(hs);
		}
	}
	
	public void addTableRow(HocSinh hs) {
		Object[] data = new Object[7];
		data[0] = hs.getHocSinhID();
		data[1] = hs.getTen();
		data[2] = hs.getGioitinh();
		data[3] = hs.getLop();
		data[4] = hs.getTruong();
		data[5] = hs.getUu_tien();
		data[6] = hs.getTohop().getId();
		tbm.addRow(data);
	}
	
	public void setValueRow(int row, HocSinh hs) {
		table.setValueAt(hs.getHocSinhID(), row, 0);
		table.setValueAt(hs.getTen(), row, 1);
		table.setValueAt(hs.getGioitinh(), row, 2);
		table.setValueAt(hs.getLop(), row, 3);
		table.setValueAt(hs.getTruong(), row, 4);
		table.setValueAt(hs.getUu_tien(), row, 5);
		table.setValueAt(hs.getTohop().getId(), row, 6);
	}
	
	public Object[] getTableRow(int row) {
		Object[] res = new Object[tbm.getColumnCount()];
		
		for (int i = 0 ;i<tbm.getColumnCount(); i++) {
			res[i] = tbm.getValueAt(row, i);
		}
		return res;
	}
	
	public void deleteRow(int index) {
		if (index != -1)
		tbm.removeRow(index);
	}
	
	
	
}
