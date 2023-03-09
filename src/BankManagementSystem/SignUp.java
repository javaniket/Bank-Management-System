package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignUp extends JFrame implements ActionListener {

	long random;
	JTextField nameTextField, fnameTextField, emailidTextField, addressTextField, cityTextField, stateTextField,
			pincodeTextField;
	JDateChooser dobField;
	JButton next;
	JRadioButton male, female, other, married, unmarried;

	SignUp() {
		setLayout(null);
		Random ran = new Random();
		random = Math.abs(ran.nextLong() % 9000L + 1000L);

		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		fnameTextField = new JTextField();
		fnameTextField.setBounds(300, 190, 400, 30);
		fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(fnameTextField);

		JLabel dob = new JLabel("Date Of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		dobField = new JDateChooser();
		dobField.setBounds(300, 240, 400, 30);
		dobField.setForeground(Color.RED);
		add(dobField);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 100, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 70, 30);
		male.setBackground(Color.WHITE);
		add(male);
		female = new JRadioButton("Female");
		female.setBounds(390, 290, 70, 30);
		female.setBackground(Color.WHITE);
		add(female);
		other = new JRadioButton("Other");
		other.setBounds(490, 290, 70, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);

		JLabel emailid = new JLabel("Email Address:");
		emailid.setFont(new Font("Raleway", Font.BOLD, 20));
		emailid.setBounds(100, 340, 150, 30);
		add(emailid);

		emailidTextField = new JTextField();
		emailidTextField.setBounds(300, 340, 400, 30);
		emailidTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(emailidTextField);

		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 150, 30);
		add(marital);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(420, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 100, 30);
		add(address);

		addressTextField = new JTextField();
		addressTextField.setBounds(300, 440, 400, 30);
		addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(addressTextField);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setBounds(300, 490, 400, 30);
		cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cityTextField);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 100, 30);
		add(state);

		stateTextField = new JTextField();
		stateTextField.setBounds(300, 540, 400, 30);
		stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(stateTextField);

		JLabel pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 100, 30);
		add(pincode);

		pincodeTextField = new JTextField();
		pincodeTextField.setBounds(300, 590, 400, 30);
		pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pincodeTextField);

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String formno = " " + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		} else if (other.isSelected()) {
			gender = "Other";
		}
		String emailid = emailidTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "Unmarried";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();

		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			if (fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father's Name is Required");
			}
			if (dob.equals("")) {
				JOptionPane.showMessageDialog(null, "DOB is Required");
			} else if (gender.equals("")) {
				JOptionPane.showMessageDialog(null, "gender is Required");
			} else if (emailid.equals("")) {
				JOptionPane.showMessageDialog(null, "Email Id is Required");
			} else if (marital.equals("")) {
				JOptionPane.showMessageDialog(null, "Marital Status is Required");
			} else if (address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is Required");
			} else if (city.equals("")) {
				JOptionPane.showMessageDialog(null, "City is Required");
			} else if (state.equals("")) {
				JOptionPane.showMessageDialog(null, "State is Required");
			} else if (pincode.equals("")) { 
				JOptionPane.showMessageDialog(null, "Pin Code is Required");
			} else {
				SqlCon login = new SqlCon();
				String sql = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','"
						+ gender + "','" + emailid + "','" + marital + "','" + address + "','" + city + "','" + state
						+ "','" + pincode + "')";
				login.s.executeUpdate(sql);
				setVisible(false);
				new SignUp1(formno).setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignUp();
	}

}
