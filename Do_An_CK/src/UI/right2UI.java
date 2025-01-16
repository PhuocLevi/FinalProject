package UI;

import javax.swing.*;
import java.awt.*;

public class right2UI extends JPanel {
	
	JLabel nameLabel, idLabel, classLabel, schoolLabel, accountLabel, passwordLabel;

	public JTextField nameField =new JTextField(), idField = new JTextField(), classField = new JTextField(),
			schoolField = new JTextField(), accountField = new JTextField(), passwordField = new JTextField();
		
	public right2UI() {
		super();
		setLayout(null);
		setBounds(5,5,390,590);
		des();
	}
	
	public void des() {
		nameLabel = new JLabel("Name:");
		idLabel = new JLabel("Student ID:");
	    classLabel = new JLabel("Class name:");
		schoolLabel = new JLabel("School name:");
		accountLabel = new JLabel("Account:");
		passwordLabel = new JLabel("Password:");
		
		idLabel.setBounds(60,25,100,30);
		nameLabel.setBounds(60,75,100,30);
		classLabel.setBounds(60,125,100,30);
		schoolLabel.setBounds(60,175,100,30);
		
		accountLabel.setBounds(60,225,100,30);
		passwordLabel.setBounds(60,275,100,30);
		
		
		idField.setBounds(150,25,200,30);
		nameField.setBounds(150,75,200,30);
		classField.setBounds(150,125,200,30);
		schoolField.setBounds(150,175,200,30);
		
		accountField.setBounds(150,225,200,30);
		passwordField.setBounds(150,275,200,30);
	
		idField.setBackground(Color.white);
		nameField.setBackground(Color.white);
		classField.setBackground(Color.white);
		schoolField.setBackground(Color.white);
		
		accountField.setBackground(Color.white);
		passwordField.setBackground(Color.white);
		
		idField.setEditable(false);
		nameField.setEditable(false);
		classField.setEditable(false);
		schoolField.setEditable(false);
		
		add(idLabel);
		add(nameLabel);
		add(classLabel);
		add(schoolLabel);
		add(accountLabel);
		add(passwordLabel);
		
		add(idField);
		add(nameField);
		add(classField);
		add(schoolField);
		add(accountField);
		add(passwordField);
		
		Hide();
		
		}
	
	public Object[] getField() {
		Object id, name, _class, _school, account, password;
		id = idField.getText();
		name = nameField.getText();
		_class = classField.getText();
		_school = schoolField.getText();
		account = accountField.getText();
		password = passwordField.getText();
		Object[] res = {id, name, _class, _school, account, password};
		
		for (Object ob : res) {
			if (ob.equals("")) return null;
		}
		
		return res;
	}
	
	public void show(Object[] data) {
		String id,name,Class,School,account,password;
		id = (String) data[0];
		name = (String) data[1];
		Class = (String) data[2];
		School = (String) data[3];
		account = (String) data[4];
		password = (String) data[5];
		
		idField.setText(id);
		nameField.setText(name);
		classField.setText(Class);
		schoolField.setText(School);
		accountField.setText(account);
		passwordField.setText(password);
	}
	
	public void clearField() {
		accountField.setText("");
		passwordField.setText("");
	}
	
	public void Hide() {
		accountField.setEditable(false);
		passwordField.setEditable(false);
	}
	
	public void UnHide() {
		accountField.setEditable(true);
		passwordField.setEditable(true);
	}
	
}
