package com.tap.model;

public class Restaruant {
	private int restaruantId;
	private String restaruantName;
	private int deliveryTime;
	private int ratings;
	private boolean isactive;
	private String dummy="";
	public int getRestaruantId() {
		return restaruantId;
	}
	public void setRestaruantId(int restaruantId) {
		this.restaruantId = restaruantId;
	}
	public String getRestaruantName() {
		return restaruantName;
	}
	public void setRestaruantName(String restaruantName) {
		this.restaruantName = restaruantName;
	}
	public int getDeiveryTime() {
		return deliveryTime;
	}
	public void setDeiveryTime(int deiveryTime) {
		this.deliveryTime = deiveryTime;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public Restaruant(int restaruantId, String restaruantName, int deiveryTime, int ratings, boolean isactive) {
		super();
		this.restaruantId = restaruantId;
		this.restaruantName = restaruantName;
		this.deliveryTime = deiveryTime;
		this.ratings = ratings;
		this.isactive = isactive;
	}
	public Restaruant(String restaruantName, int deiveryTime, int ratings, boolean isactive) {
		super();
		this.restaruantName = restaruantName;
		this.deliveryTime = deiveryTime;
		this.ratings = ratings;
		this.isactive = isactive;
	}
	public Restaruant() {
		super();
	}
	public String checking() {
		if(isactive==true) {
			return "Restaruant open";
		}
		else {
			return "Restaruant close";
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return restaruantId+"   "+restaruantName+"   "+"   "+deliveryTime+"   "+ ratings+"   "+ checking() ;
	}
	

}
