package com.tap.DAOimpl;
import java.util.List;

import com.tap.DAO.RestaruantDAO;
import com.tap.model.Restaruant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class RestaruantDAOimpl  implements RestaruantDAO{
	private static final ArrayList<Restaruant> Restaruant = new ArrayList<Restaruant> ();
	int x=0;
	ArrayList<Restaruant> al = new ArrayList<Restaruant>();
	Restaruant restaruant;
	private static Connection conn;
	private PreparedStatement pstmt;
	private static ResultSet resultset;
	private static Statement stmt;
	private static String insert_By_Restaruant_id="insert into restruant values(?,?,?,?,?)";
	private static String get_All_Restaruant = "select * from restruant";
	private static String get_Restaruant_By_Id="select * from restruant where restruant_id=?";
	private static String delete_By_Restaruant_id="delete from restruant where id=?";
	private static String update_Restaruant_By_Id="update restruant set isactive=? where restruant_id=?";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery_app","root","sumanth");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertByRestaruantId(Restaruant restaruant) {
		try {
			pstmt= conn.prepareStatement(insert_By_Restaruant_id);
			pstmt.setInt(1, restaruant.getRestaruantId());
			pstmt.setString(2,restaruant.getRestaruantName());
			pstmt.setInt(3, restaruant.getDeiveryTime());
			pstmt.setInt(4, restaruant.getRatings());
			pstmt.setBoolean(5, restaruant.isIsactive());
			x= pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public List<Restaruant> getAllRestaruants() {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			resultset = stmt.executeQuery(get_All_Restaruant);
			al= (ArrayList<Restaruant>) (extractAllRestaruants(resultset));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public Restaruant getRestaruantById(int id) {
		try {
			pstmt= conn.prepareStatement(get_Restaruant_By_Id);
			pstmt.setInt(1, id);
			resultset = pstmt.executeQuery();
			al = (ArrayList<Restaruant>) (extractAllRestaruants(resultset));
			restaruant =al.get(0);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaruant;
	}
	@Override
	public int updateAvailabilityByRestaruantId(int restaruantid, boolean b) {
		try {
			pstmt = conn.prepareStatement(update_Restaruant_By_Id);
			pstmt.setInt(2, restaruantid);
			pstmt.setBoolean(1, b);
			x = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	@Override
	public int deleteByRestaruantId(int restaruantId) {
		// TODO Auto-generated method stub
		try {
			pstmt = conn.prepareStatement(delete_By_Restaruant_id);
			pstmt.setInt(1,restaruantId);
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	List<Restaruant> extractAllRestaruants(ResultSet resultset){
		 
		try {
			while(resultset.next()) {
				al.add(new Restaruant (resultset.getInt(1),resultset.getString(2),resultset.getInt(3),resultset.getInt(4),resultset.getBoolean(5)));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
}
