package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.modal.Orders;
import com.modal.Product;

public class OrdersDao {

	public static int orders(String email) throws ClassNotFoundException, SQLException {

		int id = 0;
		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select id from user where email=?");

		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		List<String> list = new ArrayList<String>();

		while (rs.next()) {

			id = (rs.getInt(1));

		}

		return id;
	}

	public static boolean UpdateOrders(Map<String, Product> map, int id) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();
		int price = 0;
		for (Map.Entry<String, Product> m : map.entrySet()) {

			price = price + (m.getValue().getPrice()) * (Integer.parseInt(m.getKey()));

		}

		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		PreparedStatement ps = con.prepareStatement("insert into orders(user_id,total_amount,order_date) values(?,?,?)");
		
		ps.setInt(1, id);
		ps.setInt(2, price);
		ps.setDate(3, ourJavaDateObject);
		
		int result = ps.executeUpdate();
		if(result!=0){
			return true;
		}
		
		return false;
	}
	
	public static int getOrderId() throws ClassNotFoundException, SQLException{
		
		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select id from orders");
		
		ResultSet rs = ps.executeQuery();
		
		int id=0;
		while(rs.next()){
			
			id = rs.getInt(1);
			
		}
		System.out.println(id);
		return id;
	}

}
