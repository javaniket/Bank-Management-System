package BankManagementSystem;

//import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

	JButton deposit, fastcash, withdrawl, balanceenquiry, exit, ministatement, pinchange;
	String pinnumber;

	Transactions(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		// 1
		deposit = new JButton("Deposite");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		// 2
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		// 3
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		// 4
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		// 5
		pinchange = new JButton("Change PIN");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		// 6
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		// 7
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);

//		getContentPane().setBackground(Color.white);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			System.exit(0);
		} else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposite(pinnumber).setVisible(true);
		} else if (ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		} else if (ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if (ae.getSource() == ministatement) {
			setVisible(false);
			new MiniStatement(pinnumber).setVisible(true);
		} else if (ae.getSource() == pinchange) {
			setVisible(false);
			new ChangePin(pinnumber).setVisible(true);
		} else if (ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transactions("");
	}
}
