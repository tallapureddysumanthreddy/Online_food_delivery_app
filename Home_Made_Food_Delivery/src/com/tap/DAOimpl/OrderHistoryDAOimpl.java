package com.tap.DAOimpl;
import com.tap.DAO.OrderHistoryDAO;
import com.tap.model.OrderHistory;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.model.OrderHistory;
public class OrderHistoryDAOimpl implements OrderHistoryDAO{
	private static int x=0;
	ArrayList<OrderHistory> al  = new ArrayList<OrderHistory>();
	private static Connection conn;
	private static ResultSet resultset;
	private PreparedStatement pstmt;
	private Statement stmt;
	private static String insert_order_on_user_id= "insert into orderhistory (user_id,order_id,total_amount,status)values (?,?,?,?)";
	private static String   fetch_on_orders_on_user_id="select * from orderhistory where user_id=?";
	private static String update_orders_on_order_history_id="update orderhistory set status=? where order_history_id=?";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery_app","root","sumanth");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<OrderHistory> fetchOrdersOnUserid(int user_id) {
		try {
			pstmt= conn.prepareStatement(fetch_on_orders_on_user_id);
			pstmt.setInt(1,user_id);
			resultset=pstmt.executeQuery();
			al= extractListOfData(resultset);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public int updateOrderHistory(int orderhistory_id, String status) {
		try {
			pstmt=conn.prepareStatement(update_orders_on_order_history_id);
			pstmt.setInt(2, orderhistory_id);
			pstmt.setString(1, status);
			x= pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	
	@Override
	public int insertOrderHistory1(OrderHistory ohis) {
		try{
			pstmt=conn.prepareStatement(insert_order_on_user_id);
			
			pstmt.setInt(1,ohis.getUser_id());
			pstmt.setInt(2, ohis.getOrder_id());
			pstmt.setFloat(3, ohis.getTotal_amount());
			pstmt.setString(4,ohis.getStatus());
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	ArrayList<OrderHistory>extractListOfData(ResultSet resultset){
		try {
			while(resultset.next()) {
				al.add(new OrderHistory(resultset.getInt(1),
						resultset.getInt(2),
						resultset.getInt(3),
						
						resultset.getFloat(4),
						resultset.getString(5) ));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	

	

}
