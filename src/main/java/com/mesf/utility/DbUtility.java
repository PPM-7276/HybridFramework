package com.mesf.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class DbUtility {
	
	static Connection con = null;
	static String driver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/tables?useSSL=true";
	String userName = "root";
	String password = "root";
	public static Logger log = Logger.getLogger(DbUtility.class);

	public static Connection myConnection() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection("dbUrl", "userName", "password");
		log.info("Connection Established Successfully");
		System.out.println(1);
		return con;
	}

	public Statement createMethod() throws SQLException {
		Statement stmt = con.createStatement();
		return stmt;
	}

	public PreparedStatement prepareMethod(String sql) throws SQLException {
		PreparedStatement st = con.prepareStatement(sql);
		return st;
	}

	public void extractDataFromDatabase(String sql) throws SQLException {
		Statement stmt = createMethod();
		ResultSet rs = stmt.executeQuery(sql);// "select * from account"
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		}
		con.close();
	}

	public void createtable(String sql) throws ClassNotFoundException, SQLException {
		Statement stmt = createMethod();
		stmt.executeUpdate(sql);// "CREATE TABLE `person` (`Id` INT(12),`Name` VARCHAR(28),`Age` INT(3))"
		log.info("table created");
		con.close();
	}

	public void insertRecord(String sql) throws Exception {
		PreparedStatement ps=prepareMethod(sql);// "insert into person values(?,?,?)"
		Scanner sc = new Scanner(System.in);
		System.out.println("Update rollno,name,age");
		int roll = sc.nextInt();
		String name = sc.next();
		int age = sc.nextInt();
		ps.setInt(1, roll);
		ps.setString(2, name);
		ps.setInt(3, age);
		int i = ps.executeUpdate();
		System.out.println(i + " records inserted");
		con.close();
	}

	public void updaterecord(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=prepareMethod(sql);// "update person set name=? where id=102"
		ps.setString(1, "ABC");
		int i = ps.executeUpdate();
		System.out.println(i + "records updated");
		con.close();
	}

	public void deleterecord(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=prepareMethod(sql);// "delete from person where id=102"
		int i = ps.executeUpdate();
		System.out.println(i + "records updated after deleting");
		con.close();
	}
}
