package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.util.*;

public class SignUp1 extends JFrame implements ActionListener {

	long random;
	JTextField pancardField,aadharField;
	JComboBox religionTextField,categoryField,incomeField,educationField,occupationField ;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	String formno;

	SignUp1(String formno) {
		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
	
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);

		String val[]= {"HIndu","Muslim","Sikh","Christian","Other"}; 
		religionTextField = new JComboBox(val);
		religionTextField.setBackground(Color.WHITE);
		religionTextField.setBounds(300, 140, 400, 30);
		add(religionTextField);

		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		String valCat[]= {"General","OBC","ST","SC","Other"};
		categoryField = new JComboBox(valCat);
		categoryField.setBounds(300, 190, 400, 30);
		categoryField.setBackground(Color.WHITE);
		add(categoryField);

		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);

		String valInc[]= {"<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		incomeField = new JComboBox(valInc);
		incomeField.setBounds(300, 240, 400, 30);
		incomeField.setBackground(Color.WHITE);
		add(incomeField);

		JLabel educational = new JLabel("Educational/");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 290, 150, 30);
		add(educational);
		
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 325, 150, 30);
		add(qualification);

		String valEdu[]= {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
		educationField = new JComboBox(valEdu);
		educationField.setBounds(300, 325, 400, 30);
		educationField.setBackground(Color.WHITE);
		add(educationField);

		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 150, 30);
		add(occupation);

		String valOcc[]= {"Salaried","Self-Employed","Business","Student","Retired","Other"};
		occupationField = new JComboBox(valOcc);
		occupationField.setBounds(300, 390, 400, 30);
		occupationField.setBackground(Color.WHITE);
		add(occupationField);
		
		JLabel pancard = new JLabel("PAN Number:");
		pancard.setFont(new Font("Raleway", Font.BOLD, 20));
		pancard.setBounds(100, 440, 150, 30);
		add(pancard);
		
		pancardField = new JTextField();
		pancardField.setBounds(300, 440, 400, 30);
		pancardField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pancardField);

		JLabel aadhar = new JLabel("AADHAR Number:");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 180, 30);
		add(aadhar);
		
		aadharField = new JTextField();
		aadharField.setBounds(300, 490, 400, 30);
		aadharField.setFont(new Font("Arial", Font.BOLD, 14));
		add(aadharField);
		
		JLabel scitizen = new JLabel("Senior Citizen:");
		scitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		scitizen.setBounds(100, 540, 150, 30);
		add(scitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(320, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(440, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup scgroup = new ButtonGroup();
		scgroup.add(syes);
		scgroup.add(sno);

		JLabel existingAcc = new JLabel("Existing Account:");
		existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAcc.setBounds(100, 590, 180, 30);
		add(existingAcc);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(320, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(440, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup egroup = new ButtonGroup();
		egroup.add(eyes);
		egroup.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 710, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		
		String freligion     = (String)religionTextField.getSelectedItem();
		String fcategory     = (String)categoryField.getSelectedItem();
		String fincome       = (String)incomeField.getSelectedItem();
		String feducation    = (String)educationField.getSelectedItem();
		String foccupation   = (String)occupationField.getSelectedItem();
		String fpannumber    = (String)pancardField.getText();
		String faadharnumber = (String)aadharField.getText();
		String fscitizen     = null;
		if (syes.isSelected()) {
			fscitizen = "Yes";
		} else if (sno.isSelected()) {
			fscitizen = "No";
		}
		String fexisting     = null;
		if (eyes.isSelected()) {
			fexisting = "Yes";
		} else if (eno.isSelected()) {
			fexisting = "No";
		}
		
		try {
			
				SqlCon login = new SqlCon();
				String sql = "insert into signup1 values('" + formno + "','" + freligion + "','" + fcategory + "','" + fincome + "','"
						+ feducation + "','" + foccupation + "','" + fpannumber + "','" + faadharnumber + "','" + fscitizen + "','" + fexisting
						+ "')";
				login.s.executeUpdate(sql);
				// signup2 object below
				
				setVisible(false);
				new SignUp2(formno).setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignUp1("");
	}

}
