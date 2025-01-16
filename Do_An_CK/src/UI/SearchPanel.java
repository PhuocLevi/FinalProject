package UI;

import java.awt.*;

import javax.swing.*;

import Entity.HocSinh;

public class SearchPanel extends JPanel{
	JButton ClearBut;
	JTextField searchField;
	JComboBox<String> SortBox;
	
	public SearchPanel() {
		super();
		des();
	}
	
	private void des() {
		setLayout(null);
		setBounds(10,10,685,30);
		
		JLabel searchLabel = new JLabel("Search");
		searchLabel.setBounds(0, 0, 40, 30);
		
		searchField = new JTextField();
		searchField.setBounds(45,0,405,30);
		
		ClearBut = new JButton("Clear");
		ClearBut.setBounds(450,0,90,30);
		
		String[] sortField = {"ID","Name","Score"};
		
		JLabel sortLabel = new JLabel("Sort by");
		sortLabel.setBounds(555,0,40,30);
		
		SortBox = new JComboBox<>(sortField);
		SortBox.setBounds(610,0,70,30);
		
		
		add(searchLabel);
		add(searchField);
		add(ClearBut);
		add(sortLabel);
		add(SortBox);
	}
}
