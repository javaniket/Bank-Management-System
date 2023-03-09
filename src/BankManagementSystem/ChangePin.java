package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener{
	String pinnumber;
	JButton back, change;
	JPasswordField newpin,renewpin;
	ChangePin(String pinnumber){
		this.pinnumber  =pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Change Your PIN");
		text.setBounds(270, 280, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(165, 320, 180, 25);
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(pintext);
		
		newpin = new JPasswordField();
		newpin.setFont(new Font("Raleway", Font.BOLD, 25));
		newpin.setBounds(330, 320, 180, 25);
		image.add(newpin);
		
		JLabel repintext = new JLabel("New PIN:");
		repintext.setBounds(165, 360, 180, 25);
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(repintext);
		
		renewpin = new JPasswordField();
		renewpin.setFont(new Font("Raleway", Font.BOLD, 25));
		renewpin.setBounds(330, 360, 180, 25);
		image.add(renewpin);
		
		
		
		change = new JButton("Change Pin");
		change.setBounds(170, 520, 150, 30);
		change.addActionListener(this);
		image.add(change);
				
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String npin = newpin.getText();
			String rnpin = renewpin.getText(); 
			
			if(!npin.equals(rnpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN DOesn't Match");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter PIN");
				return;
			}
			if(rnpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
				return;
			}
			SqlCon n = new SqlCon();
			String query1="update bank set pin = '"+rnpin+"' where pin = '"+pinnumber+"'";
			String query2="update login set pin = '"+rnpin+"' where pin = '"+pinnumber+"'";
			String query3="update signup2 set pin = '"+rnpin+"' where pin = '"+pinnumber+"'";
			
			n.s.executeUpdate(query1);
			n.s.executeUpdate(query2);
			n.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
			
			setVisible(false);
			new Transactions(rnpin).setVisible(true);
		}catch(Exception e) {
			System.out.println(e);
		}
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
		
	
	public static void main(String[] args) {
		new ChangePin("").setVisible(true);;
	}

}
