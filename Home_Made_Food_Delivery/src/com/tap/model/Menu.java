package com.tap.model;

public class Menu {
	private int menu_id;
	private int restaruant_id;
	private String item_name;
	private String description;
	private int price;
	private boolean isavailable;
	private String imagepath;
	
	public int getMenu_id() 
	{
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}



	public int getRestaruant_id() {
		return restaruant_id;
	}



	public void setRestaruant_id(int restaruant_id) {
		this.restaruant_id = restaruant_id;
	}

	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isIsavailable() {
		return isavailable;
	}

	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	



	public Menu(int restaruant_id, String item_name, String description, int price, boolean isavailable,
			String imagepath) {
		super();
		this.restaruant_id = restaruant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}

	public Menu() {
		super();
	}

	public Menu(int menu_id, int restaruant_id, String item_name, String description, int price, boolean isavailable,
			String imagepath) {
		super();
		this.menu_id = menu_id;
		this.restaruant_id = restaruant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return menu_id+"    "+restaruant_id+"    "+"    "+item_name+"    "+description+"   "+price+"   "+"    "+isavailable+"   "+"   "+imagepath;
	}
	

}
