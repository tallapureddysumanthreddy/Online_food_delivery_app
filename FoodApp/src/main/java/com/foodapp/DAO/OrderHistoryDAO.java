package com.foodapp.DAO;

import com.foodapp.model.OrderHistory;
import java.util.ArrayList;
public interface OrderHistoryDAO {
	ArrayList<OrderHistory> fetchOrdersOnUserid(int user_id);
	int updateOrderHistory(int orderhistory_id,String status);
	int insertOrderHistory1(OrderHistory ohis);
	
}

