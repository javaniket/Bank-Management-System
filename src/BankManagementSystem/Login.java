package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
JButton login, signup, clear;
JTextField cardNoInputField; 
JPasswordField PinTextField;
JLabel label, text, cardno, pin;  
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 =i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		label =new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);

		cardno = new JLabel("Card No: ");
		cardno.setFont(new Font("Raleway",Font.BOLD, 28));
		cardno.setBounds(150, 120, 400, 30);
		add(cardno);
		
		cardNoInputField =  new JTextField();
		cardNoInputField.setBounds(290, 120, 200, 30);
		cardNoInputField.setFont(new Font("Arial",Font.BOLD, 14));
		add(cardNoInputField);
		
		pin = new JLabel("Pin: ");
		pin.setFont(new Font("Raleway",Font.BOLD, 28));
		pin.setBounds(150, 180, 200, 30);
//		pin.setFont(new Font("Arial",Font.BOLD, 14));
		add(pin);
		
		PinTextField =  new JPasswordField();
		PinTextField.setBounds(290, 180, 200, 30);
		add(PinTextField);
//		(left,top,length ,height)
		
		login = new JButton("SIGN IN");
		login.setBounds(290, 230, 90, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(400, 230, 90, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(290, 280, 200, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== clear) {
			cardNoInputField.setText("");
			PinTextField.setText("");
		}else if(ae.getSource()== login)  {
			try {
			SqlCon log = new SqlCon();
			String cardnumber = cardNoInputField.getText();
			String pinnumber =  PinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			
				ResultSet rs = log.s.executeQuery(query);
			
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}else if(ae.getSource()== signup) {
			setVisible(false);
			new SignUp().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();
	}

}
