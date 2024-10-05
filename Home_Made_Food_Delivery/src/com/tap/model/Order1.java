package com.tap.model;

import java.sql.Date;

public class Order1 {
	private int order_id;
	private int user_id;
	private int restruant_id;
	private float total_amount;
	private String status;
	private String payment_option ;
	private Date date;
	public Order1(int order_id, int user_id, int restruant_id, float total_amount, String status,Date date ,String payment_option) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restruant_id = restruant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.date=date;
		this.payment_option = payment_option;
	}

	public Order1(int user_id, int restruant_id, float total_amount, String status, String payment_option) {
		super();
		this.user_id = user_id;
		this.restruant_id = restruant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_option = payment_option;
	}
	public Order1() {
		super();
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestruant_id() {
		return restruant_id;
	}
	public void setRestruant_id(int restruant_id) {
		this.restruant_id = restruant_id;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_option() {
		return payment_option;
	}
	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		
		return order_id+"   "+user_id+"   "+restruant_id+"   "+status+"   "+total_amount+"   "+payment_option;
	}
}
