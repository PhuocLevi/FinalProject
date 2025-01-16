package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.HocSinh;
import Entity.MonHoc;
import Entity.ToHop;
import Entity.TuNhien;

import java.awt.*;
import java.util.ArrayList;

public class center3UI extends JPanel {

	public DefaultTableModel tbm;
	public JTable table;
	public JScrollPane scroll;
	
	public center3UI() {
		super();
		setLayout(null);
		setBounds(5,45,695,550);
		des();
	}
	
	public double TotalScore(Object [] scores) {
		double Total = 0;
 		for (int i = 0; i<scores.length; i++) {
			Total += Double.parseDouble((String)scores[i]);
		}
 		
		return (double)Math.round(Total*10000)/10000;
	}
	
	public void des() {
		tbm = new DefaultTableModel(new Object[] {"Student ID","Student Name","Class Name","School Name","Combination","Total Score", "Pass?"} ,0);
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
		data[2] = hs.getLop();
		data[3] = hs.getTruong();
		data[4] = hs.getTohop().getId();
		
		Object[] scores = new Object[6];
		for (int i = 0; i < 6; i++) {
			scores[i] = Double.toString(hs.getTohop().getDSMon().get(i).getDiem()) ;
		}
		data[5] = TotalScore(scores);
		data[6] = checkScore(scores)?"pass":"fail";
		tbm.addRow(data);
	}
	
	public boolean checkScore(Object[] data) {
		if (TotalScore(data) < 5) return false;
		for (int i = 0; i < data.length; i++) {
			if (Double.parseDouble( (String) data[i]) < 1) return false;
		}
		return true;
	}
	
	public void setValueRow(int row, HocSinh hs) {
		table.setValueAt(hs.getHocSinhID(), row, 0);
		table.setValueAt(hs.getTen(), row, 1);
		table.setValueAt(hs.getLop(), row, 2);
		table.setValueAt(hs.getTruong(), row, 3);
		table.setValueAt(hs.getTohop().getId(), row, 4);
		
		Object[] scores = new Object[6];
		for (int i = 0; i < 6; i++)
		scores[i] = Double.toString(hs.getTohop().getDSMon().get(i).getDiem());
		
		table.setValueAt(TotalScore(scores), row, 5);
		table.setValueAt(checkScore(scores)?"pass":"fail", row, 6);
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
