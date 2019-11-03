package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modal.Product;
import com.modal.User;
import com.service.Service;

public class MensFashionServlet extends HttpServlet {

	String b;
	String eml;
	String cat;
	String quant[] =new String[50];
	Map<String, Product> map;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		HttpSession session1 = request.getSession();
		HttpSession session2 = request.getSession();
		String name = request.getParameter("action");
		if (name == null) {
			try {
				List<String> list = Service.getCatagory();
				request.setAttribute("list", list);

				List<Product> p = Service.getItems();
				request.setAttribute("items", p);
				request.getRequestDispatcher("home.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		} else if (name.equals("SignUp")) {

			String nme = request.getParameter("name");
			String eml = request.getParameter("email");
			String pwd = request.getParameter("pwd");

			User u = new User();

			u.setName(nme);
			u.setEmail(eml);
			u.setPassword(pwd);

			try {
				boolean res = Service.signUp(u);

				if (res) {

					List<String> list = Service.getCatagory();
					request.setAttribute("list", list);

					List<Product> p = Service.getItems();
					request.setAttribute("items", p);
					out.print("<center><h2 style='color: red'>Registration Succesfull</h2></center>");
					request.getRequestDispatcher("home.jsp").include(request, response);
				} else {
					List<String> list = Service.getCatagory();
					request.setAttribute("list", list);

					List<Product> p = Service.getItems();
					request.setAttribute("items", p);
					out.print("<center><h2 style='color: red'>Email is Already Registered</h2></center>");
					request.getRequestDispatcher("home.jsp").include(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

		} else if (name.equals("Login")) {

			eml = request.getParameter("email");
			String pwd = request.getParameter("pwd");

			try {

				b = Service.validateLogin(eml, pwd);
				if (b != null) {
					List<String> list = Service.getCatagory();
					request.setAttribute("list", list);

					List<Product> p = Service.getItems();
					request.setAttribute("items", p);

					session.setAttribute("name", b);
					request.getRequestDispatcher("loginhome.jsp").include(request, response);
				} else {
					out.print("<center><h2 style='color: red'>Please Register Or check your PassWord</h2></center>");
					request.getRequestDispatcher("home.jsp").include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		} else if (name.equals("Logout")) {
			try {
				List<String> list = Service.getCatagory();
				request.setAttribute("list", list);

				List<Product> p = Service.getItems();
				request.setAttribute("items", p);
				request.getRequestDispatcher("home.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		else if (name.equals("Go")) {
			 cat = request.getParameter("category");

			try {
				List<String> list = Service.getCatagory();
				request.setAttribute("list", list);
				List<Product> p = Service.getSelectedCategory(cat);
				request.setAttribute("items", p);

				request.getRequestDispatcher("loginhome.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (name.equals("AddToCart")) {

			 quant= request.getParameterValues("quant");
			String id[] = request.getParameterValues("ids");
			for (int i = 0; i < quant.length; i++) {
				System.out.println(quant[i]);
			}
			System.out.println("=============================");
			for (int i = 0; i < id.length; i++) {
				System.out.println(id[i]);
			}
			int count = 0;
			for (int i = 0; i < quant.length; i++) {
				if (!quant[i].equals("0")) {
					count++;
				}
			}
			System.out.println(count);
			System.out.println(b);
			String id1[] = new String[count];
			String quant1[] = new String[count];
			int j = 0;
			for (int i = 0; i < quant.length; i++) {
				if (!quant[i].equals("0")) {

					id1[j] = id[i];
					System.out.print(id1[j] + " ");
					quant1[j] = quant[i];
					System.out.print(quant1[j] + " ");
					j++;
				}

			}

			try {
				List<Product> list = Service.getItemById(id1);

				map = new HashMap<String, Product>();
				int i = 0;
				for (Product p : list) {
					map.put(quant1[i], p);
					i++;
				}
				int price = 0;
				for (Map.Entry<String, Product> m : map.entrySet()) {

					price = price + (m.getValue().getPrice()) * (Integer.parseInt(m.getKey()));

				}

				session1.setAttribute("price", price);
				session2.setAttribute("map", map);

				request.getRequestDispatcher("cart.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		} else if (name.equals("MoreShopping")) {

			try {

				List<String> list = Service.getCatagory();
				request.setAttribute("list", list);
				List<Product> p = Service.getSelectedCategory(cat);
				Map<Product,String> m =new HashMap<Product,String>();
				
				int i=0;
				for (Product product : p) {
					m.put(product, quant[i]);
					i++;
				}
				request.setAttribute("items", m);
				request.getRequestDispatcher("loginhome1.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

		} else if (name.equals("PlaceOrder")) {

			request.getRequestDispatcher("continue.jsp").forward(request, response);

		}

		else if (name.equals("continue")) {

			try {
				int id = Service.orders(eml);

				boolean res = Service.UpdateOrders(map, id);
				if (res) {
					int orderId = Service.getOrderId();
					boolean updateOrderDetails = Service.updateOrderDetails(map, orderId);
					if (updateOrderDetails) {
						request.getRequestDispatcher("Final.jsp").forward(request, response);
					}
				}

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

		}
		else if (name.equals("Go Home")) {
			
			List<String> list;
			try {
				list = Service.getCatagory();
				
				request.setAttribute("list", list);

				List<Product> p = Service.getItems();
				request.setAttribute("items", p);

				session.setAttribute("name", b);
				request.getRequestDispatcher("loginhome.jsp").include(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cat = request.getParameter("category");

		try {
			List<String> list = Service.getCatagory();
			request.setAttribute("list", list);
			List<Product> p = Service.getSelectedCategory(cat);
			request.setAttribute("items", p);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
