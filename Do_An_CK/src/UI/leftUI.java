package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class leftUI extends JPanel{
	
	public JButton tabInfo,tabAccount, tabScore,statistical;
	
	public leftUI() {
		super();
		setLayout(null);
		setBounds(0,60,170,600);
		setBorder( new LineBorder(Color.black));
		des();
	}
	
	public void des(){
		tabInfo = new JButton("Infomation");
		tabAccount = new JButton("Account");
		tabScore = new JButton("Score");
		statistical = new JButton("Statistical");
		
		tabInfo.setBounds(5,135,160,30);
		tabAccount.setBounds(5,185,160,30);
		tabScore.setBounds(5,235,160,30);
		statistical.setBounds(5,285,160,30);
		
		add(tabInfo);
		add(tabAccount);
		add(tabScore);
		add(statistical);
	}
	
	public void UseLeft() {
		tabInfo.setEnabled(true);
		tabAccount.setEnabled(true);
		tabScore.setEnabled(true);
		statistical.setEnabled(true);
	}
	
	public void noUseLeft() {
		tabInfo.setEnabled(false);
		tabAccount.setEnabled(false);
		tabScore.setEnabled(false);
		statistical.setEnabled(false);
	}
}
