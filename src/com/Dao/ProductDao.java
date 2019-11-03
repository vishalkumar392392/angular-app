package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modal.Product;

public class ProductDao {

	public static List<String> getAllCategory() throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select distinct(category) from product");

		ResultSet rs = ps.executeQuery();

		List<String> list = new ArrayList<String>();

		while (rs.next()) {

			list.add(rs.getString(1));

		}

		return list;
	}

	public static List<Product> getItems() throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select * from product");

		ResultSet rs = ps.executeQuery();

		List<Product> list = new ArrayList<Product>();

		Product p = null;

		while (rs.next()) {

			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImage_url(rs.getString(4));
			p.setCategory(rs.getString(5));

			list.add(p);

		}

		return list;

	}

	public static List<Product> getSelectedCategory(String cat) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select * from product where category=?");
		ps.setString(1, cat);
		ResultSet rs = ps.executeQuery();

		List<Product> list = new ArrayList<Product>();

		while (rs.next()) {

			Product p = null;
			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImage_url(rs.getString(4));
			p.setCategory(rs.getString(5));

			list.add(p);

		}
		return list;
	}

	public static List<Product> getItemById(String id[]) throws SQLException, ClassNotFoundException{
		
		Connection con = ConnectionUtility.getConnection();
		ResultSet rs=null;
		List<Product> list = new ArrayList<Product>();
		Product p = null;
		for(int i =0;i<id.length;i++){
		PreparedStatement ps = con.prepareStatement("select * from product where id=?");
		ps.setInt(1,Integer.parseInt(id[i]));
		rs = ps.executeQuery();
          while(rs.next()){
			
			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImage_url(rs.getString(4));
			p.setCategory(rs.getString(5));

			list.add(p);
		
		}
		
	}
		return list;
	}
}
	
	

