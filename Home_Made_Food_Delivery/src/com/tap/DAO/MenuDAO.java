package com.tap.DAO;
import java.util.ArrayList;
import com.tap.model.Menu;
import java.util.List;
public interface MenuDAO {
	int insertmenu(Menu m);
	ArrayList<Menu> getAllItemsByRestaruantId(int id);
	Menu getItemByMenuId(int id);
	int deleteByMenuId(int id);
	int updateMenuById(int id,boolean b);
	
}
