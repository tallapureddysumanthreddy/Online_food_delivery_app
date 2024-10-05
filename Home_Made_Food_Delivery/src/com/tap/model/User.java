package com.tap.model;

public class User {
	private int id;
	private String name ;
	private String email;
	private String role;
	private String password;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int id, String name, String email, String password, String role, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.address = address;
	}
	public User(String name, String email, String password, String role, String address) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.address = address;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"   "+name+"   "+"   "+email+"   "+role+"   "+password+"   "+address;
	}
}
