package com.modal;

import java.sql.Date;

public class Orders {
	private int id;
	private User user_id;
	private int total_amount;
	private Date date;

	public Orders() {
		super();
	}

	public Orders(User user_id, int total_amount, Date date) {
		super();

		this.user_id = user_id;
		this.total_amount = total_amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", total_amount=" + total_amount + ", date=" + date + "]";
	}

}
