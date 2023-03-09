package BankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlCon {

	Connection c;
	Statement s;

	public SqlCon() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root","abcd@123");
		System.out.println("Connection Established");
		s = c.createStatement();
	}
	public static void main(String[] args) throws Exception{
		SqlCon log = new SqlCon();
	}
}
