package com.foodapp.DAO;

import java.util.ArrayList;

import com.foodapp.model.Menu;

public interface MenuDAO {
	int insertmenu(Menu m);
	ArrayList<Menu> getAllItemsByRestaruantId(int id);
	Menu getItemByMenuId(int id);
	int deleteByMenuId(int id);
	int updateMenuById(int id,boolean b);
	
}