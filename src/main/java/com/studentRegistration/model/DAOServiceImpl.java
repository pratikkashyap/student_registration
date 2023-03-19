package com.studentRegistration.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService{

	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_app","root","mysqltest");
			stmnt = con.createStatement();
		} catch (Exception e) {

		}
	}

	@Override
	public boolean verifyDetails(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where Email='"+email+"' and Password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into Registration values ('"+name+"','"+city+"', '"+email+"','"+mobile+"')");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet RegistrationList() {
		try {
			ResultSet result = stmnt.executeQuery("select * from Registration");
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
		}		return null;
	}

	@Override
	public void DeleteRegistration(String email) {	
		try {
			stmnt.executeUpdate("Delete From Registration Where Email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update Registration SET Mobile='"+mobile+"' Where Email='"+email+"'");
		} catch (Exception e) {
		
		}
	}	
	
}
