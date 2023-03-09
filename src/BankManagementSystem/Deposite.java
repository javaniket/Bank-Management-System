package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Deposite  extends JFrame implements ActionListener{
	String pinnumber;
	JButton back, deposite;
	JTextField amountTextField;
	Deposite(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter The Amount you Want To Deposite");
		text.setBounds(180, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		amountTextField =  new JTextField();
		amountTextField.setBounds(170, 350, 320, 30);
		amountTextField.setFont(new Font("Raleway",Font.BOLD, 22));
		add(amountTextField);
		
		deposite = new JButton("Deposite");
		deposite.setBounds(170, 520, 150, 30);
		deposite.addActionListener(this);
		image.add(deposite);
				
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposite) {
			String deposit =  amountTextField.getText();
			Date date = new Date();
			if(deposit.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the Amount You Want to Deposite");
			}else {
				try {
				SqlCon log = new SqlCon();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+deposit+"')";
				log.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs "+deposit +" Deposited Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
	}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Deposite("");
	}
}
