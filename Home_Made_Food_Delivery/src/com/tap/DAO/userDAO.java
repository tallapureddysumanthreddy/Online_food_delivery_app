package com.tap.DAO;
import java.util.List;
import com.tap.model.User;
public interface userDAO {
	int insertuser(User u);
	List<User> getAllUsers();
	User getUserById(int id);
	int deleteUserById(int id);
	int updateUser(int id,String address);
	
}