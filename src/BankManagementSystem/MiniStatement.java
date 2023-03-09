package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {
	String pinnumber;
//	JButton back, ministatement;
//	JTextField pinField;
	MiniStatement(String pinnumber) {
		this.pinnumber = pinnumber;

		setTitle("Mini Statement");
		setLayout(null);
//		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//		ImageIcon l3 = new ImageIcon(l2);
//		JLabel image = new JLabel(l3);
//		image.setBounds(0, 0, 900, 900);
//		add(image);

		JLabel mini = new JLabel("");
		mini.setBounds(20, 140, 400, 200);
//		mini.setForeground(Color.WHITE);
//		text.setFont(new Font("System", Font.BOLD, 16));
		add(mini);

		JLabel bank = new JLabel("Digital Bank");
		bank.setBounds(150, 20, 100, 20);
//		bank.setForeground(Color.WHITE);
//		bank.setFont(new Font("System", Font.BOLD, 16));
		add(bank);

		JLabel balance = new JLabel("");
		balance.setBounds(20, 400, 300, 20);
		add(balance);

		JLabel card = new JLabel("");
		card.setBounds(20, 80, 300, 20);
		add(card);
		try {
			SqlCon con = new SqlCon();

			ResultSet rs = con.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardnumber").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			SqlCon con = new SqlCon();
			int bal = 0;
			ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
			while (rs.next()) {
				mini.setText(mini.getText() + "<html> " + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("amount") + "<br><br><html>");
				if (rs.getString("type").equals("Deposite")) {
					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your Current Account Balance is Rs " + bal);
		} catch (Exception e) {
			System.out.println(e);
		}

//		pinField =  new JTextField();
//		pinField.setBounds(170, 350, 320, 30);
//		pinField.setFont(new Font("Raleway",Font.BOLD, 22));
//		add(pinField);
//		
//		ministatement = new JButton("Mini Statement");
//		ministatement.setBounds(170, 520, 150, 30);
//		ministatement.addActionListener(this);
//		add(ministatement);
//				
//		back = new JButton("Back");
//		back.setBounds(355, 520, 150, 30);
//		back.addActionListener(this);
//		add(back);

		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MiniStatement("");
	}
}
