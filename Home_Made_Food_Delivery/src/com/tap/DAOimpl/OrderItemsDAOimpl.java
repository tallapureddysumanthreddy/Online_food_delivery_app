package com.tap.DAOimpl;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import com.tap.main.OrderItemsMain;
import com.tap.DAO.OrderItemsDAO;
import com.tap.model.OrderItems;

public class OrderItemsDAOimpl implements OrderItemsDAO{
	ArrayList <OrderItems> al = new ArrayList<OrderItems>();
	OrderItems orderitems;
	int x=0;
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet resultset;
	private static String insert_data_by_order_item_id="insert into orderitems (order_id,menu_item_id,quantity,sub_total_amount) values(?,?,?,?)";
	private static String fetch_data_by_order_item_id="select * from orderitems where orderitem_id=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery_app","root","sumanth");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insertOrderItem(OrderItems orderitems) {
		try {
			pstmt=conn.prepareStatement(insert_data_by_order_item_id);
			pstmt.setInt(1, orderitems.getOrder_id());
			pstmt.setInt(2, orderitems.getMenu_item_id());
			pstmt.setInt(3, orderitems.getQuantity());
			pstmt.setFloat(4, orderitems.getSub_total_amount());
			x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public ArrayList<OrderItems> fetchOrderItems(int order_item_id) {
		try {
			pstmt = conn.prepareStatement(fetch_data_by_order_item_id);
			pstmt.setInt(1, order_item_id);
			resultset = pstmt.executeQuery();
			al= extractbyorderitemid(resultset);
			orderitems= al.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
	ArrayList<OrderItems> extractbyorderitemid(ResultSet resultset){
		try {
			while(resultset.next())
			{
				al.add(new OrderItems (resultset.getInt(1),
						resultset.getInt(2),
						resultset.getInt(3),
						resultset.getInt(4),
						resultset.getFloat(5)));
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	


}
