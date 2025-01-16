package UI;

import javax.swing.*;
import ConnetToDB.AccountLogin;
import ConnetToDB.AutoID;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisUI extends JFrame 
implements ActionListener
{
	
	JPanel Main = new JPanel();
	
	JTextField accField;
	JPasswordField passField, passField2;
	JButton regBut;
	JCheckBox showPass;
	JComboBox<String> role;
	
	public RegisUI() {
		super("Register");
		Main.setLayout(null);
		Main.setPreferredSize(new Dimension(500,500));
		add(Main);
				
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		RegisArea();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void RegisArea() {
		
		JLabel reg = new JLabel("Register");
		Main.add(reg);
		reg.setFont(new Font("Arial",Font.BOLD,20));
		reg.setBounds(210,0,100,100);
		
		JPanel accArea = new JPanel();
		Main.add(accArea);
		
		accArea.setBounds(5,100,500,40);
		accArea.add(new JLabel("Account"));
		accField = new JTextField();
		accArea.add(accField);
		accField.setPreferredSize(new Dimension(300,30));
		
		JPanel passArea = new JPanel();
		Main.add(passArea);
		
		passArea.setBounds(0,150,500,40);
		passArea.add(new JLabel("Password"));
		passField = new JPasswordField();
		passArea.add(passField);
		passField.setEchoChar('*');
		passField.setPreferredSize(new Dimension(300,30));
		
		JPanel passArea2 = new JPanel();
		Main.add(passArea2);
		
		passArea2.setBounds(0,200,500,40);
		passArea2.add(new JLabel("Password again"));
		passField2 = new JPasswordField();
		passArea2.add(passField2);
		passField2.setEchoChar('*');
		passField2.setPreferredSize(new Dimension(300,30));
		
		JPanel roleArea = new JPanel();
		Main.add(roleArea);
		roleArea.setBounds(90,250,100,30);
		String[] roles = {"user","admin"};
		role = new JComboBox<>(roles);
		roleArea.add(new JLabel("Role"));
		roleArea.add(role);
		
		showPass = new JCheckBox("Show password");
		Main.add(showPass);
		showPass.setBounds(300,250,200,20);
		
		regBut = new JButton("Regsiter");
		Main.add(regBut);
		regBut.setBounds(200,280,100,30);
		
		showPass.addActionListener(this);
		regBut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (showPass.isSelected()) {
			passField.setEchoChar((char)0);
			passField2.setEchoChar((char)0);
		} else {
			passField.setEchoChar('*');
			passField2.setEchoChar('*');
		}
		
		if (e.getSource() == regBut) {
			char[] passarr = passField.getPassword();
			char[] passarr2 = passField2.getPassword();
			
			String pass1 = new String(passarr), pass2 = new String(passarr2);
			
			if (pass1.equals(pass2)) {
				String account = accField.getText();
				boolean roleField = (role.getSelectedItem().equals("admin"));
				if (!(account.length() == 0) && !(pass1.length() == 0)) {
					String newID = "";
					if (roleField == false) {						
						newID = AutoID.nextID();
					}
						if (AccountLogin.addAcount(account,pass1,roleField,newID)) {
							JOptionPane.showMessageDialog(null,"Registration successful!");
							dispose();
							new LoginUI();
					} else {
						JOptionPane.showMessageDialog(null, "Account already exists");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Account is not null!");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
			}
		}
	}
}