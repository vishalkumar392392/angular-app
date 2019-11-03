package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.modal.Product;

public class Order_DetailsDao {
	
	
	public static boolean updateOrderDetails(Map<String, Product> map, int orderId) throws ClassNotFoundException, SQLException{
		
		Connection con = ConnectionUtility.getConnection();
		int res=0;
		for (Map.Entry<String, Product> m : map.entrySet()) {
		
		PreparedStatement ps = con.prepareStatement("insert into order_details(order_id,product_id,quantity) values(?,?,?)");
		
		ps.setInt(1, orderId);
		ps.setInt(2, m.getValue().getId());
		ps.setInt(3, Integer.parseInt(m.getKey()));
		 res = ps.executeUpdate();
		}
		if(res!=0)
		{
			return true;
		}
		
		return false;
	}
	
	

}
