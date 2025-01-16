package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ConnetToDB.*;
import Entity.*;


public class AdminController {
	
	private AdminUI view;
	private ArrayList<HocSinh> DS;
	
	public AdminController(AdminUI view) {
		this.view = view;
		addListener();
		addTableAction();
		addDocumentListener();
		DS = StudentManagement.getDS();
		view.c1.showDS(DS);
		view.c2.showDS(DS);
		view.c3.showDS(DS);
	}
	
	public void addListener() {
		view.top.outBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null,"Sign out?");
				if (select == 0) {
					new LoginUI();
					view.dispose();
				}
			}
		});
		
		view.left.tabInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.butArea.newBut.setEnabled(true);
				view.butArea.delete.setEnabled(true);
				view.butArea.edit.setEnabled(true);
				view.butArea.addBut.setEnabled(false);
				view.butArea.clearBut.setEnabled(false);
				
				int index = 0;
				
				if (view.c2.isVisible()) {
					index = view.c2.table.getSelectedRow();
					if (index != -1) {
						Object[] data2 = view.c2.getTableRow(index);
						for (int i = 0; i<view.c1.table.getRowCount(); i++) {
							Object[] data1 = view.c1.getTableRow(i);
							if (data1[0].equals(data2[0])) {
								index = i;
								break;
							}
						}
					}
				} else {
					index = view.c3.table.getSelectedRow();
					if (index != -1) {
						Object[] data3 = view.c3.getTableRow(index);
						for (int i = 0; i<view.c1.table.getRowCount(); i++) {
							Object[] data1 = view.c1.getTableRow(i);
							if (data1[0].equals(data3[0])) {
								index = i;
								break;
							}
						}
					}
				}
				
				if (index != -1) {
				view.c1.table.setRowSelectionInterval(index, index);
				view.c1.table.scrollRectToVisible(view.c1.table.getCellRect(index, 0, true));
				}
				view.useInfoPanel();
			}
		});
		
		view.left.tabAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.butArea.newBut.setEnabled(false);
				view.butArea.delete.setEnabled(true);
				view.butArea.edit.setEnabled(true);
				view.butArea.addBut.setEnabled(false);
				view.butArea.clearBut.setEnabled(false);

				int index = 0;
				if (view.c1.isVisible()) {
					index = view.c1.table.getSelectedRow();
					if (index != -1) {
						Object[] data1 = view.c1.getTableRow(index);
						for (int i = 0; i<view.c2.table.getRowCount(); i++) {
							Object[] data2 = view.c2.getTableRow(i);
							if (data1[0].equals(data2[0])) {
								index = i;
								break;
							}
						}
					}
				} else {
					index = view.c3.table.getSelectedRow();
					if (index != -1) {
						Object[] data3 = view.c3.getTableRow(index);
						for (int i = 0; i<view.c2.table.getRowCount(); i++) {
							Object[] data2 = view.c2.getTableRow(i);
							if (data2[0].equals(data3[0])) {
								index = i;
								break;
							}
						}
					}
				}
				
				if (index != -1) {
				view.c2.table.setRowSelectionInterval(index, index);
				view.c2.table.scrollRectToVisible(view.c1.table.getCellRect(index, 0, true));
				}
				
				view.useAccPanel();
			}
		});
		
		view.left.tabScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.butArea.newBut.setEnabled(false);
				view.butArea.addBut.setEnabled(false);
				view.butArea.delete.setEnabled(false);
				view.butArea.clearBut.setEnabled(false);

				String comb = "TN";
				int index = 0;
				if (view.c1.isVisible()) {
					index = view.c1.table.getSelectedRow();
					if (index != -1) {
						Object[] data1 = view.c1.getTableRow(index);
						for (int i = 0; i<view.c3.table.getRowCount(); i++) {
							Object[] data3 = view.c3.getTableRow(i);
							if (data1[0].equals(data3[0])) {
								index = i;
								comb = (String) data1[6];
								break;
							}
						}
					}
				} else {
					index = view.c2.table.getSelectedRow();
					if (index != -1) {
						Object[] data2 = view.c2.getTableRow(index);
						for (int i = 0; i<view.c3.table.getRowCount(); i++) {
							Object[] data3 = view.c3.getTableRow(i);
							if (data2[0].equals(data3[0])) {
								index = i;
								break;
							}
						}
						
						Object[] data3 = view.c3.getTableRow(index);
						for (int i = 0; i<view.c1.table.getRowCount(); i++) {
							Object[] data1 = view.c1.getTableRow(i);
							if (data3[0].equals(data1[0])) {
								comb = (String) data1[6];
								break;
							}
						}
						
					}
				}
				
				if (index != -1) {
				view.c3.table.setRowSelectionInterval(index, index);
				view.c3.table.scrollRectToVisible(view.c1.table.getCellRect(index, 0, true));
					if (comb.equals("TN")) {
						view.r3.useNaturalScore();
					} else {
						view.r3.useSocialScore();
					}
				}
				
				view.useScorePanel();
			}
		});
		
		view.search.ClearBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.search.searchField.setText("");
			}
		});
		
		view.left.statistical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				statisticalUI statis = new statisticalUI();
				statis.updateData(DS);
			}
		});
		
		view.butArea.newBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.left.noUseLeft();
				view.butArea.newBut.setEnabled(false);
				view.butArea.addBut.setEnabled(true);
				view.butArea.clearBut.setEnabled(true);
				view.butArea.delete.setEnabled(false);
				view.butArea.edit.setEnabled(false);
				view.r1.UnHide();
				view.butArea.clearBut.doClick();
				view.r1.idField.setText(AutoID.nextID());
			}
		});
		
		view.butArea.addBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.c1.isVisible()) {
					Object[] data = view.r1.getField();
					if (data == null) {
						JOptionPane.showMessageDialog(null,"Fields cannot be left blank!","Thong bao!",JOptionPane.ERROR_MESSAGE);
						return ;
					}
					
					if (checkIdIsExist((String)data[0], null)) {
						JOptionPane.showMessageDialog(null,"Id already exists","Thong bao!",JOptionPane.ERROR_MESSAGE);
						return ;
					}
					
					view.r1.clearID();
					ToHop comb;
					
					if (data[6].equals("TN")) {
						comb = new TuNhien();
					} else {
						comb = new XaHoi();
					}
					
					HocSinh hs = new HocSinh((String) data[0],(String) data[1],(String) data[2],(String) data[3],
							(String) data[4],(String) data[5],comb,"","");
					if (StudentManagement.addStu(hs)) {
						DS.add(hs);
						view.c1.addTableRow(hs);
						view.c2.addTableRow(hs);
						view.c3.addTableRow(hs);
					}
					
				} else if (view.c2.isVisible()) {
					Object[] data = view.r2.getField();
					
					if (data == null) {
						JOptionPane.showMessageDialog(null,"Fields cannot be left blank!","Thong bao!",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					ToHop comb = new TuNhien();
					HocSinh hs = new HocSinh((String) data[0],(String) data[1],(String) data[2],(String) data[3],
							"","",comb,(String) data[4],(String) data[5]);
					
					if(StudentManagement.addStu(hs)) {
						DS.add(hs);
						view.c1.addTableRow(hs);
						view.c2.addTableRow(hs);
						view.c3.addTableRow(hs);						
					}
				}
				view.butArea.clearBut.doClick();
				view.butArea.clearBut.setEnabled(false);
				
				view.r1.Hide();
				view.left.UseLeft();
				view.butArea.newBut.setEnabled(true);
				view.butArea.edit.setEnabled(true);
				view.butArea.addBut.setEnabled(false);
				view.butArea.delete.setEnabled(true);
			}
		});
		
		view.butArea.edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.butArea.edit.setVisible(false);
				view.butArea.done.setVisible(true);
				view.butArea.clearBut.setEnabled(true);
				view.left.noUseLeft();
				view.butArea.newBut.setEnabled(false);
				view.butArea.delete.setEnabled(false);
				view.butArea.addBut.setEnabled(false);
				
				if (view.c1.isVisible()) {
					view.r1.UnHide();
				} else if (view.c2.isVisible()) {
					view.r2.UnHide();
				} else {
					view.r3.UnHide();
				}
				
			}
		});
		
		view.butArea.done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if (view.c1.isVisible()) {
					
					int index1 = view.c1.table.getSelectedRow();
					
					if (index1 != -1) {
						
						String id1 = (String) view.c1.table.getValueAt(index1,0);
						Object[] data1 = view.r1.getField();
						
						if (data1 == null) {
							JOptionPane.showMessageDialog(null,"Fields cannot be left blank!","Thong bao!",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						if (data1 != null) {
							String name = (String) data1[1],gender = (String) data1[2], Class = (String) data1[3] , School = (String) data1[4],
									priority = (String) data1[5],_comb = (String) data1[6];
//							id,name,gender,_class,_school,prioritycode,combination
							
							String acc = "", pass = "";
							ToHop comb = null;
							
							boolean change = false;
							for (HocSinh hs : DS) {
								if (id1.equals(hs.getHocSinhID())) {
									acc = hs.getAccount();
									pass = hs.getPassword();
									
									if (_comb.equals(hs.getTohop().getId())) {
										comb = hs.getTohop();
									} else {
										comb = ToHop.Cast_TH(hs.getTohop());
										change = true;
									}
								}
							}
							
							HocSinh hs = new HocSinh(id1, name,gender,Class, School,
									priority, comb, acc, pass);
							if (StudentManagement.updateStu(hs,change)) {
								view.c1.setValueRow(index1, hs);
								
								int index2 = -1, index3 = -1;
								boolean check2 = false, check3 = false;
								for (int i = 0; i < view.c3.table.getRowCount(); i++) {
									String id2 = (String) view.c2.table.getValueAt(i,0), id3 = (String) view.c3.table.getValueAt(i,0);
									if (!check2 && id1.equals(id2.trim())) {
										index2 = i;
										check2 = true;
									}
									
									if (!check3 && id1.equals(id3.trim())) {
										index3 = i;
										check3 = true;
									}
									
									if (check2 && check3) {
										break;
									}
								}
								view.c2.setValueRow(index2, hs);
								view.c3.setValueRow(index3, hs);
								for (int i = 0; i < DS.size(); i++) {
									if (hs.getHocSinhID().trim().equals(DS.get(i).getHocSinhID().trim())) {
										DS.set(i,hs);
										break;
									}
								}
							}
						}
					}
					
				} else if (view.c2.isVisible()) {
					int index2 = view.c2.table.getSelectedRow();
					
					if (index2 != -1) {
						String id2 = (String) view.c2.table.getValueAt(index2,0);
						Object[] data2 = view.r2.getField();
						
						if (data2 != null) {
							String name = (String) data2[1], Class = (String) data2[2] , School = (String) data2[3], acc = (String) data2[4], pass = (String) data2[5];
//							id, name, _class, _school, account, password
							String last_acc = (String) view.c2.table.getValueAt(index2, 4);
							if (checkAccountIsExist(acc,last_acc)) {
								JOptionPane.showMessageDialog(null,"Account already exists","Thong bao!",JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							String gender = "",priority = "";
							ToHop comb = null;
							
							for (HocSinh hs : DS) {
								if (id2.equals(hs.getHocSinhID())) {
									gender = hs.getGioitinh();
									priority = hs.getUu_tien();
									comb = hs.getTohop();
								}
							}
							
							HocSinh hs = new HocSinh(id2, name,gender,Class, School,
									priority, comb, acc, pass);
							if (StudentManagement.updateStu(hs,false)) {
								view.c2.setValueRow(index2, hs);
								
								int index1 = -1, index3 = -1;
								boolean check1 = false, check3 = false;
								for (int i = 0; i < view.c3.table.getRowCount(); i++) {
									String id1 = (String) view.c1.table.getValueAt(i,0), id3 = (String) view.c3.table.getValueAt(i,0);
									if (!check1 && id2.equals(id1.trim())) {
										index1 = i;
										check1 = true;
									}
									
									if (!check3 && id2.equals(id3.trim())) {
										index3 = i;
										check3 = true;
									}
									
									if (check1 && check3) {
										break;
									}
								}
								view.c1.setValueRow(index1, hs);
								view.c3.setValueRow(index3, hs);
								for (int i = 0; i < DS.size(); i++) {
									if (hs.getHocSinhID().trim().equals(DS.get(i).getHocSinhID().trim())) {
										DS.set(i,hs);
										break;
									}
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,"Fields cannot be left blank!","Thong bao!",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				} else {
					int index3 = view.c3.table.getSelectedRow();
					
					if (index3 != -1) {
						String id3 = (String) view.c3.table.getValueAt(index3,0);
						id3 = id3.trim();
						
						String gender = "", priority = "", acc = "", pass = "";
						ToHop comb = null;
						
						for (HocSinh hs : DS) {
							if ( id3.equals(hs.getHocSinhID().trim()) ) {
								gender = hs.getGioitinh();
								priority = hs.getUu_tien();
								acc = hs.getAccount();
								pass = hs.getPassword();
								comb = hs.getTohop();
								break;
							}
						}
						
						Object[] data3 = view.r3.getField(comb.getId().trim().equals("TN"));
						
						if (data3 == null) {
							JOptionPane.showMessageDialog(null,"Fields cannot be left blank!","Thong bao!",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						ArrayList<MonHoc> DSMon = new ArrayList<MonHoc>();
						
						DSMon.add(new MonHoc("toan",null, Double.parseDouble( (String) data3[4] )));
						DSMon.add(new MonHoc("van",null, Double.parseDouble( (String) data3[5] )));
						DSMon.add(new MonHoc("anh",null, Double.parseDouble( (String) data3[6] )));
						
						if (comb.getId().trim().equals("TN")) {
							DSMon.add(new MonHoc("ly",null, Double.parseDouble( (String) data3[7] )));
							DSMon.add(new MonHoc("hoa",null, Double.parseDouble( (String) data3[8] )));
							DSMon.add(new MonHoc("sinh",null, Double.parseDouble( (String) data3[9] )));
						} else {
							DSMon.add(new MonHoc("su",null, Double.parseDouble( (String) data3[7] )));
							DSMon.add(new MonHoc("dia",null, Double.parseDouble( (String) data3[8] )));
							DSMon.add(new MonHoc("gdcd",null, Double.parseDouble( (String) data3[9] )));
						}
						comb.setScore(DSMon);
						HocSinh hs = new HocSinh((String) data3[0], (String) data3[1],gender,(String)data3[2], (String) data3[3],
								priority, comb, acc, pass);
						
						if (StudentManagement.updateStu(hs,false)) {
							view.c3.setValueRow(index3, hs);
							
							int index1 = -1, index2 = -1;
							boolean check1 = false, check2 = false;
							for (int i = 0; i < view.c3.table.getRowCount(); i++) {
								String id1 = (String) view.c1.table.getValueAt(i,0), id2 = (String) view.c2.table.getValueAt(i,0);
								if (!check1 && id3.equals(id1.trim())) {
									index1 = i;
									check1 = true;
								}
								
								if (!check2 && id3.equals(id2.trim())) {
									index2 = i;
									check2 = true;
								}
								
								if (check1 && check2) {
									break;
								}
							}
							view.c1.setValueRow(index1, hs);
							view.c2.setValueRow(index2, hs);
							for (int i = 0; i < DS.size(); i++) {
								if (hs.getHocSinhID().trim().equals(DS.get(i).getHocSinhID().trim())) {
									DS.set(i,hs);
									break;
								}
							}
						}
					}
				}
				view.butArea.edit.setVisible(true);
				view.butArea.done.setVisible(false);
				view.butArea.clearBut.setEnabled(false);
				view.left.UseLeft();
				if (!view.c3.isVisible()) {					
					view.butArea.newBut.setEnabled(true);
					view.butArea.delete.setEnabled(true);
				}
				
				if (view.c1.isVisible()) {
					view.r1.Hide();
				} else if (view.c2.isVisible()) {
					view.r2.Hide();
				} else {
					view.r3.Hide();
				}
			}
		});
		
		view.butArea.clearBut.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.c1.isVisible()) {
					view.r1.clearField();
				} else if (view.c2.isVisible()) {
					view.r2.clearField();
				} else {
					view.r3.clearField();
				}
			}
		});
		
		view.butArea.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.c1.table.getRowCount() != 0) {
					int index;
					if (view.c1.isVisible()) {
						index = view.c1.table.getSelectedRow();
						if (index != -1) {
							String id =(String) view.c1.table.getValueAt(index,0);
							
							if (StudentManagement.deleteStuByID(id)) {
								view.c1.deleteRow(index);
								
								for (int i = 0; i < DS.size(); i++) {
									if (id.equals(DS.get(i).getHocSinhID())) {
										DS.remove(i);
										break;
									}
								}
								
								int indexT2 = -1, indexT3 = -1;
								boolean check2 = false, check3 = false;
								for (int i = 0; i < view.c2.table.getRowCount(); i++) {
									Object idT2 = view.c2.table.getValueAt(i,0),
										   idT3 = view.c3.table.getValueAt(i,0);
										if (idT2.equals(id) && !check2) {
											indexT2 = i;
											check2 = true;
										}
										if (idT3.equals(id) && !check3) {
											indexT3 = i;
											check3 = true;
										}
										if (check2 && check3) break;
								}
								
								if (indexT2 != -1 && indexT3 != -1) {
								view.c2.deleteRow(indexT2); 
								view.c3.deleteRow(indexT3);
								}
							}
						}
					} else if (view.c2.isVisible()) {
						index = view.c2.table.getSelectedRow();
						if (index != -1) { 	
							String id =(String) view.c2.table.getValueAt(index,0);
							if (StudentManagement.deleteStuByID(id)) {
								view.c2.deleteRow(index);
								
								for (int i = 0; i < DS.size(); i++) {
									if (id.equals(DS.get(i).getHocSinhID())) {
										DS.remove(i);
										break;
									}
								}
								
								int indexT1 = -1, indexT3 = -1;
								boolean check1 = false, check3 = false;
								for (int i = 0; i < view.c1.table.getRowCount(); i++) {
									Object idT1 = view.c1.table.getValueAt(i,0),
										   idT3 = view.c3.table.getValueAt(i,0);
										if (idT1.equals(id) && !check1) {
											indexT1 = i;
											check1 = true;
										}
										if (idT3.equals(id) && !check3) {
											indexT3 = i;
											check3 = true;
										}
										if (check1 && check3) break;
								}
								if (indexT1 != -1 && indexT3 != -1) {
								view.c1.deleteRow(indexT1);
								view.c3.deleteRow(indexT3);
								}
							}
						}
					}
				}
			}
		});
		
		view.search.SortBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String select = (String) view.search.SortBox.getSelectedItem();
				
				if (select.equals("ID")) SortDS(1);
				if (select.equals("Name")) SortDS(2);
				if (select.equals("Score")) SortDS(3);
				
				view.c1.tbm.setRowCount(0);
				view.c2.tbm.setRowCount(0);
				view.c3.tbm.setRowCount(0);
				view.c1.showDS(DS);
				view.c2.showDS(DS);
				view.c3.showDS(DS);
			}
		});
	}
	private void SortDS(int option) {
		if (option == 1) {
			DS.sort((a,b) -> a.getHocSinhID().compareTo(b.getHocSinhID()));
			return;
		}
		if (option == 2) {
			DS.sort((a,b) -> a.PriorityOfName().compareTo(b.PriorityOfName()));
			return;
		}
		if (option == 3) {
			DS.sort((a,b) -> Double.compare(b.totalScore(),a.totalScore()));
			return;
		}
	}
	
	public void addTableAction() {
		
		view.c1.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = view.c1.table.getSelectedRow();
				if (index!=-1) {
					view.r1.show(view.c1.getTableRow(index));
				}
			}
		});
		
		view.c2.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = view.c2.table.getSelectedRow();
				if (index!=-1) {
					view.r2.show(view.c2.getTableRow(index));
				}
			}
		});
		
		view.c3.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = view.c3.table.getSelectedRow();
				String comb = null;
				Object[] scores = new Object[6];
				if (index!=-1) {
					view.r3.show(view.c3.getTableRow(index));
					String id = (String) view.c3.table.getValueAt(index,0);
					
					for (int i = 0; i < DS.size(); i++) {
						String id1 = DS.get(i).getHocSinhID();
						if (id.equals(id1)) {
							comb = DS.get(i).getTohop().getId();
							scores[0] = (Object) Double.toString(DS.get(i).getTohop().getDSMon().get(0).getDiem());
							scores[1] = (Object) Double.toString(DS.get(i).getTohop().getDSMon().get(1).getDiem());
							scores[2] =	(Object) Double.toString(DS.get(i).getTohop().getDSMon().get(2).getDiem());
							scores[3] =	(Object) Double.toString(DS.get(i).getTohop().getDSMon().get(3).getDiem());
							scores[4] = (Object) Double.toString(DS.get(i).getTohop().getDSMon().get(4).getDiem());
							scores[5] = (Object) Double.toString(DS.get(i).getTohop().getDSMon().get(5).getDiem());
							break;
						}
					}
					
					if (comb.equals("TN")) {
						view.r3.useNaturalScore();
						view.r3.showScore(true, scores);
					} else {
						view.r3.useSocialScore();
						view.r3.showScore(false, scores);
					}
					
				}
			}
		});
		
	}
	
	public void addDocumentListener() {
		view.search.searchField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				SearchAction();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				SearchAction();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				SearchAction();
			}
		});
	}
	
	private void SearchAction() {
		String Keyword = view.search.searchField.getText().toLowerCase();
		if (!Keyword.isEmpty()) {
		ArrayList<HocSinh> Ds = Search(Keyword);
		view.c1.tbm.setRowCount(0);
		view.c2.tbm.setRowCount(0);
		view.c3.tbm.setRowCount(0);
		view.c1.showDS(Ds);
		view.c2.showDS(Ds);
		view.c3.showDS(Ds);
		} else {
			view.c1.tbm.setRowCount(0);
			view.c2.tbm.setRowCount(0);
			view.c3.tbm.setRowCount(0);
			view.c1.showDS(DS);
			view.c2.showDS(DS);
			view.c3.showDS(DS);
		}
	}
	
	private ArrayList<HocSinh> Search(String keyword){
		ArrayList<HocSinh> students = new ArrayList<HocSinh>();
		
		for (HocSinh hs : DS) {
			 if (hs.toString().toLowerCase().contains(keyword)) {
				 students.add(hs);
			 }
		}
		return students;
	}
	
	private boolean checkAccountIsExist(String acc, String last_acc) {
		if (acc.equals(last_acc)) return false; 
		for (HocSinh hs : DS) {
			if (acc.equals(hs.getAccount())) return true;
		}
		return false;
	}
	
	private boolean checkIdIsExist(String id, String last_id) {
		if (id.equals(last_id)) return false; 
		for (HocSinh hs : DS) {
			if (id.equals(hs.getHocSinhID())) return true;
		}
		return false;
	}
	
}
