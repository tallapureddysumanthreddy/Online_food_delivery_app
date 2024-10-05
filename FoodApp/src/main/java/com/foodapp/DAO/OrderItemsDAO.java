package com.foodapp.DAO;
import com.foodapp.model.OrderItems;
import java.util.ArrayList;
public interface OrderItemsDAO {
	int insertOrderItem(OrderItems orderitems);
	ArrayList<OrderItems>fetchOrderItems(int order_id);
}