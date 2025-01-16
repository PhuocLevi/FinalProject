package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class right3UI extends JPanel {

	JLabel nameLabel, idLabel, classLabel, schoolLabel,
	mathLabel, litLabel, engLabel, chemLabel, physLabel, bioLabel, geoLabel, histLabel, civLabel;

	public JTextField nameField =new JTextField(), idField = new JTextField(), classField = new JTextField(),
			schoolField = new JTextField(),mathField = new JTextField(),litField = new JTextField(), engField = new JTextField(),
			physField = new JTextField(), chemField = new JTextField(),  bioField = new JTextField(), histField = new JTextField(),
			geoField = new JTextField(), civField = new JTextField();
	
//	"Student ID","Student Name","Class Name","School Name","Combination","Total Score", "Pass?"
	
	private JPanel naturalScore,socialScore;
		
	public right3UI() {
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
		
		idLabel.setBounds(60,25,100,30);
		nameLabel.setBounds(60,75,100,30);
		classLabel.setBounds(60,125,100,30);
		schoolLabel.setBounds(60,175,100,30);
		
		idField.setBounds(150,25,200,30);
		nameField.setBounds(150,75,200,30);
		classField.setBounds(150,125,200,30);
		schoolField.setBounds(150,175,200,30);
		
		idField.setBackground(Color.white);
		nameField.setBackground(Color.white);
		classField.setBackground(Color.white);
		schoolField.setBackground(Color.white);
		
		idField.setEditable(false);
		nameField.setEditable(false);
		classField.setEditable(false);
		schoolField.setEditable(false);
		
		mathLabel = new JLabel("Math:");
		litLabel = new JLabel("Lit:");
		engLabel = new JLabel("Eng:");

		physLabel = new JLabel("Phys:");
		chemLabel = new JLabel("Chem:");
		bioLabel = new JLabel("Bio:");

		histLabel = new JLabel("Hist:");
		geoLabel = new JLabel("Geo:");
		civLabel = new JLabel("Civ:");
		
		mathLabel.setBounds(30,35,45,30);
		litLabel.setBounds(140,35,45,30);
		engLabel.setBounds(250,35,45,30);
		
		physLabel.setBounds(30,85,45,30);
		chemLabel.setBounds(140,85,45,30);
		bioLabel.setBounds(250,85,45,30);
		
		histLabel.setBounds(physLabel.getBounds());
		geoLabel.setBounds(chemLabel.getBounds());
		civLabel.setBounds(bioLabel.getBounds());
		
		mathField = new JTextField();
		mathField.setBounds(75,35,45,30);
		
		litField = new JTextField();
		litField.setBounds(185,35,45,30);
		
		engField = new JTextField();
		engField.setBounds(295,35,45,30);
		
		physField = new JTextField();
		physField.setBounds(75,85,45,30);
		
		chemField = new JTextField();
		chemField.setBounds(185,85,45,30);
		
		bioField = new JTextField();
		bioField.setBounds(295,85,45,30);
		
		histField = new JTextField();
		histField.setBounds(physField.getBounds());;
		
		geoField = new JTextField();
		geoField.setBounds(chemField.getBounds());
		
		civField = new JTextField();
		civField.setBounds(bioField.getBounds());
		
		naturalScore = new JPanel();
		naturalScore.setLayout(null);
		naturalScore.setBounds(10,225,370,150);
		naturalScore.setBorder(new TitledBorder(new LineBorder(Color.black),"Student's score"));
		
		
		socialScore = new JPanel();
		socialScore.setLayout(null);
		socialScore.setBounds(naturalScore.getBounds());
		socialScore.setBorder(new TitledBorder(new LineBorder(Color.black),"Student's score"));
		
		naturalScore.add(physLabel);
		naturalScore.add(chemLabel);
		naturalScore.add(bioLabel);
		
		naturalScore.add(physField);
		naturalScore.add(chemField);
		naturalScore.add(bioField);
		
		socialScore.add(histLabel);
		socialScore.add(geoLabel);
		socialScore.add(civLabel);
	
		socialScore.add(histField);
		socialScore.add(geoField);
		socialScore.add(civField);
		
		add(idLabel);
		add(nameLabel);
		add(classLabel);
		add(schoolLabel);
		
		add(idField);
		add(nameField);
		
		add(classField);
		add(schoolField);
		
		add(naturalScore);
		add(socialScore);
		useNaturalScore();
		Hide();
	}
	
	public void useNaturalScore() {
		naturalScore.setVisible(true);
		socialScore.setVisible(false);
		
		naturalScore.add(mathLabel);
		naturalScore.add(litLabel);
		naturalScore.add(engLabel);
		
		naturalScore.add(mathField);
		naturalScore.add(litField);
		naturalScore.add(engField);
	}
	
	public void useSocialScore(){
		naturalScore.setVisible(false);
		socialScore.setVisible(true);
		
		socialScore.add(mathLabel);
		socialScore.add(litLabel);
		socialScore.add(engLabel);
		
		socialScore.add(mathField);
		socialScore.add(litField);
		socialScore.add(engField);
	}
	
	public Object[] getScore(boolean comb) {
		Object math = mathField.getText(),lit = litField.getText(),eng = engField.getText(),
				phys,chem,bio,hist,geo,civ;
		
		if (comb) {
			phys = physField.getText();
			chem = chemField.getText();
			bio = bioField.getText();
			
			if (math.equals("") || lit.equals("") || eng.equals("") || phys.equals("") || chem.equals("") || bio.equals("")) {
				return null;
			}
			return new Object[] {math,lit,eng,phys,chem,bio};
		} else {
			hist = histField.getText();
			geo = geoField.getText();
			civ = civField.getText();
			
			if (math.equals("") || lit.equals("")  || eng.equals("") || hist.equals("") || geo.equals("") || civ.equals("")) {
				return null;
			}
			
			return new Object[] {math,lit,eng,hist,geo,civ};
		}
	}
	
	public void showScore(boolean comb, Object[] Scores) {
		mathField.setText( (String) Scores[0]);
		litField.setText((String) Scores[1]);
		engField.setText((String) Scores[2]);
		
		if (comb) {
			physField.setText((String) Scores[3]);
			chemField.setText((String) Scores[4]);
			bioField.setText((String) Scores[5]);
		} else {
			histField.setText((String) Scores[3]);
			geoField.setText((String) Scores[4]);
			civField.setText((String) Scores[5]);
		}
	}
	
	public Object[] getField(boolean comb) {
		Object id, name, _class, _school;
		id = idField.getText();
		name = nameField.getText();
		_class = classField.getText();
		_school = schoolField.getText();
		
		Object[] info = {id,name,_class,_school}, scores = getScore(comb);
		
		if (scores == null) {
			scores = new Object[] {"0","0","0","0","0","0"};
		}
		
		Object[] res = new Object[info.length + scores.length];
		
		for (int i = 0; i < res.length; i++) {
			if (i < info.length) {
				res[i] = info[i];
			} else {
				res[i] = scores[ i - info.length];
			}
		}
		
		for (Object ob : res) {
			if (ob.equals("")) return null;
		}
		
		return res;
	}
	
	public void showPoints(boolean comb, Object[] data) {
		mathField.setText((String) data[0]);
		litField.setText((String) data[1]);
		engField.setText((String) data[2]);
		if (comb) {
			physField.setText((String) data[3]);
			chemField.setText((String) data[4]);
			bioField.setText((String) data[5]);
		} else {
			histField.setText((String) data[3]);
			geoField.setText((String) data[4]);
			civField.setText((String) data[5]);
		}
	}
	
	public void show(Object[] data) {
		
		String id,name,Class,School;
		id = (String) data[0];
		name = (String) data[1];
		Class = (String) data[2];
		School = (String) data[3];
		
		idField.setText(id);
		nameField.setText(name);
		classField.setText(Class);
		schoolField.setText(School);
	}
		
	public void clearField() {
		mathField.setText("");
		litField.setText("");
		engField.setText("");
		physField.setText("");
		chemField.setText("");
		bioField.setText("");
		histField.setText("");
		geoField.setText("");
		civField.setText("");
	}
	
	public void Hide() {
		mathField.setEditable(false);
		litField.setEditable(false);
		engField.setEditable(false);
		physField.setEditable(false);
		chemField.setEditable(false);
		bioField.setEditable(false);
		histField.setEditable(false);
		geoField.setEditable(false);
		civField.setEditable(false);
	}
	
	public void UnHide() {
		mathField.setEditable(true);
		litField.setEditable(true);
		engField.setEditable(true);
		physField.setEditable(true);
		chemField.setEditable(true);
		bioField.setEditable(true);
		histField.setEditable(true);
		geoField.setEditable(true);
		civField.setEditable(true);
	}
	
}
