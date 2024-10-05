package com.tap.DAOimpl;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Statement;
import java.sql.PreparedStatement;


import com.tap.DAO.Order1DAO;
import com.tap.model.Order1;

public class Order1DAOimpl implements Order1DAO {
	int x=-1;
	ArrayList <Order1> al= new ArrayList<Order1>();
	Order1 order;
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet resultset;
	
	private static String insert_data="insert into order1 (user_id,restruant_id,total_amount,status,payment_option) values (?,?,?,?,?)";
	private static String update_data="update order1 set status=? where order_id=?";
	private static String fetch_on_Order_id="select * from order1 where order_id=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery_app","root","sumanth");
		}
		catch(Exception e) {
			
		}
	}
	@Override
	public int updateOrderAcceptingOrderId(int order_id, String status) {
		try {
			pstmt= conn.prepareStatement(update_data);
			pstmt.setInt(2, order_id);
			pstmt.setString(1, status);
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	
	}

	@Override
	public ArrayList<Order1> fetchOnOrderId(int order_id) {
		try {
			pstmt= conn.prepareStatement(fetch_on_Order_id);
			pstmt.setInt(1, order_id);
			resultset= pstmt.executeQuery();
			al=(ExtractAlldataBasedOnId(resultset));
			order = al.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public int insertOrder(Order1 order) {
		try {
			pstmt=conn.prepareStatement(insert_data);
			pstmt.setInt(1, order.getUser_id());
			pstmt.setInt(2, order.getRestruant_id());
			pstmt.setFloat(3, order.getTotal_amount());
			pstmt.setString(4,order.getStatus());
			pstmt.setString(5, order.getPayment_option());
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	ArrayList <Order1> ExtractAlldataBasedOnId(ResultSet resultset){
		
		try {
			
			while(resultset.next()) {
			al.add(
					new Order1( 
							resultset.getInt(1),
							resultset.getInt(2),
							resultset.getInt(3),
							resultset.getFloat(4),
							resultset.getString(5),
							resultset.getDate(6),
							resultset.getString(7)));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
