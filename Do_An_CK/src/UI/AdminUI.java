package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class AdminUI extends JFrame {
	
	String nameAdmin;
	public JPanel centerPanel, rightPanel;
	public topUI top;
	public leftUI left;
	public center1UI c1;
	public center2UI c2;
	public center3UI c3;
	public SearchPanel search;
	
	public right1UI r1 = new right1UI();
	public right2UI r2 = new right2UI();
	public right3UI r3 = new right3UI();
	
	public buttonArea butArea = new buttonArea();
	
	public AdminUI(String nameAdmin) {
		super("Admin");
		setSize(1300,700);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.nameAdmin = nameAdmin;
		
		des();
		
		setVisible(true);
	}
	
	public void des() {
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBounds(175,60,705,600);
		centerPanel.setBorder(new LineBorder(Color.black));
		
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(885,60,400,600);
		
		top = new topUI(nameAdmin);
		left = new leftUI();
		c1 = new center1UI();
		c2 = new center2UI();
		c3 = new center3UI();
		search = new SearchPanel();
		
		centerPanel.add(c1);
		centerPanel.add(c2);
		centerPanel.add(c3);
		centerPanel.add(search);
		
		r1 = new right1UI();
		r2 = new right2UI();
		r3 = new right3UI();
		
		
		rightPanel.add(r1);
		rightPanel.add(r2);
		rightPanel.add(r3);
		
		r1.add(butArea);
		
		c2.setVisible(false);
		c3.setVisible(false);
		r2.setVisible(false);
		r3.setVisible(false);
		
		add(top);
		add(left);
		add(centerPanel);
		add(rightPanel);
	}
	
	public void useInfoPanel() {
		c1.setVisible(true);
		r1.setVisible(true);
		r1.add(butArea);
		
		c2.setVisible(false);
		r2.setVisible(false);

		c3.setVisible(false);
		r3.setVisible(false);
	}
	
	public void useAccPanel() {
		c1.setVisible(false);
		r1.setVisible(false);
		
		c2.setVisible(true);
		r2.setVisible(true);
		r2.add(butArea);

		c3.setVisible(false);
		r3.setVisible(false);
	}
	
	public void useScorePanel() {
		c1.setVisible(false);
		r1.setVisible(false);
		
		c2.setVisible(false);
		r2.setVisible(false);

		c3.setVisible(true);
		r3.setVisible(true);
		r3.add(butArea);
	}
}
