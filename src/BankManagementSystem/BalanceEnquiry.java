package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	String pinnumber;
	JButton back, ministatement;
	JTextField pinField;

	BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		int balance = 0;
		try {
			SqlCon l = new SqlCon();
			ResultSet rs = l.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposite")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}

		JLabel text = new JLabel("Your Current Account Balance is Rs "+ balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400,30);
		image.add(text);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
//		if (ae.getSource() == ministatement) {
//			String statement = pinField.getText();
//			Date date = new Date();
//			if (statement.equals("")) {
//				JOptionPane.showMessageDialog(null, "Please Enter the Amount You Want to Withdraw");
//			} else {
//				try {
//					SqlCon log = new SqlCon();
//					String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','"
//							+ statement + "')";
//					log.s.executeUpdate(query);
//					JOptionPane.showMessageDialog(null, "Rs " + statement + " Withdrawl Successfully");
//					setVisible(false);
//					new Transactions(pinnumber).setVisible(true);
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//
//		} else if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
//		}
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
