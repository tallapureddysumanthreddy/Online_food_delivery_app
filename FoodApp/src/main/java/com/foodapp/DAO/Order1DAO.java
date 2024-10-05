package com.foodapp.DAO;

import java.util.ArrayList;
import com.foodapp.model.Order1;
public interface Order1DAO {
	int updateOrderAcceptingOrderId(int order_id,String status);
	ArrayList <Order1> fetchOnOrderId(int order_id);
	int insertOrder(Order1 order);
}