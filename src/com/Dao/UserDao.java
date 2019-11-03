package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.modal.User;

public class UserDao {
	
	public static boolean signUp(User c) throws ClassNotFoundException, SQLException{
		
		Connection con = ConnectionUtility.getConnection();
		
		PreparedStatement ps1 = con.prepareStatement("select email from user");
		ResultSet rs = ps1.executeQuery();
		while(rs.next()){
		if(c.getEmail().equals(rs.getString(1))){
			return false;
		}
		}
		PreparedStatement ps = con.prepareStatement("insert into user(name,email,password) values(?,?,?)");
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setString(3, c.getPassword());
		
		int a = ps.executeUpdate();
		if(a!=0){
			return true;
		}
		return false;
	}
	
	public static String validateLogin(String email,String password) throws ClassNotFoundException, SQLException{
		
		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select name from user where email=? and password=? ");
		
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet res = ps.executeQuery();
		while(res.next()){
			
			return res.getString(1);
			
		}
		return null;
	}
	
	public static boolean checkLogin(){
		return true;
	}
	
	
	
	

}
