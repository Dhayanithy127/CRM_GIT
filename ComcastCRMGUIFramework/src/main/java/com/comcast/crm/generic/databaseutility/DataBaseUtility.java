package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;

	public void getConnection(String url, String username, String password) throws SQLException {
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	public void getConnection() {
		try {
			Class.forName("com.cj.jdbc.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium_practice", "root", "root");
		} catch (Exception e) {
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		}catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet rs = null;
		try {
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		}catch (Exception e) {
		}
		return rs;
	} 
	
	public int executeNonSelectQuery(String query) throws SQLException {
		int res = 0;
		try {
		Statement stmt=con.createStatement();
		res=stmt.executeUpdate(query);
		}catch (Exception e) {
		}
		return res;
	} 

}
