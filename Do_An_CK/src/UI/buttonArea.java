package UI;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class buttonArea extends JPanel{
	
	public JButton addBut, edit, delete, clearBut, newBut, done;
	
	public buttonArea() {
		super();
		setLayout(null);
		setBounds(80,455,240,110);
		addButton();
		setBorder(new TitledBorder(new LineBorder(Color.black),"Function button"));
	}
	
	public void addButton() {
		newBut = new JButton("NEW");
		edit = new JButton("EDIT");
		delete = new JButton("DEL");
		addBut = new JButton("ADD");
		clearBut = new JButton("CLEAR");
		done = new JButton("DONE");
		
		newBut.setBounds(5,20,70,40);
		delete.setBounds(85,20,70,40);
		edit.setBounds(165,20,70,40);
		addBut.setBounds(5,65,110,40);
		clearBut.setBounds(125,65,110,40);
		done.setBounds(edit.getBounds());
		
		
		addBut.setEnabled(false);
		clearBut.setEnabled(false);
		done.setVisible(false);
		
		add(newBut);
		add(edit);
		add(delete);
		add(addBut);
		add(clearBut);
		add(done);
	}
}
