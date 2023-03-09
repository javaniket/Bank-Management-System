package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener {
	JRadioButton type1, type2, type3, type4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;

	String formno;
	SignUp2(String formno) {
		this.formno = formno;
		setLayout(null);
		JLabel accountDetails = new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		accountDetails.setBounds(280, 40, 400, 40);
		add(accountDetails);

		JLabel accountType = new JLabel("Account Type");
		accountType.setFont(new Font("Raleway", Font.BOLD, 22));
		accountType.setBounds(100, 140, 200, 30);
		add(accountType);

		type1 = new JRadioButton("Saving Account");
		type1.setFont(new Font("Raleway", Font.BOLD, 16));
		type1.setBounds(100, 180, 250, 20);
		type1.setBackground(Color.WHITE);
		add(type1);

		type2 = new JRadioButton("Fixed Deposit Account");
		type2.setFont(new Font("Raleway", Font.BOLD, 16));
		type2.setBounds(350, 180, 250, 20);
		type2.setBackground(Color.WHITE);
		add(type2);

		type3 = new JRadioButton("Current Account");
		type3.setFont(new Font("Raleway", Font.BOLD, 16));
		type3.setBounds(100, 220, 250, 20);
		type3.setBackground(Color.WHITE);
		add(type3);

		type4 = new JRadioButton("Recurring Deposit Account");
		type4.setFont(new Font("Raleway", Font.BOLD, 16));
		type4.setBounds(350, 220, 250, 20);
		type4.setBackground(Color.WHITE);
		add(type4);

		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(type1);
		groupaccount.add(type2);
		groupaccount.add(type3);
		groupaccount.add(type4);

		JLabel cardno = new JLabel("Card Number");
		cardno.setFont(new Font("Raleway", Font.BOLD, 22));
		cardno.setBounds(100, 300, 200, 30);
		add(cardno);

		JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4184");
		cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		cnumber.setBounds(330, 300, 300, 30);
		add(cnumber);

		JLabel cardetails = new JLabel("(Here is Your 16 digit Card Number)");
		cardetails.setFont(new Font("Raleway", Font.BOLD, 12));
		cardetails.setBounds(100, 330, 300, 20);
		add(cardetails);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);

		JLabel pindetails = new JLabel("(Here is Your 4 digit PIN)");
		pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pindetails.setBounds(100, 400, 300, 20);
		add(pindetails);

		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 370, 300, 30);
		add(pnumber);

		JLabel srequired = new JLabel("Services Required: ");
		srequired.setFont(new Font("Raleway", Font.BOLD, 22));
		srequired.setBounds(100, 450, 400, 30);
		add(srequired);

		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);

		c2 = new JCheckBox("INTERNET BANKING");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);

		c3 = new JCheckBox("MOBILE BANKING");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(100, 550, 200, 30);
		add(c3);

		c4 = new JCheckBox("EMAIL & SMS ALERTS");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);

		c5 = new JCheckBox("CHEQUE BOOK");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-STATEMENT");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);

		c7 = new JCheckBox(
				"I hereby declares that the above mentioned details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 680, 600, 30);
		add(c7);

		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(220, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

		getContentPane().setBackground(Color.white);
		setSize(850, 820);
		setLocation(350, 0);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String accountType = null;
			if (type1.isSelected()) {
				accountType = "Saving Account";
			} else if (type2.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if (type3.isSelected()) {
				accountType = "Current Account";
			} else if (type4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			Random random = new Random();
			String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			String facilities = "";
			if(c1.isSelected()) {
				facilities= facilities+"ATM CARD";
			}else if(c2.isSelected()) {
				facilities= facilities+"INTERNET BANKING";
			}else if(c3.isSelected()) {
				facilities= facilities+"MOBILE BANKING";
			}else if(c4.isSelected()) {
				facilities= facilities+"EMAIL & SMS ALERT";
			}else if(c5.isSelected()) {
				facilities= facilities+"CHEQUE BOOK";
			}else if(c6.isSelected()) {
				facilities= facilities+"E-STATEMENT";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null,"Account Type is Required");
				}else {
					SqlCon sq = new SqlCon();
					String sql1 = "insert into signup2 values('"+ formno +"','"+ accountType +"','"+ cardno +"','"+ pinnumber +"','"+facilities+"')";
					String sql2= "insert into login values('"+ formno +"','"+ cardno +"','"+ pinnumber +"')";
					sq.s.executeUpdate(sql1);
					sq.s.executeUpdate(sql2);
					
					JOptionPane.showMessageDialog(null,"Card Number: "+cardno + "\n Pin: "+ pinnumber);
					
				}
				setVisible(false);
				new Deposite(pinnumber).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			

		} else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new SignUp2("");
	}
}
