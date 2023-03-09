package BankManagementSystem;

//import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

	JButton hundred,fivehundred,thousand,back,twothousand,fivethousand,tenthousand;
	String pinnumber;
	FastCash(String pinnumber) {
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		// 1
		hundred = new JButton("Rs 100");
		hundred.setBounds(170, 415, 150, 30);
		hundred.addActionListener(this);
		image.add(hundred);
		// 2
		fivehundred = new JButton("Rs 500");
		fivehundred.setBounds(355, 415, 150, 30);
		fivehundred.addActionListener(this);
		image.add(fivehundred);
		// 3
		thousand = new JButton("Rs 1000");
		thousand.setBounds(170, 450, 150, 30);
		thousand.addActionListener(this);
		image.add(thousand);
		// 4
		twothousand = new JButton("Rs 2000");
		twothousand.setBounds(355, 450, 150, 30);
		twothousand.addActionListener(this);
		image.add(twothousand);
		// 5
		fivethousand = new JButton("Rs 5000");
		fivethousand.setBounds(170, 485, 150, 30);
		fivethousand.addActionListener(this);
		image.add(fivethousand);
		// 6
		tenthousand = new JButton("Rs 10000");
		tenthousand.setBounds(355, 485, 150, 30);
		tenthousand.addActionListener(this);
		image.add(tenthousand);
		// 7
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

//		getContentPane().setBackground(Color.white);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else {
		String amount =  ((JButton)ae.getSource()).getText().substring(3);
		try {
			SqlCon l = new SqlCon();
			ResultSet rs = l.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
			int balance = 0;
			while(rs.next()) {
				if(rs.getString("type").equals("Deposite")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			if(ae.getSource()!= back && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}
			Date date = new Date();
			String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
			l.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Rs " + amount + " Debited Successfully");
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		}
	}

	public static void main(String[] args) {
		new FastCash("");
	}
}
