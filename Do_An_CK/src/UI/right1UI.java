package UI;

import java.awt.Color;

import javax.swing.*;

public class right1UI extends JPanel{
	
	JLabel nameLabel, idLabel, genderLabel, classLabel, schoolLabel, priorityLabel;

	public JTextField nameField =new JTextField(), idField = new JTextField(), classField = new JTextField(),
			schoolField = new JTextField(), priorityField = new JTextField();
	
	ButtonGroup group, group2;
	public JRadioButton male, female, natural, social;
		
	public right1UI() {
		super();
		setLayout(null);
		setBounds(5,5,390,590);
		des();
	}
	
	public void des() {		
		nameLabel = new JLabel("Name:");
		idLabel = new JLabel("Student ID:");
 	    genderLabel = new JLabel("Gender:");
	    classLabel = new JLabel("Class name:");
		schoolLabel = new JLabel("School name:");
		priorityLabel = new JLabel("Priority code:");
		
		idLabel.setBounds(60,25,100,30);
		nameLabel.setBounds(60,75,100,30);
		genderLabel.setBounds(60,125,100,30);
		classLabel.setBounds(60,175,100,30);
		schoolLabel.setBounds(60,225,100,30);
		priorityLabel.setBounds(60,275,100,30);
				
		idField.setBounds(150,25,200,30);
		nameField.setBounds(150,75,200,30);
		classField.setBounds(150,175,200,30);
		schoolField.setBounds(150,225,200,30);
		priorityField.setBounds(150,275,200,30);
		
		idField.setBackground(Color.white);
		nameField.setBackground(Color.white);
		classField.setBackground(Color.white);
		schoolField.setBackground(Color.white);
		priorityField.setBackground(Color.white);
		
		group = new ButtonGroup();
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		group.add(male); group.add(female);

		male.setBounds(160,125,60,30);
		male.setSelected(true);
		female.setBounds(260,125,100,30);
		
		group2 = new ButtonGroup();
		natural = new JRadioButton("Natural sciences combination");
		social = new JRadioButton("Social sciences combination");
		group2.add(natural); group2.add(social);
		
		natural.setBounds(95,325,200,30);
		natural.setSelected(true);
		social.setBounds(95,350,190,30);
		
		add(idLabel);
		add(nameLabel);
		add(genderLabel);
		add(classLabel);
		add(schoolLabel);
		add(priorityLabel);
		
		add(idField);
		add(nameField);
		add(male); add(female);
		add(classField);
		add(schoolField);
		add(priorityField);
		add(natural);
		add(social);
		
		idField.setEditable(false);
		Hide();
	}
	
	public Object[] getField() {
		Object id, name, gender, _class, _school, prioritycode, combination;
		id = idField.getText();
		name = nameField.getText();
		gender = (male.isSelected() ? "Nam":"Nu");
		_class = classField.getText();
		_school = schoolField.getText();
		prioritycode = priorityField.getText();
		combination = (natural.isSelected() ? "TN":"XH");
		
		Object[] res = {id,name,gender,_class,_school,prioritycode,combination};
		
		for (Object ob : res) {
			if (ob.equals("")) return null;
		}
		
		return res;
	}
	
	public void show(Object[] data) {
		
		String id = (String) data[0];
		String name = (String) data[1];
		String Class = (String) data[3];
		String School = (String) data[4];
		String priority = (String) data[5];
		
		idField.setText(id);
		nameField.setText(name);
		String gender = (String) data[2];
		classField.setText(Class);		schoolField.setText(School);		priorityField.setText(priority);
		String comb = (String) data[6];
		
		if (gender.equalsIgnoreCase("Nam") || gender.isEmpty()) male.setSelected(true);
		else female.setSelected(true);
		
		
		if (comb.equalsIgnoreCase("TN") || comb.isEmpty()) natural.setSelected(true);
		else social.setSelected(true);	}
	
	public void clearField() {
		nameField.setText("");
		classField.setText("");
		schoolField.setText("");
		priorityField.setText("");
		male.setSelected(true);
		natural.setSelected(true);
	}
	
	public void clearID() {
		idField.setText("");
	}
	
	public void Hide() {
		nameField.setEditable(false);
		classField.setEditable(false);
		schoolField.setEditable(false);
		priorityField.setEditable(false);
		male.setEnabled(false);
		female.setEnabled(false);
		natural.setEnabled(false);
		social.setEnabled(false);
	}
	
	public void UnHide() {
		nameField.setEditable(true);
		classField.setEditable(true);
		schoolField.setEditable(true);
		priorityField.setEditable(true);
		male.setEnabled(true);
		female.setEnabled(true);
		natural.setEnabled(true);
		social.setEnabled(true);
	}
	
}

