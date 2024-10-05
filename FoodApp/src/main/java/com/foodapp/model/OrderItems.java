package com.foodapp.model;
public class OrderItems {
	private int order_item_id;
	private int order_id;
	private int menu_item_id;
	private int quantity;
	private float sub_total_amount;
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMenu_item_id() {
		return menu_item_id;
	}
	public void setMenu_item_id(int menu_item_id) {
		this.menu_item_id = menu_item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSub_total_amount() {
		return sub_total_amount;
	}
	public void setSub_total_amount(float sub_total_amount) {
		this.sub_total_amount = sub_total_amount;
	}
	
	public OrderItems() {
		super();
	}
	public OrderItems(int order_id, int menu_item_id, int quantity, float sub_total_amount) {
		super();
		this.order_id = order_id;
		this.menu_item_id = menu_item_id;
		this.quantity = quantity;
		this.sub_total_amount = sub_total_amount;
	}
	
	public OrderItems(int order_item_id, int order_id, int menu_item_id, int quantity, float sub_total_amount) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.menu_item_id = menu_item_id;
		this.quantity = quantity;
		this.sub_total_amount = sub_total_amount;
	}
	
	@Override
	public String toString() {
		return order_item_id+"   "+order_id+"   "+menu_item_id+"   "+quantity+"   "+sub_total_amount;
	}
	

}
