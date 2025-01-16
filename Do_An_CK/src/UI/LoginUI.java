package UI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import ConnetToDB.AccountLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginUI extends JFrame implements ActionListener,MouseListener{	
	JPanel Main = new JPanel();
	
	JTextField accField;
	JPasswordField passField;
	JButton logBut,regBut;
	JCheckBox showPass;
	JComboBox<String> role;
	
	boolean isClicked1 = false , isClicked2 = false;
	
	public LoginUI() {
		super("Login");
		Main.setLayout(null);
		Main.setPreferredSize(new Dimension(500,500));
		add(Main);
				
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		LoginArea();
		
		setVisible(true);
	}
	
	public void LoginArea() {
		JPanel login = new JPanel();
		Main.add(login);
		login.setLayout(null);
		login.setBounds(100,50,300,300);
				
		JLabel title = new JLabel("Login");
		login.add(title);
		
		Font font = new Font("Arial",Font.BOLD,15);
		
		title.setFont(new Font("Arial",Font.BOLD,20));
		title.setBounds(120,80,300,30);
		
		accField = new JTextField("Account");
		login.add(accField);
		accField.setFont(font);
		accField.setBounds(0,110,300,30);
		
		passField = new JPasswordField("Password");
		login.add(passField);
		passField.setBounds(0,150,300,30);
		passField.setEchoChar((char) 0);
		passField.setFont(font);
		
		showPass = new JCheckBox("Show Password");
		login.add(showPass);
		showPass.setBounds(180,180,150,30);
		
		String[] roles = { "user","admin" };
		role = new JComboBox<>(roles);
		JLabel roleLabel = new JLabel("Role");
		
		login.add(roleLabel);
		login.add(role);
		roleLabel.setBounds(0,180,30,30);
		role.setBounds(30,180,60,30);
		
		logBut = new JButton("Login");
		login.add(logBut);
		logBut.setBounds(110,210,80,30);
		
		regBut = new JButton("Register here");
		login.add(regBut);
		regBut.setBounds(90,250,120,30);
		
		showPass.addActionListener(this);
		logBut.addActionListener(this);
		regBut.addActionListener(this);
		accField.addMouseListener(this);
		passField.addMouseListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (showPass.isSelected()) {
			passField.setEchoChar((char) 0);
		} else {
			passField.setEchoChar('*');
		}
		
		if (e.getSource() == logBut) {
			String acc = accField.getText();
			char[] arr = passField.getPassword();
			String pass = new String(arr);
			boolean roleField = role.getSelectedItem().equals("admin");
			
			if (AccountLogin.checkAccount(acc,pass,roleField)) {
				
				JOptionPane.showMessageDialog(null, "Login successful");
				if (roleField) {
					AdminUI adminview = new AdminUI(acc);
					new AdminController(adminview);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,"Comming soon!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect account");
			}
		}
		
		
		if (e.getSource() == regBut) {
			new RegisUI();
			dispose();
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == accField && !isClicked1) {
			isClicked1 = true;
			accField.setText("");
		}
		if (e.getSource() == passField && !isClicked2) {
			isClicked2 = true;
			passField.setText("");
			passField.setEchoChar('*');
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
}
