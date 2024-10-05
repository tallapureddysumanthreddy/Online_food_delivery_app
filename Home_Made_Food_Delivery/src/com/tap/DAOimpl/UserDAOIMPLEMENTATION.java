package com.tap.DAOimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.DAO.userDAO;
import com.tap.model.User;
import java.util.ArrayList;
import java.sql.Statement;
public class UserDAOIMPLEMENTATION implements userDAO{
	static int x= 0;
	User user;
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet resultset;
	
	private static String Insert_data="insert into user (user_name,password,email,address,role) values(?,?,?,?,?)";
	private static String get_All_Data="select * from user ";
	private static String get_user_by_id="select * from user where user_id=?";
	private static String delete_user_by_id="delete from user where user_id=?";
	private static String update_user_address_by_id="update user set address=? where user_id=?";
	
	private static ArrayList<User> al = new ArrayList<User>();
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery_app","root","sumanth");
		}
		catch(Exception e) {
		}
	}
	
	public static void main(String[] args) {
	}
	
	@Override
	public int insertuser(User u) {
		try {
			pstmt= conn.prepareStatement(Insert_data);
			pstmt.setString( 1, u.getName() );
			pstmt.setString(2, u.getPassword() );
			pstmt.setString(3,u.getEmail());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getRole());
			 x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public List<User> getAllUsers() {
		try {
			stmt = conn.createStatement();
			resultset = stmt.executeQuery(get_All_Data);
			al = (ArrayList<User>) extractUserListFromResultSet(resultset);
			user = al.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public User getUserById(int id) {
		try {
			pstmt = conn.prepareStatement(get_user_by_id);
			pstmt.setInt(1, id);
			resultset = pstmt.executeQuery();
			al = (ArrayList<User>) (extractUserListFromResultSet(resultset));
			user =al.get(0);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		try {
			pstmt= conn.prepareStatement(delete_user_by_id);
			pstmt.setInt(1, id);
			x= pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateUser(int id,String address) {
		try {
			pstmt = conn.prepareStatement(update_user_address_by_id);
			pstmt.setInt(2, id);
			pstmt.setString(1, address);
			x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	List<User> extractUserListFromResultSet(ResultSet resultset){
		try {
			while(resultset.next()) {
				 al.add (new User(resultset.getInt(1),resultset.getString(2),resultset.getString(3),
				resultset.getString(4),resultset.getString(5),resultset.getString(6)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
