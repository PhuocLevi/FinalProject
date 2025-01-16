package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class topUI extends JPanel{
	public JButton outBut;
	private String nameAccount;
	public topUI(String nameAccount) {
		super();
		setLayout(null);
		setBounds(0,5,1285,50);
		setBorder(new LineBorder(Color.black));
		this.nameAccount = nameAccount;
		des();
	}
	
	public void des() {
		JLabel adLabel = new JLabel("Admin:");
		adLabel.setFont(new Font("Arial",Font.BOLD,18));
		adLabel.setBounds(20, 10, 65, 30);
					
		JLabel accLabel = new JLabel(nameAccount);
		accLabel.setFont(new Font("Arial",Font.BOLD,18));
		accLabel.setBounds(100,10,500,30);
			
		outBut = new JButton("Sign out");
		outBut.setBounds(1180,10,100,30);
		
		add(accLabel);
		add(adLabel);
		add(outBut);
	}
}
