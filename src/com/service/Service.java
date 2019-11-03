package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.Dao.Order_DetailsDao;
import com.Dao.OrdersDao;
import com.Dao.ProductDao;
import com.Dao.UserDao;
import com.modal.Product;
import com.modal.User;

public class Service {

	public static List<String> getCatagory() throws ClassNotFoundException, SQLException {

		return ProductDao.getAllCategory();

	}

	public static List<Product> getItems() throws ClassNotFoundException, SQLException {

		return ProductDao.getItems();
	}

	public static boolean signUp(User c) throws ClassNotFoundException, SQLException {

		return UserDao.signUp(c);
	}

	public static String validateLogin(String email, String password) throws ClassNotFoundException, SQLException {

		return UserDao.validateLogin(email, password);

	}

	public static List<Product> getSelectedCategory(String cat) throws ClassNotFoundException, SQLException {

		return ProductDao.getSelectedCategory(cat);
	}

	public static List<Product> getItemById(String id[]) throws SQLException, ClassNotFoundException {

		return ProductDao.getItemById(id);

	}

	public static boolean checkLogin() {
		return UserDao.checkLogin();
	}

	public static int orders(String email) throws ClassNotFoundException, SQLException {
		return OrdersDao.orders(email);
	}

	public static boolean UpdateOrders(Map<String, Product> map, int id) throws ClassNotFoundException, SQLException {
		
		return OrdersDao.UpdateOrders(map, id);

	}
	
	public static int getOrderId() throws ClassNotFoundException, SQLException{
		
		return OrdersDao.getOrderId();
	}
	
	public static boolean updateOrderDetails(Map<String, Product> map, int orderId) throws ClassNotFoundException, SQLException{
		
		return Order_DetailsDao.updateOrderDetails(map, orderId);
	}

}
