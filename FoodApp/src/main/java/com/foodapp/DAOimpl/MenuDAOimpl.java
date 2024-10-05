package com.foodapp.DAOimpl;
import java.util.List;
import com.foodapp.DAO.MenuDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.foodapp.model.Menu;
import com.foodapp.DAO.MenuDAO;
import com.foodapp.model.Menu;

public class MenuDAOimpl implements MenuDAO{
	Menu menu;
	int x=-1;
	private static ArrayList<Menu> al = new ArrayList<Menu>();
	static Connection conn;
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet resultset;
	static String insert_data= "insert into menu values(?,?,?,?,?,?,?)";
	static String delete_by_menu_id="delete from menu where item_id=?";
	static String update_availability_of_items_by_menu_id="update menu set isavailable=? where item_id=?";
	static String get_all_items_by_restaruant_id="select * from menu where restruant_id=?";
	
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
	public int insertmenu(Menu m) {
		try {
			pstmt= conn.prepareStatement(insert_data);
			pstmt.setInt(1, m.getMenu_id());
			pstmt.setInt(2, m.getRestaruant_id());
			pstmt.setString(3,m.getItem_name());
			pstmt.setString(4,m.getDescription());
			pstmt.setInt(5,m.getPrice());
			pstmt.setBoolean(6,m.isIsavailable());
			pstmt.setString(7, m.getImagepath());
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public ArrayList<Menu> getAllItemsByRestaruantId(int restaruant_id) {
		try {
			pstmt = conn.prepareStatement(get_all_items_by_restaruant_id);
			pstmt.setInt(1,restaruant_id);
			resultset = pstmt.executeQuery();
			 al = (extractAllItemsByRestaruantId(resultset));
			 menu = al.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Menu getItemByMenuId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByMenuId(int id) {
		try {
			pstmt= conn.prepareStatement(delete_by_menu_id);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	@Override
	public int updateMenuById(int id,boolean b) {
		try {
			pstmt = conn.prepareStatement(update_availability_of_items_by_menu_id);
			pstmt.setInt(2,id);
			pstmt.setBoolean(1, b);
			 x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	ArrayList<Menu> extractAllItemsByRestaruantId(ResultSet resultset){
		try {
			while(resultset.next()) {
				al.add(new Menu(resultset.getInt(1),resultset.getInt(2),resultset.getString(3),resultset.getString(4),resultset.getInt(5),resultset.getBoolean(6),resultset.getString(7)));
			}
		}
		catch(Exception e) {
			
		}
		return al;
	}

	
}
