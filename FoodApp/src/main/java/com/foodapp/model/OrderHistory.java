package com.foodapp.model;

public class OrderHistory {
	private int order_history_id;
	private int user_id;
	private int order_id;
	private float total_amount;
	private String status;
	
	public OrderHistory(int order_history_id, int user_id, int order_id, float total_amount, String status) {
		super();
		this.order_history_id = order_history_id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.total_amount = total_amount;
		this.status = status;
	}
	public OrderHistory(int user_id, int order_id, float total_amount, String status) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.total_amount = total_amount;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
	public int getOrder_history_id() {
		return order_history_id;
	}
	public void setOrder_history_id(int order_history_id) {
		this.order_history_id = order_history_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	
	@Override
	public String toString() {
		
		return order_id+"   "+user_id+"   "+order_id+"   "+total_amount+"   "+status;
	}
}
