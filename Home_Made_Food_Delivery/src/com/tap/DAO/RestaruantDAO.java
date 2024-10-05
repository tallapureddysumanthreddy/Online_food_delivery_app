package com.tap.DAO;
import com.tap.model.Restaruant;
import java.util.List;
public interface RestaruantDAO {
	int insertByRestaruantId(Restaruant restaruant);
	List<Restaruant> getAllRestaruants();
	Restaruant getRestaruantById(int id);
	int updateAvailabilityByRestaruantId(int restaruantid,boolean b);
	int deleteByRestaruantId(int restaruantId);
}
